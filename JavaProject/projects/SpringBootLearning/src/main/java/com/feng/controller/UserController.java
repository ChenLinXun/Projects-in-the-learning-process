package com.feng.controller;

import com.feng.pojo.User;
import com.feng.service.UserService;
import com.feng.utils.ImageUpLoadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public String saveUser(User user, @RequestPart MultipartFile userImageFile, Model model){

        //保存user到数据库
        userService.saveUser(user);

        //保存成功才调用文件上传工具类上传user头像
        String imgUrl = ImageUpLoadUtil.uploadImg(userImageFile, user.getUserName());
        //上传成功才设置头像url
        if(!imgUrl.equals("")) {
            user.setUserImage(imgUrl);
            userService.updateUserImage(imgUrl);
            model.addAttribute("user",user);
            model.addAttribute("isSave","保存成功！");
        }else {
            model.addAttribute("user",user);
            model.addAttribute("isSave","头像保存失败！");
        }
        return "lookupUser";
    }
}
