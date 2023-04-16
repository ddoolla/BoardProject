<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 수정</title>
    <link rel="stylesheet" href="../css/commonStyle.css">
    <link rel="stylesheet" href="../css/updatePostStyle.css">
</head>
<body>
    <div id="page-wrapper">
    
        <jsp:include page="../common/header.jsp"/>

        <section id="writeForm-section">
           <div>
                <h1>게시글 수정</h1>
                <form action="./updatePost.do?uNum=${ sessionScope.loginOK.uNum }" enctype="multipart/form-data" method="post">
                	<input type="hidden" name="cNum" value="${ requestScope.BoardDTO.cNum }">
                    <table>
                        <tr>
                            <th>작성자</th>
                            <td><input type="text" name="userId" value="${ sessionScope.loginOK.userId }" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <th>제목</th>
                            <td><input type="text" name="title" value="${ requestScope.BoardDTO.title }"></td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td><textarea name="content" cols="70" rows="20">${ requestScope.BoardDTO.content }</textarea></td>
                        </tr>
                        <tr>
                            <th>이미지</th>
                            <td><input type="text" name="originalImage" value="${ requestScope.BoardDTO.originalFile }" /></td>
                        </tr>
                        <tr>
                            <th>변경</th>
                            <td><input type="file" name="myFile" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="수정" >
                                &nbsp;
                                <input type="button" value="취소" onClick="history.back();">
                            </td>
                        </tr>
                    </table>
                </form>
           </div>
        </section>

        <jsp:include page="../common/footer.jsp"/>
        
    </div>
</body>
</html>