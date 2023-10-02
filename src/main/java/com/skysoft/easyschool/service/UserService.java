package com.skysoft.easyschool.service;

import com.skysoft.easyschool.domain.User;
import com.skysoft.easyschool.dto.AuthorityUserDTO;
import com.skysoft.easyschool.dto.UserDTO;

import java.util.Optional;

public interface UserService {

    User createUser(UserDTO userDTO);

    Optional<User> getUserWithAuthorities();

    AuthorityUserDTO getAuthorityWithUser (String username);
}
