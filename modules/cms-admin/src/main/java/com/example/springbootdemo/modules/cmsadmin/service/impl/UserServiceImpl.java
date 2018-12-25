package com.example.springbootdemo.modules.cmsadmin.service.impl;

import com.example.springbootdemo.modules.cmsadmin.domain.primary.entity.UserPri;
import com.example.springbootdemo.modules.cmsadmin.domain.primary.repository.UserRepositoryPri;
import com.example.springbootdemo.modules.cmsadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryPri userRepositoryPri;


    public List<UserPri> getAllUser(){
        return userRepositoryPri.findAll();
    }

}
