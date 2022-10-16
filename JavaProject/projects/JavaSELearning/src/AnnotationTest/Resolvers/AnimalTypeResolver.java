package AnnotationTest.Resolvers;

import AnnotationTest.Annotations.Animal;

/**
 * 动物参数类型解析器
 */
public class AnimalTypeResolver implements ParameterResolver {

    @Override
    public boolean isSupport(Object obj) {
        //先拿到该对象的class对象
        Class<?> objClass = obj.getClass();
        //判断该对象是否为动物类型的逻辑：
        //如果该类有标注@Animal注解，说明该对象是Animal类型的，支持解析
        return objClass.isAnnotationPresent(Animal.class);
    }

    @Override
    public String doResolve(Object obj) {
        //先拿到该对象的class对象
        Class<?> objClass = obj.getClass();
        //获取@Animal注解对象
        Animal annotation = objClass.getAnnotation(Animal.class);
        //返回该对象具体的类型，完成参数解析
        return "".equals(annotation.type()) ? "Animal, but unknown which type" : annotation.type();
    }
}
