<%--
  Created by IntelliJ IDEA.
  User: lhs
  Date: 2024-07-28
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>로그인 성공!</h1>
    <h2>환영합니다! ${username} 님</h2>
    <h2>환영합니다! <%= request.getAttribute("username") %> 님</h2>
</body>
</html>
