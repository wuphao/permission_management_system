package com.example.demotest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Integer roleid;
    private String rolename;
    private String orgname;
    private String posname;
    private String pername;

}
