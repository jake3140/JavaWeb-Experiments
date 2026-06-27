<%--
  Created by IntelliJ IDEA.
  User: Patriotic
  Date: 2026/6/27
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e9ecef;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .welcome-card {
            background-color: white;
            padding: 50px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.1);
            text-align: center;
            max-width: 500px;
            width: 90%;
        }
        h1 {
            color: #28a745;
            margin-bottom: 20px;
        }
        p {
            color: #555;
            font-size: 18px;
            line-height: 1.6;
        }
        .logout-btn {
            margin-top: 30px;
            display: inline-block;
            padding: 10px 20px;
            background-color: #dc3545;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .logout-btn:hover {
            background-color: #c82333;
        }
        .info-box {
            background-color: #f8f9fa;
            border-left: 5px solid #007bff;
            padding: 15px;
            margin-top: 20px;
            text-align: left;
            font-size: 14px;
            color: #666;
        }
    </style>
  </head>
<body>
<div class="welcome-card">
    <h1>登录成功!</h1>
    <p>欢迎您, <strong>${userName}</strong></p>
    <p>您已通过Cookie免登录验证进入系统。</p>

    <div class="info-box">
        <strong>提示:</strong><br>
        如果您勾选了“五分钟免登录”，在关闭浏览器后的5分钟内再次访问登录页，将自动跳转至此页面。<br>
        超过5分钟或清除Cookie后，需重新登录。
    </div>
    <!-- 简单的退出逻辑：实际项目中应有一个LogoutServlet来清除Cookie（老师写的） -->
    <a href="login.jsp" class="logout-btn" onclick="clearCookie()">退出登录 / 返回</a>
</div>
<script>
    function clearCookie(){
        // 前端辅助清除Cookie，以便测试重新登录流程(老师写的）
        document.cookie = "userLoginInfo=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    }
</script>
</body>
</html>
