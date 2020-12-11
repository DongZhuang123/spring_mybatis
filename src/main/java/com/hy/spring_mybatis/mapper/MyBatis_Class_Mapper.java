package com.hy.spring_mybatis.mapper;

import com.hy.spring_mybatis.pojo.H_Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface MyBatis_Class_Mapper {

    @Select("select * from class")
    public List<H_Class> queryclass();

}
