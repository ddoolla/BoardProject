<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/test.do">
		<input type="checkbox" name="testCheck" value="Y"> 안녕
		<input type="submit" value="보내기"/>
	</form>
	체크 파라미터 : ${ requestScope.str }
	
	
	
</body>
</html>