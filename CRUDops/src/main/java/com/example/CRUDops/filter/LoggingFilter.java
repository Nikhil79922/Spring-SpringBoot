package com.example.CRUDops.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class LoggingFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Request Entered in Do Filter");
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("Request details : "+req.getRequestURL().toString() + " Request Method "+ req.getMethod());


        chain.doFilter(request, response);

        System.out.println("Response Entered in Do Filter");
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("Response details : "+res.getStatus());


    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
}
