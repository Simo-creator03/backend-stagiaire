package com.skysoft.easyschool.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skysoft.easyschool.domain.User;
import com.skysoft.easyschool.exception.InvalidInputException;
import com.skysoft.easyschool.repository.RoleRepository;
import com.skysoft.easyschool.repository.UserRepository;
import com.skysoft.easyschool.security.jwt.JWTFilter;
import com.skysoft.easyschool.security.jwt.TokenProvider;
import com.skysoft.easyschool.web.vm.LoginVM;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;

@RestController
@Slf4j
@RequestMapping("/api")
public class UserJWTController {
    private final TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserJWTController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JWTToken> authorize(@RequestBody @Valid LoginVM loginVM) throws InvalidInputException, NotFoundException {

        //log.info("UserJWTController authorize");

        if(!hasText(loginVM.getUsername())) {
            throw new InvalidInputException("Veillez renseigner le login");
        }

        if(!hasText(loginVM.getPassword())) {
            throw new InvalidInputException("Veillez renseigner le mot de passe");
        }

        Optional<User> user = userRepository.findByLogin(loginVM.getUsername());

        if(user.isPresent()){
            if (!passwordEncoder.matches(loginVM.getPassword(), user.get().getPassword())) {
                throw new NotFoundException("Les identifications sont erronés");
            }
        } else {
            throw new NotFoundException("Cet utilisateur n'existe pas");
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginVM.getUsername(), loginVM.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        boolean rememberMe = (loginVM.isRememberMe() == null) ? false : loginVM.isRememberMe();
        String jwt = tokenProvider.createToken(authentication, rememberMe);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);
    }
    /**
     * Object to return as body in JWT Authentication.
     */
    static class JWTToken {

        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }
}
