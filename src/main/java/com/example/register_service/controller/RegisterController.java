package com.example.register_service.controller;

import com.example.register_service.entity.User;
import com.example.register_service.request.RegisterUserRequest;
import com.example.register_service.response.ApiResponse;
import com.example.register_service.response.RegisterUserResponse;
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
    public ResponseEntity<ApiResponse<RegisterUserResponse>> registerUser(@RequestBody RegisterUserRequest request) {
        User user = registerService.registerUser(request.getUser(), request.getListSubjectId());
        return ResponseEntity.ok(new ApiResponse<>("Success", "Đăng ký user thành công",
                RegisterUserResponse.responseWithSubject(user)));
    }
}
