package com.example.register_service.service.impl;

import com.example.register_service.entity.Subject;
import com.example.register_service.entity.User;
import com.example.register_service.kafka.KafkaProducer;
import com.example.register_service.repository.SubjectRepository;
import com.example.register_service.repository.UserRepository;
import com.example.register_service.response.RegisterUserResponse;
import com.example.register_service.service.RegisterService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
        if (CollectionUtils.isEmpty(listSubjectId)) {
            listSubjectId = new ArrayList<>();
        }

        List<Subject> subjects = subjectRepository.findAllByIds(listSubjectId);
        user.getSubjects().addAll(subjects);
        RegisterUserResponse userResponse = RegisterUserResponse.responseWithSubject(userRepository.save(user));
        logger.info("Register successfully: {}", gson.toJson(userResponse));

//        kafkaProducer.sendMessage("send-email", userResponse.getEmail());
        return userResponse;
    }

}
