package org.mz.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.mz.bean.Product;
import org.mz.services.ProductServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoOnProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int productId = Integer.parseInt(request.getParameter("productId"));

    	Product product = null;
		try {
			product = ProductServices.getProductById(productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        request.setAttribute("product", product);

        request.getRequestDispatcher("./view/goOnProduct.jsp").forward(request, response);
    }
}
