package com.example.register_service.response;

import com.example.register_service.entity.Subject;
import com.example.register_service.response.dto.SubjectDTO;
import com.example.register_service.response.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllSubjectReponse extends SubjectDTO {

    private List<UserDTO> users;

    public GetAllSubjectReponse(Long id, String subjectName, List<UserDTO> userDTOs) {
        super(id, subjectName);
        this.users = userDTOs;
    }

    public static GetAllSubjectReponse responseWithUser(Subject subject) {
        List<UserDTO> userDTOs = subject.getUsers().stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());

        return new GetAllSubjectReponse(
                subject.getId(),
                subject.getSubjectName(),
                userDTOs
        );
    }
}
