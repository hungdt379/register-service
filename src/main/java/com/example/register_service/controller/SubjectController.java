package com.example.register_service.controller;

import com.example.register_service.response.ApiResponse;
import com.example.register_service.response.GetAllSubjectReponse;
import com.example.register_service.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<GetAllSubjectReponse>>> getAllSubject() {
        return ResponseEntity.ok(new ApiResponse<>(false, "Successfully",
                subjectService.getAllSubject().stream().map(GetAllSubjectReponse::responseWithUser).collect(Collectors.toList())));
    }

}
