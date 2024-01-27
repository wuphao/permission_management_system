package com.example.demotest.service.impl;

import com.example.demotest.config.Result;
import com.example.demotest.controller.PositionController;
import com.example.demotest.mapper.PositionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PositionServiceImplTest {
    @Resource
    private PositionController positionController;

    @Test
    void getallpos() {
        Result result=  positionController.getallposs();
        System.out.println(result);
    }

    @Test
    void selectByTiaoJianpos() {
    }
}