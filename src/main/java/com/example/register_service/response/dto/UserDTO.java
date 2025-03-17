package com.example.register_service.response.dto;

import com.example.register_service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long userId;
    private String username;
    private String name;
    private String email;
    private String phone;

    // Chuyển đổi từ User sang UserDTO
    public static UserDTO fromEntity(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getName(),
                user.getPhone(),
                user.getEmail()
        );
    }

}
