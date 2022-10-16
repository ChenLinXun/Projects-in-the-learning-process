package AnnotationTest.Resolvers;

public interface ParameterResolver {
    /**
     * 是否支持解析该参数
     * @return
     */
    boolean isSupport(Object obj);

    /**
     * 解析
     * 返回参数类型
     * @return
     */
    String doResolve(Object obj);
}
