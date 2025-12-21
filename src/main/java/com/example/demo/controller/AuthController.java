package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    @Operation(summary = "Authenticate user (plain match for Review 1)")
    public Map<String, Object> login(@RequestBody User loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());
        if (!loginRequest.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return Map.of(
            "status", "OK",
            "userId", user.getId(),
            "email", user.getEmail(),
            "role", user.getRole()
        );
    }
}
