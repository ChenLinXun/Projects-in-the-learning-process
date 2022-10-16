package com.feng.mapper;

import com.feng.pojo.Clazz;
import com.feng.pojo.Student;
import com.feng.pojo.User;
import com.feng.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class CacheTest {

    /**
     * 一级缓存：
     * 如果多次查询使用的是同一个SqlSession对象，则第一次查询之后数据会存放到缓存，
     * 后续的查询则直接访问缓存中存储的数据
     */
    @Test
    public void testL1Cache01(){

        //这样获取mapper，两个mapper对应的是同一个sqlSession对象，那么一级缓存生效
        UserMapper mapper1 = MyBatisUtil.getMapper(UserMapper.class);
        UserMapper mapper2 = MyBatisUtil.getMapper(UserMapper.class);

        //这样获取mapper，两个mapper对应的不是同一个sqlSession对象，那么没有使用一级缓存
        UserMapper mapper3 = MyBatisUtil.getFactory().openSession().getMapper(UserMapper.class);
        UserMapper mapper4 = MyBatisUtil.getFactory().openSession().getMapper(UserMapper.class);

        //第一次查询王五
        User user1 = mapper1.queryUser("wangwu");
        System.out.println(user1);
        System.out.println("=======================================");

        //第二次查询王五的结果：从缓存中获取的，控制台上没有sql的打印
        User user2 = mapper2.queryUser("wangwu");
        System.out.println(user2);
        System.out.println("=======================================");

        //第一次查询张三
        User user3 = mapper3.queryUser("zhangsan");
        System.out.println(user3);
        System.out.println("=======================================");

        //第二次查询张三的结果：从数据库中获取的，控制台上有sql的打印
        User user4 = mapper4.queryUser("zhangsan");
        System.out.println(user4);
        System.out.println("=======================================");

    }

    /**
     * 一级缓存：
     * 如果第一次查询完成之后，对查询出的对象进行修改（此修改会影响到缓存），
     * 第二次查询会直接访问缓存，造成第二次查询的结果与数据库不一致
     */
    @Test
    public void testL1Cache02(){

        //两个mapper对应的是同一个sqlSession对象，一级缓存生效
        UserMapper mapper1 = MyBatisUtil.getMapper(UserMapper.class);
        UserMapper mapper2 = MyBatisUtil.getMapper(UserMapper.class);

        //第一次查询王五
        User user1 = mapper1.queryUser("wangwu");
        System.out.println(user1);
        System.out.println("=======================================");

        //修改了查询结果user1中的属性值
        user1.setUserName("JOJO");

        //为了使第二次查询结果和数据库一致，可以清空缓存，从数据库中查找，那么一级缓存也没有意义了
        //SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //sqlSession.clearCache();

        //第二次查询王五的结果：和数据库不一致
        User user2 = mapper2.queryUser("wangwu");
        System.out.println(user2);
        System.out.println("=======================================");
    }

    /**
     * 二级缓存：
     * 二级缓存默认没有开启，需要在mybatis-config.xml中通过settings标签开启
     * 二级缓存只能缓存实现序列化接口的对象
     * 查询操作后必须commit提交事务，才能将结果存到缓存中
     */
    @Test
    public void testL2Cache(){

        //通过同一个Factory获取到的不同sqlSession
        SqlSession sqlSession1 = MyBatisUtil.getFactory().openSession();
        SqlSession sqlSession2 = MyBatisUtil.getFactory().openSession();

        //第一次查询
        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);
        List<Student> students1 = mapper1.listStudentsByCid(1);
        System.out.println(students1);

        //查询过后必须提交事务才能将结果放入缓存
        sqlSession1.commit();

        System.out.println("===============================================");

        //第二次查询
        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);
        List<Student> students2 = mapper2.listStudentsByCid(1);
        System.out.println(students2);
    }

    /**
     * 延迟加载：
     * 只有访问结果对象的关联对象属性时，
     * 才会执行子查询
     */
    @Test
    public void testLazyLoading(){

        ClassMapper mapper = MyBatisUtil.getMapper(ClassMapper.class);

        //执行查询（实际只执行了第一次查询，没有执行子查询，看日志信息）
        Clazz clazz = mapper.queryClassWithStu2("Java1班");

        //访问clazz中的非关联对象属性时，也不会执行子查询，看日志信息
        System.out.println(clazz.getClassDesc());

        //访问clazz中的关联对象属性stus(学生列表)时，执行子查询返回结果，看日志信息
        System.out.println(clazz.getStus());
    }
}
