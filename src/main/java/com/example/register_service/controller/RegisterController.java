package com.example.register_service.controller;

import com.example.register_service.entity.User;
import com.example.register_service.request.RegisterUserRequest;
import com.example.register_service.response.ApiResponse;
import com.example.register_service.response.GetAllUserResponse;
import com.example.register_service.response.RegisterUserResponse;
import com.example.register_service.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterUserResponse>> registerUser(@RequestBody RegisterUserRequest request) {
        RegisterUserResponse userResponse = registerService.registerUser(request.getUser(), request.getListSubjectId());
        return ResponseEntity.ok(new ApiResponse<>(false, "User register successfully",
                userResponse));
    }

    @GetMapping("/user/all")
    public ResponseEntity<ApiResponse<List<GetAllUserResponse>>> getAllUser() {
        List<GetAllUserResponse> allUserResponses = registerService.getAllUser();
        return ResponseEntity.ok(new ApiResponse<>(false, "Successfully",
                allUserResponses));
    }
}
