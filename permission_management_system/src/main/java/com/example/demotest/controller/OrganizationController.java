package com.example.demotest.controller;

import com.example.demotest.config.Result;
import com.example.demotest.config.ResultCode;
import com.example.demotest.pojo.Organization;
import com.example.demotest.service.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("org")
@Slf4j
@Api(value = "组织")
public class OrganizationController {
    @Resource
    private OrganizationService organizationService;

    @ApiOperation(value = "获得所有组织")
    @GetMapping("/getallorg")
    public Result getallorgs(){
        Result allorgs = organizationService.getallorg();
        log.info("当前结果为:{}",allorgs.getData());
        return allorgs;
    }
    @ApiOperation(value = "删除一个组织")
    @GetMapping("/deleteOneorg")
    public Result deleteOneorg(@RequestParam Integer orgid){
        Boolean trueOrFalse =organizationService.deleteOneorg(Long.valueOf(orgid));
        if (trueOrFalse) {
            return new Result(ResultCode.SUCCESS,trueOrFalse);
        }
        return new Result(ResultCode.ERROR, "删除信息失败");
    }

    @ApiOperation(value = "修改一个组织")
    @PostMapping("/updateorg")
    public Result updateorg(@RequestBody Organization organization){
        Boolean update = organizationService.updateorg(organization);
        if (update) {
            return new Result(ResultCode.SUCCESS,update);
        }
        return new Result(ResultCode.ERROR, "新增或一个组织的信息失败");
    }

    @ApiOperation(value = "新增一个组织")
    @PostMapping("/insertorg")
    public Result insertorg(@RequestBody Organization organization){
        Boolean insert = organizationService.insertorg(organization);
        if (insert) {
            return new Result(ResultCode.SUCCESS,insert);
        }
        return new Result(ResultCode.ERROR, "新增或一个组织的信息失败");
    }
    @ApiOperation(value = "筛选组织")
    @GetMapping("/selectByTiaoJianorg")
    public Result selectByTiaoJianorg(@RequestParam("orgname") String orgname,
                                       @RequestParam("location") String location,
                                       @RequestParam("limit")Integer limit ,
                                       @RequestParam("page") Integer page){
        return organizationService.selectByTiaoJianorg(orgname,location,limit,page);
    }
    @ApiOperation(value = "获得组织数目")
    @GetMapping("/getorgcount")
    public Result getorgcount()
    {
        return organizationService.getorgcount();
    }
}
