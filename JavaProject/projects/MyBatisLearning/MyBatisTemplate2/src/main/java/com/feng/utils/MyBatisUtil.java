package com.feng.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 会话工厂SqlSessionFactory、会话SqlSession、Mapper对象的获取工具类
 */
public class MyBatisUtil {

    private static SqlSessionFactory factory;

    /**
     * 使用ThreadLocal存放sqlSession对象，
     * 可以保证同一线程访问ThreadLocal获取的sqlSession对象是同一个
     * ThreadLocal为每个线程保存仅属于自己的对象
     * 不同线程对同一个ThreadLocal对象的访问，
     * 获取的都是线程本地的对象（底层是map实现）
     */
    private static final ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();

    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取：SqlSessionFactory 会话工厂
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getFactory(){
        return factory;
    }

    /**
     * 获取：SqlSession 会话
     * 无参，默认手动提交事务
     * @return SqlSession
     */
    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }

    /**
     * 获取：SqlSession 会话
     * @param isAutoCommit: true，自动提交；false，手动提交
     * @return SqlSession
     */
    public static SqlSession getSqlSession(boolean isAutoCommit){
        SqlSession sqlSession = local.get();
        if(sqlSession == null){
            sqlSession = factory.openSession(isAutoCommit);
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 获取：Mapper
     * 默认手动提交事务
     * @param c Mapper的Class对象
     * @param <T> Mapper类型
     * @return Mapper
     */
    public static <T>T getMapper(Class<T> c){
        return getMapper(c,false);
    }

    /**
     * 获取：Mapper
     * @param c Mapper的Class对象
     * @param <T> Mapper类型
     * @param isAutoCommit: true，自动提交；false，手动提交
     * @return Mapper
     */
    public static <T>T getMapper(Class<T> c, boolean isAutoCommit){
        SqlSession sqlSession = getSqlSession(isAutoCommit);
        return sqlSession.getMapper(c);
    }

    /**
     * 提交事务
     */
    public static void commit(){
        SqlSession sqlSession = local.get();
        sqlSession.commit();
    }

    /**
     * 回滚事务
     */
    public static void rollback(){
        SqlSession sqlSession = local.get();
        sqlSession.rollback();
    }

    /**
     * 关闭SqlSession会话
     */
    public static void closeSqlSession(){
        SqlSession sqlSession = local.get();
        if(sqlSession != null){
            sqlSession.close();
            local.set(null);
        }
    }
}
