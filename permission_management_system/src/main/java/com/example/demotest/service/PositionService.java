package com.example.demotest.service;

import com.example.demotest.config.Result;
import com.example.demotest.pojo.Position;
import org.springframework.stereotype.Service;

@Service
public interface PositionService {
    Result getposcount();
    Result getallpos();

    Boolean deleteOnepos(Long posid);


    Boolean updatepos(Position position);

    Boolean insertpos(Position position);

    Result selectByTiaoJianpos(String posname, String responsibility, Integer limit, Integer page);
}
