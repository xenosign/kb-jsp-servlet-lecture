<%@ page import="org.example.kbjspservletlecture.PostDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    PostDto post = (PostDto) request.getAttribute("post");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세 정보</title>
    <style>
        .post-detail {
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 16px;
            margin-bottom: 20px;
        }

        .post-title {
            font-size: 24px;
            font-weight: bold;
        }

        .post-content {
            margin-top: 10px;
            font-size: 16px;
        }

        .post-meta {
            margin-top: 10px;
            font-size: 14px;
            color: #555;
        }

        .action-buttons {
            margin-top: 20px;
        }

        .action-buttons form {
            display: inline;
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>게시글 상세 정보</h1>
<hr>
<%
    int postId = post.getPostId();
    int userId = (int) session.getAttribute("userid");

    boolean isAuthor = postId == userId;
%>

<div class="post-detail">
    <div class="post-title"><%= post.getTitle() %>
    </div>
    <div class="post-content"><%= post.getContent() %>
    </div>
    <div class="post-meta">
        작성자: <%= post.getUsername() %> <br>
        작성일: <%= post.getCreatedAt() %>
    </div>
</div>
<div class="action-buttons">
    <form action="postDelete" method="get">
        <input type="hidden" name="postId" value="<%= postId %>">
        <% if (isAuthor) { %>
            <button type="submit">삭제</button>
        <% } %>
    </form>
</div>
</body>
</html>
