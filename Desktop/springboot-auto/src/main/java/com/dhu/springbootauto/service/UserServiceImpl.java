package com.dhu.springbootauto.service;

import com.dhu.springbootauto.entites.User;
import com.dhu.springbootauto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Cacheable(cacheNames = "users")
    public List<User> alluser() {
        return userMapper.alluser();
    }
}
