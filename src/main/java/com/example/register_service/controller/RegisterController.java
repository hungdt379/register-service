package com.example.register_service.controller;

import com.example.register_service.entity.User;
import com.example.register_service.request.RegisterUserRequest;
import com.example.register_service.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterUserRequest request) {
        return ResponseEntity.ok(registerService.registerUser(request.getUser(), request.getListSubjectId()));
    }
}
