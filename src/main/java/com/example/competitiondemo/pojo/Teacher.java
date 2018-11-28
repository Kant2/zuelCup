package com.example.competitiondemo.pojo;

import lombok.Data;
import org.springframework.core.annotation.AliasFor;

import javax.persistence.*;

@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_Id")
    private String tId;

    @Column(name = "T_Name")
    private String tName;

    @Column(name = "T_Pwd")
    private String tPwd;

    @Column(name = "t_Sex")
    private String tGender;

    @Column(name = "T_Age")
    private String tAge;

    @Column(name = "T_Email")
    private String tEmail;

    @Column(name = "T_Runclasses")
    private String tRunClasses;

}
