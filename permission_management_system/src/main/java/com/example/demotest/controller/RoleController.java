package com.example.demotest.controller;

import com.example.demotest.config.Result;
import com.example.demotest.config.ResultCode;
import com.example.demotest.pojo.Role;
import com.example.demotest.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("role")
@Slf4j
@Api(value = "角色")
public class RoleController {
    @Resource
    private RoleService roleService;

    @ApiOperation("获取角色名字")
    @GetMapping("/getorgname")
    public Result getorgname(){
        Result allroles = roleService.getorgname();
        log.info("当前结果为:{}",allroles.getData());
        return allroles;
    }

    @ApiOperation("获取所有角色")
    @GetMapping("/getallrole")
    public Result getallroles(){
        Result allroles = roleService.getallrole();
        log.info("当前结果为:{}",allroles.getData());
        return allroles;
    }

    @ApiOperation("删除角色")
    @GetMapping("/deleteOnerole")
    public Result deleteOnerole(@RequestParam Integer roleid){
        Boolean trueOrFalse =roleService.deleteOnerole(Long.valueOf(roleid));
        if (trueOrFalse) {
            return new Result(ResultCode.SUCCESS,trueOrFalse);
        }
        return new Result(ResultCode.ERROR, "删除信息失败");
    }

    @ApiOperation("修改角色")
    @PostMapping("/updaterole")
    public Result updaterole(@RequestBody Role role){
        Boolean update = roleService.updaterole(role);
        if (update) {
            return new Result(ResultCode.SUCCESS,update);
        }
        return new Result(ResultCode.ERROR, "新增一个角色的信息失败");
    }
    @ApiOperation("新增角色")
    @PostMapping("/insertrole")
    public Result insertrole(@RequestBody Role role){
        Boolean insert=roleService.insertrole(role);
        if(insert)
           return new Result(ResultCode.SUCCESS, "新增一个人的信息成功");
        else
            return new Result(ResultCode.ERROR, "新增一个角色的信息失败");
    }

    @ApiOperation("筛选角色")
    @GetMapping("/selectByTiaoJianrole")
    public Result selectByTiaoJianrole(@RequestParam("rolename") String rolename,
                                       @RequestParam("orgname") String orgname,
                                       @RequestParam("posname") String posname,
                                       @RequestParam("pername") String pername,
                                       @RequestParam("limit")Integer limit ,
                                       @RequestParam("page") Integer page){
        return roleService.selectByTiaoJianrole(rolename,orgname,posname,pername,limit,page);
    }

    @ApiOperation("获取角色数量")
    @GetMapping("/getrolecount")
    public Result getrolecount()
    {
        return roleService.getrolecount();
    }
}
