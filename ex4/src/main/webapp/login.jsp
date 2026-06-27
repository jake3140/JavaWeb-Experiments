<%--
  Created by IntelliJ IDEA.
  User: Patriotic
  Date: 2026/6/27
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            width: 350px;
            text-align: center;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #666;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .checkbox-group {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }
        .checkbox-group input {
            margin-right: 10px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            margin-bottom: 15px;
            font-size: 14px;
        }
    </style>
</head>
<body>
<%--这里通过<% %>把Java代码写进了来，同时也将HTML语句嵌入了if语句里，妙！--%>
<div class="login-container">
    <%
        String error = (String) request.getAttribute("error");
        if(error != null){
    %>
    <div class="error"><%= error %></div>
    <%
        }
    %>
<%--    login对应的地址不是本jsp，而是servlet的--%>
    <form action="login" method="post" >
<%--        form-group是CSS别名--%>
        <div class="form-group">
<%--        for是用来绑定input的id，input的id只能用一次，name可以用多次--%>
<%--            placehoder灰色提示，输入后消失--%>
            <label for="userName">用户名：</label>
            <input type="text" id="userName" name="userName" required placeholder="请输入 admin">
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" required placeholder="请输入 123456">
        </div>
        <div class="checkbox-group">
            <input type="checkbox" id="rememberMe" name="rememberMe">
            <label for="rememberMe" style="margin-bottom: 0; display: inline;">五分钟免登录</label>
        </div>
        <button type="submit">登录</button>
    </form>
</div>
</body>
</html>
