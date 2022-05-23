package com.example.jwtlogin.config;

import com.example.jwtlogin.handler.InterceptorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Devil
 * @create 2022-04-03 19:03
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private InterceptorHandler interceptorHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorHandler).addPathPatterns("/user/list");
    }
}
