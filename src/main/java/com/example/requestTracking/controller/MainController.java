package com.example.requestTracking.controller;

import com.example.requestTracking.entity.User;
import com.example.requestTracking.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private JournalRepository journalRepository;


    @GetMapping("/")
    private String greeting(Model model){
        return "greeting";
    }

    @GetMapping("/main")
    private String mainRequest(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("journals" ,journalRepository.findAllByUser(user));
        return "main";
    }


}
