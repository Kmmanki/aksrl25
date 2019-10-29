<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 모든 팀이 리스트로 들어와야 함. -->
	<h1>팀 지원 및 현황</h1>
	<div>
	<!--teamlist = 모든 팀의 리스트  -->
	<!--teamlist = 모든 팀의 리스트  -->
			<form action="" method="post">
		<c:forEach  items="${teamlist}" var="team"  >
				<p>-----------------${cnt}팀---------------------------</p>
				<h2>팀명: ${team.name}</h2>
				<h2>팀장: ${team.leader}</h2>
				<h2>현재팀원 수: ${team.length}</h2>
				<h2>지원 가능 여부: <button onclick="location.href="#">${team.applyCheck}</button>    </h2>
		</c:forEach>
					 <input	type="submit" value="확인">
			</form>
	</div>
	
</body>
</html>