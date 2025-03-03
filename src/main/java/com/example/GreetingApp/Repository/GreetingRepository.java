package com.example.GreetingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.GreetingApp.Model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}