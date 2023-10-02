package com.skysoft.easyschool.web;

import com.skysoft.easyschool.domain.User;
import com.skysoft.easyschool.dto.AuthorityUserDTO;
import com.skysoft.easyschool.dto.UserDTO;
import com.skysoft.easyschool.exception.InvalidInputException;
import com.skysoft.easyschool.service.UserService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserRessource {

    private final UserService userService;

    public UserRessource(UserService userService) {
        this.userService = userService;
    }

    private static class AccountResourceException extends RuntimeException {
        private AccountResourceException(String message) {
            super(message);
        }
    }

    @PostMapping("/createNewUser")
    public ResponseEntity<User> createNewUser(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.createUser(userDTO));
    }


    @GetMapping("/account")
    public UserDTO getAccount() {
        return userService.getUserWithAuthorities()
                .map(UserDTO::new)
                .orElseThrow(() -> new AccountResourceException("User could not be found"));
    }

    @GetMapping("/rolesWithUser/{username}")
    public ResponseEntity<AuthorityUserDTO> rolesUtilisateurs(@PathVariable("username") String username){
        return ResponseEntity.ok(userService.getAuthorityWithUser(username));
    }
}
