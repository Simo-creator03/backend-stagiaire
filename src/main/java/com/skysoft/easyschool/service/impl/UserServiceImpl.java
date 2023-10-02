package com.skysoft.easyschool.service.impl;

import com.skysoft.easyschool.domain.Role;
import com.skysoft.easyschool.domain.User;
import com.skysoft.easyschool.dto.AuthorityUserDTO;
import com.skysoft.easyschool.dto.UserDTO;
import com.skysoft.easyschool.repository.RoleRepository;
import com.skysoft.easyschool.repository.UserRepository;
import com.skysoft.easyschool.security.AuthoritiesConstants;
import com.skysoft.easyschool.service.UserService;
import com.skysoft.easyschool.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository authorityRepository;
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public UserServiceImpl(PasswordEncoder passwordEncoder, RoleRepository authorityRepository, UserRepository userRepository, EntityManager entityManager) {
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }


    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User();
        User user1 = new User();
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encryptedPassword);
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        user.setNomComplet(userDTO.getNomComplet());
        user.setTelephone(userDTO.getTelephone());
        if (userDTO.getAuthorities() != null) {
            Set<Role> authorities = userDTO.getAuthorities().stream()
                    .map(authorityRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
            user.setAuthorities(authorities);
        }
          user1 = userRepository.save(user);
          return user1;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities() {
        return SecurityUtils.getCurrentUserLogin().flatMap(userRepository::findOneWithAuthoritiesByLogin);
    }

    @Override
    public AuthorityUserDTO getAuthorityWithUser(String username) {
        AuthorityUserDTO authorityUserDTO = new AuthorityUserDTO();
            Optional<User> user = userRepository.findOneByLogin(username);
        String role_user = "ROLE_USER";
        if(user.isPresent()) {

            List<String> authorityOfUser = (List<String>) entityManager.createNativeQuery("select user_authority.authority_name from user_authority where " +
                    " user_authority.user_id = " + user.get().getId() + " ").getResultList();

            List<String> authorityNotUser = userRepository.getAuthorityWithUser(authorityOfUser);
            authorityUserDTO.setAuthorityOfUser(authorityOfUser);
            authorityUserDTO.setAuthorityNotUser(authorityNotUser);
            authorityUserDTO.setLoginUser(user.get().getLogin());
        }
        return authorityUserDTO;
    }

}
