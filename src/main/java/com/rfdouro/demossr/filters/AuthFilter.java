package com.rfdouro.demossr.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

 @Override
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
   throws IOException, ServletException {

  String url = request instanceof HttpServletRequest ? ((HttpServletRequest) request).getRequestURL().toString()
    : "N/A";
  System.out.println("from filter, processing url: " + url);
  chain.doFilter(request, response);

 }

}
