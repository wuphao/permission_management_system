package com.example.demotest.service;

import com.example.demotest.config.Result;
import com.example.demotest.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Result getusercount();
    Integer getper(User user);
    Result login(String username,String password);
    Result getalluser(Integer limit, Integer page);

    Boolean deleteOneuser(Long id);

    Boolean updateuser(User user);

    Boolean insertuser(User user);

    Result selectByTiaoJianuser(String username, String rolename,String phonenumber, Integer limit, Integer page);


}
