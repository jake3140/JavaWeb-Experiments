package com.cqust.ex2_1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "myservlet",value = {"/my-servlet"})
public class OutputPicture extends HttpServlet {
    //直接输入doGet，会有提示
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从servelet输出的二进制流的通道
        ServletOutputStream out = resp.getOutputStream();
        //servelet里的工具
        ServletContext context = req.getServletContext();
        //工具里的一个吸管，输出到浏览器
        InputStream input = context.getResourceAsStream("/WEB-INF/mao.png");
        //一个盒子，一部分一部分地获取字节
        byte[] buffer = new byte[1024];
        //记录每次获得的字节数，不为0输出
        int byteRead = 0;
        //获取buffer里字节
        while ((byteRead = input.read(buffer)) >0) {
            out.write(buffer,0,byteRead);
        }
        out.close();
        input.close();
    }
}
