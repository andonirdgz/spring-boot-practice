package com.andoni.springboot.course.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andoni.springboot.course.webapp.springbootweb.models.User;
import com.andoni.springboot.course.webapp.springbootweb.models.dto.ParamDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/path-variables")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.values}")
    private List<String> values;

    @Value("${config.code}")
    private Integer code;

    @Value("#{ '${config.values}'.toUpperCase().split(',') }")
    private List<String> manipulatedValues;

    @Value("#{${config.product}}")
    private Map<String, Object> product;

    @Autowired
    private Environment environment;

    @GetMapping("/message-from-path/{message}")
    public ParamDTO messageFromPath(@PathVariable String message) {

        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setMessage(message);

        return paramDTO;
    }

    @GetMapping("/multi-var-from-path/{product}/{id}")
    public Map<String, Object> multiVarFromPath(@PathVariable String product, @PathVariable Long id) {

        Map<String, Object> json = new HashMap<>();

        json.put("product", product);
        json.put("id", id);

        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {

        return user;
    }

    @GetMapping("/config")
    public Map<String, Object> config() {

        Map<String, Object> json = new HashMap<>();

        json.put("username", username);
        json.put("message", message);
        json.put("values", values);
        json.put("code", code);
        json.put("manipulatedValues", manipulatedValues);
        json.put("product", product);

        json.put("java.version", environment.getProperty("java.version"));
        json.put("messageFromEnvironment", environment.getProperty("config.message"));

        return json;
    }

}
