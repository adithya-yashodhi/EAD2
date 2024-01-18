package com.example.userservice.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data //
@NoArgsConstructor //generate getters,setters,hashcode and toString method
public class LoginResponse { //Represents login-related data.

    private Long userId;
    private String message;
    private boolean status;

    public LoginResponse(Long userId, String message, boolean status) {
        this.userId = userId;
        this.message = message;
        this.status = status;
    }
}
