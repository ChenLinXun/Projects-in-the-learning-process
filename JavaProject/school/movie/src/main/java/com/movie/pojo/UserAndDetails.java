package com.movie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndDetails {
    private String userId; //用户编号
    private String userName; //用户昵称
    private String userAccount; //用户账号
    private String userPassword; //用户密码

    private String detailsId; //详情编号
    private String detailsTel; //用户电话号
    private String detailsAddr; //用户地址
    private String detailsDesc; //个性签名
}
