package com.feng.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期转换类
 */
public class MyDateConverter implements Converter<String, Date> {

    public Date convert(String dateString) {
        //定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

        //获取日期字符串的日期分隔符
        char c = dateString.charAt(4);
        try {
            //如果第一个分隔符是'年'，说明符合格式，返回date
            if (c == '年') {
                return sdf.parse(dateString);
            }
            //否则是其他分隔符类型（例如："/" "." "-"）
            //将原字符串根据分隔符切割
            String separator = String.valueOf(c);
            String[] s;
            if (".".equals(separator)) {
                //如果分隔符是特殊符号："." ，则需要特殊处理
                s = dateString.split("\\.");
            } else {
                s = dateString.split(separator);
            }
            //如果分隔出正好三条字符串，说明格式正确，返回date
            if (s.length == 3) {
                String convert = s[0] + "年" + s[1] + "月" + s[2] + "日";
                //返回正确格式Date
                return sdf.parse(convert);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
