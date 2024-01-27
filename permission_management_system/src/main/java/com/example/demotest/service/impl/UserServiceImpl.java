package com.example.demotest.service.impl;

import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.example.demotest.config.Result;
import com.example.demotest.config.ResultCode;
import com.example.demotest.mapper.UserMapper;
import com.example.demotest.pojo.User;
import com.example.demotest.service.UserService;
import com.example.demotest.utils.SystemUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    final static String key = "sm4demo123456789";
    @Resource
    private UserMapper userMapper;
   @Resource
   private RedisTemplate<String,Object> redisTemplate;
    @Override
    public Result getalluser(Integer limit, Integer page) {
        Page<User> objects = PageHelper.startPage(page,limit);
        List<User> userList = userMapper.getalluser();
        Result result = new Result(ResultCode.SUCCESS, objects.getResult());
        result.setCount((int) objects.getTotal());
        return result;
    }

    @Override
    public Boolean deleteOneuser(Long id) {
        int i = userMapper.deleteOneuser(Math.toIntExact(id));
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public  Boolean updateuser(User user) {
        int update = 0;
        update= userMapper.updateuser(user);
        if(update>0)
            return  true;
        else
            return  false;
    }

    @Override
    public  Boolean insertuser(User user) {
        Integer []id= userMapper.getuserid();
        User user1 = new User();
        user1.setUserid(SystemUtil.getid(id));
        user1.setUsername(user.getUsername());
        user1.setPhonenumber(user.getPhonenumber());
        user1.setEmail(user.getEmail());
        //密码加密
        SymmetricCrypto sm4 = new SymmetricCrypto("SM4/ECB/PKCS5Padding", key.getBytes());
        String password=sm4.encryptHex(user.getPassword());
        user1.setPassword(password);
        user1.setRolename(user.getRolename());
        int insert = 0;
        insert= userMapper.insertuser(user1);
        if(insert>0)
            return  true;
        else
            return  false;

    }

    @Override
    public Result selectByTiaoJianuser(String username, String rolename, String phonenumber, Integer limit, Integer page) {
        Page<User> objects = PageHelper.startPage(page,limit);
        List<User> userList = userMapper.selectByTiaoJianuser(username, rolename,phonenumber);
        log.info(userList.toString());
        Result result = new Result(ResultCode.SUCCESS, objects.getResult());
        result.setCount((int) objects.getTotal());
        return result;
    }

    @Override
    public Result getusercount() {
        return new Result(ResultCode.SUCCESS,userMapper.getusercount());
    }

    @Override
    public Integer getper(User user) {
        return  userMapper.getper(user);
    }

    @Override
    public Result login(String username, String password) {
        SymmetricCrypto sm4 = new SymmetricCrypto("SM4/ECB/PKCS5Padding", key.getBytes());
        String password1= sm4.encryptHex(password);
       // System.out.println(password1);
        User user = userMapper.login(username,password1);
        if(user!=null)
        {
            String token=UUID.randomUUID()+"";
            redisTemplate.opsForValue().set(token,user, Duration.ofMinutes(30L));
            Result result = new Result(ResultCode.SUCCESS, token);
            result.setCount(1);
            return  result;
        }
        Result result = new Result(ResultCode.USER_LONGIN_ERROR, user);
        result.setCount(1);
        return result;
    }
}
