package com.feng.hello.auto;

import com.feng.hello.pojo.HelloProperties;
import com.feng.hello.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类：
 * springboot会自动加载该配置类
 * 1、条件装配 HelloService组件
 * 2、配置绑定 HelloProperties属性，并注册到容器中
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class) //配置绑定 + 注册
public class HelloServiceAutoConfiguration {

    //容器中没有 HelloService组件时，采用该默认装配：
    @ConditionalOnMissingBean(HelloService.class)
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
