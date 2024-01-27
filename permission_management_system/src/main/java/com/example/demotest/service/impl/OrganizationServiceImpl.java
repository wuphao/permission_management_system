package com.example.demotest.service.impl;

import com.example.demotest.config.Result;
import com.example.demotest.config.ResultCode;
import com.example.demotest.mapper.OrganizationMapper;
import com.example.demotest.pojo.Organization;
import com.example.demotest.pojo.User;
import com.example.demotest.service.OrganizationService;
import com.example.demotest.utils.SystemUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {
    @Resource
    private OrganizationMapper organizationMapper;


    @Override
    public Result getorgcount() {
        return new Result(ResultCode.SUCCESS,organizationMapper.getorgcount());
    }

    @Override
    public Result getallorg() {
        List<Organization> orgs= organizationMapper.getallorg();
        Result result = new Result(ResultCode.SUCCESS, orgs);
        result.setCount(orgs.size());
        return result;
    }

    @Override
    public Boolean deleteOneorg(Long orgid) {
        int i = organizationMapper.deleteOneorg(Math.toIntExact(orgid));
        if (i > 0) {
            return true;
        }
        return false;
    }


    @Override
    public Boolean updateorg(Organization organization) {
        int update = 0;
        update=organizationMapper.updateorg(organization);
        if(update>0)
            return  true;
        else
            return  false;
    }

    @Override
    public Boolean insertorg(Organization organization) {
        Integer []id=organizationMapper.getorgid();
        Organization organization1 = new Organization();
        organization1.setOrgid(SystemUtil.getid(id));
        organization1.setOrgname(organization.getOrgname());
        organization1.setLocation(organization.getLocation());
        int insert = 0;
        insert = organizationMapper.insertorg(organization1);
        if(insert>0)
            return  true;
        else
            return  false;
    }

    @Override
    public Result selectByTiaoJianorg(String orgname, String location, Integer limit, Integer page) {
        Page<Organization> objects = PageHelper.startPage(page,limit);
        List<Organization> orgList =organizationMapper.selectbyTiaoJianorg(orgname,location);
        log.info(orgList.toString());
        Result result = new Result(ResultCode.SUCCESS, objects.getResult());
        result.setCount((int) objects.getTotal());
        return result;
    }
}
