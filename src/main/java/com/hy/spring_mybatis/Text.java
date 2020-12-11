package com.hy.spring_mybatis;


import com.hy.spring_mybatis.mapper.MyBatis_Class_Mapper;
import com.hy.spring_mybatis.mapper.MyBatis_Student_Mapper;
import com.hy.spring_mybatis.pojo.H_Class;
import com.hy.spring_mybatis.pojo.H_Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Text {
    public static void main(String[] args){
        ApplicationContext app = new ClassPathXmlApplicationContext("springapplicationContext/applicationContext.xml");

//        H_StudentDao h=new H_StudentDao();
//        List<H_Student> students=h.FindAll();
//        SqlSession session=Session.getsqlsession();
//        MyBatis_Student_Mapper msm=session.getMapper(MyBatis_Student_Mapper.class);
//        List<H_Student> students=msm.queryallstudent();
////        List<H_Class> lisclass=msm.queryallclass();
//       for (H_Student h1:students){
//           System.out.println(h1);
//       }
//        H_Student student=new H_Student();
////        student.setSid("3");
//        student.setSname("java");
//        student.setSage(333);
//        student.setSsex("F");
//        student.setCid(2);
//        msm.insertStu(student);
//        msm.updateByid(student);
//        msm.deleteByid("3");
        MyBatis_Student_Mapper jdbc= app.getBean(MyBatis_Student_Mapper.class);
        H_Student student=new H_Student();
        student.setSname("java");
        student.setSage(333);
        student.setSsex("F");
        student.setCid(2);
        jdbc.insertStu(student);
//        MyBatis_Class_Mapper jdbc= app.getBean(MyBatis_Class_Mapper.class);
//        List<H_Class> clas=jdbc.leftjoinclass(1);
//
//        for (H_Class h_class:clas){
//            System.out.println( h_class);
//        }



    }
}
