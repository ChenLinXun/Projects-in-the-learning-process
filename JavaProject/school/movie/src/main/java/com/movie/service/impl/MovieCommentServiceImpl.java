package com.movie.service.impl;

import com.movie.mapper.MovieCommentMapper;
import com.movie.mapper.UserMapper;
import com.movie.pojo.MovieComment;
import com.movie.service.MovieCommentService;
import com.movie.utils.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("all")
public class MovieCommentServiceImpl implements MovieCommentService {

    @Autowired
    private MovieCommentMapper movieCommentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String insertComment(MovieComment movieComment) {
        //获取并注入UUID
        String commentId = UUIDutils.getId();
        movieComment.setCommentId(commentId);
        //插入数据
        movieCommentMapper.insertComment(movieComment);
        //查询该条评论的用户昵称并返回
        return userMapper.selectUserNameById(movieComment.getCommentUser());
    }

    @Override
    public int deleteComment(String commentId) {
        return movieCommentMapper.deleteComment(commentId);
    }
}
