package com.example.GreetingApp.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.GreetingApp.Service.GreetingService;
import com.example.GreetingApp.Model.Greeting;

/**
 * GreetingController handles HTTP requests for greeting messages.
 */
@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /**
     * Handles GET requests to generate a greeting message.
     *
     * @param firstName Optional first name query parameter
     * @param lastName  Optional last name query parameter
     * @return A Greeting object containing the personalized greeting message.
     *
     * Example Requests:
     * - `curl -X GET "http://localhost:8080/greetings"` → "Hello, World!"
     * - `curl -X GET "http://localhost:8080/greetings?firstName=John"` → "Hello, John!"
     * - `curl -X GET "http://localhost:8080/greetings?lastName=Doe"` → "Hello, Doe!"
     * - `curl -X GET "http://localhost:8080/greetings?firstName=John&lastName=Doe"` → "Hello, John Doe!"
     */
    @GetMapping
    public Greeting getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return new Greeting(greetingService.getGreetingMessage(firstName, lastName));
    }
}