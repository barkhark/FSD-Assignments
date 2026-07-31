<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lab.a5.Product" %>
<%@ page import="com.lab.a5.ProductCatalog" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

<div class="container">

    <nav>
        <a href="products.jsp">Products</a> |
        <a href="cart.jsp">View Cart</a>
    </nav>

    <h2>Available Products</h2>

    <table>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Qty</th>
            <th>Action</th>
        </tr>

        <%
            List<Product> products = ProductCatalog.getAllProducts();

            for(Product p : products){
        %>

        <tr>
            <td><%= p.getName() %></td>

            <td>&#8377; <%= p.getPrice() %></td>

            <td>
                <input class="qty-input"
                       type="number"
                       value="1"
                       min="1"
                       disabled>
            </td>

            <td>
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="<%= p.getId() %>">
                    <input type="hidden" name="quantity" value="1">

                    <button type="submit" class="btn add">
                        Add to Cart
                    </button>
                </form>
            </td>
        </tr>

        <%
            }
        %>

    </table>

</div>

</body>
</html>