<%--
  Created by IntelliJ IDEA.
  User: Patriotic
  Date: 2026/6/28
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生查询</title>
  </head>
<body>
<p><a href="find-student">查询学生</a></p>
<form method="post" action="find-student">
    请输入学生学号：
    <input type="text" name="stuId" size="15">
    <input type="submit" value="确定">
</form>
</body>
</html>
