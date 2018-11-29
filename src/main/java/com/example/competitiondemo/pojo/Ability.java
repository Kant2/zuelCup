package com.example.competitiondemo.pojo;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Ability {

    /**
     * “Score”是不是太冗余了
     */

    @Id
    @Column(name = "S_Id")
    private String sId;
    @Column(name = "programmingScore")
    private Integer programming;
    @Column(name = "designScore")
    private Integer design;
    @Column(name = "languageScore")
    private Integer language;
    @Column(name = "mathScore")
    private Integer math;
    @Column(name = "researchScore")
    private Integer research;
    @Column(name = "writingScore")
    private Integer writing;
    @Column(name = "basisScore")
    private Integer basis;
    @Column(name = "innovationScore")
    private Integer innovation;
    @Column(name = "teamworkScore")
    private Integer teamwork;

    @LastModifiedDate
    private Date updateTime;
}
