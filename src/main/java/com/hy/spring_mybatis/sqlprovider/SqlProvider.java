package com.hy.spring_mybatis.sqlprovider;

import com.hy.spring_mybatis.pojo.H_Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class SqlProvider {

    //    联合条件查询
    public String Select_mid_stu(H_Student student) {
        StringBuffer sql = new StringBuffer("select * from student stu inner join class cla on stu.cid=cla.cid");
        if (student != null) {
            if (student.getSname() != null && student.getSname() != "") {
                sql.append(" and stu.sname like CONCAT('%',#{sname},'%')");
            }
            if (student.getSsex() != null && student.getSsex() != "") {
                sql.append(" and stu.ssex=#{ssex} ");
            }
            if (student.getCid() != null && student.getCid() != -1) {
                sql.append(" and stu.cid=#{cid}");
            }

        }
        return sql.toString();
    }

    //    批量删除
    public String Delect_all_byid(@Param("sid") String[] ids) {
        StringBuffer sql = new StringBuffer("DELETE from student where sid in (");
        for (int i = 0; i < ids.length; i++) {
            sql.append("#{sid[" + i + "]},");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        return sql.toString();
    }

    public String UpdeteStu(H_Student student) {
        SQL sql = new SQL();
        sql.UPDATE("student");
        if (student != null) {
            if (student.getSname() != null) {
                sql.SET("sname=#{sname}");
            }
            if (student.getCid() != null) {
                sql.SET("cid=#{cid}");
            }
            if (student.getSsex() != null) {
                sql.SET("ssex=#{ssex}");
            }
            if (student.getSage() != null) {
                sql.SET("sage=#{sage}");
            }
            if (student.getSahao() != null) {
                sql.SET("sahao=#{sahao}");
            }
            if (student.getDatatime() != null) {
                sql.SET("datatime=#{datatime}");
            }
            if (student.getFile() != null) {
                sql.SET("file=#{file}");
            }
        }
        sql.WHERE("sid=#{sid}");
        return sql.toString();

    }

}
