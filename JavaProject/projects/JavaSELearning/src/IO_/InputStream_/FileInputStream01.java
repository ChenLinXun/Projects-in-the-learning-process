package IO_.InputStream_;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/*
 * FileInputStream：
 * 构造方法:
 * 1.  根据路径读取文件：FileInputStream(String name)
 * 2.  读取传入的文件对象：FileInputStream(File file)
 *
 * 读取方式:
 * 1.  read() 方法读取： 
 *     每次读取一个字节，并返回该字节(int类型，ASCII码)   
 *     若要输出，可强转为char类型（char和int之间可以直接转换） 
 *     若读取结束，返回-1
 * 2.  read(byte[] buff) 方法读取：
 *     一次读取一个字节数组，读到该数组中 
 *     正常读取，返回实际读到的字节个数 
 *     读取完毕，返回-1   
 *     若要输出，可根据该数组构建String对象，调用String类型的 
 *     构造方法：String(byte bytes[], int offset, int length)
 */
public class FileInputStream01 {

    @SuppressWarnings({"all"})
    public static void main(String[] args){
        System.out.println("FileInputStream读取方式...");
    }

    @Test
    public void read01(){

        //(相对路径是从当前位置为起点开始，IDEA中，默认的当前路径是工程的根，和out文件是同一级)
        String path = "src\\IO_\\z_Resource";

        File file = new File(path, "hello.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //使用字节流来读取文本文件，如果文本文件中含有中文，很容易出现乱码
        //例如utf-8下，一个中文字符是三个字节，当一个字节一个字节地读取，同时转换成char，就会出现乱码
        //因此，文本文件还是用字符流读取比较合适，而且效率更高
        FileInputStream is = null;

        try {
            //使用根据File文件对象的方式构造
            is = new FileInputStream(file);

            //调用read()方法读取，每次读取一个字节，并返回
            //读取完毕，返回-1
            int data = 0; //读取出来的一个字节
            while (( data = is.read() ) != -1){
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void read02(){

        //(相对路径是从当前位置为起点开始，IDEA中，默认的当前路径是工程的根，和out文件是同一级)
        String path = "src\\IO_\\z_Resource\\hello.txt";

        FileInputStream is = null;

        try {
            //使用根据File文件对象的方式构造
            is = new FileInputStream(path);

            //read(byte[] buff)方法，一次读取一个字节数组，读到该数组中
            //正常读取，返回实际读到的字节数
            //读取完毕，返回-1
            byte[] buf = new byte[1024];//一次读取1024字节，1KB
            int len = 0;
            while ((len = is.read(buf)) != -1){
                System.out.print(new String(buf,0,len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
