package com.example.demotest.mapper;
import com.example.demotest.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    Integer getrolecount();
    List<Role> getallrole();

    Integer [] getroleid();
    List<String> getorgname();

    int deleteOnerole(Integer role);

    int insertrole(Role role);

    int updaterole(Role role);

    List<Role> selectbyTiaoJianrole(@Param("rolename")String rolename, @Param("orgname")String orgname,@Param("posname")String posname,@Param("pername")String pername);
}
