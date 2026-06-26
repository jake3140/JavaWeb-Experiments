package com.cqust.ex2_4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/exam")
public class exam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get是在网址后可见的输入，post是页面表单提交，更安全
        //在doGet里调用doPost，只写post，如果用了地址栏的get请求会报错405，相当于一个过度
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //客户的请求格式为UTF-8，服务器的的回应格式text/html;charset=UTF-8
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int score= 0;
        String q1 = req.getParameter("q1");
        if("C".equals(q1)){
            score += 10;
        }
        //多选题，少选5分，多选错选没分
        String[] q2=req.getParameterValues("q2");
        if(q2 != null && q2.length>0){
            boolean allCorrect = true;
            boolean hasWrong = false;
            for(String i:q2){
                if("A".equals(i)){
                    hasWrong = true;
                    break;
                }
            }
            if(!hasWrong){
                if(Arrays.asList(q2).contains("B")&&Arrays.asList(q2).contains("C")&&Arrays.asList(q2).contains("D")){
                    score += 10;
                }else {
                    score += 5;
                }
            }
        }
        String q3 = req.getParameter("q3");
        if(q3 != null && "北京".equals(q3)){
            score += 10;
        }

        out.print("<html>");
        out.print("<head><title>考试结果</title></head>");
        out.print("<body>");
        out.print("<h3 align='center'>你的分数：" + score + "分。</h3>");
        out.print("</body></html>");

    }
}
