<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
      form {border: 3px solid #f1f1f1;}
      input[type=text], input[type=password] {width: 100%;padding: 12px 20px;margin: 8px 0;display: inline-block;border: 1px solid #ccc;box-sizing: border-box;}
      button {background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;width: 100%;}
      button:hover {opacity: 0.8;}
      .cancelbtn {width: auto;padding: 10px 18px;background-color: #f44336}
      .imgcontainer {text-align: center;margin: 24px 0 12px 0;}
      img.avatar {width: 40%;border-radius: 50%;}
      .container {padding: 16px;}
      span.psw {float: right;padding-top: 16px;}
      @media screen and (max-width: 300px) {span.psw {display: block;float: none;}.cancelbtn {width: 100%;}}
    </style>
</head>
<body>
	<div style="width: 30%;">
		<form action="#" method="post">
			<div class="container" style="overflow: hidden;">
				<label for="uname"><b>아이디</b></label> 
				<input type="text" placeholder="아이디 입력" name="uid" required> 
				<label for="psw"><b>비밀번호</b></label> 
				<input type="password" placeholder="비밀번호 입력" name="upw" required>
				<button type="submit">로그인</button>
				</label>
		</form>
				<button type="submit">회원가입</button>
	</div>

</body>
</html>