<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${list}
${param.msg} 

<script type="text/javascript">
	var msg = '${param.msg}'; 
	if(msg === 'success'){
		alert("등록성공");
	}
</script>

</body>
</html>