package com.example.demotest.controller;

import com.example.demotest.config.Result;

import com.example.demotest.pojo.User;
import com.example.demotest.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class LoginController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "登录")
    @GetMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        return userService.login(username,password);
    }

    @ApiOperation(value = "获得用户权限")
    @GetMapping("/getper")
    public Integer getper(@RequestBody User user)
    {
        return userService.getper(user);
    }


}
