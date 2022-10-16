package com.feng.config;

import com.feng.interceptor.LoginInterceptor;
import com.feng.interceptor.TestInterceptor1;
import com.feng.interceptor.TestInterceptor2;
import com.feng.pojo.Person;
import com.feng.pojo.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer webMvcConfig(){
        return new WebMvcConfigurer() {

            /**
             * 配置自定义拦截器
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //同一路径多个拦截器，形成拦截器链，拦截顺序就是添加顺序
                registry.addInterceptor(new TestInterceptor1())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/","/toLogin","/login", "/static/**");
                registry.addInterceptor(new TestInterceptor2())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/","/toLogin","/login", "/static/**");
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**") //拦截的路径 /**拦截所有请求，包括静态
                        .excludePathPatterns("/","/toLogin","/login", "/static/**"); //放行的路径（静态资源放行）
            }

            /**
             * 自定义数据绑定类型转换器
             */
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        if(!StringUtils.isEmpty(source)){
                            //自定义转换逻辑
                            String[] split = source.split(",");
                            Pet pet = new Pet();
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                            return pet;
                        }
                        return null;
                    }
                });
            }

            /**
             * 自定义内容协商消息转换器
             */
            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new HttpMessageConverter<Person>() {

                    @Override
                    public boolean canRead(Class<?> clazz, MediaType mediaType) {
                        //将前端数据转为POJO对象的工作交由其他MessageConverter完成
                        return false;
                    }

                    @Override
                    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
                        //只要该返回值类型是Person类型的，就可以进行媒体类型的转化
                        return clazz.isAssignableFrom(Person.class);
                    }

                    /**
                     * 服务器要统计所有MessageConverter能写出哪些内容
                     */
                    @Override
                    public List<MediaType> getSupportedMediaTypes() {
                        //自定义的媒体类型为 application/x-guigu ，格式见write方法
                        return MediaType.parseMediaTypes("application/x-guigu");
                    }

                    @Override
                    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
                        return null;
                    }

                    /**
                     * 自定义协议数据的写出
                     */
                    @Override
                    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
                        //将POJO类型数据，转换成自定义媒体类型
                        //自定义媒体类型格式：Person属性，用;分隔
                        String data = person.getPersonName()+";"+person.getAge()+";"+person.getBirth()+";"+
                                person.getPet().getName()+";"+person.getPet().getAge();

                        //将数据响应出去
                        OutputStream body = outputMessage.getBody();
                        body.write(data.getBytes());
                        body.flush();
                    }
                });
            }

            /**
             * 自定义基于请求参数的内容协商策略
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                //自定义策略需要传入的Map
                Map<String, MediaType> mediaTypes = new HashMap<>();

                //key为请求参数format的值，value为转化出的媒体类型
                mediaTypes.put("json",MediaType.APPLICATION_JSON);
                mediaTypes.put("xml",MediaType.APPLICATION_XML);
                mediaTypes.put("gg",MediaType.parseMediaType("application/x-guigu"));
                mediaTypes.put("guigu",MediaType.parseMediaType("application/x-guigu"));
                mediaTypes.put("x-guigu",MediaType.parseMediaType("application/x-guigu"));

                //自定义的基于请求参数的strategy策略，需要传入一个Map，key为请求参数format的值，value为转化出的媒体类型
                ParameterContentNegotiationStrategy myParameterStrategy = new ParameterContentNegotiationStrategy(mediaTypes);

                //使用原来默认的基于请求头的strategy策略（根据Accept请求头值获取浏览器接受的媒体类型）
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();

                //contentNegotiationManager 内容协商管理器，调用strategies()方法，添加自定义策略（List集合）
                //注意！此时SpringMVC以添加的该自定义策略（集合）为准，相当于覆盖了原来的策略（集合）
                ArrayList<ContentNegotiationStrategy> myStrategies = new ArrayList<>();
                myStrategies.add(myParameterStrategy); //此时集合中只有一个策略，是自定义基于请求参数的
                //加上原来默认的基于请求头策略，才可以继续使用默认请求头方式
                myStrategies.add(headerContentNegotiationStrategy);
                configurer.strategies(myStrategies);
            }
        };
    }
}
