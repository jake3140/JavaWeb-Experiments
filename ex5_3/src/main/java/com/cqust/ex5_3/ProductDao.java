package com.cqust.ex5_3;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao extends Dao{
    public Product findProductById(int id)throws SQLException;
    public List<Product>findAllProduct()throws SQLException;
    public int addProduct(Product product)throws SQLException;
}
