package com.feng.hello.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JavaBean组件，采用配置绑定，使得用户能在配置文件中修改属性：
 * 交由自动配置类完成注册
 */
//@Component
@ConfigurationProperties(prefix = "feng.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
