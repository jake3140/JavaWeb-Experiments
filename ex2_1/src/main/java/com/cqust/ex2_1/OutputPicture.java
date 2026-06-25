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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        ServletContext context = req.getServletContext();
        InputStream input = context.getResourceAsStream("/WEB-INF/mao.png");
        byte[] buffer = new byte[1024];
        int byteRead = 0;
        while ((byteRead = input.read(buffer)) >0) {
            out.write(buffer,0,byteRead);
        }
        out.close();
        input.close();
    }
}
