package com.andoni.springboot.course.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.andoni.springboot.course.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String getDetails(Model model) {
        User user = new User("John", "Doe");

        model.addAttribute("title", "Hello world Spring boot");
        model.addAttribute("user", user);

        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        User user1 = new User("User", "1", "email@1.com");
        User user2 = new User("User", "2");
        User user3 = new User("User", "3");

        List<User> users = Arrays.asList(user1, user2, user3);

        model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");

        return "list";
    }

}
