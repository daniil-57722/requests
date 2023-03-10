package com.example.requestTracking.controller;


import com.example.requestTracking.entity.User;
import com.example.requestTracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model, @RequestParam String username){
        user.setLogin(username);
        if(!userService.addUser(user)){
            model.put("message", "user exists!");
            return "registration";
        }
            return "redirect:/login";
    }

}
