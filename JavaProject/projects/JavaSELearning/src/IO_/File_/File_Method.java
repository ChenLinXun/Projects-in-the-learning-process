package IO_.File_;
import java.io.File;
/*
 * 获取文件信息的方法
 */
public class File_Method {

    public static void main(String[] args) {

        String path = "D:\\作业和笔记\\学校作业和课设\\大学一年级第一学期C语言课设\\课设学生管理系统报告.docx";
        File file = new File(path);

        System.out.println("文件名字："+ file.getName());
        System.out.println("文件绝对路径："+ file.getAbsolutePath());
        System.out.println("文件父级目录："+ file.getParent());
        System.out.println("文件大小（字节）："+ file.length());
        System.out.println("文件是否存在："+ file.exists());
        System.out.println("是否是一个文件："+ file.isFile());
        System.out.println("是否是一个目录："+ file.isDirectory());

    }

}
