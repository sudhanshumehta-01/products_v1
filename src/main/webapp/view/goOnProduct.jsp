<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.mz.bean.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Product Details</h2>
    <% 
        Product product = (Product) request.getAttribute("product");
    	String productId = request.getParameter("productId");
        if (productId != null) {
    %>
        <div class="product-container">
            <div class="product-image">
                <img src="<%= request.getContextPath() %>/uploads/<%= product.getImagePath() %>" alt="Product Image" width="100">
            </div>
            <div class="product-details">
                <form action="addToCart.do" method="post">
                    <input type="hidden" name="productId" value="<%= product.getId() %>">
                    <p><strong>Product ID:</strong> <%= product.getId() %></p>
                    <p><strong>Product Name:</strong> <%= product.getName() %></p>
                    <p><strong>Price:</strong> <%= product.getPrice() %></p>
                    <p><strong>Product Date:</strong> <%= product.getDate() %></p>
                    <p><strong>Product Time:</strong> <%= product.getTime() %></p> 
                    <br>
                    <input type="submit" value="Add To Cart"> 
                </form>
            </div>
        </div>
    <% } else { %>
        <p>Product not found.</p>
    <% } %>
    <br>
    <a href="./showProducts.do">Back to Shopping</a>
</body>
</html>
