package com.example.demotest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;


/*
http://localhost:8083/swagger-ui/index.html
 */
@Configuration
@EnableWebMvc
@EnableOpenApi
public class SwaggerConfig {

}
