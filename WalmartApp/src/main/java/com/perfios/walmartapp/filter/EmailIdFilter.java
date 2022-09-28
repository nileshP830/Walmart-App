package com.perfios.walmartapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter("/register")
public class EmailIdFilter extends HttpFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        String email = req.getParameter("email");
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+[.]com");
        Matcher matcher =pattern.matcher(email);
        if(matcher.find() && matcher.group().equals(email)) {
            chain.doFilter(request, response);
        }
        else {
            response.getWriter().print("Please Enter valid EmailId");
        }
    }
}
