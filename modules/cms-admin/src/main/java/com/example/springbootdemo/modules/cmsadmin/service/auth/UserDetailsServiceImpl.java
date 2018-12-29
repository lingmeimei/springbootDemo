package com.example.springbootdemo.modules.cmsadmin.service.auth;

import com.example.springbootdemo.common.vo.UserVO;
import com.example.springbootdemo.modules.cmsadmin.domain.auth.UserDetailsImpl;
import com.example.springbootdemo.modules.cmsadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVo = userService.findUserByUsername(username);
        return new UserDetailsImpl(userVo);
    }


}
