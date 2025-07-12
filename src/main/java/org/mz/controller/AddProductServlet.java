package org.mz.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

import org.mz.bean.Product;
import org.mz.services.ProductServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
public class AddProductServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        int productPrice = Integer.parseInt(request.getParameter("productPrice"));
        String productDate = request.getParameter("productDate");
        String productTime = request.getParameter("productTime");

        Part imagePart = request.getPart("productImage");
        String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();

        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        String filePath = uploadPath + File.separator + fileName;
        imagePart.write(filePath);

        Product product = new Product();
        product.setId(productId);
        product.setName(productName);
        product.setPrice(productPrice);
        product.setDate(productDate);
        product.setTime(productTime);
        product.setImagePath("uploads/" + fileName);

        int result = 0;
		try {
			result = ProductServices.addProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        String message = (result > 0) ? "success" : "fail";
        response.sendRedirect("jsp/addProduct.jsp?msg=" + message);
    }
}
