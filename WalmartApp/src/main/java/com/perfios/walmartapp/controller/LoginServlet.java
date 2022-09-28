package com.perfios.walmartapp.controller;

import com.perfios.walmartapp.beans.CustomerDetails;
import com.perfios.walmartapp.dao.CustomerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        System.out.println("email"+email);
        String password = request.getParameter("password");
        System.out.println(email+" "+password);
        CustomerDao customerDao = new CustomerDao();
        CustomerDetails customerDetails=null;

        HttpSession session = request.getSession();

        customerDetails = customerDao.getUserDetails(email, password);

        if(customerDetails!=null) {
            response.sendRedirect("welcome.jsp");
        }
        else {
            session.setAttribute("status", "failed");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}