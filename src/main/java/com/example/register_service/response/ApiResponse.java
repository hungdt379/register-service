package com.example.register_service.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private boolean error;
    private HttpStatus errorCode;
    private String errorMessage;
    private String message;
    private T data;

    // Success
    public ApiResponse(boolean error, String message, T data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    // Error
    public ApiResponse(boolean error, HttpStatus errorCode ,String errorMessage) {
        this.error = error;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
