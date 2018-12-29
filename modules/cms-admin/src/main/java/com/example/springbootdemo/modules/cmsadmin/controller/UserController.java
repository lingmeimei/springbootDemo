package com.example.springbootdemo.modules.cmsadmin.controller;

import com.example.springbootdemo.modules.cmsadmin.domain.primary.entity.UserPri;
import com.example.springbootdemo.modules.cmsadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getLoginView(){
        return "login";
    }

    @RequestMapping("/getUserPriListView")
    public String getUserPriListView(){
        return "userManage/userPriList";
    }

    @RequestMapping("/getUserPriList")
    @ResponseBody
    public List<UserPri> getUserPriList(){
        System.out.println(userService.getAllUser());
        return userService.getAllUser();
    }

}
