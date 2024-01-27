package com.example.demotest.controller;

import com.example.demotest.config.Result;
import com.example.demotest.config.ResultCode;
import com.example.demotest.pojo.User;
import com.example.demotest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("user")
@Slf4j
@Api(value = "用户")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @GetMapping("/login")
    public Result login(@RequestParam("username") String username,@RequestParam("password") String password)
    {
      return userService.login(username,password);
    }


    @ApiOperation(value = "获得所有用户")
    @GetMapping("/getalluser")
    public Result getallusers(@RequestParam("limit")Integer limit ,
                                @RequestParam("page") Integer page){
        Result allusers = userService.getalluser(limit, page);
        log.info("当前结果为:{}",allusers.getData());
        return allusers;
    }
    @ApiOperation(value = "删除用户")
    @GetMapping("/deleteOneuser")
    public Result deleteOne(@RequestParam Integer userid){
        Boolean trueOrFalse =userService.deleteOneuser(Long.valueOf(userid));
        if (trueOrFalse) {
            return new Result(ResultCode.SUCCESS,trueOrFalse);
        }
        return new Result(ResultCode.ERROR, "删除信息失败");
    }

    @ApiOperation(value = "修改用户")
    @PostMapping("/updateuser")
    public Result updateuser(@RequestBody User user){
        Boolean update = userService.updateuser(user);
        if (update) {
            return new Result(ResultCode.SUCCESS,update);
        }
        return new Result(ResultCode.ERROR, "新增或一个人的信息成功");
    }
    @ApiOperation(value = "新增用户")
    @PostMapping("/insertuser")
    public Result insertuser(@RequestBody User user){
        Boolean insert=userService.insertuser(user);
        if(insert)
         return new Result(ResultCode.SUCCESS, "新增一个人的信息成功");
        else
            return new Result(ResultCode.ERROR, "新增一个人的信息成功");
    }

    @ApiOperation(value = "筛选用户")
    @GetMapping("/selectByTiaoJianuser")
    public Result selectByTiaoJianuser(@RequestParam("username") String username,
                                   @RequestParam("rolename") String rolename,
                                       @RequestParam("phonenumber") String phonenumber,
                                   @RequestParam("limit")Integer limit ,
                                   @RequestParam("page") Integer page){
        return userService.selectByTiaoJianuser(username,rolename,phonenumber,limit,page);
    }

    @ApiOperation(value = "获得用户总数")
    @GetMapping("/getusercount")
    public Result getusercount()
    {
        return userService.getusercount();
    }
}
