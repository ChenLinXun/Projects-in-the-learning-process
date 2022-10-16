package IO_.OutputStream_;
import java.io.FileOutputStream;
import java.io.IOException;
/*
 * FileOutPutStream：
 * 构造方法:
 * 1.  根据路径写入文件：FileOutputStream(String name, boolean append)
 * 2.  写入传入的文件对象：FileOutputStream(File file, boolean append) 
 * 说明：       
 *  1.  如果文件不存在，会默认创建（但路径必须存在）         
 *  2.  不传入追加方式append的值，默认为false，不追加，直接覆盖               
 *      注意，并不是每调用一次write()就覆盖一次，而是流关闭前的所有操作作为一个整体覆盖一次
 *
 * 写入方式：
 * 1.  写入一个字节：write(int b)
 * 2.  写入字符串：write(byte b[]) 
 *     可以使用字符串的getBytes()方法：将字符串转换为byte数组传入
 * 3.  写入byte数组中的指定内容：write(byte b[], int off, int len)
 *     可以使用字符串的getBytes()方法：将字符串转换为byte数组传入
 */
public class FileOutPutStream01 {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        String path = "src\\IO_\\z_Resource\\hello2.txt";

        //如果传入的文件不存在，则创建该文件（路径必须存在）
        FileOutputStream os = null;

        try {
            //不传入追加方式参数，默认追加为：false 也就是覆盖
            //之后该流对此文件的写入，会覆盖原来文件中的数据
            //注意，并不是每调用一次write()就覆盖一次，而是流关闭前的所有操作
            os = new FileOutputStream(path);

            //写入一个字节：write(int b)
            os.write('H');

            //写入字符串：write(byte b[])
            //字符串的getBytes()方法：将字符串转换为byte数组返回
            String s = "ello,";
            os.write(s.getBytes());

            //写入byte数组中的指定内容：write(byte b[], int off, int len)
            //字符串的getBytes()方法：将字符串转换为byte数组返回
            String s1 = "world!!!";
            os.write(s1.getBytes(),0,6);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
