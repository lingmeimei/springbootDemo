package com.example.springbootdemo.modules.cmsadmin.domain.primary.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "user")
@Entity
@Getter
@Setter
public class UserPri implements Serializable{

    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String password;

    public UserPri(){}

    public UserPri(String userName, Integer age,String password) {
        this.userName = userName;
        this.age = age;
        this.password = password;
    }


}
