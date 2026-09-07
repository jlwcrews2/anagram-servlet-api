package no.jlwcrews;

import jakarta.servlet.*;

import java.io.IOException;

public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest.getProtocol());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
