package com.example.demotest.service.impl;

import com.example.demotest.config.Result;
import com.example.demotest.config.ResultCode;
import com.example.demotest.mapper.PositionMapper;
import com.example.demotest.pojo.Organization;
import com.example.demotest.pojo.Position;
import com.example.demotest.service.PositionService;
import com.example.demotest.utils.SystemUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionMapper positionMapper;

    @Override
    public Result getposcount() {
        return new Result(ResultCode.SUCCESS,positionMapper.getposcount());
    }

    @Override
    public Result getallpos() {
        List<Position> poss= positionMapper.getallpos();
        Result result = new Result(ResultCode.SUCCESS, poss);
        result.setCount(poss.size());
        return result;
    }

    @Override
    public Boolean deleteOnepos(Long posid) {
        int i = positionMapper.deleteOnepos(Math.toIntExact(posid));
        if (i > 0) {
            return true;
        }
        return false;
    }



    @Override
    public Boolean updatepos(Position position) {
        int update = 0;
        update=positionMapper.updatepos(position);
        if(update>0)
            return  true;
        else
            return  false;
    }

    @Override
    public Boolean insertpos(Position position) {
        Integer []id=positionMapper.getposid();
        Position position1=new Position();
        position1.setPosid(SystemUtil.getid(id));
        position1.setPosname(position.getPosname());
        position1.setResponsibility(position.getResponsibility());
        int insert = 0;
        insert = positionMapper.insertpos(position1);
        if(insert>0)
            return  true;
        else
            return  false;
    }

    @Override
    public Result selectByTiaoJianpos(String posname, String responsibility, Integer limit, Integer page) {
        Page<Position> objects = PageHelper.startPage(page,limit);
        List<Position> postList =positionMapper.selectbyTiaoJianpos(posname,responsibility);
        log.info(postList.toString());
        Result result = new Result(ResultCode.SUCCESS, objects.getResult());
        result.setCount((int) objects.getTotal());
        return result;
    }
}