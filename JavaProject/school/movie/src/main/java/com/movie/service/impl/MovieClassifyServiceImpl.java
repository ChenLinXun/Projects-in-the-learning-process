package com.movie.service.impl;

import com.movie.mapper.MovieClassifyMapper;
import com.movie.pojo.MovieClassify;
import com.movie.service.MovieClassifyService;
import com.movie.utils.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("all")
public class MovieClassifyServiceImpl implements MovieClassifyService {

    @Autowired
    private MovieClassifyMapper movieClassifyMapper;

    @Override
    public String insertClassify(MovieClassify movieClassify) {
        //获取并注入UUID
        String classifyId = UUIDutils.getId();
        movieClassify.setClassifyId(classifyId);
        //插入数据
        movieClassifyMapper.insertClassify(movieClassify);
        return movieClassify.getClassifyId();
    }

    @Override
    public int updateClassify(MovieClassify movieClassify) {
        int i = movieClassifyMapper.updateClassify(movieClassify);
        return i;
    }
}
