package com.example.demotest.service.impl;

import com.example.demotest.config.Result;
import com.example.demotest.config.ResultCode;
import com.example.demotest.mapper.RoleMapper;
import com.example.demotest.pojo.Role;
import com.example.demotest.pojo.User;
import com.example.demotest.service.RoleService;
import com.example.demotest.utils.SystemUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public Result getrolecount() {
        return new Result(ResultCode.SUCCESS,roleMapper.getrolecount());
    }

    @Override
    public Result getallrole() {
        List<Role> roles= roleMapper.getallrole();
        Result result = new Result(ResultCode.SUCCESS, roles);
        result.setCount(roles.size());
        return result;
    }

    @Override
    public Boolean deleteOnerole(Long roleid) {
        int i = roleMapper.deleteOnerole(Math.toIntExact(roleid));
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Result getorgname() {
        List<String> roles= roleMapper.getorgname();
        Result result = new Result(ResultCode.SUCCESS, roles);
        result.setCount(roles.size());
        return result;
    }


    @Override
    public Boolean updaterole(Role role) {
        int update = 0;
        update=roleMapper.updaterole(role);
        if(update>0)
            return  true;
        else
            return  false;
    }

    @Override
    public Boolean insertrole(Role role) {
        Integer []id=roleMapper.getroleid();
        Role role1=new Role();
        role1.setRoleid(SystemUtil.getid(id));
        role1.setOrgname(role.getOrgname());
        role1.setRolename(role.getRolename());
        role1.setPername(role.getPername());
        role1.setPosname(role.getPosname());
        int insert = 0;
         insert = roleMapper.insertrole(role1);
        if(insert>0)
            return  true;
        else
            return  false;
    }

    @Override
    public Result selectByTiaoJianrole(String rolename, String orgname, String posname, String pername, Integer limit, Integer page) {
        Page<Role> objects = PageHelper.startPage(page,limit);
        List<Role> roleList =roleMapper.selectbyTiaoJianrole(rolename, orgname,posname,pername);
        log.info(roleList.toString());
        Result result = new Result(ResultCode.SUCCESS, objects.getResult());
        result.setCount((int) objects.getTotal());
        return result;
    }
}
