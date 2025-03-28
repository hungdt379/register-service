package com.example.register_service.service;

import com.example.register_service.entity.User;
import com.example.register_service.response.GetAllUserResponse;
import com.example.register_service.response.RegisterUserResponse;

import java.util.List;

public interface RegisterService {
    RegisterUserResponse registerUser(User user, List<Long> listSubjectId);

    List<GetAllUserResponse> getAllUser();
}
