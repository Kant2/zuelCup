package com.example.competitiondemo.pojo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Message {

    // 类型是int？
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Msg_Id")
    private String mId;

    @Column(name = "Sender_Id")
    private String sId;
    @Column(name = "Receiver_Id")
    private String rId;

    private String Content;

    @Column(name = "Msg_Flag")
    private int mFlag;

    @Column(name = "Msg_Time")
    @CreatedDate
    private Date mTime;
}
