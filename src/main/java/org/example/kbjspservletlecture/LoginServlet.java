package org.example.kbjspservletlecture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/board";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";
    private static Connection conn = null;
    private int userid = 0;

    @Override
    public void init() throws ServletException {
        System.out.println("###### LoginServlet init() 메서드 호출, 서블릿 초기화 ######");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            System.out.println("###### MySQL 연결 성공 ######");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isLoginSuccess = false;

        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        userid = rs.getInt("id");
                        System.out.println(userid);
                        isLoginSuccess = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isLoginSuccess) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("userid", userid);

            response.sendRedirect("/board");
        } else {
            response.sendRedirect("loginFailed.jsp");
        }
    }

    @Override
    public void destroy() {
        try {
            conn.close();
            System.out.println("###### MySQL 접속 종료 ######");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("###### LoginServlet destroy() 메서드 호출, 서블릿 소멸! ######");
    }
}

