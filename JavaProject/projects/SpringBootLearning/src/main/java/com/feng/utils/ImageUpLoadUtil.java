package com.feng.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUpLoadUtil {

    //文件保存在服务器的绝对路径
    public static final String dir =
            "D:\\JavaProject\\projects\\SpringBootLearning\\src\\main\\resources\\static\\images";

    //由于上传到resource/static/images的图片不会自动更新到target目录下（项目运行时真正访问的路径），手动进行更新
    public static final String dirCopy =
            "D:\\JavaProject\\projects\\SpringBootLearning\\target\\classes\\static\\images";

    public static String uploadImg(MultipartFile multipartFile, String imageNamePre){

        //如果用户头像不为空，进行处理：
        if(!multipartFile.isEmpty()){
            //1. 处理上传文件名，只保留文件名后缀，以当前时间和用户名作为文件名
            String originalFilename = multipartFile.getOriginalFilename();

            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
            //文件名
            String imageName = System.currentTimeMillis() + imageNamePre + ext;

            //2. 确定用户头像保存的绝对路径
            String savePath = dir + "/" + imageName;
            String savePathCopy = dirCopy + "/" + imageName;

            //3. 将用户头像保存到硬盘
            InputStream is = null;
            FileOutputStream os1 = null, os2 = null;
            try {
                //multipartFile.transferTo(new File(savePath)); //复制到多个路径不能重复调用
                //自行解决将图片复制到多个路径
                is = multipartFile.getInputStream();
                os1 = new FileOutputStream(new File(savePath));
                os2 = new FileOutputStream(new File(savePathCopy));
                byte[] buff = new byte[1024];
                int len = 0;
                while ((len = is.read(buff)) != -1){
                    os1.write(buff,0,len);
                    os2.write(buff,0,len);
                }
                //4. 返回图像保存路径
                return "images/" + imageName;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(os1 != null)
                        os1.close();
                    if(os2 != null)
                        os2.close();
                    if(is != null)
                        is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
