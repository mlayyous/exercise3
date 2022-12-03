package com.example.exercise.api.controller;

import com.example.exercise.api.model.Users;
import com.example.exercise.api.service.UsersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/service")
    public List<Users> getServiceUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/service/{id}")
        public Users getServiceSpending(@PathVariable Long id) {
        return usersService.getUser(id);
    }
}
