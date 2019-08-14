package com.dhu.springbootauto.controller;


import com.dhu.springbootauto.entites.Book;
import com.dhu.springbootauto.entites.User;
import com.dhu.springbootauto.mapper.BookMapper;
import com.dhu.springbootauto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        try{
            Integer id  = Integer.valueOf(username);
            User user = userMapper.getUserById(id);
            if(password.equals(user.getPassword())){

                session.setAttribute("UserId",id);
                //如果是用户
                if(user.getStatus()==1)
                {
                    return "redirect:/main?page=1&keyword=";
                }
                else{
                    return "redirect:/main_admin?page=1&keyword=";
                }
            }
            else{
                map.put("msg","用户名或密码错误");
                return "login";
            }
        }
        catch (Exception e) {
            map.put("msg","用户名或密码错误");
            return "login";
        }


}}
