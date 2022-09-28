package com.perfios.walmartapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter("/register")
public class PasswordFilter extends HttpFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        String password = req.getParameter("password");

        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher matcher = pattern.matcher(password);
        if(password.length()>8 && matcher.matches()) {
            chain.doFilter(request, response);
        }
        else {
            response.getWriter().println("Password should contains\n"
                    + "at least 8 characters and at most 20 characters\n"
                    + "at least one digit\n"
                    + "at least one upper case alphabet\n"
                    + "at least one lower case alphabet\n"
                    + "at least one special character which includes !@#$%&*()-+=^\n"
                    + "It doesn’t contain any white space");
        }
    }
}
