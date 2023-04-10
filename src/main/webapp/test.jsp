<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int x = 10;
		out.print(x-- + "<br>");
		out.print(x + "<br>");
		out.print("----------------" + "<br>");
		request.setAttribute("x", x);
	%>
	${ x-1 }<br>
	${ x-1 }<br>
	${ x-1 }<br>
	${ x-1 }<br>
</body>
</html>