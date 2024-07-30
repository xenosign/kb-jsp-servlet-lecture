<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Welcome</title>
</head>
<%@ include file="header.jsp" %>
<body>
    <h1>로그인 성공!</h1>
    <h2>환영합니다! <%= session.getAttribute("username") %> 님</h2>
    <h2>환영합니다! ${username} 님</h2>
</body>
</html>
