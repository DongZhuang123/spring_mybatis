package com.hy.spring_mybatis.date;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
//        将日期串装换为日期类型yyyy-MM-dd HH:mm:ss
        System.out.println("日期装换器");
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sim.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
