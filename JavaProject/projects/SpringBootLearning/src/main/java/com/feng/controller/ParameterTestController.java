package com.feng.controller;

import com.feng.pojo.Car;
import com.feng.pojo.Person;
import com.feng.pojo.Pet;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    //RESTful风格：/car/{id}/owner/{username}
    //示例：http://localhost:8080/car/8888/owner/陈林迅?age=22&inters=篮球&inters=rap
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv, //获取所有路径参数放到map中
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header, //获取所有请求头放到map中
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params, //获取所有请求参数放到map中
                                     @CookieValue("Idea-c84cbbae") String Idea_c84cbbae, //获取名为Idea_c84cbbae的cookie的值
                                     @CookieValue("Idea-c84cbbae") Cookie cookie //获取名为Idea_c84cbbae的cookie
                                    ){

        Map<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("headers",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("Idea_c84cbbae",Idea_c84cbbae);
        System.out.println(cookie.getName()+"===>"+cookie.getValue());
        return map;
    }

    /**
     * 数据绑定：页面提交的请求数据（Get、Post）都可以和对象属性进行绑定
     */
    @PostMapping("/savePerson")
    public Person savePerson(Person person){return person;}

    /**
     * 基于请求参数的内容协商
     */
    @GetMapping("/savePerson")
    public Person savePerson(){return new Person("李四",20,
            new Date("2002/01/20"),
            new Pet("小哈",20));}

    @PostMapping("/saveCar")
    public Car saveCar(@RequestBody Car car){//原生表单提交，不能使用@RequestBody注解
        return car;
    }
}
