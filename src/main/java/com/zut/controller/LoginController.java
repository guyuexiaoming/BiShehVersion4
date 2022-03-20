package com.zut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
    @RequestMapping("tologin")
    public String login() {
        System.out.println("********login********");


        return "login1";
    }
}
