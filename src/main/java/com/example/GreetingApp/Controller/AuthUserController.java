package com.example.GreetingApp.Controller;

import com.example.GreetingApp.Model.AuthUser;
import com.example.GreetingApp.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private AuthenticationService authenticationService;

    // Register User
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AuthUser authUser) {
        String response = authenticationService.registerUser(authUser);
        return ResponseEntity.ok(response);
    }

    // Login User and Generate JWT Token
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> request) {
        String token = authenticationService.authenticateUser(
                request.get("email"),
                request.get("password")
        );

        if (token.equals("User not found!") || token.equals("Invalid email or password!")) {
            return ResponseEntity.status(401).body(Map.of("error", token));
        }

        return ResponseEntity.ok(Map.of("message", "Login successful!", "token", token));
    }
}