package com.cqust.ex4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/login")
public class LoginCookieServlet extends HttpServlet {
    private static final String fixed_userName = "admin";
    private  static final String fixed_password = "123456";

    @Override
    //doGet在地址输入触发，而doPost是通过表单
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //检测cookie是否为空,cookie用一个数组来接受
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie:cookies){
                if("userLoginInfo".equals(cookie.getName())){
                    resp.sendRedirect("welcome");
                    return;
                }
            }
        }
        req.getRequestDispatcher("/login,jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getParameter获取前端相同name的参数
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");
        //验证输入是否正确
        if(fixed_userName.equals(userName) && fixed_password.equals(password)){
            //如果是复选框checkbox，勾选为on，不勾选为null
            //如果是on即勾选了五分钟内免登录，就要new一个cookie凭证
            //cookie用来短暂“记住用户”
            if("on".equals(rememberMe)){
                Cookie cookie = new Cookie("userLoginInfo", URLEncoder.encode(userName,"UTF-8"));
                cookie.setMaxAge(300);
                //设置全局读取cookie，有两个servlet
                cookie.setPath("/");
                resp.addCookie(cookie);
            }
            resp.sendRedirect("welcome");
        }else{
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }
}
