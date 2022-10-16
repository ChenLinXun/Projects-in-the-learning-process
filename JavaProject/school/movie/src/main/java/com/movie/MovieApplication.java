package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 电影信息平台 工期：4天
 * @Author 太峰（后端）、文宇（前端）
 * @Date 2020/06/08/下午 14:08
 * @Description 大三下学期期末企业学习课设
 */
@SpringBootApplication
@EnableTransactionManagement
public class MovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

}
