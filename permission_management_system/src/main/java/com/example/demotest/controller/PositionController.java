package com.example.demotest.controller;

import com.example.demotest.config.Result;
import com.example.demotest.config.ResultCode;
import com.example.demotest.pojo.Position;
import com.example.demotest.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("pos")
@Slf4j
@Api("部门")
public class PositionController {
    @Resource
    private PositionService positionService;

    @ApiOperation("获得所有部门")
    @GetMapping("/getallpos")
    public Result getallposs(){
        Result allposs = positionService.getallpos();
        log.info("当前结果为:{}",allposs.getData());
        return allposs;
    }

    @ApiOperation("删除部门")
    @GetMapping("/deleteOnepos")
    public Result deleteOnepos(@RequestParam Integer posid){
        Boolean trueOrFalse =positionService.deleteOnepos(Long.valueOf(posid));
        if (trueOrFalse) {
            return new Result(ResultCode.SUCCESS,trueOrFalse);
        }
        return new Result(ResultCode.ERROR, "删除信息失败");
    }

    @ApiOperation("修改部门")
    @PostMapping("/updatepos")
    public Result updatepos(@RequestBody Position position){
        Boolean update = positionService.updatepos(position);
        if (update) {
            return new Result(ResultCode.SUCCESS,update);
        }
        return new Result(ResultCode.ERROR, "新增或一个部门的信息失败");
    }

    @ApiOperation("新增部门")
    @PostMapping("/insertpos")
    public Result insertorg(@RequestBody Position position){
        Boolean insert = positionService.insertpos(position);
        if (insert) {
            return new Result(ResultCode.SUCCESS,insert);
        }
        return new Result(ResultCode.ERROR, "新增或一个部门的信息失败");
    }

    @ApiOperation("筛选部门")
    @GetMapping("/selectByTiaoJianpos")
    public Result selectByTiaoJianpos(@RequestParam("posname") String posname,
                                      @RequestParam("responsibility") String responsibility,
                                      @RequestParam("limit")Integer limit ,
                                      @RequestParam("page") Integer page){
        return positionService.selectByTiaoJianpos(posname,responsibility,limit,page);
    }
    @ApiOperation("获得部门数量")
    @GetMapping("/getposcount")
    public Result getposcount()
    {
        return positionService.getposcount();
    }
}
