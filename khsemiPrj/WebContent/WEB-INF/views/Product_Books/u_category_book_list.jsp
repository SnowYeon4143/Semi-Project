<%@page import="com.dev.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리상품보기(도서)</title>

    <!-- 내부 스타일시트 -->
    <link rel="stylesheet" href="./Resources/css/Product_Books/u_category_book_list.css">
    <link rel="stylesheet" href="./Resources/css/Product_Books/style.css">

    <!-- 외부 스타일시트 -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
    <!-- 헤더 영역, 상단 메뉴바 -->
    <header>
    
    	<%
			String id = "";
			if (session.getAttribute("loginUser") != null) {
				MemberVo member = (MemberVo) session.getAttribute("loginUser");
				id = member.getUserId();
			}
		%>


		<%
			if (session.getAttribute("loginUser") != null) {
		%>
			<%@ include file="../Common/u_menubar_login.jsp"%>
			
		<%
			} else if (session.getAttribute("loginUser") == null) {
		%>
			<%@ include file="../Common/u_menubar.jsp"%>
		<%
			}
		%>
    	
    	<br>

        <div id="currentlocationarea">
            <a href="#" class="icon-home3"></a>
            >
            <a href="#">카테고리상품보기(도서)</a>
        </div>

        <div><h1 id="pagetitle">카테고리상품보기(도서)</h1></div>

    </header>

    <section>
        <nav id="submenu">
            <a id="submenuscript">결과 표시됨</a>
            <div id="blank"></div>
            <a href="#" id="submenubotton"><span class="icon-thumbsup"></span> 추천 순</a>
            <a href="#" id="submenubotton"><span class="icon-coin-dollar"></span> 판매 순</a>
        </nav>

        <!-- 컨텐츠 내부 배경 영역 (padding: 40px;) -->
        <div id="maincontentdeployarea" class="maincontentarea">
            <!-- 컨텐츠 배치 영역 (padding: 40px;) -->
            <div id="maincontent01area" class="maincontentarea">

                <!-- 컨텐츠 배치 첫번째 영역 (padding: 40px;) -->
                <div id="contentarea">
                    <table border="0">
                        <tr>
                            <td>
                                <div id="bookarea">
                                    <div id="bookcover">책 표지</div>
                                    <div id="booktitle">
                                        <h2>책 제목</h2>
                                        <h5>저자</h5>
                                    </div>
                                    <div id="bookinf">
                                        00,000$
                                        <button class="icon-heart1" id="cont1button"></button>
                                        <button class="icon-shopping-cart" id="cont1button"></button>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div id="bookarea">
                                    <div id="bookcover">책 표지</div>
                                    <div id="booktitle">
                                        <h2>책 제목</h2>
                                        <h5>저자</h5>
                                    </div>
                                    <div id="bookinf">
                                        00,000$
                                        <button class="icon-heart1" id="cont1button"></button>
                                        <button class="icon-shopping-cart" id="cont1button"></button>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div id="bookarea">
                                    <div id="bookcover">책 표지</div>
                                    <div id="booktitle">
                                        <h2>책 제목</h2>
                                        <h5>저자</h5>
                                    </div>
                                    <div id="bookinf">
                                        00,000$
                                        <button class="icon-heart1" id="cont1button"></button>
                                        <button class="icon-shopping-cart" id="cont1button"></button>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <table border="0">
                        <tr>
                            <td>
                                <div id="bookarea">
                                    <div id="bookcover">책 표지</div>
                                    <div id="booktitle">
                                        <h2>책 제목</h2>
                                        <h5>저자</h5>
                                    </div>
                                    <div id="bookinf">
                                        00,000$
                                        <button class="icon-heart1" id="cont1button"></button>
                                        <button class="icon-shopping-cart" id="cont1button"></button>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div id="bookarea">
                                    <div id="bookcover">책 표지</div>
                                    <div id="booktitle">
                                        <h2>책 제목</h2>
                                        <h5>저자</h5>
                                    </div>
                                    <div id="bookinf">
                                        00,000$
                                        <button class="icon-heart1" id="cont1button"></button>
                                        <button class="icon-shopping-cart" id="cont1button"></button>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div id="bookarea">
                                    <div id="bookcover">책 표지</div>
                                    <div id="booktitle">
                                        <h2>책 제목</h2>
                                        <h5>저자</h5>
                                    </div>
                                    <div id="bookinf">
                                        00,000$
                                        <button class="icon-heart1" id="cont1button"></button>
                                        <button class="icon-shopping-cart" id="cont1button"></button>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>

                    <div id="pagecontrol">
                        <nav id="pagecontrolinner" aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">4</a></li>
                                <li class="page-item"><a class="page-link" href="#">5</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <%@ include file="../Common/u_footer.jsp" %>

</body>
</html>