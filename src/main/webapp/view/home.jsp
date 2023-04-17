<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet" href="../css/homeStyle.css" type="text/css">
<link rel="stylesheet" href="../css/commonStyle.css" type="text/css">
</head>
<body>
	<div id="page-wrapper">
		<!-- 페이지 전체 감싸는 태그 -->

		<jsp:include page="../common/header.jsp" />


		<div id="content">
			<!-- 컨텐츠 전체 -->

			<section id="main-section">
				<!-- 메인 섹션 영역 -->
				<h2>abcdefasdasg</h2>

				<div id="bigPic">
					<!-- 큰 사진 -->
					<img src="../images/camera-ga9294504e_1920.jpg" alt="">
				</div>

				<div id="smallPic">
					<c:choose>
						<c:when test="${ !empty requestScope.smallPicList }">
							<c:forEach var="smallPicLists"
								items="${ requestScope.smallPicList }">
								<table>
									<tr>
										<th>new !</th>
									</tr>
									<tr>
										<td class="smallPicBox"><a href="./selectList.do?cNum=${ smallPicLists.cNum }"><img
												src="../upload/${ smallPicLists.newNameFile }" alt=""></a>
										</td>
									</tr>
									<tr>
										<td>${ smallPicLists.writeDate }<br> <span>${ smallPicLists.userId }</span>
										</td>
									</tr>
								</table>
							</c:forEach>
						</c:when>
						<c:otherwise> <!-- 디비에 사진없으면 기본출력 -->
							<table>
								<!-- 첫번째 작은 사진 -->
								<tr>
									<th>title1</th>
								</tr>
								<tr>
									<td class="smallPicBox"><a href="#"><img
											src="https://via.placeholder.com/250X350" alt=""></a></td>
								</tr>
								<tr>
									<td>yyyy-MM-dd<br> <span>userId</span>
									</td>
								</tr>
							</table>
							<table>
								<!-- 두번째 작은 사진 -->
								<tr>
									<th>title2</th>
								</tr>
								<tr>
									<td class="smallPicBox"><a href="#"><img
											src="https://via.placeholder.com/250X350" alt=""></a></td>
								</tr>
								<tr>
									<td>yyyy-MM-dd<br> <span>userId</span>
									</td>
								</tr>
							</table>
							<table>
								<!-- 세번째 작은 사진 -->
								<tr>
									<th>title3</th>
								</tr>
								<tr>
									<td class="smallPicBox"><a href="#"><img
											src="https://via.placeholder.com/250X350" alt=""></a></td>
								</tr>
								<tr>
									<td>yyyy-MM-dd<br> <span>userId</span>
									</td>
								</tr>
							</table>
						</c:otherwise>
					</c:choose>

				</div>
			</section>

			<section id="sub-section">
				<div id="subPic">
					<img src="../images/camera-g5ca820c24_1280.jpg" alt="">
				</div>
				<div id="board">
					<!-- 하단 게시판 -->
					<table>
						<c:choose>
							<c:when test="${ empty requestScope.homeLists }">
								<tr>
									<td colspan="5">게시물이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="homeLists" items="${ requestScope.homeLists }">
									<tr>
										<td>${ homeLists.userId }</td>
										<td>|</td>
										<td><a href="./selectList.do?cNum=${ homeLists.cNum }">${ homeLists.title }</a></td>
										<td>|</td>
										<td>${ homeLists.writeDate }</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>


					</table>
					<span><a href="/view/list.do">더보기</a></span>
				</div>
			</section>
		</div>

		<jsp:include page="../common/footer.jsp" />


	</div>
</body>
</html>


