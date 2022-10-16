package com.feng.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = "/demo3")
public class ServletDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet...");
        //在业务逻辑相同的情况下，将GET、POST请求统一交给doPost()方法处理：
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 遍历所有的请求参数信息：
        req.setCharacterEncoding("utf-8");

        //调用getParameterMap()方法获取所有请求参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        //遍历map集合
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            for (String s : entry.getValue()) {
                //打印到控制台
                System.out.println(entry.getKey()+"："+s);
                //响应到浏览器页面
                resp.setHeader("content-type","text/html;charset=utf-8");
                resp.getWriter().write("<h1>"+entry.getKey()+"："+s+"<h1>");
            }
        }
        //2. 根据参数名称获取参数值（数组）
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        //3. 根据参数名称获取参数值（单个参数）
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
    }
}
