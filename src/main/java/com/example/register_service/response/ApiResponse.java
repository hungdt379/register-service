package com.example.register_service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponse<T> {
    private String status; // Trạng thái (ví dụ: "success", "error")
    private String message; // Thông báo (ví dụ: "Thành công", "Lỗi")
    private T data; // Dữ liệu trả về
}
