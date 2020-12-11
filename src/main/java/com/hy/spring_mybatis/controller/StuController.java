package com.hy.spring_mybatis.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.spring_mybatis.mapper.MyBatis_Class_Mapper;
import com.hy.spring_mybatis.pojo.H_Class;
import com.hy.spring_mybatis.pojo.H_Student;
import com.hy.spring_mybatis.service.ClassService;
import com.hy.spring_mybatis.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
//@RequestMapping("/stu")
public class StuController {
    @Autowired
    public StuService stService;
    @Autowired
    private ClassService cla;

    public Integer pagesize=4;

    //多表联合查询
    @RequestMapping("queryStucla")
    public String QueryStucla(Model model,H_Student h_student,@RequestParam(value = "pagenum",defaultValue = "1") Integer pagenum){
         Page   page= PageHelper.startPage(pagenum,pagesize,true);
        List<H_Student> list=stService.queryallleftjoin(h_student,pagenum);
        Long pa=page.getTotal();
        Long io=(pa+pagesize- 1) /pagesize;
        model.addAttribute("pagenum",pagenum);
        model.addAttribute("io",io);
        model.addAttribute("list",list);
        model.addAttribute("lis",cla.queryclass());
        return "/query.jsp";
    }
//根据id查询学生信息
    @RequestMapping("queryByid")
    public String queryByid(Model model,String sid){
        model.addAttribute("list",stService.queryByid(sid));
        model.addAttribute("lis",cla.queryclass());
        return "/setstudent.jsp";
    }
//查询班级信息
    @RequestMapping("queryByidclass")
    public String queryByidclass(Model model){
        model.addAttribute("lis",cla.queryclass());
        return "/addstudent.jsp";
    }
//添加学生信息，上传图片
    @RequestMapping("addstudent")
    public String Addstudent(H_Student student,@RequestParam("filee") MultipartFile mu, HttpServletRequest rq){
        //        设置图片名称不能重复
        String uuidname= UUID.randomUUID().toString();
//        获取文件名s
        String  filename=mu.getOriginalFilename();
//        获取文件后缀

        String textname=filename.substring(filename.lastIndexOf("."));
        try {
            mu.transferTo(new File(rq.getServletContext().getRealPath("/")+"file/"+uuidname+textname));
        } catch (IOException e) {
            e.printStackTrace();
        }
        student.setFile(uuidname+textname);
        stService.insertStu(student);
        return "redirect:queryStucla.do";
    }

    //    批量删除
     @RequestMapping("delectall_byid")
     public String Delectall_byid(String[] student){
        System.out.println("id+++++"+student.length);
         stService.delectall_byid(student);
        return "redirect:queryStucla.do";
     }

    @RequestMapping("updateByid")
    public String UpdateByid(H_Student student,@RequestParam("filee") MultipartFile mu, HttpServletRequest rq){
        //        设置图片名称不能重复
        String uuidname= UUID.randomUUID().toString();
//        获取文件名s
        String  filename=mu.getOriginalFilename();
 //判断文件是否上传
        if (filename!=null && filename!=""){
            //        获取文件后缀
            String textname=filename.substring(filename.lastIndexOf("."));
            try {
                mu.transferTo(new File(rq.getServletContext().getRealPath("/")+"file/"+uuidname+textname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            student.setFile(uuidname+textname);
        }
        stService.updateByid(student);
        return "redirect:queryStucla.do";
    }

    @RequestMapping("deleteByid")
    public String DeleteByid(String id){
        stService.deleteByid(id);
        return "redirect:queryStucla.do";
    }





}
