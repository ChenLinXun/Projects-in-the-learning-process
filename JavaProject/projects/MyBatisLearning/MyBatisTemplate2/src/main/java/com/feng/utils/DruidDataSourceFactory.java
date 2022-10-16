package com.feng.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

public class DruidDataSourceFactory extends PooledDataSourceFactory {

    public DruidDataSourceFactory() {
        //修改 父类属性dataSource 为DruidDataSource
        this.dataSource = new DruidDataSource();
    }
}
