package com.example.demotest.service.impl;

import com.example.demotest.config.Result;
import com.example.demotest.controller.RoleController;
import com.example.demotest.pojo.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class RoleServiceImplTest {
     @Resource
    private RoleController roleController;
    @Test
    void getallrole() {
        Result result=roleController.getallroles();
        System.out.println(result.getData());
    }
    @Test
    void update()
    {
//        Role role=new Role(null,"admin6","人事部","软件工程师","增加");
//        Result result=roleController.updaterole(role);
//        System.out.println(result);
        System.out.println(roleController.getrolecount().getData());
    }
}