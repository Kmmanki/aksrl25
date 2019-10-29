<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {border: 3px solid #f1f1f1;}
h1 {color: black;border: none;cursor: pointer;width: 100%;text-align: center;}
input[type=text], input[type=password] {width: 100%;padding: 12px 20px;margin: 8px 0;display: inline-block;border: 1px solid #ccc;box-sizing: border-box;}
button {background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;width: 100%;}
button:hover { opacity: 0.8; }
</style>
</head>
<body>
 <div style="width: 30%;">
		<h1>회원가입</h1>
		<form action="" method="post">
			<br>
			<br> <input minlength="3" max="50" type="text" name="id" placeholder="아이디"><br>
			<br> <input minlength="5" max="50" type="password" name="pw" placeholder="비밀번호"><br>
			<br> <input type="text" minlength="2" max="50" name="name" placeholder="이름"><br>
			<br>
			<button>회원가입</button>
			<br>
			<br>
		</form>
		<a href=""><button>뒤로가기</button></a>
	</div>
</body>
</html>