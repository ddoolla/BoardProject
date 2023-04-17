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
    <link rel="stylesheet" href="../css/galleryStyle.css">
</head>
<body>
    <div id="page-wrapper">
    
        <jsp:include page="../common/header.jsp" />
        
        <section id="gallery-section">
            <div>
                <c:forEach var="galleryItems" items="${ requestScope.galleryList }">
                	<table>
                    	<tr>
                        	<td class="img-mouseover">
	                            <a href="./selectList.do?cNum=${ galleryItems.cNum }">
                                	<img src="../upload/${ galleryItems.newNameFile }" alt="">
                            	</a>
                        	</td>
                    	</tr>
                    	<tr>
	                        <td>${ galleryItems.writeDate }<br> <span>${ galleryItems.userId }</span>
                        	</td>
                    	</tr>
               		</table>
                </c:forEach>
            </div>
            <div id="paging">
                ${ requestScope.pagingStr }
            </div>

        </section>

        <jsp:include page="../common/footer.jsp" />
        
    </div>
</body>
</html>