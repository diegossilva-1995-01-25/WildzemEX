/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildzem.controller.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import wildzem.model.Staff;

/**
 *
 * @author Caio
 */
@WebFilter("/system/*")
public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {}
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpSession session = ((HttpServletRequest) request).getSession();
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        
        if ( servletRequest.getRequestURI().indexOf("index.xhtml") <= -1) {
            
            Staff staff =  (Staff) session.getAttribute("authUser");
            
            if (staff == null) {
                servletResponse.sendRedirect(servletRequest.getContextPath() + "/index.xhtml");
            }
            else {
                
                chain.doFilter(request, response);
            }
        }
        else {
            
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {} 
}
