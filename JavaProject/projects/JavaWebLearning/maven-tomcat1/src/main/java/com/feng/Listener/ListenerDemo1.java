package com.feng.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerDemo1 implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        //项目发布，加载资源
        System.out.println("ServletContextListener...资源加载...");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        //项目卸载，释放资源
        System.out.println("ServletContextListener...资源释放...");
    }
}
