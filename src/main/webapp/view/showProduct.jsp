<%@ page import="java.util.List" %>
<%@ page import="org.mz.bean.Product" %>
<%@ page import="org.mz.services.ProductServices" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Products</title>
    <link rel="stylesheet" href="css/showAllPolls.css"> <!-- Assuming you have a relevant CSS file -->
    <style>
        .product-list {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }
        .product-item {
            border: 1px solid #ccc;
            padding: 15px;
            width: 200px;
            text-align: center;
            background-color: #f9f9f9;
        }
        .product-item h3 {
            margin: 10px 0;
        }
        .product-item p {
            margin: 5px 0;
        }
        .product-item a {
            text-decoration: none;
            color: black;
        }
        .product-item a:hover {
            color: blue;
        }
    </style>
</head>
<body>
    <h2>All Products</h2>
    <div class="product-list">
    	<div id="left_element">
				<a href="./view/addproducts.jsp">Add Product</a><br>
				<a href="showProduct.do">Show Products</a><br>
				<a href="displayAllCart.do">Display All Carts</a><br>
		</div>
        <%
            List<Product> products = (List<Product>) session.getAttribute("products");
            if (products != null) {
                for (Product product : products) {
        %>
            <div class="product-item">
                <a href="goOnProduct.do?productId=<%= product.getId() %>">
                    <p><strong>Product ID:</strong> <%= product.getId() %></p>
                    <p><strong>Product Name:</strong> <%= product.getName() %></p>
                    <p><strong>Price:</strong> <%= product.getPrice() %></p>
                    <p><strong>Date:</strong> <%= product.getDate() %></p>
                    <p><strong>Time:</strong> <%= product.getTime() %></p>
                </a>
            </div>
        <%
                }
            } else {
        %>
            <p>No products available.</p>
        <%
            }
        %>
    </div>
</body>
</html>
