package com.example.empl4sem2CRUD.controllers;


import com.example.empl4sem2CRUD.model.User;
import com.example.empl4sem2CRUD.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        UserService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user/delete/{id}")
    String deleteUser(@PathVariable("id") int id){
        userService.deleteById(id);
        return "redirect:/user";
    }
}
