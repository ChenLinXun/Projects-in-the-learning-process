package com.feng.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(urlPatterns = "/CookieDemo2")
public class CookieDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("username".equals(name)){
                //获取cookie值
                String value = cookie.getValue();
                //解码
                value = URLDecoder.decode(value,"utf-8");
                //响应
                response.setHeader("content-type","text/html;charset=utf-8");
                response.getWriter().write("<h1>"+value+"，欢迎回来！"+"</h1>");
                System.out.println(value);
                break;
            }
        }
    }
}
