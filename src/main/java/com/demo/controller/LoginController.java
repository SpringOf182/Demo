package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login( String userName,String password){
        if(userName=="admin"&&password=="admin")
            return "/success.jsp";
        return "Login.jsp";
    }
}
