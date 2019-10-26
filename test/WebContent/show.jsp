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
		Cookie[] cks = request.getCookies();
		if(cks == null || cks.length == 0 ){
			out.println("<h1> No cookies</h1>");
		}else{
			for(Cookie ck : cks){
				out.println("<h2>"+ ck+"<h2>");
				
			}
		}
	%>


</body>
</html>