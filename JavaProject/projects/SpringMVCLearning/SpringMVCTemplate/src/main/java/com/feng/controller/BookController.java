package com.feng.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    /**
     * 响应同步请求
     * 接收请求行数据
     */
    /*
        数据传递：
        1.在方法参数中添加一个Model类型的参数（相当于response对象）
        2.在return页面之前，向model中添加键值对，该键值对会传递到下个页面
        3.除了使用model对象，也可以直接使用HttpServletResponse对象
     */
    @RequestMapping("/add")
    public String add(@RequestParam("bookName") String name,
                      @RequestParam("bookAuthor") String author,
                      @RequestParam("bookPrice") double price,
                      Model model){
        System.out.println("add book......");
        System.out.println("书名："+name);
        System.out.println("作者："+author);
        System.out.println("价格："+price);

        //如何跳转到指定的页面呢？
        model.addAttribute("book",
                new Book(1,"Java","老张",2.22));
        //return "/tips.jsp";
        return "tips";
    }

    /*
        数据传递：
        1.创建ModelAndView对象
        2.在ModelAndView对象中添加键值对，该键值对会传递到下个页面
    */
    @RequestMapping("/add2")
    public ModelAndView add2(@RequestParam("bookName") String name,
                             @RequestParam("bookAuthor") String author,
                             @RequestParam("bookPrice") double price){
        System.out.println("add2 book......");
        System.out.println("书名："+name);
        System.out.println("作者："+author);
        System.out.println("价格："+price);

        //如何跳转到指定的页面呢？
        //ModelAndView modelAndView = new ModelAndView("/tips.jsp");
        ModelAndView modelAndView = new ModelAndView("tips");
        modelAndView.addObject("book",
                new Book(1,"Java","老张",2.22));
        return modelAndView;
    }

    /**
     * 响应异步请求
     * 接收请求头数据
     */
    @RequestMapping("/list")
    public void list(@RequestHeader("token") String token){
        System.out.println("list book......");
        System.out.println("token:"+token);
    }

    /**
     * 响应异步请求
     * 接收请求体数据
     */
    @RequestMapping("/update")
    @ResponseBody
    public List<Book> update(@RequestBody Book book) throws IOException {
        System.out.println("update book......");
        System.out.println(book);

        /*
            方式一：使用response对象输出流响应数据，方法返回值为void
            //使用jackson的转换工具，将java对象转成JSON字符串
            String s = new ObjectMapper().writeValueAsString(book);

            //用阿里的fastjson更快
            //String s = JSON.toJSONString(book);

            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(s);
            out.flush();
            out.close();
        */

        //方式二：SpringMVC特别提供的，直接将返回类型定义为返回的对象（或List集合）
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1,"Java","老张",2.22));
        books.add(new Book(2,"C++","老李",3.33));
        return books;
    }
}
