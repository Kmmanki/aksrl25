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

        <form action="/upload" method="POST" style="margin: auto" enctype="multipart/form-data">
            <input type="text" name="title" minlength="5" maxlength="50" placeholder="제목"><br><br>
            <input type="text" name="writer" minlength="5" maxlength="50"placeholder="작성자"><br><br>
            <textarea cols="150" name="content" minlength="5"  rows="30" placeholder="내용" ></textarea>
            <input type="file" name="fs" multiple="multiple"><br><br>
            <input type="submit" value="확인">
    		<a href="/board/list"><button>취소</button></a>
    </form>
</body>
</html>