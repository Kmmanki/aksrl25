<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>veiw</h1>
<h2>제목 ${vo.title}</h2>
<h2>작성자 ${vo.writer}</h2>
<h2>내용 ${vo.content}</h2>
<h2>첨부파일${vo.fnames}</h2>

<a href="/board/list?page=${param.page}"><input type="submit" value = "목록으로"></a>

</body>
</html>