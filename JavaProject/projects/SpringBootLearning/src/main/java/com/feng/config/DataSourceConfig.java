package com.feng.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 旧的，使用配置类的方式配置Druid的方式
 */
@Deprecated
//@Configuration
public class DataSourceConfig {

    /**
     * 配置druid数据源
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){

        DruidDataSource druidDataSource = new DruidDataSource();
        //所有的set()都和配置文件中的 spring.datasource 绑定
        //连接数据库信息：
        //druidDataSource.setUsername();
        //druidDataSource.setPassword();
        //druidDataSource.setUrl();
        //打开统计监控信息：stat 和 打开防火墙预防sql注入：wal
        //druidDataSource.setFilters("stat,wal");
        return druidDataSource;
    }

    /**
     * 配置使用Druid的内置监控页面
     * (Druid要求配置一个原生Servlet，因为没有web.xml，采用嵌入注册方式)
     */
    @Bean
    public ServletRegistrationBean druidStatView(){

        //Druid监控页面功能要求注入的Servlet类型：
        StatViewServlet statViewServlet = new StatViewServlet();

        //注册到SpringBoot容器中
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(statViewServlet, "/druid");

        //通过配置原生Servlet的初始化参数，为Druid监控配置访问权限(配置访问监控信息的用户与密码)
        HashMap<String, String> inits = new HashMap<>();
        ////Druid后台管理界面的登录账号、密码
        inits.put("loginUsername","chen");
        inits.put("loginPassword","123");
        //后台允许谁可以访问
        //initParams.put("allow", "localhost")：表示只有本机可以访问
        //initParams.put("allow", "")：为空或者为null时，表示允许所有访问
        inits.put("allow", "");
        //deny：Druid 后台拒绝谁访问
        //initParams.put("ling", "192.168.1.20");表示禁止此ip访问

        //配置到该原生Servlet中
        registrationBean.setInitParameters(inits);

        return registrationBean;
    }

    /**
     * 打开Web和Druid数据源之间的关联监控统计功能
     * （Druid要求配置一个原生Filter，因为没有web.xml，采用嵌入注册方式）
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){

        //Druid数据源与web关联监控统计要求注入的Filter类型：
        WebStatFilter webStatFilter = new WebStatFilter();

        //注册到SpringBoot容器中
        FilterRegistrationBean filterBean = new FilterRegistrationBean(webStatFilter);

        //配置该原生Filter的过滤路径为全部
        filterBean.setUrlPatterns(Arrays.asList("/*"));

        //通过配置该原生Filter的初始化参数，设置统计功能排除哪些请求，不参与统计
        //exclusions：设置哪些请求进行过滤排除掉，从而不进行统计
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*,/jdbc/*");
        filterBean.setInitParameters(initParams);

        return filterBean;
    }
}
