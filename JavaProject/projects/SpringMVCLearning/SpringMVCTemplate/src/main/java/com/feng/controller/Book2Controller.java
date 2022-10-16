package com.feng.controller;

import com.feng.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book2")
public class Book2Controller {

    /**
     * 包含日期类型的对象数据处理
     * @param book
     * @return
     */
    @RequestMapping("add")
    public String add(Book book){
        System.out.println("add book......");
        System.out.println("书名："+book.getBookName());
        System.out.println("作者："+book.getBookAuthor());
        System.out.println("价格："+book.getBookPrice());
        System.out.println("出版日期："+book.getPublishTime());

        return "tips";
    }

}
