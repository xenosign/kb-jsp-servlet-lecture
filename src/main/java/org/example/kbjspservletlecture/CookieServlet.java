package org.example.kbjspservletlecture;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setCookie")
public class CookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 쿠키 생성
        Cookie userCookie = new Cookie("username", "tetz");
        // 쿠키의 유효 기간을 설정
        userCookie.setMaxAge(7 * 24 * 60 * 60); // 7일

        // 응답에 쿠키 추가
        response.addCookie(userCookie);

        // 응답 내용 작성
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>쿠키가 설정되었습니다.</h1>");
        response.getWriter().println("</body></html>");
    }
}
