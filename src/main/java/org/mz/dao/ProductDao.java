package org.mz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mz.bean.Product;
import org.mz.util.DBConnection;

public class ProductDao {
    
	private Connection conn;

    public ProductDao() {
        conn = DBConnection.getConnection();
    }

    public int addProduct(Product product) throws SQLException {
    	
    	int result = -1;
    	
        String sql = "INSERT INTO product_details (product_id, product_name, price,image_path, product_date, product_time) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, product.getId());
        ps.setString(2, product.getName());
        ps.setDouble(3, product.getPrice());
        ps.setString(4, product.getDate());
        ps.setString(5, product.getTime());
        ps.setString(6, product.getImagePath());

        result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    public List<Product> getAllProducts() throws SQLException {
        String sql = "SELECT * FROM product_details";
        Statement stm =  conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        List<Product> list = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("product_id"));
            p.setName(rs.getString("product_name"));
            p.setPrice(rs.getInt("price"));
            p.setDate(rs.getString("product_date"));
            p.setTime(rs.getString("product_time"));
            p.setImagePath(rs.getString("image_path"));
            list.add(p);
        }
        return list;
    }
    public Product getProductById(int productId) throws SQLException {
    	Statement stm =  conn.createStatement();
		String sql = "Select product_id, product_name, price, product_date, product_time FROM product_details WHERE product_id="+productId;
		ResultSet rs =  stm.executeQuery(sql);

        int lastroductId = -1;
		Product product = null;
		while(rs.next())
        {
        	int rsProductId = rs.getInt("product_id");
        	
        	if (rsProductId != lastroductId)
        	{
        		product = new Product();
        		product.setId(rs.getInt("product_id"));
        		product.setName(rs.getString("product_name"));
        		product.setPrice(rs.getDouble("price"));
        		product.setDate(rs.getString("product_date"));
        		product.setTime(rs.getString("product_time"));
        		product.setImagePath(rs.getString("image_path"));
        		product.setDesc(rs.getString("description"));
            
        		lastroductId = rsProductId;
        	}
        }

        return product;
    }


}
