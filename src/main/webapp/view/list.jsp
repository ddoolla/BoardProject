<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/commonStyle.css">
    <link rel="stylesheet" href="../css/listStyle.css">
</head>
<body>
    <div id="page-wrapper">
        
        <jsp:include page="../common/header.jsp"/>

        <section id="list-section">
            <h1>asdasfqwe</h1>
            <p>
                sdfsdfsdfsdf
            </p>
            <div id="searchBox">
                <div>
                    <form action="./list.do">
                        <input type="text" name="searchTitle" value="${ requestScope.searchTitle }">
                        <input type="submit" value="검색">
                    </form>
                </div>
            </div>
            <table>
                <tr>
                    <th width="50px">번호</th>
                    <th width="480px">제목</th>
                    <th width="100px">작성자</th>
                    <th width="110px">작성일</th>
                    <th width="60px">조회수</th>
                </tr>
                <c:choose>
                	<c:when test="${ empty requestScope.lists }">
                		<tr><td colspan="5">등록된 게시물이 없습니다.</td></tr>
                	</c:when>
                	<c:otherwise>
                		<c:forEach var="lists" items="${ requestScope.lists}" varStatus="idx"> <!-- 페이지 요청에 따라 한페이지에 10번씩 반복해서 출력 -->
                			<tr>
                				<td>${ requestScope.totalNum - (((requestScope.pageNum - 1) * 10) + idx.index)}</td> <!-- 가상의 번호 사용 -->
                				<td><a href="./selectList.do?cNum=${ lists.cNum }">${ lists.title }</a></td>
                				<td>${ lists.userId }</td>
                				<td>${ lists.writeDate }</td>
                				<td>${ lists.visitNum }</td>
                			</tr>
                		</c:forEach>
                	</c:otherwise>
                </c:choose>
            </table>
            <div id="bottom-btn">
                <div></div>
                <div>${ requestScope.pagingStr }</div> <!-- 페이징 -->
                <div>
                	<input type="button" value="글쓰기">
                </div>
            </div>
        </section>

       	<jsp:include page="../common/footer.jsp"/>
       	
    </div>
</body>
</html>