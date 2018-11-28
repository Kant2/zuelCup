package com.example.competitiondemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用户权限
 */
@RestController
public class DemoController {

    @GetMapping("/api/public")
    public String getDemoData() {
        return "Public Demo";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/api/private")
    public String getDemoPrivateData() {
        return "Private Demo Data";
    }

    @GetMapping("/admin/data")
    public String getDemoAdminData() {
        return "Administrator Demo Data. This is a local Commit";
    }
}