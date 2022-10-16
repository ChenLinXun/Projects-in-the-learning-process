package com.feng.controller;

import com.feng.pojo.Book;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/add")
    public String addBook(Book book, MultipartFile imgFile, HttpServletRequest request) throws IOException {
        System.out.println("add book......");

        //imgFile就表示要上传的文件
        //1. 截取上传文件的后缀名，生成新的文件名
        String originalFilename = imgFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));//.jpg
        String fileName = System.currentTimeMillis() + ext;

        //2. 获取imgs目录在服务器的绝对路径
        String dir = request.getServletContext().getRealPath("imgs");
        String savePath = dir + "/" + fileName;
        System.out.println(savePath);

        //3. 保存文件到imgs目录中
        imgFile.transferTo(new File(savePath));

        //4. 将文件访问路径赋值到book对象（注意，访问路径是服务器的相对路径，而不能是绝对路径savePath）
        book.setBookImg("imgs/"+fileName);

        System.out.println(book);

        //5. 调用service将book保存到数据库（此处省略）
        return "tips";
    }

    @RequestMapping("/list")
    @ResponseBody
    public String[] listImages(HttpServletRequest request){
        //从imgs目录下获取所有的文件信息
        String dir = request.getServletContext().getRealPath("imgs");
        File imgDir = new File(dir);
        String[] fileNames = imgDir.list();

        //响应异步请求
        return fileNames;
    }

    @RequestMapping("/downLoad")
    public void downLoadImage(String imageName,
                              HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据文件名参数，获取该文件的绝对路径
        String dir = request.getServletContext().getRealPath("imgs");
        String filePath = dir + "/" +imageName;

        //输入流指向文件
        FileInputStream is = new FileInputStream(filePath);

        //设置响应类型
        response.setContentType("image/jpg");
        //设置响应头，下载时显示文件名
        response.addHeader("Content-Disposition","attachment;filename="+imageName);

        //将文件响应到客户端（输出流即从response获取）
        IOUtils.copy(is,response.getOutputStream());
    }

    @RequestMapping("/query")
    public String queryBookByName(String bookName){
        System.out.println(bookName);
        return "tips2";
    }
}
