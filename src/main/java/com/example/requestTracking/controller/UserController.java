package com.example.requestTracking.controller;


import com.example.requestTracking.entity.User;
import com.example.requestTracking.repository.RoleRepository;
import com.example.requestTracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public String userList(Model model, @AuthenticationPrincipal User user){
        if(user.getRole().getRoleName().equals("Администратор")){
        model.addAttribute("users", userRepository.findAll());
        return "userList";
        } else return "main";
    }

    @PostMapping("/found")
    public String searchUser(@RequestParam String username, Model model){
        System.out.println(userRepository.findByLogin(username).getFullName());
        model.addAttribute("users", userRepository.findAllByLogin(username));
        return "userList";

    }
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){

        model.addAttribute("user", user);
        return "userEdit";
    }

    @PostMapping("/{user}")
    public String delete(@RequestParam User user){
        userRepository.delete(user);
        return "redirect:/user";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user){
        String[] name = username.split(" ");
        user.setFirstname(name[1]);
        user.setMiddlename(name[2]);
        user.setLastname(name[0]);

        if(form.get("admin")!=null){
            user.setRole(roleRepository.findByRoleName("Администратор"));
        } else user.setRole(roleRepository.findByRoleName("Пользователь"));

        userRepository.save(user);
        return "redirect:/user";
    }
}
