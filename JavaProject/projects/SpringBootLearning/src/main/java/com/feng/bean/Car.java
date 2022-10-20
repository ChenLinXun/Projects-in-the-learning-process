package com.feng.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
//@Component
//配置绑定
@ConfigurationProperties(prefix = "mycar")
//lombok
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Car {
    private String name;
    private Integer price;
}
