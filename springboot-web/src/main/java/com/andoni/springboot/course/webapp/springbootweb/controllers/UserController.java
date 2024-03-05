package com.andoni.springboot.course.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
