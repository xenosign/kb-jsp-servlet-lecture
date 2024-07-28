<%@ page import="org.example.kbjspservletlecture.PostDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%
    List<PostDto> posts = (List<PostDto>) request.getAttribute("posts");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            border: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        .action-buttons {
            margin-top: 20px;
            display: flex;
            justify-content: center;
        }
    </style>
</head>
<%@ include file="header.jsp" %>
<body>
<h1>게시글 목록</h1>
<hr>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>내용</th>
        <th>작성일</th>
    </tr>
    <%
        for (PostDto post : posts) {
    %>
    <tr>
        <td><%= post.getPostId() %></td>
        <td><%= post.getTitle() %></td>
        <td><%= post.getUsername() %></td>
        <td><a href="postDetail?postId=<%= post.getPostId() %>"><%= post.getContent() %></a></td>
        <td><%= post.getCreatedAt() %></td>
    </tr>
    <%
        }
    %>
</table>
<div class="action-buttons">
    <a href="postWrite"><button type="button">글 추가</button></a>
</div>
</body>
</html>
