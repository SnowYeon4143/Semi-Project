<%@page import="com.dev.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>베스트셀러</title>

    <!-- 내부 스타일시트 -->
    <link rel="stylesheet" href="./Resources/css/Product_Books/u_bestseller_list.css">
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
            <a href="#">베스트셀러</a>
        </div>

        <div><h1 id="pagetitle">베스트셀러</h1></div>

    </header>

    <section>
        <nav id="submenu">
            <a id="submenuscript">베스트셀러 TOP 10</a>
            <div id="blank"></div>
        </nav>

        <!-- 컨텐츠 내부 배경 영역 (padding: 40px;) -->
        <div id="maincontentdeployarea" class="maincontentarea">
            <!-- 컨텐츠 배치 영역 (padding: 40px;) -->
            <div id="maincontent01area" class="maincontentarea">
                <!-- 컨텐츠 배치 첫번째 영역 (padding: 40px;) -->
                <div id="contentarea">

                    <table border="0">
                                  				    
					<br>

					<c:forEach items="${data}" var="d">
						<tr>
							<div>
								<td>
									<img alt="" src="${d.imageLink}" style="width: 130px; height: 190px;">
								</td>
								<td>
									<h4 style="height: 60px; text-align: center;">${d.productName}</h4>
									<h5>${d.writerName}</h5>
									${d.productPrice}원 <br>
									판매량 : ${d.productSaleCount}
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
			        
                    </table>

                </div>
            </div>
        </div>
    </section>

    <%@ include file="../Common/u_footer.jsp" %>

</body>
</html>