package com.cqust.ex2_2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "second9",value = {"/second-9"})
public class factorial9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        //getAttribute返回object
        long f9 = (long) context.getAttribute("factorial7");
        f9 = f9*8*9;
        //text/html;charset=UTF-8得记一下
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("<h2>阶乘的计算结果</h2>");
        resp.getWriter().write("9!="+f9);
    }
}
