package com.cqust.ex5_3;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public interface Dao {
    public default DataSource getDataSource(){
        DataSource dataSource=null;
        Context context=null;
        try {
            context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/elearningDS");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
       return dataSource;
    }
    public default Connection getConnection()throws SQLException {
        DataSource dataSource = getDataSource();
        Connection connection = dataSource.getConnection();
        return connection;

    }
}
