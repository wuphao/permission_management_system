package com.example.demotest.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userid;
    private String  username;
    private  String  password;
    private  String  phonenumber;
    private  String  email;
    private String rolename;

}
