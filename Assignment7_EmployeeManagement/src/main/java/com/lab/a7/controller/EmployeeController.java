package com.lab.a7.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.lab.a7.dao.EmployeeDAO;
import com.lab.a7.model.Employee;

/** Controller (MVC) - single front controller that dispatches to model / view. */
@WebServlet("/employees")
public class EmployeeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";
        try {
            switch (action) {
                case "delete":
                    dao.deleteEmployee(Integer.parseInt(request.getParameter("id")));
                    response.sendRedirect("employees?action=list");
                    return;
                case "edit":
                    Employee emp = dao.getEmployeeById(Integer.parseInt(request.getParameter("id")));
                    request.setAttribute("employee", emp);
                    request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
                    return;
                case "search":
                    String keyword = request.getParameter("keyword");
                    List<Employee> results = dao.searchEmployees(keyword == null ? "" : keyword);
                    request.setAttribute("employees", results);
                    request.getRequestDispatcher("employeeList.jsp").forward(request, response);
                    return;
                default:
                    List<Employee> all = dao.getAllEmployees();
                    request.setAttribute("employees", all);
                    request.getRequestDispatcher("employeeList.jsp").forward(request, response);
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
            Employee emp = new Employee();
            emp.setEmpName(request.getParameter("empName"));
            emp.setDepartment(request.getParameter("department"));
            emp.setDesignation(request.getParameter("designation"));
            emp.setSalary(Double.parseDouble(request.getParameter("salary")));

            if ("update".equals(action)) {
                emp.setEmpId(Integer.parseInt(request.getParameter("empId")));
                dao.updateEmployee(emp);
            } else {
                dao.insertEmployee(emp);
            }
            response.sendRedirect("employees?action=list");
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }
}
