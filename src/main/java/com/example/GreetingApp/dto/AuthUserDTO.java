package com.example.GreetingApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AuthUserDTO {

    @NotBlank(message = "First Name is required")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "First letter must be uppercase")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "First letter must be uppercase")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$%^&*()-+=])(?=.*\\d).{8,}$",
            message = "Password must contain 1 uppercase, 1 special character, 1 digit, and be at least 8 characters long")
    private String password;
}
