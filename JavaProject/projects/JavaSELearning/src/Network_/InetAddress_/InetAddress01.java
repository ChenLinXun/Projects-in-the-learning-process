package Network_.InetAddress_;
import java.net.InetAddress;
import java.net.UnknownHostException;
/*
 * InetAddress类：
 * 这个类代表一个互联网协议（IP）地址，通过它可获得ip、主机名称，等信息
 *
 * 常用方法：
 * 静态方法：
 * 1.  getLocalHost()：获取本机InetAddress对象getLocalHost
 * 2.  getByName()：根据指定主机名/域名获取ip地址对象
 *
 * 对象方法：
 * 3.  getHostName()：获取InetAddress对象的主机名
 * 4.  getHostAddress()：获取InetAddress对象的地址
 */
public class InetAddress01 {

    @SuppressWarnings({"all"})
    public static void main(String[] args) throws UnknownHostException {

        //1. 获取本机InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //2. 根据主机名获取InetAddress对象
        InetAddress host1 = InetAddress.getByName("陈林迅的雷神911");
        System.out.println("host1："+host1);

        //3. 根据域名获取InetAddress对象
        InetAddress bilibili = InetAddress.getByName("www.bilibili.com");
        System.out.println("bilibili："+bilibili);

        //4. 根据InetAddress对象获取ip地址
        String hostAddress = bilibili.getHostAddress();
        System.out.println("b站的ip地址"+hostAddress);

        //5. 根据InetAddress对象获取主机名或者域名
        String hostName = bilibili.getHostName();
        System.out.println("b站主机名或域名："+hostName);

    }

}
