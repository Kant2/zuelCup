package com.example.competitiondemo.controller;

import com.example.competitiondemo.pojo.Student;
import com.example.competitiondemo.repository.StudentRepository;
import com.example.competitiondemo.security.JwtTokenProvider;
import com.example.competitiondemo.util.result.Result;
import com.example.competitiondemo.util.result.ResultGenerator;
import com.example.competitiondemo.vo.JwtAuthenticationResponse;
import com.example.competitiondemo.vo.LoginRequest;
import com.example.competitiondemo.vo.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    StudentRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Result authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        System.out.println("准备认证：" + loginRequest.getUserId() + "---" + loginRequest.getPassword());

        System.out.println("生成认证token： ");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getPassword());

        System.out.println(authenticationToken.getPrincipal());
        System.out.println(authenticationToken.getCredentials());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        System.out.println("将用户放入SecurityContext");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("生成token");
        String token = tokenProvider.generateToken(authentication);

        return ResultGenerator.getSuccessResult(new JwtAuthenticationResponse(token));

    }

    @PostMapping("/signup")
    public Result registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (repository.existsBySId(signUpRequest.getId())) {
            return ResultGenerator.getFailResult("该学号已经被使用！");
        }

        // 创建用户账号
        Student student = new Student(
                signUpRequest.getId(), signUpRequest.getUsername(), signUpRequest.getGender(),
                signUpRequest.getMajor(), signUpRequest.getUclass(),
                signUpRequest.getTel(), signUpRequest.getEmail()
        );

        // 暂时：encode密码
        student.setSPwd(passwordEncoder.encode(signUpRequest.getPassword()));
        // 暂时：设置临时使用角色
        student.setSRole(1);
        // 暂时：设置性格
        student.setSPersonality("123");

        System.out.println("准备创建用户");

        Student result = repository.save(student);

        System.out.println("创建用户成功");
        System.out.println(result);

        return ResultGenerator.getSuccessResult(result);
    }

}
