package com.movie.controller;

import com.movie.pojo.MovieClassify;
import com.movie.service.MovieClassifyService;
import com.movie.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classify")
@SuppressWarnings("all")
public class MovieClassifyController {

    @Autowired
    private MovieClassifyService movieClassifyService;

    /**
     * 接口：插入一条分类信息（管理员页面插入）
     * @param MovieClassify
     * @return
     */
    @PostMapping(value = "/addClassify")
    public ResultJson<String> addClassify(@RequestBody MovieClassify movieClassify){
        String s = movieClassifyService.insertClassify(movieClassify);
        if(s != null && !"".equals(s)){
            return new ResultJson<String>(200,true,"添加成功",s);
        }else {
            return new ResultJson<String>(200,true,"添加失败",null);
        }
    }

    /**
     * 接口：修改一条分类信息（管理员页面修改）
     * @param MovieClassify
     * @return
     */
    @PostMapping(value = "/updateClassify")
    public ResultJson<Integer> updateClassify(@RequestBody MovieClassify movieClassify){
        int i = movieClassifyService.updateClassify(movieClassify);
        if(i > 0){
            return new ResultJson<Integer>(200,true,"修改成功",i);
        }else {
            return new ResultJson<Integer>(200,true,"修改失败",i);
        }
    }
}
