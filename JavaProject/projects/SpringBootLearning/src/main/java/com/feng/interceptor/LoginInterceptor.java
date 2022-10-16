package com.feng.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 登录检查
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("登录检查...");
        //如果Session中存在登录用户对象，则放行
        HttpSession session = request.getSession();
        if(session.getAttribute("loginUser") != null){
            return true;
        }
        //否则跳转回首页
        session.setAttribute("NotLoggedIn","请先登录，再访问管理员页面！");
        response.sendRedirect("/");
        return false;
    }
}
