package com.microservice.user.controller;

import com.microservice.user.Response.UserResponseWithDepartment;
import com.microservice.user.model.User;
import com.microservice.user.service.UserService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public UserResponseWithDepartment getUserByIdWithDepartment(@PathVariable long userId) throws NotFoundException {
        return userService.getUserByIdWithDepartment(userId);
    }
}
