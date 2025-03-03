package com.example.GreetingApp.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    /**
     * Handles HTTP GET requests.
     * This method returns a simple JSON response indicating that a GET request was received.
     * GET is typically used for retrieving data from the server.
     *
     * Example Usage:
     * curl -X GET http://localhost:8080/greetings
     */
    @GetMapping
    public String getGreeting() {
        return "{\"message\": \"Hello, GET request received!\"}";
    }

    /**
     * Handles HTTP POST requests.
     * This method returns a JSON response indicating that a POST request was received.
     * POST is commonly used for sending new data to the server, such as creating a new resource.
     *
     * Example Usage:
     * curl -X POST http://localhost:8080/greetings
     */
    @PostMapping
    public String postGreeting() {
        return "{\"message\": \"Hello, POST request received!\"}";
    }

    /**
     * Handles HTTP PUT requests.
     * This method returns a JSON response indicating that a PUT request was received.
     * PUT is generally used for updating existing resources or creating them if they do not exist.
     *
     * Example Usage:
     * curl -X PUT http://localhost:8080/greetings
     */
    @PutMapping
    public String putGreeting() {
        return "{\"message\": \"Hello, PUT request received!\"}";
    }

    /**
     * Handles HTTP DELETE requests.
     * This method returns a JSON response indicating that a DELETE request was received.
     * DELETE is used to remove a resource from the server.
     *
     * Example Usage:
     * curl -X DELETE http://localhost:8080/greetings
     */
    @DeleteMapping
    public String deleteGreeting() {
        return "{\"message\": \"Hello, DELETE request received!\"}";
    }
}