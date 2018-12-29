package com.example.springbootdemo.modules.cmsadmin.service;

import com.example.springbootdemo.common.vo.UserVO;
import com.example.springbootdemo.modules.cmsadmin.domain.primary.entity.UserPri;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

    /**
     * 根据用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return userVo
     */
    UserVO findUserByUsername(@PathVariable("username")String username);

    /**
     * 通过手机号查询用户、角色信息
     *
     * @param mobile 手机号
     * @return UserVo
     */
    UserVO findUserByMobile(@PathVariable("mobile") String mobile);

    /**
     * 根据OpenId查询用户信息
     * @param openId openId
     * @return UserVo
     */
    UserVO findUserByOpenId(@PathVariable("openId") String openId);





    public List<UserPri> getAllUser();

}
