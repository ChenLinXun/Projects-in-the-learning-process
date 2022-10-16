package com.movie.service;

import com.movie.pojo.MovieClassify;

public interface MovieClassifyService {

    //添加一条分类信息
    String insertClassify(MovieClassify movieClassify);

    //修改一条分类信息
    int updateClassify(MovieClassify movieClassify);
}
