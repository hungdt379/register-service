package com.example.register_service.service;

import com.example.register_service.entity.Subject;
import com.example.register_service.response.GetAllSubjectReponse;
import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubject();
}
