package com.hy.spring_mybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.spring_mybatis.mapper.MyBatis_Student_Mapper;
import com.hy.spring_mybatis.pojo.H_Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuService {
    @Autowired
    private MyBatis_Student_Mapper stu;

    public MyBatis_Student_Mapper getStu() {
        return stu;
    }

    public void setStu(MyBatis_Student_Mapper stu) {
        this.stu = stu;
    }


    public void insertStu(H_Student h_student){
        stu.insertStu(h_student);
    }


    public void updateByid(H_Student h_student){
        stu.updateByid(h_student);
    }

    public void deleteByid(String id){
        stu.deleteByid(id);
    }

    public List<H_Student> queryallleftjoin(H_Student student,Integer pagenum){
        return stu.queryallleftjoin(student);
    }

    public H_Student queryByid(String id){
        return stu.queryByid(id);
    }

    public void delectall_byid(String[] id){
        stu.delectall_byid(id);
    }

}
