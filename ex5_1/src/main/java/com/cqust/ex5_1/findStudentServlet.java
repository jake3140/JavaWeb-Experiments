package com.cqust.ex5_1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("find-student")
public class findStudentServlet extends HttpServlet {
    public void init(){
        String drive = "com.mysql.cj.jdbc";//在mysql那个架包里
        try {
            Class.forName(drive);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            getServletContext().log("找不到驱动器类！");
        }
    }
    public Connection getConnection()throws SQLException{
        String userName = "root";
        String password = "1234";
        String dbURL = "jdbc:mysql://127.0.0.1:3306/elearning?useSSL=false&amp;severTimezone = UTC";
        Connection connection = DriverManager.getConnection(dbURL,userName,password);
        return connection;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<student>studentList = new ArrayList<student>();
        String sql = "select * from students";
        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet result = pstmt.getResultSet();
                ){
            while ()

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

