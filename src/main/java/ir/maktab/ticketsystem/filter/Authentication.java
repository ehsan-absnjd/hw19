package ir.maktab.ticketsystem.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebFilter(filterName = "Authentication" ,value = "/*")
public class Authentication implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        Object user = session.getAttribute("user");
        if (user==null){
            if(!httpRequest.getMethod().toLowerCase().equals("post") ||
                    !httpRequest.getRequestURI().substring(httpRequest.getContextPath().length()).equals("/login")) {
                System.out.println("inside");
                httpRequest.getRequestDispatcher("Login.jsp").forward(request, response);
            }else {
                chain.doFilter(request ,response);
            }
        }
    }
}
