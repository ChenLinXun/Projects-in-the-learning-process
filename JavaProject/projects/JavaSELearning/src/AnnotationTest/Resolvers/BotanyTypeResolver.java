package AnnotationTest.Resolvers;

import AnnotationTest.Annotations.Botany;

/**
 * 植物参数类型解析器
 */
public class BotanyTypeResolver implements ParameterResolver {
    @Override
    public boolean isSupport(Object obj) {
        Class<?> objClass = obj.getClass();
        return objClass.isAnnotationPresent(Botany.class);
    }

    @Override
    public String doResolve(Object obj) {
        Class<?> objClass = obj.getClass();
        Botany annotation = objClass.getAnnotation(Botany.class);
        return "".equals(annotation.type()) ? "Botany, but unknown which type" : annotation.type();
    }
}
