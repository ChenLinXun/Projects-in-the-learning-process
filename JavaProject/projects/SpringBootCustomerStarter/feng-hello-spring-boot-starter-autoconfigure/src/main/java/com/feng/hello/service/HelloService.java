package com.feng.hello.service;

import com.feng.hello.pojo.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * HelloService组件：
 * 模拟Service层的第三方组件
 * 1、这里不要直接注册到容器中，交由自动配置类进行条件装配（用户才能对该组件进行定制化）
 * 2、所需要的JavaBean从容器中获取，交由自动配置类进行注册
 */
public class HelloService {

    //从容器中获取
    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName){
        return helloProperties.getPrefix() + "," + userName + "," + helloProperties.getSuffix();
    }
}
