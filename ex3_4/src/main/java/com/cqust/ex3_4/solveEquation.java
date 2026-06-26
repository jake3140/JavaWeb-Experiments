package com.cqust.ex3_4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/solveEquation")
public class solveEquation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从前端获取输入值,返回为字符串
        String aStr = req.getParameter("a");
        String bStr = req.getParameter("b");
        String cStr = req.getParameter("c");

        double a,b,c;
        try {
            a = Double.parseDouble(aStr);
            b = Double.parseDouble(bStr);
            c = Double.parseDouble(cStr);
        } catch (NumberFormatException e) {
            req.setAttribute("result","输入格式错误，请输入有效数字！");
            req.getRequestDispatcher("result.jsp").forward(req,resp);
            return;
        }
        if(a==0){
            req.setAttribute("result","a不能为0，这不是一元二次方程！");
            req.getRequestDispatcher("result.jsp").forward(req,resp);
            return;
        }

        double delta = b*b-4*a*c;
        String result;
        if(delta > 0){
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            //很有意思，format把一些变量和一些字符一起放到了一个字符
            result = String.format("方程有两个不相等的实数根： x1 = %.2f, x2 = %.2f",x1,x2);
        }else if (delta == 0) {
            double x = -b / (2 * a);
            result = String.format("方程有两个相等的实数根：x = %.2f", x);
        } else {
            result = "方程无实数根（判别式小于0）";
        }
        req.setAttribute("result",result);
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
}
