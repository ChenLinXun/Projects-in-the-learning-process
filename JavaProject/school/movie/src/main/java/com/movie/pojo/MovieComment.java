package com.movie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieComment {
    private String commentId; //评论ID
    private String commentDesc; //评论内容
    private String commentUser; //此条评论用户
    private String commentMovie; //此条评论电影
    private String commentUsername; //此条评论用户昵称
}
