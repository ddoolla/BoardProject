<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>index</title>
    <link rel="stylesheet" href="./css/mainStyle.css">
    <link rel="stylesheet" href="./css/commonStyle.css">
    
</head>
<body>
    <div id="page-wrapper"> <!-- 페이지 전체 감싸는 태그 -->
        
        <jsp:include page="./common/header.jsp"/>
        
        <div id="content"> <!-- 컨텐츠 전체 -->

            <section id="main-section"> <!-- 메인 섹션 영역 -->
                <h2>abcdefasdasg</h2>

                <div id="bigPic"> <!-- 큰 사진 -->
                    <a href="#"><img src="https://via.placeholder.com/800X500" alt=""></a>
                </div>

                <div id="smallPic">
                    <table> <!-- 첫번째 작은 사진 -->
                        <tr>
                            <th>title1</th>
                        </tr>
                        <tr>
                            <td>
                                <a href="#"><img src="https://via.placeholder.com/250X350" alt=""></a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                yyyy-MM-dd<br>
                                <span>userId</span>
                            </td>
                        </tr>
                    </table>
                    <table > <!-- 두번째 작은 사진 -->
                        <tr>
                            <th>title2</th>
                        </tr>
                        <tr>
                            <td>
                                <a href="#"><img src="https://via.placeholder.com/250X350" alt=""></a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                yyyy-MM-dd<br>
                                <span>userId</span>
                            </td>
                        </tr>
                    </table>
                    <table > <!-- 세번째 작은 사진 -->
                        <tr>
                            <th>title3</th>
                        </tr>
                        <tr>
                            <td>
                                <a href="#"><img src="https://via.placeholder.com/250X350" alt=""></a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                yyyy-MM-dd<br>
                                <span>userId</span>
                            </td>
                        </tr>
                    </table>
                </div>
            </dsection>

            <section id="sub-section">
                <div id="subPic">
                    <img src="https://via.placeholder.com/250" alt="">
                </div>
                <div id="board"> <!-- 하단 게시판 -->
                    <table>
                        <tr>
                            <td>userId</td>
                            <td> | </td>
                            <td><a href="#">title</a></td>
                            <td> | </td>
                            <td>yyyy-MM-dd</td>
                        </tr>
                        <tr>
                            <td>userId</td>
                            <td> | </td>
                            <td><a href="#">title</a></td>
                            <td> | </td>
                            <td>yyyy-MM-dd</td>
                        </tr>
                        <tr>
                            <td>userId</td>
                            <td> | </td>
                            <td><a href="#">title</a></td>
                            <td> | </td>
                            <td>yyyy-MM-dd</td>
                        </tr>
                        <tr>
                            <td>userId</td>
                            <td> | </td>
                            <td><a href="#">title</a></td>
                            <td> | </td>
                            <td>yyyy-MM-dd</td>
                        </tr>
                        <tr>
                            <td>userId</td>
                            <td> | </td>
                            <td><a href="#">title</a></td>
                            <td> | </td>
                            <td>yyyy-MM-dd</td>
                        </tr>
                    </table>
                    <span><a href="#">더보기</a></span>
                </div>
            </section>
        </div>

        <jsp:include page="./common/footer.jsp"/>
    </div>
</body>
</html>


