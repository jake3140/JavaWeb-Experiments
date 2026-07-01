package com.cqust.ex5_1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/find-student")
public class findStudentServlet extends HttpServlet {
    DataSource dataSource;
    public void init(){
        String drive = "com.mysql.cj.jdbc.Driver";//在mysql那个架包里
        try {
            Class.forName(drive);
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/elearningDS");
        } catch (Exception e) {
            System.out.println(e);
            getServletContext().log("找不到驱动器类！");
        }
    }
    public Connection getConnection()throws SQLException{
        String userName = "root";
        String password = "1234";
        String dbURL = "jdbc:mysql://127.0.0.1:3306/elearning?useSSL=false&serverTimezone=UTC";
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
                ResultSet result = pstmt.executeQuery();
                ){
            while (result.next()){
                student stu = new student();
                stu.setStuId(result.getInt("stud_id"));
                stu.setName(result.getString("name"));
                stu.setGender(result.getString("gender"));
                stu.setBirthday(result.getDate("birthday").toLocalDate());
                stu.setPhone(result.getString("phone"));
                studentList.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!studentList.isEmpty()){
            req.getSession().setAttribute("studentList",studentList);
            resp.sendRedirect("show-all-student.jsp");
        }else{
            resp.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("stuId");
        String sql = "select * from students where stud_id=?";
        try (
                //建立Java与数据库的连接通道
                Connection connection = getConnection();
                //对sql语句进行预编译，防止sql注入
                //sql注入指从前端获取的内容可能包含sql语句，导致原本sql语句被篡改，信息泄露
                PreparedStatement pstmt = connection.prepareStatement(sql);
                ){
            //把前端获取的stud_id数据转换为int，填入占位符？
            pstmt.setInt(1,Integer.parseInt(studentId));
            //执行查询，返回ResultSet
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                //创建一个student对象，把数据库里的属性值set进这个student对象
                student stu = new student();
                stu.setStuId(resultSet.getInt("stud_id"));
                stu.setName(resultSet.getString("name"));
                stu.setGender(resultSet.getString("gender"));
                stu.setBirthday(resultSet.getDate("birthday").toLocalDate());
                stu.setPhone(resultSet.getString("phone"));
                req.setAttribute("student",stu);
                req.getRequestDispatcher("show-student.jsp").forward(req,resp);
            }else {
                resp.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

