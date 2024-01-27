package com.example.demotest.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemUtilTest {
  @Test
    void test()
    {
        Integer []a={0,1,2,3,4,5};
        System.out.println(SystemUtil.getid(a));
    }

}