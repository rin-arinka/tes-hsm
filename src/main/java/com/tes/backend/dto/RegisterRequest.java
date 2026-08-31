package com.tes.backend.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String nama;
    private String email;
    private String password;
}
