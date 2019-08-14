package com.dhu.springbootauto.mapper;


import com.dhu.springbootauto.entites.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {
//    @Select("select * from user where id = #{id}")
//    @Delete("delete from user where id = #{id}")
//    @Insert("insert into user (password) values(#{password})")
//    @Update("update User set password = #{password} where id = #{id}")


    public User getUserById(@Param("id") Integer id);
    public int deleteById(@Param("id") Integer id);
    public int insertUser( User user);
    public int updateUser(User user);

    public List<User> alluser();
}
