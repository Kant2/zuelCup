package com.example.competitiondemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeacherController {

    /**
     * 修改教师个人信息
     *
     * @param teacher 教师信息
     * @return 结果消息
     */
    public String saveTeacher(String teacher) {
        return null;
    }
}
