package com.cqust.ex2_3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        //servlet本身的名字
        name = "demoServlet1",
        //访问这个servlet的两个地址
        urlPatterns = {"/demo1-servlet1","/demo2-servlet1"},
        //设置正确输入值
        initParams = {
                @WebInitParam(name="name",value = "Jacky"),
                @WebInitParam(name="password",value = "3140")
        }
)
public class demoServlet extends HttpServlet {
    private String name;
    private  String password;
    @Override
    public void init() throws ServletException{
        //读取上面initParams设置的两个值Jacky，3140
        name = getInitParameter("name");
        password = getInitParameter("password");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取客户输入
        String inputName = req.getParameter("name");
        String inputPassword = req.getParameter("password");

        resp.setContentType("text/html;charset=UTF-8");
        if(name.equals(inputName) && password.equals(inputPassword)){
            resp.sendRedirect("welcome.html");
        }else{
            resp.sendRedirect("fail.html");
        }
    }
}
