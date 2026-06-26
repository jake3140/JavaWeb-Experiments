<%--
  Created by IntelliJ IDEA.
  User: Patriotic
  Date: 2026/6/26
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算结果</title>
  </head>
<body>
<h2>一元二次方程求解结果</h2>
<p><%=request.getAttribute("result")%></p>
<br>
<a href=index.html>返回重新输入</a>
</body>
</html>
