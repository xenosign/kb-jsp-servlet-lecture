package org.example.kbjspservletlecture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/post")
public class PostServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/board";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PostDto> posts = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT p.post_id, p.title, p.content, p.created_at, u.username FROM posts p JOIN users u ON p.user_id = u.id")) {

                while (rs.next()) {
                    int postId = rs.getInt("post_id");
                    String title = rs.getString("title");
                    String content = rs.getString("content");
                    Timestamp createdAt = rs.getTimestamp("created_at");
                    String username = rs.getString("username");

                    posts.add(new PostDto(postId, title, content, createdAt, username));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("posts", posts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("postList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}