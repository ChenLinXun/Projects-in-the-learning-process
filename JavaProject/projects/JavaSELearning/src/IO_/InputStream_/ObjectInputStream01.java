package IO_.InputStream_;
import IO_.OutputStream_.Dog;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
 * 1.  对象流的作用： 
 *     对象流可以将一个对象存储到文件中，保存对象的状态，称为序列化 
 *     相对地可以将对象从文件中读出，恢复对象的状态，称为反序列化
 *
 * 2.  序列化和反序列化： 
 *     序列化：Serialize  对java对象进行拆分，按序列号拆分成若干数据包，存储到文件中。   
 *            将java对象的状态保存下来的过程（文件是dat文件）
 *     反序列化：DeSerialize 将硬盘中的数据按序列号组装，重新恢复到内存当中， 
 *              恢复成java对象的过程
 *
 *     序列化需要类(流)：ObjectOutputStream 方法：writeObject(); 
 *     反序列化需要类(流)：ObjectInputStream 方法   readObject();
 *
 * 3.  序列化细节：
 *     3.1  参与序列化和反序列化的对象，其类必须实现Serializable接口或Externalizable接口；
 *          一般使用Serializable接口，它是一个标记接口，没有方法来需要实现
 *
 *     3.2  参与序列化和反序列化的对象，其类都必须有一个序列化版本号。   
 *          解释：java中区分类的方式是：1.根据类名的不同 2.类名相同根据序列化版本号进行区分
 *
 *     3.3  实现了Serializable接口后，可以不用手动写类的序列化版本号，jvm会自动为其分配一个
            独一无二的版本号，这样做虽然方便，但有一个重大缺陷： 
 *          当一个类没有手动写序列化版本号时，若对象序列化之后，修改了类的内容，那么重新编译时，
 *          该类的序列化版本号会被jvm重新分配，导致和之前的不同，那么文件中的对象就无法再反序列化回来 
 *
 *     3.4  手动写一个独一无二的序列化版本号很重要，提高版本兼容性
 *          Idea中快捷键生成一个序列化版本号：
 *          鼠标放在类名上按alt+回车，选择创建一个序列化版本号
 *   
 *     3.5  对于基本数据类型的序列化和反序列化，会先将基本类型进行自动装箱成包装类对象，
 *          基本类型的包装类对象都实现了Serializable接口
 *
 *     3.6  序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员   
 *
 *     3.7  序列化对象时,要求里面属性的类型也需要实现序列化接口
 *
 *     3.8  序列化具备可继承性，如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化
 */
public class ObjectInputStream01 {

    public static void main(String[] args) {

        String path = "src\\IO_\\z_Resource\\序列化.dat";

        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(path));

            //反序列化顺序要和序列化顺序一致！
            /*
                oos.writeInt(1);//int-->integer
                oos.writeFloat(1.2f);//float-->Float
                oos.writeBoolean(true);//boolean-->Boolean
                oos.writeChar('a');//char-->Character
                oos.writeUTF("陈林迅");//String

                oos.writeObject(dog);
             */

            System.out.println(ois.readInt());
            System.out.println(ois.readFloat());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readChar());
            System.out.println(ois.readUTF());

            Object obj = ois.readObject();
            System.out.println(obj);

            //注意，如果要使用反序列化对象独有方法，注意向下转型
            Dog dog = (Dog)obj;
            dog.say();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}