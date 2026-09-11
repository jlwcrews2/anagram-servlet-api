package no.jlwcrews;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class LogFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        var request = (HttpServletRequest) servletRequest;
        System.out.println(request.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
