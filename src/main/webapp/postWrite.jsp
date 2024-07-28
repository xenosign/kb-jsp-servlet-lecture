<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 추가</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>게시글 추가</h1>
<hr>
<form action="postWrite" method="post">
    제목: <input type="text" name="title"><br>
    내용: <textarea name="content"></textarea><br>
    <input type="hidden" name="userId" value="<%= session.getAttribute("userid") %>">
    <button type="submit">추가</button>
</form>
</body>
</html>
