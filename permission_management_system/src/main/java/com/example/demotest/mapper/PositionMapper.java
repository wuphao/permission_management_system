package com.example.demotest.mapper;

import com.example.demotest.pojo.Position;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PositionMapper {
    @Select("SELECT * from pos")
    List<Position> getallpos();
    @Delete("delete from Pos where posid=#{posid}")
    int deleteOnepos(Integer posid);

    Integer [] getposid();
    int insertpos(Position position);

    int updatepos(Position position);

    List<Position> selectbyTiaoJianpos(@Param("posname")String posname, @Param("responsibility")String responsibility);

    Integer getposcount();
}
