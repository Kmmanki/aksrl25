<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LIST</h1>
<c:forEach var = "vo" items="${list}">
${vo.pno}
<a href="/board/view?pno=${vo.pno}&page=${page}" >${vo.title}</a>
${vo.writer}
<br>

</c:forEach>
    <form action="/board/register">
    <input type="submit" value="글쓰기">
    </form>
</body>
</html>