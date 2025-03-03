package com.example.GreetingApp.Service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    /**
     * Generates a greeting message based on the provided user attributes.
     *
     * @param firstName User's first name (optional)
     * @param lastName  User's last name (optional)
     * @return Personalized greeting message
     */
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello, World!";
        }
    }
}