<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <h1>EL 문법의 Scope 확인용 페이지</h1>

    <h2>Request 범위</h2>
    <p>${request}</p>

    <h2>Session 범위</h2>
    <p>${session != null ? session : "없는데여" }</p>

    <h2>Application 범위</h2>
    <p>${application != null ? application : "없는데여"}</p>

    <h2>JSP Page 범위</h2>
    <%--  데이터 지정을 안해 봅시다  --%>
    <p>${page}</p>
</body>
</html>
