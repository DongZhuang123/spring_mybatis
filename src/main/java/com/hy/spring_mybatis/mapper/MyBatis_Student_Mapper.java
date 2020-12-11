package com.hy.spring_mybatis.mapper;

import com.hy.spring_mybatis.pojo.H_Class;
import com.hy.spring_mybatis.pojo.H_Student;
import com.hy.spring_mybatis.sqlprovider.SqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MyBatis_Student_Mapper {
    @SelectKey(statement = "select uuid()" ,before =true,keyProperty = "sid",resultType = String.class,keyColumn = "sid")
    @Insert("insert into student value(#{sid},#{sname},#{sage},#{ssex},#{cid},#{sahao},#{datatime},#{file})")
    public void insertStu(H_Student student);

    @UpdateProvider(type = SqlProvider.class,method = "UpdeteStu")
    public void updateByid(H_Student student);

    @Delete("delete from student where sid=#{sid}")
    public void deleteByid(String id);

    @Results({
            @Result(property = "sid",column = "sid"),
            @Result(property = "sname",column = "sname"),
            @Result(property = "ssex",column = "ssex"),
            @Result(property = "hClass.cname",column = "cname")
    })
    @SelectProvider(type = SqlProvider.class,method = "Select_mid_stu")
    public List<H_Student> queryallleftjoin(H_Student student);

    @Select("select * from student where sid=#{sid}")
    public H_Student queryByid(String sid);

    @DeleteProvider(type = SqlProvider.class,method = "Delect_all_byid")
    public void delectall_byid(@Param("sid") String[] ids);

}
