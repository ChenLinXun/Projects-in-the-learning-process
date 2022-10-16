package IO_.File_;
import java.io.File;
import java.io.IOException;
/*
 * 文件的创建：
 * 先创建File对象，三种方式：（父子路径都必须存在）
 * 1.  new File(String pathname)：根据路径构建一个File对象
 * 2.  new File(File parent,String child)：根据父目录对象+子路径构建
 * 3.  new File(String parent,String child)：根据父目录+子路径构建
 * 再调用 .createNewFile() 方法创建文件至磁盘
 */
public class File_create {

    public static void main(String[] args) {

        //三种方法，不管父子级，路径都必须存在

        //方法一：全路径
        File file = new File("D:\\JavaProject\\hello.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //方法二：父目录对象+子路径
        File parentFile = new File("D:\\JavaProject");
        File file1 = new File(parentFile, "hello2.txt");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //方法三：父路径+子路径
        File file2 = new File("D:", "JavaProject\\hello3.txt");
        try {
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
