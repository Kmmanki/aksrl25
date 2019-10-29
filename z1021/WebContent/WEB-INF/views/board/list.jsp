<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
li {
float: left;
margin-right: 0.3em;
font-weight : bold;
text-align : center;
border:1px solid blue;
width : 5em;
border-radius : 0.3em;
}
</style>
</head>
<body>
<h1>LIST</h1>

<c:forEach var = "vo" items="${list}">
${vo.pno}
<a href="/board/view?pno=${vo.pno}&page=${page.page}" >${vo.title}</a>
${vo.writer}
${vo.view_count}
<br>
</c:forEach>
<br>

<c:if test="${pm.prev}"><a href="/board/list?page=${pm.start -1}"><li>이전</li></a></c:if>

<c:forEach begin="${pm.start}" end="${pm.end}" var="num" >
		<a href="/board/list?page=${num}&amount=${pm.paging.amount}">
		<li>${num}</li>
		</a>
		
</c:forEach>

<c:if test="${pm.next}"><a href="/board/list?page=${pm.end +1}"><li>다음</li></a></c:if>



	<a href="/board/register?page=${pm.page}"><button>글쓰기</button></a>

</body>
</html>