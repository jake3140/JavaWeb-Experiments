<%--
  Created by IntelliJ IDEA.
  User: Patriotic
  Date: 2026/6/28
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>所有学生信息</title>
  </head>
<body>
<table border="1">
  <tr><td>学号</td><td>姓名</td><td>性别</td><td>出生日期</td><td>电话</td><td>是否删除</td></tr>
    <c:forEach var="student" items = "${studentList}">
        <tr>
            <td>${student.stuId}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.birthday}</td>
            <td>${student.phone}</td>
            <td><a>删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
