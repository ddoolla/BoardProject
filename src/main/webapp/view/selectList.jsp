<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>selectList</title>
    <link rel="stylesheet" href="../css/commonStyle.css">
    <link rel="stylesheet" href="../css/selectListStyle.css">
</head>
<body>
    <div id="page-wrapper">
        
        <jsp:include page="../common/header.jsp"/>

        <section id="selectList-section">
            <div>
                <span>제목:</span>
                ㅇㄴㅁㄴ이ㅏㅁㄴ
            </div>
            <div>
                <div>
                    <span>작성자:</span> ddddddddd
                </div>
                <div></div>
                <div>
                    <span>작성일:</span> yyyy-MM-dd
                </div>
            </div>
            <div>
                내용용용ㅇ
            </div>
            <div>
                <input type="button" value="수정">
                <input type="button" value="삭제">
                <input type="button" value="목록">
            </div>
        </section>


        <jsp:include page="../common/footer.jsp"/>
    </div>
</body>
</html>