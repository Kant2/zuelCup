package com.example.competitiondemo.security.model;

import com.example.competitiondemo.pojo.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 被UserDetailService返回，Spring Security使用这些信息进行认证 & 授权
 */
@Data
public class UserPrincipal implements UserDetails {

    private Long id;
    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String username, String password, List<GrantedAuthority> grantedAuthorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = grantedAuthorities;
    }

    /**
     * 学生用户暂时硬编码成“USER”
     *
     * @param student
     * @return
     */
    public static UserPrincipal create(Student student) {

        System.out.println("根据用户信息创建UserPrincipal");
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        System.out.println("用户密码为：" + student.getSPwd());
        return new UserPrincipal(
                Long.parseLong(student.getSId()),
                student.getSName(),
                student.getSPwd(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // ...找了半天BUG，原来默认反悔了NULL W(￣_￣)W
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
