<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>저장된 정보 확인</h1>
<%
	Object obj = session.getAttribute("cer");
	if(obj==null){
		out.println("<h1>fake.jsp 방문해라</h1>");
	}else{
		out.println("<h1>"+obj+"</h1>");
	}
%>
</body>
</html>