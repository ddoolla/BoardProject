<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 	    

    <header id="main-header"> <!-- 헤더 -->
            
            <div id="main-logo">
                <a href="./home.do"><img src="https://via.placeholder.com/100" alt=""></a>
            </div>
            
            <div id="top-title">
                <h1>ABCDEFG</h1>
            </div>
            
           
            <div id="join">
            <c:choose>
            	<c:when test="${ !empty sessionScope.loginOK.userId }">
            		<span>${ sessionScope.loginOK.name }</span>님 안녕하세요!
            		| <a href="logout.do">로그아웃</a>
            	</c:when>
            	<c:otherwise>
            		<a href="./loginForm.jsp">로그인</a> 
               		&nbsp;|&nbsp;
                	<a href="./joinForm.jsp">회원가입</a>  
            	</c:otherwise>
            	
            </c:choose>       
            </div>

        </header>

        <nav id="main-navigation"> <!-- 네비게이션바 -->
            <div>
                <ul>
                    <li><a href="./home.do">home</a></li>
                    <li>&nbsp;|&nbsp;</li>
                    <li><a href="./list.do">게시글</a></li>
                    <li>&nbsp;|&nbsp;</li>
                    <li><a href="#">갤러리</a></li>
                    <li>&nbsp;|&nbsp;</li>
                    <li><a href="#">마이페이지</a></li>
                </ul>
            </div>
        </nav>