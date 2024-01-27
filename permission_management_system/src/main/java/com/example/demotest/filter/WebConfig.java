package com.example.demotest.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import com.example.demotest.filter.MyInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/user/*")
                .addPathPatterns("/org/*")
                .addPathPatterns("/pos/*")
                .addPathPatterns("/role/*");
        registry.addInterceptor(getMyInterceptor())
                .addPathPatterns("/user/*")
                .addPathPatterns("/org/*")
                .addPathPatterns("/pos/*")
                .addPathPatterns("/role/*");
    }

    @Bean
    public HandlerInterceptor getMyInterceptor(){
        return new MyInterceptor();
    }

    @Bean
    public HandlerInterceptor getLoginInterceptor(){
        return new LoginInterceptor();
    }

}
