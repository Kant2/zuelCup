package com.example.competitiondemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 核心过滤器
 * AbstractAuthenticationProcessingFilter：
 *  通过之前创建的“认证管理器”（authentication manage）处理认证请求（authentication request）
 * 1. 从请求头（Authentication）中读取认证token
 * 2. 验证token有效性
 * 3. 加载token关联的UserDetail（从数据库）
 * 4. 将UserDetail放在Spring Security的Spring Context中——以进行授权检查
 *  我们可以在Controller中通过SecurityContext获得UserDetail——运行业务逻辑
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("调用：doFilterInternal");
        String token = getTokenFromRequest(request);

        if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {

            String id = tokenProvider.getUserIdFromJWT(token).toString();

            /*
                Note that you could also encode the user's username and roles inside JWT claims
                and create the UserDetails object by parsing those claims from the JWT.
                That would avoid the following database hit. It's completely up to you.
             */
            UserDetails userDetails = userDetailsService.loadUserById(id);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        System.out.println("未找到token，交给后面的过滤器");
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {

        System.out.println("调用：getTokenFromRequest");
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }

        return null;
    }
}
