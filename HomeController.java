package com.example.readhub.readhub_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hey Momal!!    🚀 ReadHub Backend is running!   Congratulations :)";
    }
}

