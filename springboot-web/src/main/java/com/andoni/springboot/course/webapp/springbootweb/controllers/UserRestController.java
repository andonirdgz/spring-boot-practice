package com.andoni.springboot.course.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.List;
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

    @GetMapping("/list")
    public List<User> listUsers() {
        User user1 = new User("User", "1");
        User user2 = new User("User", "2");
        User user3 = new User("User", "3");

        List<User> users = Arrays.asList(user1, user2, user3);

        return users;
    }

}
