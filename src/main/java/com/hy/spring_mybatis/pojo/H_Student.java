package com.hy.spring_mybatis.pojo;



import java.util.Date;
import java.util.List;


public class H_Student {
    private String sid;
    private String sname;
    private Integer sage;
    private String ssex;
    private Integer cid;
    private String sahao;
    private Date datatime;
    private String file;
    private H_Class hClass;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getSahao() {
        return sahao;
    }

    public void setSahao(String sahao) {
        this.sahao = sahao;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


    public H_Class gethClass() {
        return hClass;
    }

    public void sethClass(H_Class hClass) {
        this.hClass = hClass;
    }

    @Override
    public String toString() {
        return "H_Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", ssex='" + ssex + '\'' +
                ", cid=" + cid +
                ", sahao='" + sahao + '\'' +
                ", datatime=" + datatime +
                ", file='" + file + '\'' +
                ", hClass=" + hClass +
                '}';
    }
}
