<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/9 0009
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>修改学生信息</title>
    <!-- 引入 Bootstrap -->
    <link href="js/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>


    <![endif]-->
</head>


<body>
<div style="padding: 100px 50px 10px;">
    <form action="/addstudent.do" method="post" enctype="multipart/form-data" >
        <div class="input-group input-group-lg">
            <span class="input-group-addon">姓名：</span>
            <input type="text" class="form-control" name="sname" >
        </div><br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon">年龄：</span>
            <input type="text" class="form-control" name="sage" >
        </div><br>
        <br>性别
        <br>
        <input type="radio" name="ssex" value="M" checked="checked">男
        <input type="radio" name="ssex"  value="F" >女
        <br>班级<select name="cid" style="padding: 5px 20px 10px;">
        <c:forEach items="${lis}" var="lis" varStatus="flag">
            <option value="${lis.cid}">${lis.cname}</option>
        </c:forEach>
    </select>
        </br>
        <br><div class="input-group input-group-lg">
        <span class="input-group-addon">爱好：</span>
        <input type="text" class="form-control" name="sahao">
    </div><br>

        <div class="input-group input-group-lg">
            <span class="input-group-addon">日期：</span>
            <input type="date" class="form-control" name="datatime">
        </div><br>

        <div class="input-group input-group-lg">
            <span class="input-group-addon">证件信息：</span>
            <input type="file" class="form-control" name="filee">
        </div>
        <input type="submit" value="修改">
    </form>
</div>
</body>
</html>
