package com.dhu.springbootauto.controller;

import com.dhu.springbootauto.entites.User;
import com.dhu.springbootauto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user")
    public User getUser( Integer id){
        return userMapper.getUserById(id);
    }

    @GetMapping("/delete")
    public int deleteuser(Integer id){
       return userMapper.deleteById(id);
    }

    @GetMapping("/update")
    public int update(User user){
        return userMapper.updateUser(user);
    }

    @GetMapping("/insert")
    public int insert(User user)
    {
        return userMapper.insertUser(user);
    }



}
