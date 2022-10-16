package AnnotationTest;

import AnnotationTest.Parameters.Cat;
import AnnotationTest.Resolvers.AnimalTypeResolver;
import AnnotationTest.Resolvers.BotanyTypeResolver;
import AnnotationTest.Resolvers.ParameterResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟JavaEE中对注解的使用：
 * （在如今主流的Web开发框架里，其灵魂在于利用Java的反射和注解，进行流程控制，设置切面，摒弃复杂的xml配置等）
 * 例如：
 * 在前端向后端请求方法（接口）发送请求时，后端框架SpringMVC需要对请求中所带参数进行解析，此时如果在后端请求方法中的参数
 * 标注了某些注解，或者该参数所属类上标注了某些注解，这些注解就可以被SpringMVC获取并进行解析判断该参数是什么类型，要做哪些处理
 */
public class Test {

    //所有的参数解析器，决定了能处理参数的所有类型
    private static final List<ParameterResolver> resolvers = new ArrayList<>();

    public static void main(String[] args){
        //假设能支持解析这两种参数
        resolvers.add(new AnimalTypeResolver());
        resolvers.add(new BotanyTypeResolver());

        //假设某个地方，例如前端，传来一个参数，我不知道他是什么类型的参数，需要进行解析：
        Object param = new Cat();

        //先遍历所有的参数解析器
        for (ParameterResolver resolver : resolvers) {
            //看哪个解析器支持解析该参数：
            if(resolver.isSupport(param)){
                //支持就进行解析
                String o = resolver.doResolve(param);
                //打印解析结果
                System.out.println("参数类型是：" + o);
            }
        }
    }
}
