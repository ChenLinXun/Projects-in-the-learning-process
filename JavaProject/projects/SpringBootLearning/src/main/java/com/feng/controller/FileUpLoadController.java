package com.feng.controller;

import com.feng.pojo.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Log4j2
@Controller
public class FileUpLoadController {

    @PostMapping("/upload")
    public String userMessageUpload(Model model,
                                    User user,
                                    @RequestPart MultipartFile userImageFile,
                                    @RequestPart MultipartFile[] userPhotosFile) throws IOException {

        log.info("上传信息：userName={},password={},userImageSize={},userPhotosLength={}",
                user.getUserName(),user.getPassword(),userImageFile.getSize(),userPhotosFile.length);

        //文件保存在服务器的绝对路径
        String dir = "D:\\JavaProject\\projects\\SpringBootLearning\\src\\main\\resources\\static\\images";
        //如果用户头像不为空，进行处理：
        if(!userImageFile.isEmpty()){
            //1. 处理上传文件名，只保留文件名后缀，以当前时间和用户名作为文件名
            String originalFilename = userImageFile.getOriginalFilename();
            //后缀
            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
            //文件名
            String imageName = System.currentTimeMillis() + user.getUserName() + ext;

            //2. 确定用户头像保存的绝对路径
            String savePath = dir + "/" + imageName;

            //3. 将用户头像保存到硬盘
            userImageFile.transferTo(new File(savePath));

            //4. 将用户头像url保存到用户对象中
            user.setUserImage("images/" + imageName); //保存到数据库过程省略
        }

        //如果用户照片不为空，进行处理：
        if(userPhotosFile.length > 0){
            //逐张处理：
            for (MultipartFile userPhoto : userPhotosFile) {
                if(!userPhoto.isEmpty()){
                    //1. 处理上传文件名，只保留文件名后缀，以当前时间和用户名作为文件名
                    String originalFilename = userPhoto.getOriginalFilename();
                    //后缀
                    String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
                    //文件名
                    String photoName = System.currentTimeMillis() + user.getUserName() + ext;

                    //2. 确定用户照片保存的绝对路径
                    String savePath = dir + "/" + photoName;

                    //3. 将用户照片保存到硬盘
                    userPhoto.transferTo(new File(savePath));

                    //4. 将用户照片url保存到服务器中，略...
                }
            }
        }
        model.addAttribute("upload","上传成功!");
        return "index";
    }
}
