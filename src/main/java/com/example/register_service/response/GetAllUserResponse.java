package com.example.register_service.response;

import com.example.register_service.entity.User;
import com.example.register_service.response.dto.SubjectDTO;
import com.example.register_service.response.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetAllUserResponse extends UserDTO {

    private List<SubjectDTO> subjects = new ArrayList<>();

    public GetAllUserResponse(Long userId, String username, String name, String email, String phone, List<SubjectDTO> subjects) {
        super(userId, username, name, email, phone);
        this.subjects = subjects;
    }

    public GetAllUserResponse(Long userId, String username, String name, String email, String phone) {
        super(userId, username, name, email, phone);
    }

    public static GetAllUserResponse responseWithSubject(User user) {
        List<SubjectDTO> subjectDTOs = user.getSubjects().stream()
                .map(SubjectDTO::fromEntity)
                .collect(Collectors.toList());

        return new GetAllUserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                subjectDTOs
        );
    }

    public static GetAllUserResponse fromEntity(User user) {
        return new GetAllUserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getName(),
                user.getEmail(),
                user.getPhone()
        );
    }
}
