<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글쓰기</h1>

        <form action="/board/register" method="POST" style="margin: auto">
            <input type="text" name="title" minlength="5" maxlength="50" placeholder="제목"><br><br>
            <input type="text" name="writer" minlength="5" maxlength="50"placeholder="작성자"><br><br>
            <textarea cols="150" name="content" minlength="5"  rows="30" placeholder="내용" ></textarea><br><br>
            <input type="submit" value="확인">
            <input type="reset" value="취소"> 
    </form>
</body>
</html>