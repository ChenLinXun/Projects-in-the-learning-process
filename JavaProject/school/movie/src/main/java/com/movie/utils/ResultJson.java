package com.movie.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultJson <E>{
    private Integer code; //服务器状态码
    private Boolean success; //是否成功
    private String message;  //返回消息
    private E data;  //返回数据
}
