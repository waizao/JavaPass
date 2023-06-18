package com.boot.demo.dao;

import com.boot.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    @Select("select * from userinfo")
    List<User> queryAll();

    @Select("select * from userinfo where username = #{username}")
    User findByName(String username);

    @Insert("insert into userinfo(username,password,plat,registdate) values(#{username},#{password},#{plat},#{registdate})")
    int insert(User userinfo);
}
