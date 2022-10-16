package com.feng.Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo1",loadOnStartup = 0)//loadOnStartup = 0 表示服务器启动时调用init()方法
public class ServletDemo1 implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("已完成初始化...");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
