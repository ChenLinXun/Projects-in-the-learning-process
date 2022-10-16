package com.movie.controller;

import com.movie.pojo.MovieComment;
import com.movie.service.MovieCommentService;
import com.movie.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@SuppressWarnings("all")
public class MovieCommentController {

    @Autowired
    private MovieCommentService movieCommentService;

    /**
     * 接口：插入一条评论（详情页面插入）
     * @param movieComment
     * @return
     */
    @PostMapping("/addComment")
    public ResultJson<String> addComment(@RequestBody MovieComment movieComment){
        String s = movieCommentService.insertComment(movieComment);
        if(s != null && !"".equals(s)){
            return new ResultJson<String>(200,true,"添加成功",s);
        }else {
            return new ResultJson<String>(200,true,"添加失败",null);
        }
    }

    /**
     * 接口：删除一条评论（详情页面删除）
     * @param movieComment
     * @return
     */
    @DeleteMapping(value = "/deleteComment/{commentId}")
    public ResultJson<Integer> deleteComment(@PathVariable String commentId){
        int i = movieCommentService.deleteComment(commentId);
        if(i > 0){
            return new ResultJson<Integer>(200,true,"删除成功",i);
        }else {
            return new ResultJson<Integer>(200,true,"删除失败",i);
        }
    }
}
