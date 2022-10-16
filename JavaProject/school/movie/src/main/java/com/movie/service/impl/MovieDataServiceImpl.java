package com.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.movie.mapper.MovieCommentMapper;
import com.movie.mapper.MovieDataMapper;
import com.movie.pojo.MovieComment;
import com.movie.pojo.MovieData;
import com.movie.pojo.MovieDataClassify;
import com.movie.req.MovieDataPageReq;
import com.movie.resp.MovieDataAndComment;
import com.movie.resp.MovieDataPageResp;
import com.movie.service.MovieDataService;
import com.movie.utils.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.List;

@Service
@SuppressWarnings("all")
public class MovieDataServiceImpl implements MovieDataService {

    @Autowired
    private MovieDataMapper movieDataMapper;

    @Autowired
    private MovieCommentMapper movieCommentMapper;

    @Override
    public String insertData(MovieData movieData) {

        //获取并注入UUID
        String dataId = UUIDutils.getId();
        movieData.setDataId(dataId);
        //插入数据
        movieDataMapper.insertData(movieData);
        return movieData.getDataId();
    }

    @Override
    public int deleteData(String dataId) {
        return movieDataMapper.deleteData(dataId);
    }

    @Override
    public int updateData(MovieData movieData) {
        return movieDataMapper.updateData(movieData);
    }

    @Override
    public MovieDataPageResp selectAll(int pageNum) {

        //设置分页(页面大小（数据条数）定死，前端要求是20，pageNum：第几页)
        PageHelper.startPage(pageNum,20);

        //查询
        List<MovieData> allDataList = movieDataMapper.selectAllData();

        //将查询数据封装到pageInfo中
        PageInfo<MovieData> info = new PageInfo<>(allDataList);

        //封装响应对象
        MovieDataPageResp movieDataPageResp = new MovieDataPageResp();
        movieDataPageResp.setMovieData(info.getList());
        movieDataPageResp.setPageNum(info.getPageNum());
        movieDataPageResp.setSize(info.getSize());
        movieDataPageResp.setTotal(info.getTotal());

        return movieDataPageResp;
    }

    @Override
    public List<MovieData> selectDataByName(String dataName) {

        //处理数据（影片名设置为模糊查询）
        if(dataName != null && !("").equals(dataName))
            dataName = "%"+dataName+"%";

        //查询
        List<MovieData> movieDataList = movieDataMapper.selectDataByName(dataName);

        return movieDataList;
    }

    @Override
    public MovieDataPageResp selectDataByCondition(MovieDataPageReq pageReq) {

        MovieData movieData = new MovieData();

        //处理数据（部分字段设置为模糊查询）
        String name = pageReq.getDataName();
        String desc = pageReq.getDataDesc();
        String country = pageReq.getDataCountry();
        if(name != null && !("").equals(name))
            movieData.setDataName("%"+name+"%");
        if(desc != null && !("").equals(desc))
            movieData.setDataDesc("%"+desc+"%");
        if(country != null && !("").equals(country))
            movieData.setDataCountry("%"+country+"%");
        //其他数据拷贝
        movieData.setDataScore(pageReq.getDataScore());
        movieData.setDataDate(pageReq.getDataDate());
        movieData.setDataImg(pageReq.getDataImg());

        //分页大小设置（定死，前端要求是20）
        pageReq.setPageSize(20);

        //设置分页（参数一：第几页；参数二：一页中有几条数据）
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());

        //查询
        List<MovieData> movieDataList = movieDataMapper.selectDataByCondition(movieData);

        //将查询数据封装到pageInfo中
        PageInfo<MovieData> info = new PageInfo<>(movieDataList);

        //封装响应对象
        MovieDataPageResp movieDataPageResp = new MovieDataPageResp();
        movieDataPageResp.setMovieData(info.getList());
        movieDataPageResp.setPageNum(info.getPageNum());
        movieDataPageResp.setSize(info.getSize());
        movieDataPageResp.setTotal(info.getTotal());

        return movieDataPageResp;
    }

    @Override
    public MovieDataPageResp selectDataJoinClassify(MovieDataPageReq pageReq) {

        MovieDataClassify movieDataClassify = new MovieDataClassify();

        //处理数据（部分字段设置为模糊查询）
        String name = pageReq.getDataName();
        String desc = pageReq.getDataDesc();
        String country = pageReq.getDataCountry();
        if(name != null && !("").equals(name))
            movieDataClassify.setDataName("%"+name+"%");
        if(desc != null && !("").equals(desc))
            movieDataClassify.setDataDesc("%"+desc+"%");
        if(country != null && !("").equals(country))
            movieDataClassify.setDataCountry("%"+country+"%");
        //其他数据拷贝
        movieDataClassify.setDataScore(pageReq.getDataScore());
        movieDataClassify.setDataDate(pageReq.getDataDate());
        movieDataClassify.setDataImg(pageReq.getDataImg());
        movieDataClassify.setDataClassifyType(pageReq.getDataClassifyType());

        //分页大小设置（定死，前端要求是20）
        pageReq.setPageSize(20);

        //设置分页（参数一：第几页；参数二：一页中有几条数据）
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());

        //查询
        List<MovieData> movieDataList = movieDataMapper.selectDataJoinClassify(movieDataClassify);

        //将查询数据封装到pageInfo中
        PageInfo<MovieData> info = new PageInfo<>(movieDataList);

        //封装响应对象
        MovieDataPageResp movieDataPageResp = new MovieDataPageResp();
        movieDataPageResp.setMovieData(info.getList());
        movieDataPageResp.setPageNum(info.getPageNum());
        movieDataPageResp.setSize(info.getSize());
        movieDataPageResp.setTotal(info.getTotal());

        return movieDataPageResp;
    }

    @Override
    public MovieDataAndComment selectDataAndCommentByDataId(String dataId) {

        MovieDataAndComment dataAndComment = new MovieDataAndComment();

        //先查询电影信息，并进行封装：
        MovieData movieData = movieDataMapper.selectAllByDataId(dataId);
        dataAndComment.setMovieData(movieData);

        //再查询评论信息，并进行封装：
        List<MovieComment> movieComments = movieCommentMapper.selectAllByDataId(dataId);
        dataAndComment.setMovieComments(movieComments);

        return dataAndComment;
    }
}
