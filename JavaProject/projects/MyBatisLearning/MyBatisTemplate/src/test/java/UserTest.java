import com.feng.mapper.UserMapper;
import com.feng.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * UserMapper测试用例
 */
public class UserTest {
    @Test
    public void testSelectAll() throws IOException {

        //1. 加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //4. 执行方法
        List<User> users = userMapper.selectAll();
        System.out.println(users);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByUP() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //以下是黑马的题目：
        //假如获取到账号密码为：
        String username = "李四";
        String password = "234";

        //根据账号密码将这两个数据封装到User对象中
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //将User对象传入到map集合中
        HashMap map = new HashMap();
        map.put("user",user);

        //调用传入map集合的方法
        List<User> users = userMapper.selectByUP(map);
        System.out.println(users);

        sqlSession.close();
    }

    @Test
    public void testSelectByUserNameAndPassword() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //假如获取到账号密码为：
        String username = "王五";
        String password = "11";

        //调用传入多个参数的方法
        User user = userMapper.selectByUserNameAndPassword(username,password);
        System.out.println(user);

        sqlSession.close();
    }
}
