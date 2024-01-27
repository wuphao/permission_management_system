package com.example.demotest.service;

import com.example.demotest.config.Result;
import com.example.demotest.pojo.Role;
import com.example.demotest.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Result getrolecount();
    Result getallrole();
    Boolean deleteOnerole(Long roleid);

    Result getorgname();

    Boolean updaterole(Role role);

    Boolean insertrole(Role role);
    Result selectByTiaoJianrole(String rolename, String orgname,String posname,String pername, Integer limit, Integer page);
}
