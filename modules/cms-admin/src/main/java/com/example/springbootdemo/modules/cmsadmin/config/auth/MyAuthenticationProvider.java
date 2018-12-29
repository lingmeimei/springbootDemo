package com.example.springbootdemo.modules.cmsadmin.config.auth;

import com.example.springbootdemo.modules.cmsadmin.domain.auth.UserDetailsImpl;
import com.example.springbootdemo.modules.cmsadmin.service.auth.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    /**
     * 注入我们自己定义的用户信息获取对象
     */
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        System.out.println("Authentication");
        String userName = authentication.getName();// 这个获取表单输入中返回的用户名;
        String password = authentication.getCredentials().toString();// 这个是表单中输入的密码；
        System.out.println("Authentication,userName="+userName+",password="+password);

        // 这里构建来判断用户是否存在
        UserDetailsImpl anyUser = (UserDetailsImpl) userDetailsServiceImpl.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；
        if (anyUser == null) {
            throw new BadCredentialsException("用户名不存在");
        }
        Collection<? extends GrantedAuthority> authorities = anyUser.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(anyUser, password, authorities);
    }


    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        // 这里直接改成retrun true;表示是支持这个执行
        return true;
    }


}