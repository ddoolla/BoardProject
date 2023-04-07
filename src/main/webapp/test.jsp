<%@page import="model.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="model.dao.BoardDAO"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.print("컨텍스트 루트 :" + request.getContextPath());
	%>
</body>
</html>