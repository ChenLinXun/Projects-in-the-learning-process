package com.movie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieClassify {
    private String classifyId; //编号ID
    private String classifyType; //类型名称
    private String classifyDid; //外键，电影ID
}
