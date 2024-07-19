package com.springBasics.Validation;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UsersController {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody Users user) {
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}
