package org.mz.controller;

import java.io.IOException;
import java.util.Set;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

public class DisplayAllCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Retrieve the cart from session
        @SuppressWarnings("unchecked")
        Set<String> cart = (Set<String>) session.getAttribute("cart");
        
        request.setAttribute("cart", cart);
        
        // Forward request to viewCart.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewCart.jsp");
        dispatcher.forward(request, response);
    }
}
