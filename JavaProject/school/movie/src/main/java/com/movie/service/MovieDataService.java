package com.movie.service;

import com.movie.pojo.MovieData;
import com.movie.req.MovieDataPageReq;
import com.movie.resp.MovieDataAndComment;
import com.movie.resp.MovieDataPageResp;

import java.util.List;

public interface MovieDataService {

    //添加一条电影信息
    String insertData(MovieData movieData);

    //删除一条电影信息
    int deleteData(String dataId);

    //修改一条电影信息
    int updateData(MovieData movieData);

    //查询所有信息（使用分页插件查询）
    MovieDataPageResp selectAll(int pageNum);

    //根据电影名查询信息（搜索框查询）
    List<MovieData> selectDataByName(String dataName);

    //动态查询若干条电影信息（使用分页插件查询）
    MovieDataPageResp selectDataByCondition(MovieDataPageReq movieDataPageReq);

    //关联查询分类的电影信息
    MovieDataPageResp selectDataJoinClassify(MovieDataPageReq movieDataPageReq);

    //根据电影编号查询电影信息以及评论信息
    MovieDataAndComment selectDataAndCommentByDataId(String dataId);
}
