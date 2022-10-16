package Reflection.Class;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/*
 * Class对象常用方法
 */
public class Class_API {

    @SuppressWarnings("all")
    public static void main(String[] args) throws ReflectiveOperationException {

        //1.  根据全类名获取Class对象：Class.forName(全类名)
        Class<?> personCls = Class.forName("Reflection.Class.Person");
        //2.  根据Class对象创建对应类的对象实例：cls.newInstance()
        Object o = personCls.newInstance();
        Person person = (Person) o;

        //获取类结构信息：
        //1.  getName：获取全类名
        System.out.println(personCls.getName());

        //2.  getSimpleName：获取简单类名
        System.out.println(personCls.getSimpleName());

        //3.  getFields：获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类的公有属性："+field);
        }

        //4.  getDeclaredFields：获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类的所有属性："+declaredField);
        }

        //5.  getMethods：获取所有public修饰的方法，包含本类以及父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类及父类的公有方法："+method);
        }

        //6.  getDeclaredMethods：获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类的所有方法："+declaredMethod);
        }

        //7.  getConstructors：获取本类所有public修饰的构造器
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类的公有构造器："+constructor);
        }

        //8.  getDeclaredConstructors：获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类的所有构造器："+declaredConstructor);
        }

        //9.  getPackage：以Package形式返回包信息
        Package aPackage = personCls.getPackage();
        System.out.println("包信息："+aPackage.getName());

        //10.  getSuperClass：以Class形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println("父类的Class信息："+superclass.getName());

        //11.  getlnterfaces：以Classl[] 形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息："+anInterface.getName());
        }

        //12.  getAnnotations：以Annotationl[] 形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息："+annotation);
        }

        //第二组：java.lang.reflect.Field类
        //1.  getModifiers: 以int形式返回修饰符
        //   （说明：默认修饰符是0，public是1， private是2，protected是4
        //          static是8，final 是 16，例如： public(1) + static (8)= 9）
        //2.  getType：Class形式返回类型
        //3.  getName：返回属性名
        for (Field declaredField : declaredFields) {
            System.out.println("本类的所有属性："+declaredField.getName()
            + " 该属性的修饰符值：" + declaredField.getModifiers()
            + " 该属性的类型：" + declaredField.getType());
        }

        //第三组：java.lang.reflect.Method类
        //1.  getModifiers：以int形式返回修饰符
        //  （说明：默认修饰符是0， public是1，private是2，protected是4
        //         static是8，final是16）
        //2.  getReturnType：以Class形式获取返回类型
        //3.  getName：返回方法名
        for (Method declaredMethod : declaredMethods) {
            System.out.println(String.format("本类的所有方法：" + declaredMethod.getName()
                    + " 该方法的修饰符值：" + declaredMethod.getModifiers()
                    + " 该方法的返回类型：" + declaredMethod.getReturnType()));
        }
        //4.  getParameterTypes：以Class[]返回参数类型数组
        for (Method declaredMethod : declaredMethods) {
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            System.out.println("该方法："+declaredMethod.getName()+"的参数类型：");
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName() );
            }
        }

        //第四组：java.lang.reflect. Constructor类：
        //1.  getModifiers：以int形式返回修饰符
        //2.  getName：返回构造器名（全类名）
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有构造器："+declaredConstructor.getName()
            + "该构造器修饰符值："+declaredConstructor.getModifiers());
        }
        //3.  getParameterTypes：以Class[ ]返回参数类型数组
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            System.out.println("该构造器："+declaredConstructor.getName()+"的参数类型：");
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName() );
            }
        }


    }
}

class A{

    public String hobby;

    public void hi(){

    }

    public A(){

    }
}

interface IA{}
interface IB{}

@Deprecated
class Person extends A implements IA,IB{

    public String name;
    protected int age;
    String job;
    private double sal;

    public Person(){

    }

    public Person(String A,Double B){

    }

    private Person(int A,Boolean B){

    }

    public void m1(int A,String B,Boolean C){

    }

    protected  void m2(String A,Double B){

    }

    void m3(float A){

    }

    private void m4(char A){

    }
}