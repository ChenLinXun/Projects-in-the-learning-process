package com.feng.JSP;

import com.feng.JSP.Actor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/JSTLDemo")
public class JSTLDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Actor> actors = new ArrayList<Actor>();
        actors.add(new Actor("灶门炭治郎","男","水之呼吸","癸",1));
        actors.add(new Actor("嘴平伊之助","男","兽之呼吸","癸",1));
        actors.add(new Actor("我妻善逸","男","雷之呼吸","癸",1));
        actors.add(new Actor("炼狱杏寿郎","男","炎之呼吸","柱",0));
        actors.add(new Actor("栗花落香奈乎","女","花之呼吸","己",1));

        request.setAttribute("actors",actors);
        request.setAttribute("status",1);
        request.getRequestDispatcher("/JSTL.jsp").forward(request,response);

    }
}
