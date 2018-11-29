package com.example.competitiondemo.pojo;

import com.example.competitiondemo.enums.GenderEnum;
import com.example.competitiondemo.util.converter.GenderConverter;
import lombok.Data;
import org.springframework.core.annotation.AliasFor;

import javax.persistence.*;

@Entity
@Data
public class Student {

    /**
     * 性别、专业、性格、角色不用枚举类型吗？
     */

    @Id
    @Column(name = "S_Id")
    private String sId;

    @Column(name = "S_Name")
    private String sName;

    // 这里是char？
    @Column(name = "S_Sex")
//    @Convert(converter = GenderConverter.class)
//    private GenderEnum sGender;
    private String sGender;

    @Column(name = "S_Major")
    private String sMajor;

    @Column(name = "S_Class")
    private String sClass;

    @Column(name = "S_Personality")
    private String sPersonality;

    @Column(name = "S_Role")
    private int sRole;

    @Column(name = "S_Tel")
    private String sTel;

    @Column(name = "S_Email")
    private String sEmail;

    @Column(name = "S_Password")
    private String sPwd;

    // 加入S_Personality\ S_Role
    public Student(String id, String username, String gender, String major, String uClass, String tel, String email) {
        this.sId = id;
        this.sName = username;
        this.sGender = gender;
        this.sMajor = major;
        this.sClass = uClass;
        this.sTel = tel;
        this.sEmail = email;
    }

    public Student() {
    }
}
