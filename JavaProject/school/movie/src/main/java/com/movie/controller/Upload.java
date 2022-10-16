package com.movie.controller;

import com.movie.utils.FileResult;
import com.movie.utils.UUIDutils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class Upload {
    /**
     * 文件上传
     */
    @RequestMapping("/upload")
    public FileResult upload(@RequestParam("file") MultipartFile picture, HttpServletRequest request) throws FileNotFoundException {

        System.out.println("您已进入图片上传服务");
        //获取文件在服务器的储存位置，此种方式直接存入了真实文件夹
        //文件上传的地址，此种方式直接存入了target
        String realPath = ResourceUtils.getURL("classpath:").getPath()+"static/image";
        String path = realPath.replace('/', '\\').substring(1,realPath.length());


        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);

        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        //更改文件名称为新文件名
        String fileName = UUIDutils.getId() + name + "." + type;
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);
        System.out.println("图片地址："+path+"/"+fileName);
        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");
            //将文件在服务器的存储路径返回
            return new FileResult(true,"http://192.168.192.25:8080/image/"+fileName);
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            return new FileResult(false, "上传失败");
        }
    }

}

