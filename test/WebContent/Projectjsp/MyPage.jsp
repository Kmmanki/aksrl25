<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<style>
div {border: 3px solid #f1f1f1;}
h1 {color: black;border: none;cursor: pointer;width: 100%;text-align: center;}
input[type=text], input[type=password] {width: 100%;padding: 12px 20px;margin: 8px 0;display: inline-block;border: 1px solid #ccc;box-sizing: border-box;}
button {background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;width: 100%;}
button:hover { opacity: 0.8; }
</style>
</head>
<body> 
	<!-- 마이페이지 -->
	<!-- ${teamname} = 팀이름 -->
	<!-- ${teamleader} = 팀장 -->
	<!--${subleader} = 부팀장 -->
	<h1>마이 페이지</h1>
	<h2>팀명: ${teamname}</h2>
	<h2>팀장: ${teamleader}</h2>
	<h2>부팀장${subleader}</h2>
	<h2>팀원</h2>			
					
	<!-- 팀원이 배열로 넘어와야 함  -->
	<!-- ${teams.length} =팀원배열 길이  -->
	<!-- ${member} = 팀원  -->
	<c:forEach var="cnt" begin="1" end="${teams.length}" items="member" >
		<h2>팀원${cnt}: ${member}</h2>
	</c:forEach>
	
	<a href=""><button>탈퇴</button></a>
	<a href=""><button>투표하러가기</button></a>
	<h2>지원자 유/무: </h2><img alt="${red}" src="${green}">
	
</body>
</html>