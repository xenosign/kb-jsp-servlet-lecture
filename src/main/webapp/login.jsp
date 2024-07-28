<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
</head>
<%@ include file="header.jsp" %>
<body>
    <h1>로그인</h1>
    <form method="post" action="login">
        <label for="username">아이디 :</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">비민번호 :</label>
        <input type="password" id="password" name="password" required>
        <br>
        <button type="submit">로그인</button>
    </form>
</body>
</html>