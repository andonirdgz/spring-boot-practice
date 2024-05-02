package com.andoni.springboot.course.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.andoni.springboot.course.webapp.springbootweb.models.dto.ParamDTO;
import com.andoni.springboot.course.webapp.springbootweb.models.dto.ParamMixDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/single-param")
    public ParamDTO singleParam(@RequestParam(required = false, defaultValue = "No message") String message) {
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setMessage(message);
        return paramDTO;
    }

    @GetMapping("/multi-param")
    public ParamDTO multiParam(@RequestParam String text, @RequestParam Integer code) {
        ParamDTO paramDTO = new ParamDTO();

        paramDTO.setMessage(text);
        paramDTO.setCode(code);

        return paramDTO;
    }

    @GetMapping("/http-servlet-request")
    public ParamMixDTO httpServletRequest(HttpServletRequest request) {
        Integer code = 0;

        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }

        ParamMixDTO params = new ParamMixDTO();
        params.setMessage(request.getParameter("message"));
        params.setCode(code);

        return params;
    }

}
