package com.movie.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResultJson<E> {
    private Integer code; //服务器状态码
    private Boolean success; //是否成功
    private String message;  //返回消息

    private int pageNum; //当前页
    private int size; //当前页中的数据条数
    private long total; //总数据条数
    private E data;  //返回数据
}
