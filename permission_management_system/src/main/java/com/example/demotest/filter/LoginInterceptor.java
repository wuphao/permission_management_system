package com.example.demotest.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.demotest.config.Result;
import com.example.demotest.config.ResultCode;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class LoginInterceptor  extends HandlerInterceptorAdapter {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpServletRequest request1 =request;

        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //拿token，看时间
        String token = request1.getHeader("token");
        token = token == null ? "" : token;
        Long expire = redisTemplate.getExpire(token);
        if(expire>0)
        {
            redisTemplate.expire(token,30L, TimeUnit.MINUTES);
           // System.out.println("登录拦截器放行");
            return true;
        }
        else
        {
            Result loginResult = new Result(ResultCode.SINE_ERROR, "用户信息已过期或未登录，请重新登录");
            String jsonResponse = JSONObject.toJSONString(loginResult);
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter writer = response.getWriter();
            writer.write(jsonResponse);
            writer.flush();
            writer.close();
            return false;
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
