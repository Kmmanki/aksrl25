<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀뷰어</title>
</head>
<body>
	<h1>팀 뷰어</h1>
	<h2>팀명 ${teamname}</h2>
	<h2>팀장${teamleader}</h2>
	<h2>부팀장${subteamleader}</h2>
										<!-- 팀원이 배열로 넘어와야 함  -->
	<c:forEach var="cnt" begin="1" end="${teams.length}" >
		<h2>팀원${cnt}: ${teamles}</h2>
	</c:forEach>
	
	<h1>지원자</h1>
	<h2>${applyer}</h2>
	<!-- method를 무엇으로 줘야하나? -->
	<form action="" method="get">
		찬성<input type="radio" value="찬성">
		반대<input type="radio" value="반대">
		<input type="submit" value="투표">
	</form>
</body>
</html>