package org.example.kbjspservletlecture;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/board";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";
    private static Connection conn = null;

    @Override
    public void init() throws ServletException {
        System.out.println("###### BoardServlet init() 메서드 호출, 서블릿 초기화 ######");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            System.out.println("###### MySQL 연결 성공 ######");

            try {
                String sql = "SELECT * FROM posts";

                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            System.out.println(rs.getString("content"));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PostDto> posts = new ArrayList<>();

        String sql = "SELECT p.post_id, p.title, p.content, p.created_at, u.username FROM posts p JOIN users u ON p.user_id = u.id";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int postId = rs.getInt("post_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Timestamp createdAt = rs.getTimestamp("created_at");
                String username = rs.getString("username");

                posts.add(new PostDto(postId, title, content, createdAt, username));
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

    @Override
    public void destroy() {
        try {
            conn.close();
            System.out.println("###### MySQL 접속 종료 ######");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("###### BoardServlet destroy() 메서드 호출, 서블릿 소멸! ######");
    }
}