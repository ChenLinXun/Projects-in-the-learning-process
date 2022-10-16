package com.movie.service;

import com.movie.pojo.MovieComment;

public interface MovieCommentService {

    //插入一条评论
    String insertComment(MovieComment movieComment);

    //删除一条评论
    int deleteComment(String commentId);
}
