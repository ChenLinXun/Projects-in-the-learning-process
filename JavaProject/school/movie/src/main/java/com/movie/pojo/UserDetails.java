package com.movie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    private String detailsId; //详情编号
    private String detailsTel; //用户电话号
    private String detailsAddr; //用户地址
    private String detailsDesc; //个性签名
    private String detailsUid; //用户编号
}
