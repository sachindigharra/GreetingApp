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

     GreetingService greetingService;

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
    @GetMapping("/greetings")
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

    /**
     * Updates an existing greeting message.
     *
     * Example:
     * - `curl -X PUT "http://localhost:8080/greetings/{id}?firstName=John&lastName=Doe"`
     */
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id,
                                   @RequestParam(required = false) String firstName,
                                   @RequestParam(required = false) String lastName) {
        return greetingService.updateGreeting(id, firstName, lastName);
    }

    /**
     * Deletes a greeting message by its ID.
     *
     * Example:
     * - `curl -X DELETE "http://localhost:8080/greetings/{id}"`
     */
    @DeleteMapping("/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
    }


}