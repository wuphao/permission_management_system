package com.example.demotest.utils;


import java.util.Arrays;


public class SystemUtil {
    public static Integer getid(Integer []id) {
        Arrays.sort(id);
        int size=id.length;
        int i=0;
        for(;i<size;i++) {
          if (id[i] != i)
              break;
         }
        return i;

    }
}
