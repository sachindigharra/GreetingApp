package com.example.GreetingApp.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.greetingApp.Service.GreetingService;
import com.example.greetingApp.Model.Greeting;
import java.util.List;

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
     * Saves a greeting message based on user input.
     *
     * Example:
     * - `curl -X POST "http://localhost:8080/greetings?firstName=John&lastName=Doe"`
     */
    @PostMapping
    public Greeting saveGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.saveGreeting(firstName, lastName);
    }

    /**
     * Retrieves all saved greetings.
     *
     * Example:
     * - `curl -X GET "http://localhost:8080/greetings"`
     */
    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}