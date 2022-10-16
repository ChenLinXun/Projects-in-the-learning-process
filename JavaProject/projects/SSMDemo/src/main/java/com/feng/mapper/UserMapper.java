package com.feng.mapper;

import com.feng.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 根据用户账号查询所有user表信息
     * @return
     */
    User selectAllByUserName(@Param("userName") String userName);

}
