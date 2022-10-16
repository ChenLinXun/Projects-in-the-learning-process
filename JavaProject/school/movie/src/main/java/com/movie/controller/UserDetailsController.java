package com.movie.controller;

import com.movie.pojo.UserAndDetails;
import com.movie.service.UserDetailsService;
import com.movie.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userDetails")
@SuppressWarnings("all")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 接口：根据用户ID查询所有详情（进入详情页）
     * @param userId
     * @return
     */
    @GetMapping(value = "/quryAllDetails/{userId}")
    public ResultJson<UserAndDetails> quryAllDetails(@PathVariable String userId){
        UserAndDetails userAndDetails = userDetailsService.selectAllByUserId(userId);
        if(userAndDetails != null){
            return new ResultJson<UserAndDetails>
                    (200,true,"查询成功",userAndDetails);
        } else {
            return new ResultJson<UserAndDetails>
                    (200,true,"查询失败",null);
        }
    }

    /**
     * 接口：修改详情
     * @param UserAndDetails
     * @return
     */
    @PostMapping(value = "/updateDetails")
    public ResultJson<Integer> updateDetails(@RequestBody UserAndDetails userAndDetails){

        //用户修改信息日志打印
        System.out.println("用户：" + userDetailsService.selectAllByUserId(userAndDetails.getUserId()).getUserName()
                + "---修改了信息：" + userAndDetails);

        String message = userDetailsService.updateDetails(userAndDetails);
        if("修改成功".equals(message)){
            return new ResultJson<Integer>
                    (200,true,message,1);
        }else {
            return new ResultJson<Integer>
                    (400,false,message,0);
        }
    }

}
