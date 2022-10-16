package com.movie.mapper;

import com.movie.pojo.UserAndDetails;
import com.movie.pojo.UserDetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDetailsMapper {

    //插入一条用户详情数据
    void insertDetails(UserDetails userDetails);

    //关联用户表，根据用户编号查询所有
    UserAndDetails selectAllByUserId(String detailsUid);

    //修改用户详情
    int updateDetails(UserAndDetails userAndDetails);
}
