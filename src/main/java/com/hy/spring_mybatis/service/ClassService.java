package com.hy.spring_mybatis.service;

import com.hy.spring_mybatis.mapper.MyBatis_Class_Mapper;
import com.hy.spring_mybatis.pojo.H_Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private MyBatis_Class_Mapper myBatis_class_mapper;

    public List<H_Class> queryclass(){
        return myBatis_class_mapper.queryclass();
    }
}
