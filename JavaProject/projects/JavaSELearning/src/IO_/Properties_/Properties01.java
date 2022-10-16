package IO_.Properties_;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
/*
 * 利用IO流技术和Map集合中的Properties集合，实现.properties配置文件的创建、修改和读取
 *
 * Properties对象常用方法：
 * 1.  load()：加载配置文件的键值对到Properties对象
 * 2.  list()：将数据显示到指定设备
 * 3.  getProperty(key)：根据键获取值
 * 4.  setProperty(key,value)：设置键值对到Properties对象
 * 5.  store()：将Properties中的键值对存储到配置文件   
 *     (在idea中，保存信息到配置文件，如果含有中文，会存储为unicode码)
 */
public class Properties01 {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        //创建.properties配置文件：
        //(setProperty：如果key存在，就是修改；如果key不存在，就是创建)
        properties.setProperty("UserName","Rick");
        properties.setProperty("PassWord","12138");

        String path = "src\\IO_\\z_Resource\\配置文件.properties";
        properties.store(new FileWriter(path),null);
        System.out.println("保存成功");

        //读取.properties配置文件：
        properties.load(new FileReader(path));

        String userName = properties.getProperty("UserName");
        String passWord = properties.getProperty("PassWord");

        System.out.println("UserName："+userName);
        System.out.println("PassWord："+passWord);

    }

}
