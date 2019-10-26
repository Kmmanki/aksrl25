<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>뭔가를 자동저장.</h1>
<%
	session.setAttribute("cer", "홍길동");
%>
<h1>정상처리 되었습니다.</h1>

</body>
</html>