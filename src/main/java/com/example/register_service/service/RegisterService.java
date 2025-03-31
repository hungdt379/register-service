package com.example.register_service.service;

import com.example.register_service.entity.User;
import com.example.register_service.response.GetAllUserResponse;
import com.example.register_service.response.RegisterUserResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RegisterService {
    RegisterUserResponse registerUser(User user, List<Long> listSubjectId);

    List<GetAllUserResponse> getAllUser();

    Page<User> getAllUserWithoutSubject(int pageIndex, int pageSize);
}
