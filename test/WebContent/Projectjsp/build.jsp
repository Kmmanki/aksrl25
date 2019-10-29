<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>몇팀인가용?</title>
<style>
div {border: 3px solid #f1f1f1;}
h1 {color: black;border: none;cursor: pointer;width: 100%;text-align: center;}
input[type=text], input[type=password] {width: 100%;padding: 12px 20px;margin: 8px 0;display: inline-block;border: 1px solid #ccc;box-sizing: border-box;}
button {background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;width: 100%;}
button:hover { opacity: 0.8; }
</style>
</head>
<body>
	<div>
		<h1>몇팀인가요?!</h1>
		<form action="" method="GET">
			<input type="text" name="teams"> <input type="submit"
				value="확인">
		</form>
	</div>

	<div>
			<form action="" method="post">
		<c:forEach var="cnt" begin="1" end="${param.teams}" >
				<p>-----------------${cnt}팀---------------------------</p>
				<input type="text" placeholder="팀명" name="teamname">
				<input	type="text" placeholder="팀장" name="leader"> 
				<select name="membercnt" >
					<option value="">인원선택</option>
					<option value="2">2명</option>
					<option value="3">3명</option>
					<option value="4">4명</option>
					<option value="5">5명</option>
					<option value="6">6명</option>
				</select>	
		</c:forEach>
					 <input	type="submit" value="확인">
			</form>
	</div>

</body>