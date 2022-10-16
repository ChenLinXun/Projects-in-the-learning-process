package IO_.File_;
import java.io.File;
import java.io.IOException;
/*
 * 目录操作:
 * 删除文件或目录：file.delete()
 * 创建一级目录：file.mkdir()
 * 创建多级目录：file.mkdirs()
 */
public class File_Directory {

    public static void main(String[] args) {

        File file = new File("D:\\JavaProject\\hello.txt");

        //判断文件或目录，存在就删除，否则创建
        if(file.exists()){
            System.out.println("已存在，删除成功");
            file.delete();//删除文件或目录
        }else {
            try {
                System.out.println("文件不存在，已创建");
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //创建一级目录
        File file1 = new File("D:\\JavaProject\\ABC");
        if(file1.mkdir()){
            System.out.println("创建成功");
        }else {
            System.out.println("创建失败");
        }

        //创建多级目录
        File file2 = new File("D:\\JavaProject\\a\\b\\c");
        if(file2.mkdirs()){
            System.out.println("创建成功");
        }else {
            System.out.println("创建失败");
        }


    }

}
