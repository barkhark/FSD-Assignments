<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.lab.a5.CartItem"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

	<div class="container">

		<nav>
			<a href="products.jsp">Products</a> | <a href="cart.jsp">View
				Cart</a>
		</nav>

		<h2>Your Shopping Cart</h2>

		<%
		@SuppressWarnings("unchecked")
		Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

		double grandTotal = 0;
		%>

		<table>

			<tr>
				<th>Product</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Subtotal</th>
				<th>Action</th>
			</tr>

			<%
			if (cart != null && !cart.isEmpty()) {
				for (CartItem item : cart.values()) {
					grandTotal += item.getSubtotal();
			%>

			<tr>
				<td><%=item.getProduct().getName()%></td>
				<td>&#8377; <%=item.getProduct().getPrice()%></td>
				<td><%=item.getQuantity()%></td>
				<td>&#8377; <%=String.format("%.2f", item.getSubtotal())%></td>
				<td><a class="btn remove"
					href="removeFromCart?productId=<%=item.getProduct().getId()%>">
						Remove </a></td>
			</tr>

			<%
			}
			} else {
			%>

			<tr>
				<td colspan="5">Your cart is empty.</td>
			</tr>

			<%
			}
			%>

			<tr class="total-row">
				<td colspan="3"><b>Grand Total</b></td>
				<td colspan="2"><b>&#8377; <%=String.format("%.2f", grandTotal)%></b>
				</td>
			</tr>

		</table>

	</div>

</body>
</html>