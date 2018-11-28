package com.example.competitiondemo.pojo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * 这个类意义不明，或者是名字太奇怪了
 * 怎么又用小写了
 */
@Entity
@Data
@Table(name = "jiafen")
public class Jf {

    // 怎么又是int了？
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jf_Id")
    private String jId;

    @Column(name = "S_Id")
    private String sId;

    @Column(name = "jf_Type")
    private String jType;
    @Column(name = "jf_Value")
    private String jValue;
    @Column(name = "jf_Detail")
    private String jDetail;
    @Column(name = "jf_Flag")
    private String jFlag;

    @CreatedDate
    @Column(name = "jf_Time")
    private Date jTime;

    // Img 用七牛云储存？

    @Column(name = "jf_Img")
    private String jImg;

}
