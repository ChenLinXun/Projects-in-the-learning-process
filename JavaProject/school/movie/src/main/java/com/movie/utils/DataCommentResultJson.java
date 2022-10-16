package com.movie.utils;

import com.movie.resp.MovieDataAndComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataCommentResultJson {
    private Integer code; //服务器状态码
    private Boolean success; //是否成功
    private String message;  //返回消息

    private MovieDataAndComment data;  //电影和电影评论
}
