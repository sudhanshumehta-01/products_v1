package org.mz.services;

import java.sql.SQLException;
import java.util.List;

import org.mz.bean.Product;
import org.mz.dao.ProductDao;

public class ProductServices {
    public static int addProduct(Product product) throws SQLException {
    	ProductDao productDao = new ProductDao();
		int result = productDao.addProduct(product);
		return result;
    }
    
    public static List<Product> getAllProducts() throws SQLException {
    	ProductDao productDao = new ProductDao();
		List<Product> result = productDao.getAllProducts();
		return result;
    }

	public static Product getProductById(int productId) throws SQLException {
		ProductDao productDao = new ProductDao();
		Product result = productDao.getProductById(productId);
		return result;
	}

}
