package com.feng.mapper;

import com.feng.pojo.Detail;

public interface DetailMapper {

    /**
     * 添加详情表
     * @param detail
     * @return
     */
    int insertDetail(Detail detail);

    /**
     * 根据uid查询详情表信息
     * @param uid
     * @return
     */
    Detail queryDetailByUid(int uid);

}
