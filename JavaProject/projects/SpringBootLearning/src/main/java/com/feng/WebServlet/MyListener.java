package com.feng.WebServlet;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Log4j2
//@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("原生Web组件MyListener监听到：项目初始化完成...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("原生Web组件MyListener监听到：项目已销毁...");
    }
}
