package com.cqust.ex2_2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "first7",value = {"/first-7"})
public class factorial7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long f7 = 1;
        for(int i=1;i<=7;i++){
            f7 *= i;
        }
        ServletContext context = getServletContext();
        //把f7的值存起来，命名为factorial7，set存入，get取出
        context.setAttribute("factorial7",f7);
        resp.getWriter().print("7!="+f7);
    }
}
