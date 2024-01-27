package com.example.demotest.mapper;

import com.example.demotest.pojo.Organization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrganizationMapper {

    Integer getorgcount();
    Integer [] getorgid();
    List<Organization> getallorg();

    int deleteOneorg(Integer orgid);

    int insertorg(Organization organization);

    int updateorg(Organization organization);

    List<Organization> selectbyTiaoJianorg(@Param("orgname")String orgname,@Param("location")String location);
}
