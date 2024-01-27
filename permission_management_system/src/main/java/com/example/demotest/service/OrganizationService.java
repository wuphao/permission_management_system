package com.example.demotest.service;

import com.example.demotest.config.Result;
import com.example.demotest.pojo.Organization;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {
    Result getorgcount();
    Result getallorg();

    Boolean deleteOneorg(Long orgid);


    Boolean updateorg(Organization organization);

    Boolean insertorg(Organization organization);

    Result selectByTiaoJianorg(String orgname, String location, Integer limit, Integer page);
}

