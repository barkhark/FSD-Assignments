<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.lab.a6.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%
    Book book = (Book) request.getAttribute("book");
%>
<div class="container">
  <h2>Edit Book</h2>
  <div class="add-form">
    <form action="books" method="post">
      <input type="hidden" name="action" value="update">
      <input type="hidden" name="bookId" value="<%= book.getBookId() %>">
      <label>Title</label>
      <input type="text" name="title" value="<%= book.getTitle() %>" required>
      <label>Author</label>
      <input type="text" name="author" value="<%= book.getAuthor() %>" required>
      <label>ISBN</label>
      <input type="text" name="isbn" value="<%= book.getIsbn() %>" required>
      <label>Quantity</label>
      <input type="number" name="quantity" value="<%= book.getQuantity() %>" min="0" required>
      <button class="submit-btn" type="submit">Update Book</button>
    </form>
  </div>
  <br><a href="books?action=list">Back to List</a>
</div>
</body>
</html>
