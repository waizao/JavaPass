package com.boot.demo.controller;

import com.boot.demo.entity.User;
import com.boot.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/")
public class TaskController {
    private UserService userService;
    @Autowired
    public void SetRedisUtil(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUser/{username}")
    @Cacheable(cacheNames = "userinfo" ,key="#username")
    public User getUserByName(@PathVariable String username){
        log.info("user={}",username);
        return this.userService.queryUserByName(username);
    }

    @PostMapping("/addUser")
    public int addUser(@RequestParam String username,@RequestParam String password,@RequestParam int plat){
        User user = new User(username,password,plat);
        System.out.println(user);
        return this.userService.addUser(user);
    }
}
