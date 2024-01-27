package com.example.demotest.controller;

import com.example.demotest.config.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserControllerTest {
    @Resource
    private UserController userController;
    @Test
    void login() {
        Result result=userController.getusercount();
        System.out.println(result);
    }
}