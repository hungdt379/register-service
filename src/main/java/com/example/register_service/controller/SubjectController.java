package com.example.register_service.controller;

import com.example.register_service.entity.Subject;
import com.example.register_service.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Subject>> getAllSubject () {
        return ResponseEntity.ok(subjectService.getAllSubject());
    }

}
