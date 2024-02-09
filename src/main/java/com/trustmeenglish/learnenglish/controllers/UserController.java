package com.trustmeenglish.learnenglish.controllers;


import com.trustmeenglish.learnenglish.dto.UserDTO;
import com.trustmeenglish.learnenglish.entity.User;
import com.trustmeenglish.learnenglish.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final IUserService userService;

    @GetMapping("/users/{id}")
    public UserDTO sayHello(@PathVariable Long id) {
        User user = userService.getUser(id);
        return userDTO(user);
    }

    private UserDTO userDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }

}
