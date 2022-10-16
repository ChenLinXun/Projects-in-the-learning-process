package com.movie.mapper;

import com.movie.pojo.MovieData;
import com.movie.pojo.MovieDataClassify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieDataMapper {

    //添加一条电影信息
    void insertData(MovieData movieData);

    //删除一条电影信息
    int deleteData(@Param("dataId") String dataId);

    //修改一条电影信息
    int updateData(MovieData movieData);

    //查询所有信息
    List<MovieData> selectAllData();

    //根据电影编号查询信息
    MovieData selectAllByDataId(String dataId);

    //根据电影名查询信息（搜索框查询）
    List<MovieData> selectDataByName(String dataName);

    //动态查询若干条电影信息
    List<MovieData> selectDataByCondition(MovieData movieData);

    //关联查询分类的电影信息
    List<MovieData> selectDataJoinClassify(MovieDataClassify movieDataClassify);
}
