package com.example.competitiondemo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignupRequest {

    @NotBlank
    private String id;

    private String username;
    private String gender;

    @NotBlank
    @Size(min = 6, max = 10)
    private String password;


    private String major;
    private String uclass;

    private String tel;
    private String email;
}
