package org.example.kbjspservletlecture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;

@WebServlet("/postDetail")
public class PostDetailServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/board";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("postId");
        PostDto post = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement("SELECT p.post_id, p.title, p.content, p.created_at, u.username FROM posts p JOIN users u ON p.user_id = u.id WHERE p.post_id = ?")) {

                pstmt.setInt(1, Integer.parseInt(postId));
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String title = rs.getString("title");
                    String content = rs.getString("content");
                    Timestamp createdAt = rs.getTimestamp("created_at");
                    String username = rs.getString("username");

                    post = new PostDto(Integer.parseInt(postId), title, content, createdAt, username);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("post", post);
        RequestDispatcher dispatcher = request.getRequestDispatcher("postDetail.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
