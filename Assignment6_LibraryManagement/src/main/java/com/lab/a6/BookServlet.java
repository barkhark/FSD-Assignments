package com.lab.a6;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/** Front controller servlet handling add/update/delete/search/view for Books. */
@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final BookDAO dao = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if (action == null) action = "list";
            switch (action) {
                case "delete":
                    dao.deleteBook(Integer.parseInt(request.getParameter("id")));
                    response.sendRedirect("books?action=list");
                    return;
                case "edit":
                    Book book = dao.getBookById(Integer.parseInt(request.getParameter("id")));
                    request.setAttribute("book", book);
                    request.getRequestDispatcher("editBook.jsp").forward(request, response);
                    return;
                case "search":
                    String keyword = request.getParameter("keyword");
                    List<Book> results = dao.searchBooks(keyword == null ? "" : keyword);
                    request.setAttribute("books", results);
                    request.getRequestDispatcher("bookList.jsp").forward(request, response);
                    return;
                default:
                    List<Book> all = dao.getAllBooks();
                    request.setAttribute("books", all);
                    request.getRequestDispatcher("bookList.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            Book book = new Book();
            book.setTitle(request.getParameter("title"));
            book.setAuthor(request.getParameter("author"));
            book.setIsbn(request.getParameter("isbn"));
            book.setQuantity(Integer.parseInt(request.getParameter("quantity")));

            if ("update".equals(action)) {
                book.setBookId(Integer.parseInt(request.getParameter("bookId")));
                dao.updateBook(book);
            } else {
                dao.addBook(book);
            }
            response.sendRedirect("books?action=list");
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }
}
