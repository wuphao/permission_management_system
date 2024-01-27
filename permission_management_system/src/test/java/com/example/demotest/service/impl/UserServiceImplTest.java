package com.example.demotest.service.impl;

import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.example.demotest.config.Result;
import com.example.demotest.controller.LoginController;
import com.example.demotest.controller.UserController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demotest.pojo.User;
import javax.annotation.Resource;


@SpringBootTest
@Slf4j
class UserServiceImplTest {
   @Resource
    private UserController userController;
   @Resource
   private LoginController loginController;
    @Test
    void selectByTiaoJianuser() {
        Result result=userController.selectByTiaoJianuser("用户","张三","1",10,1);
        System.out.println(result.getData());
    }
    @Test
    void login()
    {
        String key = "sm4demo123456789";
        SymmetricCrypto sm4 = new SymmetricCrypto("SM4/ECB/PKCS5Padding", key.getBytes());
        String password1= sm4.encryptHex("user6");
        System.out.println(password1);
    }
    @Test
    void insert()
    {
        User user=new User(null,"test666644987766","321456","1632333","qqeamikl","admin1");
        Result result=userController.insertuser(user);
        System.out.println(user);
    }
    @Test
    void getper()
    {
        User user=new User(7,"user6","user6","631","user6@163.com","admin6");
        Integer perid=loginController.getper(user);
        System.out.println(perid);
    }
    @Test
    void testps() {
        System.out.println(userController.getusercount().getData());
    }
}