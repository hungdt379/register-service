package com.example.register_service.service.impl;

import com.example.register_service.entity.Subject;
import com.example.register_service.entity.User;
import com.example.register_service.kafka.KafkaProducer;
import com.example.register_service.repository.SubjectRepository;
import com.example.register_service.repository.UserRepository;
import com.example.register_service.response.GetAllUserResponse;
import com.example.register_service.response.RegisterUserResponse;
import com.example.register_service.service.RegisterService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegisterServiceImpl implements RegisterService {

    private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    Gson gson;

    @Override
    public RegisterUserResponse registerUser(User user, List<Long> listSubjectId) {

        String username = user.getUsername();
        User existedUser = userRepository.findByUsername(username);
        if (existedUser != null) {
            throw new RuntimeException("username = " + username + " was existed");
        }

        if (CollectionUtils.isEmpty(listSubjectId)) {
            listSubjectId = new ArrayList<>();
        }

        List<Subject> subjects = subjectRepository.findAllByIds(listSubjectId);
        user.getSubjects().addAll(subjects);


        RegisterUserResponse userResponse = RegisterUserResponse.responseWithSubject(userRepository.save(user));
        logger.info("Register successfully: {}", gson.toJson(userResponse));

        kafkaProducer.sendMessage("send-email", userResponse.getEmail());
        return userResponse;
    }

    @Override
    public List<GetAllUserResponse> getAllUser() {
        return userRepository.findAll().stream()
                .map(GetAllUserResponse::responseWithSubject)
                .collect(Collectors.toList());
    }

    @Override
    public Page<User> getAllUserWithoutSubject(int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize, Sort.by("username").ascending());
        return userRepository.findAll(pageable);
    }

}
