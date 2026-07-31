package com.lab.a7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lab.a7.model.Employee;
import com.lab.a7.util.DBConnection;

/** DAO (Model layer of MVC) - handles all JDBC operations for Employee. */
public class EmployeeDAO {

    public void insertEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO employees (emp_name, department, designation, salary) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, emp.getEmpName());
            ps.setString(2, emp.getDepartment());
            ps.setString(3, emp.getDesignation());
            ps.setDouble(4, emp.getSalary());
            ps.executeUpdate();
        }
    }

    public void updateEmployee(Employee emp) throws SQLException {
        String sql = "UPDATE employees SET emp_name=?, department=?, designation=?, salary=? WHERE emp_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, emp.getEmpName());
            ps.setString(2, emp.getDepartment());
            ps.setString(3, emp.getDesignation());
            ps.setDouble(4, emp.getSalary());
            ps.setInt(5, emp.getEmpId());
            ps.executeUpdate();
        }
    }

    public void deleteEmployee(int empId) throws SQLException {
        String sql = "DELETE FROM employees WHERE emp_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, empId);
            ps.executeUpdate();
        }
    }

    public Employee getEmployeeById(int empId) throws SQLException {
        String sql = "SELECT * FROM employees WHERE emp_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, empId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        }
        return null;
    }

    public List<Employee> searchEmployees(String keyword) throws SQLException {
        String sql = "SELECT * FROM employees WHERE emp_name LIKE ? OR department LIKE ? OR designation LIKE ?";
        List<Employee> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        }
        return list;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        String sql = "SELECT * FROM employees ORDER BY emp_id";
        List<Employee> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        }
        return list;
    }

    private Employee mapRow(ResultSet rs) throws SQLException {
        return new Employee(
            rs.getInt("emp_id"),
            rs.getString("emp_name"),
            rs.getString("department"),
            rs.getString("designation"),
            rs.getDouble("salary")
        );
    }
}
