package com.movie.mapper;

import com.movie.pojo.MovieComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieCommentMapper {

    //插入一条评论
    void insertComment(MovieComment movieComment);

    //删除一条评论
    int deleteComment(String commentId);

    //根据电影编号查询评论信息
    List<MovieComment> selectAllByDataId(String dataId);

    //根据用户ID修改该评论下的用户名
    void updateCommentUserNameByUserId(MovieComment movieComment);
}
