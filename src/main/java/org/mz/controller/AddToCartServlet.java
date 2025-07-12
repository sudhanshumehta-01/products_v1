package org.mz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve productId from request
        String productId = request.getParameter("productId");

        // Get the current session or create one if it doesn't exist
        HttpSession session = request.getSession(true);

        // Retrieve or initialize cart
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Avoid duplicate entries
        if (productId != null && !productId.trim().isEmpty() && !cart.contains(productId)) {
            cart.add(productId);
        }

        // Save updated cart back to session
        session.setAttribute("cart", cart);

        // Redirect to cart page
        response.sendRedirect("cart.jsp"); // Ensure 'cart.jsp' displays cart contents
    }
}
