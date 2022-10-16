package com.feng.WebServlet;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Log4j2
//@WebFilter(urlPatterns = {"/CSS/*","/images/*"})
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Web原生组件Filter：MyFilter初始化...");
    }

    @Override
    public void doFilter(ServletRequest res, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        log.info("Web原生组件Filter：MyFilter工作...");
        chain.doFilter(res,resp);
    }

    @Override
    public void destroy() {
        log.info("Web原生组件Filter：MyFilter销毁...");
    }
}
