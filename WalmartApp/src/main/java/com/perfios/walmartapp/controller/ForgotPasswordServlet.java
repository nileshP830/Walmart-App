package com.perfios.walmartapp.controller;

import com.perfios.walmartapp.dao.CustomerDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ForgotPasswordServlet", value = "/forgot-password")
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String newPassword = request.getParameter("new-password");
        String confirmPassword = request.getParameter("confirm-password");
        if(newPassword.equals(confirmPassword)) {
            CustomerDao customerDao = new CustomerDao();
            String updateString = customerDao.updateUserPassword(email, newPassword);
            if (updateString != null) {
                response.sendRedirect("login.jsp");
            }
        }
        else{
            request.getRequestDispatcher("forgot.jsp").forward(request, response);
        }
    }
}
