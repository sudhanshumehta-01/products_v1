<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h2>Add Product</h2>
    <%
        String message = request.getParameter("msg");
        if(message!=null && message.equalsIgnoreCase("fail"))
        {
        %>
        <p><%="Due to some error! Product not added"%></p>
                
        <%} 
        else if(message!=null && message.equalsIgnoreCase("success")){
        %>
         <p><%="product added successfully" %></p>
         
         <%} %>
    <form action="../addProduct.do" method="post" enctype="multipart/form-data">
    	<label>Product Id:</label>
        <input type="text" name="productId" required><br><br>
        
        <label>Product Name:</label>
        <input type="text" name="productName" required><br><br>

        <label>Product Price:</label>
        <input type="text" name="productPrice" required><br><br>
        
        <label>Product Date:</label>
        <input type="date" name="productDate" required><br><br>

        <label>Product Time:</label>
       	<input type="time" name="productTime" required><br><br>
       
       	<label>Upload Image:</label>
        <input type="file" name="productImage" accept="image/*" required><br><br>

        <input type="submit" value="Upload">
    </form>
</body>
</html>
