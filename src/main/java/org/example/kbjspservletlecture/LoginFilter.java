package org.example.kbjspservletlecture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/post")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 초기화 작업이 필요하면 여기에 추가
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("userid") != null);


        if (loggedIn) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect("/auth.jsp");
        }
    }

    @Override
    public void destroy() {
        // 정리 작업이 필요하면 여기에 추가
    }
}
