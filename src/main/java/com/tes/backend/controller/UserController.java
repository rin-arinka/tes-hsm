package com.tes.backend.controller;

import com.tes.backend.entity.User;
import com.tes.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/user")
public class UserController {

    private final UserService service;

    @PostMapping
    public User register(@RequestBody User user) { return service.save(user);}

}
