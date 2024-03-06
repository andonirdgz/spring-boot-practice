package com.andoni.springboot.course.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andoni.springboot.course.webapp.springbootweb.models.User;
import com.andoni.springboot.course.webapp.springbootweb.models.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details-map")
    public Map<String, Object> getDetails() {
        Map<String, Object> body = new HashMap<>();
        User user = new User("John", "Doe");

        body.put("title", "Hello world Spring boot");
        body.put("user", user);

        return body;
    }

    @GetMapping("/details-dto")
    public UserDTO getDetailsDto() {
        User user = new User("John", "Doe");
        UserDTO userDTO = new UserDTO();

        userDTO.setUser(user);
        userDTO.setTitle("Hello world with DTO");

        return userDTO;
    }

}
