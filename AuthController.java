package com.example.readhub.readhub_backend.controller;

import com.example.readhub.readhub_backend.dto.LoginRequest;
import com.example.readhub.readhub_backend.model.User;
import com.example.readhub.readhub_backend.payload.ApiResponse;
import com.example.readhub.readhub_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        System.out.println("🔐 Login attempt for: " + request.getEmail());

        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            System.out.println("✅ User found: " + user.getEmail());

            if (user.getPassword().equals(request.getPassword())) {
                System.out.println("🔑 Password matched");

                user.setLoggedIn(true);
                userRepository.save(user);

                return ResponseEntity.ok(new ApiResponse("Login successful"));
            } else {
                System.out.println("❌ Password mismatch");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new ApiResponse("Invalid password"));
            }
        } else {
            System.out.println("❌ User not found");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse("User not found"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody LoginRequest request) {
        System.out.println("📝 Registration attempt for: " + request.getEmail());

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            System.out.println("⚠️ Email already registered");
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ApiResponse("Email already registered"));
        }

        User newUser = new User(request.getEmail(), request.getPassword(), false);
        userRepository.save(newUser);
        System.out.println("✅ Registration successful");

        return ResponseEntity.ok(new ApiResponse("Registration successful"));
    }

    @GetMapping("/ping")
    public ApiResponse ping() {
        return new ApiResponse("✅ Server is alive!");
    }
}
