package com.movie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDataClassify {
    private String dataId; //电影ID
    private String dataName; //电影名
    private String dataDesc; //电影描述
    private Float dataScore; //电影评分
    private String dataCountry; //出品地区
    private String dataDate; //上映日期
    private String dataImg; //上映日期
    private String dataClassifyType; //类型名称
}
