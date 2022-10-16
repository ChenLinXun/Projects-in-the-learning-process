package IO_.Writer_;
import java.io.*;
/*
 * 使用处理流简单实现文件拷贝
 */
public class Copy {

    public static void main(String[] args) throws IOException {

        String path1 = "src\\IO_\\z_Resource\\哈喽.txt";
        String path2 = "src\\IO_\\z_Resource\\哈喽2.txt";

        BufferedReader bfr = new BufferedReader(new FileReader(path1));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(path2));

        String readLine;
        while ((readLine = bfr.readLine()) != null){
            bfw.write(readLine);
            bfw.newLine();
        }

        bfr.close();
        bfw.close();
    }

}
