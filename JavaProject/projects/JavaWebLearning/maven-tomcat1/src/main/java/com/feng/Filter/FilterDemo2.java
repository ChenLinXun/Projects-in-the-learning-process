package com.feng.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("*.html")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //放行前的逻辑处理
        System.out.println("已被过滤器2 拦截，正在权限判定...");

        //放行
        chain.doFilter(req, resp);

        //放行后返回过滤器的逻辑处理
        System.out.println("资源访问完成，过滤器2 对响应数据进一步处理...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
