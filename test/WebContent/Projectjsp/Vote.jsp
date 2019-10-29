<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{margin: 0; padding: 0;}
body{width: 1200px; margin: 0 auto; text-align: center;}
div {border: 3px solid #f1f1f1;text-align: center; width: 30%; align-items: center;}
h1 {color: black;border: none;cursor: pointer;width: 100%;}
input[type=text], input[type=password] {width: 100%;padding: 12px 20px;margin: 8px 0;display: inline-block;border: 1px solid #ccc;box-sizing: border-box;}
button {background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;width: 100%;}
button:hover { opacity: 0.8; }
</style>
</head>
<body>
<div>
<h1>투표</h1>
	<!--  ${aplier} = 지원자 이름 -->
	<h2>${applier}가 지원했습니다. </h2>
	<!-- method를 무엇으로 줘야하나? -->
	<form action="" method="POST">
		찬성<input name="vote" type="radio" value="찬성">
		반대<input name="vote" type="radio" value="반대">
		<input type="submit" value="투표">
	</form>


</body>
</html>