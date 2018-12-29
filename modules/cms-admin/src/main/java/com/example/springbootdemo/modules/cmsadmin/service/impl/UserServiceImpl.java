package com.example.springbootdemo.modules.cmsadmin.service.impl;

import com.example.springbootdemo.common.vo.UserVO;
import com.example.springbootdemo.modules.cmsadmin.domain.primary.entity.UserPri;
import com.example.springbootdemo.modules.cmsadmin.domain.primary.repository.UserRepositoryPri;
import com.example.springbootdemo.modules.cmsadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryPri userRepositoryPri;

    @Autowired
    private UserMapperPri userMapperPri;


    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return UserVo
     */
    @Override
    //@Cacheable(value = "user_details", key = "#username")
    public UserVO findUserByUsername(String username) {
        return userMapperPri.selectUserVoByUsername(username);
    }

    /**
     * 通过手机号查询用户信息
     *
     * @param mobile 手机号
     * @return 用户信息
     */
    @Override
    //@Cacheable(value = "user_details_mobile", key = "#mobile")
    public UserVO findUserByMobile(String mobile) {
        return userMapperPri.selectUserVoByMobile(mobile);
    }

    /**
     * 通过openId查询用户
     *
     * @param openId openId
     * @return 用户信息
     */
    @Override
    //@Cacheable(value = "user_details_openid", key = "#openId")
    public UserVO findUserByOpenId(String openId) {
        return userMapperPri.selectUserVoByOpenId(openId);
    }



    public List<UserPri> getAllUser(){
        return userRepositoryPri.findAll();
    }

}
