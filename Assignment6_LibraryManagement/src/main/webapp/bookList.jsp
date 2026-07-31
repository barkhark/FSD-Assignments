<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lab.a6.Book" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

<div class="container">

    <h2>Library Management System</h2>

    <form class="search-box" action="books" method="get">
        <input type="hidden" name="action" value="search">

        <input type="text"
               name="keyword"
               placeholder="Search by title, author or ISBN">

        <button class="btn edit" type="submit">Search</button>

        <a class="btn"
           style="background:#7f8c8d;"
           href="books?action=list">Reset</a>
    </form>

    <table>

        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>ISBN</th>
            <th>Qty</th>
            <th>Actions</th>
        </tr>

        <%
            @SuppressWarnings("unchecked")
            List<Book> books = (List<Book>) request.getAttribute("books");

            if (books != null) {
                for (Book b : books) {
        %>

        <tr>
            <td><%= b.getBookId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getAuthor() %></td>
            <td><%= b.getIsbn() %></td>
            <td><%= b.getQuantity() %></td>
            <td>
                <a class="btn edit"
                   href="books?action=edit&id=<%= b.getBookId() %>">
                    Edit
                </a>

                <a class="btn delete"
                   href="books?action=delete&id=<%= b.getBookId() %>"
                   onclick="return confirm('Delete this book?');">
                    Delete
                </a>
            </td>
        </tr>

        <%
                }
            }
        %>

    </table>

    <div class="add-form">

        <h3>Add New Book</h3>

        <form action="books" method="post">

            <input type="hidden" name="action" value="add">

            <label>Title</label>
            <input type="text" name="title" required>

            <label>Author</label>
            <input type="text" name="author" required>

            <label>ISBN</label>
            <input type="text" name="isbn" required>

            <label>Quantity</label>
            <input type="number" name="quantity" min="0" required>

            <button class="submit-btn" type="submit">
                Add Book
            </button>

        </form>

    </div>

</div>

</body>
</html>