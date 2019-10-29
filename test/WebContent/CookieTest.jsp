<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie ck = new Cookie("sample", "hello");
		ck.setMaxAge(60*5);
		response.addCookie(ck);
	%>
</body>
</html>