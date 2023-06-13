<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link rel="stylesheet" href="../css/commonStyle.css">
    <link rel="stylesheet" href="../css/noticeStyle.css">
    <script src="../javascript/script.js" type="text/javascript"></script>
</head>
<body>
    <div id="page-wrapper">
        
        <jsp:include page="../common/header.jsp"/>

        <section id="notice-section">
            <h1>공지사항</h1>
            <p>
                ----------
            </p>
            <div id="searchBox">
                <div>
                    <form action="">
                        <input type="text" name="searchTitle" value="">
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
                <tr><td colspan="5">등록된 공지사항이 없습니다.</td></tr>
            </table>
            <div id="bottom-btn">
                <div></div>
                <div></div> <!-- 페이징 -->
                <div>
                	<!-- 글쓰기 버튼 -->
                </div>
            </div>
        </section>

       	<jsp:include page="../common/footer.jsp"/>
       	
    </div>
</body>
</html>