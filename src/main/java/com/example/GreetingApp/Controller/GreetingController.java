package com.example.GreetingApp.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.GreetingApp.Service.GreetingService;
import com.example.GreetingApp.Model.Greeting;
import java.util.List;
import java.util.Optional;

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
     *  new method for get all ids
     */
    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    /**
     * Retrieves a greeting message by its ID.
     * <p>
     * Example:
     * - curl -X GET "http://localhost:8080/greetings/{id}"
     */
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
}