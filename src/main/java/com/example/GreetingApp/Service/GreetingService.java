package com.example.greetingApp.Service;

import org.springframework.stereotype.Service;
import com.example.greetingApp.Model.Greeting;
import com.example.greetingApp.Repository.GreetingRepository;

import java.util.List;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    /**
     * Generates and saves a greeting message based on the user input.
     */
    public Greeting saveGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello, World!";
        }

        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting); // Save to DB



    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}