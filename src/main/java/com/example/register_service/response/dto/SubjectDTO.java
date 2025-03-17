package com.example.register_service.response.dto;

import com.example.register_service.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDTO {
    private Long id;
    private String subjectName;

    public static SubjectDTO fromEntity(Subject subject) {
        return new SubjectDTO(
                subject.getId(),
                subject.getSubjectName()
        );
    }


}
