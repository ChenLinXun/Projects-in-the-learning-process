package com.feng.ioc.bean;

public class Book {

    private String bookName;
    private String author;

    public void init(){
        //初始化方法，当前类对象被创建时，进行一些资源准备工作
        bookName  = "《活着》";
        author = "余华";
        System.out.println("~~~~~~~~~init~~~~~~~~~~~");
    }

    public Book(){
        System.out.println("---book已创建---");
    }

    public void destroy(){
        //销毁方法，当Spring容器销毁对象时调用，进行一些资源释放的工作
        System.out.println("~~~~~~~~~destroy~~~~~~~~~~~");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
