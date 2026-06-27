package com.cqust.ex4;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/welcome")
public class welcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = null;
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie:cookies){
                if("userLoginInfo".equals(cookie.getName())){
                    userName = URLDecoder.decode(cookie.getValue(),"UTF-8");
                    break;
                }
            }
        }
        if(userName != null){
            req.setAttribute("userName",userName);
            RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
            rd.forward(req,resp);
        }else{
            resp.sendRedirect("login");
        }
    }
}
