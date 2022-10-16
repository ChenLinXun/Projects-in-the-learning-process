package com.movie.service.impl;

import com.movie.mapper.MovieCommentMapper;
import com.movie.mapper.UserDetailsMapper;
import com.movie.mapper.UserMapper;
import com.movie.pojo.MovieComment;
import com.movie.pojo.UserAndDetails;
import com.movie.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@SuppressWarnings("all")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsMapper userDetailsMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MovieCommentMapper movieCommentMapper;

    @Override
    public UserAndDetails selectAllByUserId(String detailsUid) {
        return userDetailsMapper.selectAllByUserId(detailsUid);
    }

    @Override
    @Transactional
    public String updateDetails(UserAndDetails userAndDetails) {

        //先判断昵称是否为空
        if("".equals(userAndDetails.getUserName())){
            return "昵称不能为空！";
        }

        //再判断昵称是否修改（和旧值做比较）
        String s1 = userMapper.selectUserNameById(userAndDetails.getUserId());
        if(!s1.equals(userAndDetails.getUserName())){
            //最后判断修改的昵称是否重复
            String s = userMapper.selectUserByName(userAndDetails.getUserName());
            if(s != null){
                return "昵称重复";
            }
        }

        //以下两步应该是事务处理：
        //1.先修改用户表和详情表
        int i = userDetailsMapper.updateDetails(userAndDetails);
        //2.再修改对应的评论表
        MovieComment movieComment = new MovieComment();
        movieComment.setCommentUser(userAndDetails.getUserId());
        movieComment.setCommentUsername(userAndDetails.getUserName());
        movieCommentMapper.updateCommentUserNameByUserId(movieComment);

        //返回修改消息
        if(i > 0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
}
