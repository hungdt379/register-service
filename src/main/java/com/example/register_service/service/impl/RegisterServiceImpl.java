package com.example.register_service.service.impl;

import com.example.register_service.entity.Subject;
import com.example.register_service.entity.User;
import com.example.register_service.kafka.KafkaProducer;
import com.example.register_service.repository.SubjectRepository;
import com.example.register_service.repository.UserRepository;
import com.example.register_service.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public User registerUser(User user, List<Long> listSubjectId) {
        if (CollectionUtils.isEmpty(listSubjectId)) {
            listSubjectId = new ArrayList<>();
        }
        List<Subject> subjects = subjectRepository.findAllByIds(listSubjectId);
        user.getSubjects().addAll(subjects);
        User userResponse = userRepository.save(user);

        kafkaProducer.sendMessage("send-email", userResponse.getEmail());
        return userResponse;
    }

}
