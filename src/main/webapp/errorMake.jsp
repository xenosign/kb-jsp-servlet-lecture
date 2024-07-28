<%@ page errorPage="error.jsp" %>
<%
    // 에러를 강제로 발생시키기 위해 사용
    if (true) {
        throw new RuntimeException("테스트 예외 발생");
    }
%>