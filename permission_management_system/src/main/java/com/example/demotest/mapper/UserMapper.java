package com.example.demotest.mapper;


import com.example.demotest.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {


    Integer getusercount();
    Integer [] getuserid();
    Integer getper(User user);
    User login(String username,String password);
    List<User> getalluser();
    int deleteOneuser(Integer userid);

    int updateuser(User user);

    int insertuser(User user1);
    List<User> selectByTiaoJianuser(@Param("username") String username, @Param("rolename") String rolename, @Param("phonenumber") String phonenumber);
}
