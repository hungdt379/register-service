package com.example.register_service.service;

import com.example.register_service.entity.User;

import java.util.List;

public interface RegisterService {
    User registerUser(User user, List<Long> listSubjectId);
}
