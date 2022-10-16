package com.movie.mapper;

import com.movie.pojo.MovieClassify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieClassifyMapper {

    //根据外键--电影编号查询类别表数据
    List<MovieClassify> selectAllByDid(String classifyDid);

    //插入一条分类信息
    void insertClassify(MovieClassify movieClassify);

    //修改一条分类信息
    int updateClassify(MovieClassify movieClassify);
}
