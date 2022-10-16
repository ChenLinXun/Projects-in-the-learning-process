package com.feng.mapper;

import com.feng.pojo.Detail;
import com.feng.pojo.User;
import com.feng.utils.MyBatisUtil;
import org.apache.ibatis.jdbc.Null;
import org.junit.Test;

public class UserMapperTest {

    @Test
    public void insertUser() {

        //用户提交了账号基本信息和详情信息到Servlet，Servlet接收注册信息封装到User和Detail对象中
        User user = new User(0, "wangwu", "123123",
                "王五", "03.jpg", null);
        Detail detail = new Detail(0, "辽宁省大连市", "13080808800",
                "我思故我在", 0);

        //业务操作
        try {
            //添加用户表
            UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
            int i = userMapper.insertUser(user);
            //设置详情表唯一外键uid，完成和用户表的映射
            detail.setUserId(user.getUserId());
            //添加详情表
            DetailMapper detailMapper = MyBatisUtil.getMapper(DetailMapper.class);
            int i1 = detailMapper.insertDetail(detail);
            //提交事务
            MyBatisUtil.commit();
            //操作数打印
            System.out.println("添加用户表："+i+"，添加详情表："+i1);
        } catch (Exception e) {
            //事务回滚
            MyBatisUtil.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
    }

    @Test
    public void queryUser(){

        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        User user = userMapper.queryUser("wangwu");

        System.out.println(user);
    }

    @Test
    public void queryUserVsDetail(){

        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        User user = userMapper.queryUserVsDetail("wangwu");

        System.out.println(user);

    }

    @Test
    public void queryUserVsDetail2(){

        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        User user = userMapper.queryUserVsDetail2("lisi");

        System.out.println(user);

    }
}