package com.example.register_service.service.impl;

import com.example.register_service.entity.Subject;
import com.example.register_service.response.GetAllSubjectReponse;
import com.example.register_service.repository.SubjectRepository;
import com.example.register_service.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAllSubjectsWithUsers();
    }
}
