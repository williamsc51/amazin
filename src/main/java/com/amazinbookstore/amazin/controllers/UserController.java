package com.amazinbookstore.amazin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    private String userLoginForm() {
        return "login";
    }

    @GetMapping("/user/register")
    private String userRegistrationForm() {
        return "user/register";
    }
}