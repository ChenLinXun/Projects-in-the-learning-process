package com.movie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId; //用户编号
    private String userName; //用户昵称
    private String userAccount; //用户账号
    private String userPassword; //用户密码
}
