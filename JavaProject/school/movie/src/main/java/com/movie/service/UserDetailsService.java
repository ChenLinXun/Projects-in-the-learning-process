package com.movie.service;

import com.movie.pojo.UserAndDetails;

public interface UserDetailsService {

    //根据用户ID查询所有详情
    UserAndDetails selectAllByUserId(String detailsUid);

    //修改用户详情
    String updateDetails(UserAndDetails userAndDetails);
}
