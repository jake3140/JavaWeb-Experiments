package com.cqust.ex5_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productDaoImpl implements ProductDao{


    @Override
    public Product findProductById(int id) throws SQLException {
        String sql="select id,pname,brand,price from products where id=?";
        Product product = null;
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rst = pstmt.executeQuery();
        if(rst.next()){
            product = new Product(rst.getInt("id"), rst.getString("pname"),rst.getString("brand"), rst.getDouble("price"));
        }
        return product;
    }

    @Override
    public List<Product> findAllProduct() throws SQLException {
        Product product = null;
        ArrayList<Product>productList=new ArrayList<>();
        String sql = "select from products";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            product = new Product(rs.getInt("id"), rs.getString("pname"), rs.getString("brand"),rs.getDouble("price") );
            productList.add(product);
        }
        return  productList;
    }

    @Override
    public int addProduct(Product product) throws SQLException {
        String sql = "insert into products values(?,?,?,?)";
        int n=0;
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,product.getId());
        pstmt.setString(2, product.getName());
        pstmt.setString(3,product.getBrand());
        pstmt.setDouble(4,product.getPrice());
        n = pstmt.executeUpdate();
        return n;

    }
}
