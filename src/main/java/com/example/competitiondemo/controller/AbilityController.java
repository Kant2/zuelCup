package com.example.competitiondemo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AbilityController {

    // 能力数据查询

    /**
     * 获取能力数据(当前时间点下 & 所有类型)
     *
     * @return 能力数据
     */
    public String getGeneralAbilityData() {
        return null;
    }


    /**
     * 获取能力数据（所有时间点 & 单独类型）
     *
     * @return 能力数据
     */
    public String getParticularAbilityDataOrderByTime() {
        return null;
    }

    /**
     * 获取能力数据（所有时间点 & 单独类型 & 原始数据）
     *
     * @return 上传数据 & 加分情况
     */
    public String getParticularAblilityPlainData() {
        return null;
    }

    /**
     * 获取第二课堂成绩单（按能力分类）
     *
     * @return 成绩单
     */
    public String getSchoolReport() {
        return null;
    }

    // 能力数据增加 & 修改

    /**
     * 上传能力数据
     *
     * @param data 能力数据（按照类别分类）
     * @return 上传数据 + 加分情况
     */
    public String postAbiltyData(String data) {
        return null;
    }

    // 能力数据修改就是审核？
}
