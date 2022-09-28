package com.perfios.walmartapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@WebFilter("/register")
public class MobileNumberFilter extends HttpFilter implements Filter {

    private static final HttpServletResponse ServletResponse = null;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        String mobileNumber = req.getParameter("mobile-number");
        Pattern pattern = Pattern.compile("(0|91)?[6-9][0-9]{9}");
        Matcher matcher =pattern.matcher(mobileNumber);
        if(matcher.find() && matcher.group().equals(mobileNumber)) {
            chain.doFilter(request, response);
        }
        else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().print("Please Enter valid MobileNumber");
        }
    }
}
