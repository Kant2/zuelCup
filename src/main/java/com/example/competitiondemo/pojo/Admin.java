package com.example.competitiondemo.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "administrator")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "A_ID")
    private String aId;

    // 管理员怎么还有role？
    @Column(name = "A_Role")
    private String aRole;

    @Column(name = "A_Password")
    private String aPwd;
}
