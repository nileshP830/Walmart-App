package com.perfios.walmartapp.controller;

import com.perfios.walmartapp.dao.CustomerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    CustomerDao customerDao = new CustomerDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Register Servlet Called");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String emailId = request.getParameter("email");
        String password = request.getParameter("password");
        String reTypePassword = request.getParameter("confirm-password");
        String mobileNumber = request.getParameter("mobile-number");

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        if(password.equals(reTypePassword)) {
            Cookie cookie1 = new Cookie("email",emailId);
            Cookie cookie2 = new Cookie("password",password);
            response.addCookie(cookie1);
            response.addCookie(cookie2);

            customerDao.addUserDetails(firstName, lastName, emailId, password,mobileNumber);
            out.print("Details added to the database successfully ");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            session.setAttribute("msg", "registered successfully");
        }
        else {
            out.println("Passwords are miss matching");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            session.setAttribute("msg", "registration failed");
        }
    }
}
