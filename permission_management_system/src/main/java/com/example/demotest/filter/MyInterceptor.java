package com.example.demotest.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.demotest.config.Result;
import com.example.demotest.config.ResultCode;
import com.example.demotest.controller.LoginController;
import com.example.demotest.pojo.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class MyInterceptor extends HandlerInterceptorAdapter {

   @Resource
    private RedisTemplate<String, Object> redisTemplate;
   @Resource
    private LoginController loginController;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpServletRequest request1 =request;

        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //拿token，取权限
        String token = request1.getHeader("token");
        StringBuffer requestURL = request1.getRequestURL();
        String url=requestURL.toString();
        token = token == null ? "" : token;
        Object user=redisTemplate.opsForValue().get(token);
        Integer perid= loginController.getper((User) user);
        perid= null==perid?0:perid;

        //修改
        if(url.contains("update"))
        {
            if(perid==0||perid==3||perid==5||perid==6) {
                return true;
            }
            else {
                Result loginResult = new Result(ResultCode.ERROR, "登录失败，权限不足");

                // 将响应对象转换为 JSON 格式
                String jsonResponse = JSONObject.toJSONString(loginResult);

                // 设置响应头和状态码
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 设置为 401 Unauthorized

                // 获取 PrintWriter 并写入 JSON 响应
                PrintWriter writer = response.getWriter();
                writer.write(jsonResponse);
                writer.flush();
                writer.close();
                // 返回 false 表示请求处理结束
                return false;
            }
        }
        if(url.contains("insert"))
        {
            if(perid==0||perid==1||perid==4||perid==5) {
                System.out.println("放行");
                return true;
            }
            else {
                System.out.println(perid);
                Result loginResult = new Result(ResultCode.ERROR, "登录失败，权限不足");

                // 将响应对象转换为 JSON 格式
                String jsonResponse = JSONObject.toJSONString(loginResult);

                // 设置响应头和状态码
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 设置为 401 Unauthorized

                // 获取 PrintWriter 并写入 JSON 响应
                PrintWriter writer = response.getWriter();
                writer.write(jsonResponse);
                writer.flush();
                writer.close();
                // 返回 false 表示请求处理结束
                return false;
            }
        }

        if(url.contains("delete"))
        {
            if(perid==0||perid==2||perid==4||perid==6) {
                return true;
            }
            else {
               // System.out.println(perid);
                Result loginResult = new Result(ResultCode.ERROR, "登录失败，权限不足");

                // 将响应对象转换为 JSON 格式
                String jsonResponse = JSONObject.toJSONString(loginResult);

                // 设置响应头和状态码
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 设置为 401 Unauthorized

                // 获取 PrintWriter 并写入 JSON 响应
                PrintWriter writer = response.getWriter();
                writer.write(jsonResponse);
                writer.flush();
                writer.close();
                // 返回 false 表示请求处理结束
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
