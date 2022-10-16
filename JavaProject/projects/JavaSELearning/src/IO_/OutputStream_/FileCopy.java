package IO_.OutputStream_;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/*
 * 简单实现文件拷贝
 */
public class FileCopy {

    public static void main(String[] args) {

        String path = "src\\IO_\\z_Resource\\";

        FileInputStream is = null;
        FileOutputStream os = null;

        try {
            is = new FileInputStream(path+"看书女孩.jpg");
            os = new FileOutputStream(path+"看书女孩2.jpg");

            //使用字节数组读取和写入，每次操作一个字节数组，提高效率
            byte[] buff = new byte[1024];//每次读1024字节，1KB
            int readLen = 0;

            while ((readLen = is.read(buff)) != -1){//一边读
                //这里必须使用write(byte b[], int off, int len)方法写入，读到几个就写入几个
                //否则容易导致数据不一致和数据紊乱
                os.write(buff,0,readLen);//一边写
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //is和os被赋值时，也就是指向了流对象，才需要关闭
                if(is != null)
                    is.close();
                if(os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
