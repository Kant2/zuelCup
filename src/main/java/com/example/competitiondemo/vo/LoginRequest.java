package com.example.competitiondemo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;
}
