<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>에러 페이지</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>에러 발생</h1>
<p>요청을 처리하는 도중 에러가 발생했습니다.</p>
<p><b>에러 메시지:</b> <%= exception.getMessage() %></p>
</body>
</html>