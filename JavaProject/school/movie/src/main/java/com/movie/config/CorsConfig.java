package com.movie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//跨域配置
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //设置允许跨域的路径
                .allowedOriginPatterns("*") //设置允许访问源地址
                .allowedHeaders(CorsConfiguration.ALL) //设置允许访问源请求头
                .allowedMethods(CorsConfiguration.ALL) //设置允许访问源请求方法
                .allowCredentials(true) //是否允许证书（cookies）
                .maxAge(3600); // 1小时内不需要再预检（发OPTIONS请求）跨域允许时间
    }
}
