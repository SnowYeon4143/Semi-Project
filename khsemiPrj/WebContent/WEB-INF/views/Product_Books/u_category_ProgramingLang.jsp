<%@page import="com.dev.member.model.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.dev.probook.model.ProbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로그래밍 언어</title>

    <!-- 내부 스타일시트 -->
    <link rel="stylesheet" href="./Resources/css/Product_Books/u_new_book_list.css">
    <link rel="stylesheet" href="./Resources/css/Product_Books/style.css">

    <!-- 외부 스타일시트 -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
            <a href="#">프로그래밍 언어</a>
        </div>

        <div><h1 id="pagetitle">프로그래밍 언어</h1></div>
        
        <hr>

    </header>
    
    <section>
        <nav id="submenu">
            <a id="submenuscript">프로그래밍 언어</a>
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
                                  
					    <div id="searcharea">
					        <form action="programinglang" method="get">
					        
					            <select id="selectbutton" name="searchtype">
					                <option value="PRO_NAME">책 제목</option>
					            </select>
					    
					            <input id="searchbar" type="text" placeholder="책 제목으로 검색" name="searchvalue">
					            <button id="searchbutton" type="submit">검색</button>
					        </form>
					    </div>
					    
						<br>

	                    <c:choose>
	                    
	                    	<c:when test="${data eq null}">
	                    		<br>
	                    		<h3> 찾으시는 상품은 존재하지 않는 상품입니다. </h3>
	                    	</c:when>
	                    	
	                    	<c:otherwise>
	                    		<c:forEach items="${data}" var="d">
									<tr>
										<div>
											<td>
												<img alt="" src="${d.imageLink}" style="width: 130px; height: 190px;">
											</td>
											<td>
												<h4 style="height: 60px; text-align: center;">${d.productName}</h4>
												<h5>${d.writerName}</h5>
												${d.productPrice}원
												<br>
												<button class="icon-heart1" id="cont1button"></button>
												<button class="icon-shopping-cart" id="cont1button"></button>
											</td>
										</div>
									</tr>
									
									<tr>
									<td> <hr> </td>
									<td> <hr> </td> 
									<td> <hr> </td> 
									<td> <hr> </td> 
									<td> <hr> </td> 	                    		     
									</tr> 
			                    </c:forEach>
							</c:otherwise>

	                    </c:choose>

                    </table>
                    
                        <div id="pagecontrol">
					        <nav id="pagecontrolinner" aria-label="Page navigation example">
					            <ul class="pagination">
					                <c:forEach var="i" begin="1" end="10" step="1">
					                    <c:if test="${i <= maxPage}">
					                        <li class="page-item">
					                            <a class="page-link" href="newproducts?currentPage=${i}">${i}</a>
					                        </li>
					                    </c:if>
					                </c:forEach>
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