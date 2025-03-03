package com.example.GreetingApp.Controller;

import com.example.GreetingApp.Model.Greeting;
import com.example.GreetingApp.Service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Greeting getGreeting() {
        return new Greeting(greetingService.getGreetingMessage());
    }
}