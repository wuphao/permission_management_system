package com.example.demotest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



@Configuration
@SuppressWarnings("all")
public class CrosConfig {
    private CorsConfiguration buildConfig() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://127.0.0.1:8848");
        corsConfiguration.addAllowedHeader("*"); //任何头
        corsConfiguration.addAllowedMethod("*"); //任何方法
        corsConfiguration.setAllowCredentials(true);
        // 添加地址映射
        source.registerCorsConfiguration("/websocket/**", corsConfiguration);
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); //注册
        return new CorsFilter(source);
    }


}
