package com.example.competitiondemo.security;

import com.example.competitiondemo.pojo.Student;
import com.example.competitiondemo.repository.StudentRepository;
import com.example.competitiondemo.security.model.UserPrincipal;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 为“认证用户”&“进行角色检查”提供用户细节数据
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    StudentRepository repository;

    /**
     * 被Spring使用
     * 返回UserDetail对象——进行各种认证 & 角色检查
     *
     * @param id 用户名
     * @return UserDetail对象
     * @throws UsernameNotFoundException 找不到用户
     */
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        try {
            System.out.println("使用方法 loadUserByUsername 找到了Id为 " + id + " 的用户");
            Student student = repository.findById(id).get();
            return UserPrincipal.create(student);
        } catch (Exception e) {
            System.out.println("使用方法 loadUserByUsername 没找到Id为 " + id + " 的用户");
            System.out.println(e);
            throw  new UsernameNotFoundException("没有找到id为 " + id + " 的用户");
        }

    }

    /**
     * Used by JwtAuthenticationFilter
     *
     * @param id
     * @return
     */
    public UserDetails loadUserById(String id) {
        Student student = repository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));

        System.out.println("没找到Id为 " + id + " 的用户");

        return UserPrincipal.create(student);
    }

}
