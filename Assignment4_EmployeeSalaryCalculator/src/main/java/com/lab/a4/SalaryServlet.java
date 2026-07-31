package com.lab.a4;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Calculates HRA, DA, PF, Tax and Net Salary from Basic pay.
 * Rates used (standard lab assumptions):
 * HRA = 20% of Basic, DA = 30% of Basic, PF = 12% of Basic
 * Tax: 0% if gross <= 20000, 5% if <= 40000, 10% otherwise
 */
@WebServlet("/salary")
public class SalaryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        double basic = Double.parseDouble(request.getParameter("basic"));

        double hra = basic * 0.20;
        double da = basic * 0.30;
        double pf = basic * 0.12;
        double gross = basic + hra + da;

        double tax;
        if (gross <= 20000) {
            tax = 0;
        } else if (gross <= 40000) {
            tax = gross * 0.05;
        } else {
            tax = gross * 0.10;
        }

        double netSalary = gross - pf - tax;

        request.setAttribute("name", name);
        request.setAttribute("basic", basic);
        request.setAttribute("hra", hra);
        request.setAttribute("da", da);
        request.setAttribute("pf", pf);
        request.setAttribute("tax", tax);
        request.setAttribute("gross", gross);
        request.setAttribute("net", netSalary);

        request.getRequestDispatcher("salaryResult.jsp").forward(request, response);
    }
}
