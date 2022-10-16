package com.feng.mapper;

import com.feng.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    int insertUser(User user);
    @Update("update user set user_image = #{userImage}")
    int updateUserImage(String userImage);
}
