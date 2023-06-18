package com.boot.demo.service;

import com.boot.demo.dao.UserMapper;
import com.boot.demo.entity.User;
import com.boot.demo.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisUtil redisUtil;

    public List<User> queryAll(){
        return userMapper.queryAll();
    }

    public int addUser(User user){
        return userMapper.insert(user);
    }

    public User queryUserByName(String username){
        if(redisUtil.hasKey(username)){
            log.info("query user from redis");
            return (User) redisUtil.get(username);
        }else{
            log.info("query user from mysql");
            User user = userMapper.findByName(username);
            if (user != null){
                redisUtil.set(username,user);
            }
            return user;
        }
    }
}
