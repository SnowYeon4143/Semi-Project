<%@page import="com.dev.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.dev.probook.model.ProbookVO"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     

<% 
	List<ProbookVO> list = (List<ProbookVO>)request.getAttribute("data");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세페이지(도서)</title>
    <!-- CSS 파일 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/Product_Books/u_book_detail.css">

    <!-- 부트스트랩 CDN -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <!-- 폰트어썸 CDN -->
    <script src="https://kit.fontawesome.com/08023c4634.js" crossorigin="anonymous"></script>
    
    <!-- * CSS 파일 불러오기 오류로 인한 비 설정된 CSS들 추가 -->
    <style type="text/css">
    	/* 페이지 네비게이션 바 */
	    .pagination {
			display: flex;
			justify-content: center;
			margin-top: 25px;
			margin-bottom: -5px;
		}
		
		/* 페이지 네비게이션 텍스트 색상 */
		.page-link {
		   	color: #2D313C !important;
		}
		
		/* 구매 버튼 */
		.buy_btn {
		    position: relative;
		    left: 1090px;
		    top: 350px;  
		}
		
		/* 하단 소개항목 */
		.bottom_book_intro {
		    padding-top: 10px;
		    padding-left: 180px;
		    padding-right: 180px;
		    margin-left: 185px;
		    margin-right: 700px;
		    position: relative;
		    bottom: 130px;
		}
		
		/* 점프 버튼 */
		#jump_button {
		    position: sticky;
		    left: 1200px;
		    top: 0;
		}		
    </style>
</head>
<body>

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
	
	    <% 
			for(ProbookVO p : list)
			{
				String productName = p.getProductName();
				String writerName = p.getWriterName();
				String publisher = p.getPublisher();
				String enrollDate = p.getEnrollDate();
				String productLikeCount = p.getProductLikeCount();
				String productPrice = p.getProductPrice();
				String imageLink = p.getImageLink();
				
				String productDescript = p.getProductDescript();
				String contentList = p.getContentList();
		%>	
	
    <!-- 위치 링크 -->
    <nav>
    	<a href="home"><img src="${pageContext.request.contextPath}/Resources/img/i_con/home_icon.png" id="home_icon"></a>
	    <a href="" id="placeLink">> 주제별 도서</a>
	    <a href="" id="placeLink">> <%=productName%></a>
    </nav>
    

    <!-- 상단 컨텐츠 항목 -->
    <div class="content">
        <!-- 오른쪽 책 제목 및 설명 / 구매 항목 -->
        <!-- 책 제목 및 저자, 출판사, 출판일 -->
        <div class="box_datail_right">
            <br>
            

		
        <hr id="rec_peopleLine">
        <!-- 책 제목 및 저자, 출판사, 출판일 그리고 좋아요 수  -->
        <div class="rec_peopleBox">
            <h2 id="book_Title" style="font-weight: bold;"><%=productName%></h2>
            <br>
            <%=writerName%> | <%=publisher%> | <%=enrollDate%>
            <br>
            <a href="" class="edit-delete-button" style="background-color: #2D313C !important; color: white; position: relative; top: 30px;"><i class="far fa-thumbs-up"></i><%=productLikeCount%>명의 유저들이 추천합니다</a>
        </div>
        <hr id="pur_QauntityLine">
        <!-- 구매 수량 및 가격 그리고 장바구니,구매 버튼 -->
        <!-- 왼쪽 영역 : 구매수량 -->
        <strong id="pur_Qauntity">구매수량</strong>
        <!-- 오른쪽 영역 : 수량 버튼  -->
        <div class="def-number-input number-input safari_only" style="position: relative; left: 1200px; top: 260px; margin-bottom: 15px;">
            <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="minus"></button>
                <input class="quantity" min="0" name="quantity" value="1" type="number">
            <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
        </div>
        <br>
        <!-- 금액 영역 -->
        <div class="buy_price">
            <strong>
                <span style="font-size: 15px; vertical-align: middle;">합계</span>
                <%=productPrice%>원
            </strong>
        </div>
        <!-- 버튼 영역 -->
        <div class="buy_btn">
            <button type="button" class="btn btn-default btn-lg" style="background-color: white; color: black; width: 190px !important;">장바구니</button>
            <button type="button" class="btn btn-primary btn-lg" style="background-color: #2D313C; border: 1px solid #2D313C; width: 190px !important;">바로구매</button>
        </div>
        <!-- // 구매 수량 및 가격 그리고 장바구니,구매 버튼 -->
        <!-- //오른쪽 책 제목 및 설명 / 구매 항목 -->
        </div>
        <!-- 왼쪽 커버 이미지 -->
        <div class="box_detail_left">
            <!-- 책 커버 이미지 -->
            <div class="cover">
                <img src="<%=imageLink%>" width="198" height="282" alt="" class="coverImg">
            </div>
        </div>
        <br><br><br>
        <hr style="border: 0; height: 1px; background: #ccc; width: 62%; position: relative; bottom: 101px;">
        <!-- 하단 소개항목 -->
        <!-- 점프 버튼 -->
        <div class="bottom_intro">
            <div class="btn-group-vertical" id="jump_button" role="group" aria-label="Vertical button group">
                <a href="#book_intro"><button type="button" class="btn" style="background-color: #2D313C !important; color: white; width: 150px !important; margin-bottom: 1px;">책 소개</button></a>
                <a href="#book_contents"><button type="button" class="btn" style="background-color: #2D313C !important; color: white; width: 150px !important; margin-bottom: 1px;">목차</button></a>
                <a href="#book_review"><button type="button" class="btn" style="background-color: #2D313C !important; color: white; width: 150px !important; margin-bottom: 1px;">독자 리뷰</button></a>
            </div>
            <!-- 하단 소개항목/책 소개 -->
            <div class="bottom_book_intro">
                <strong id="book_intro">책 소개</strong>
                <br>
                <br>
                <p style="line-height: 2.0;">
					<%=productDescript%>
                </p>
            </div>
            <hr id="bottom_contents_line" style="border: 0; height: 1px; background: #ccc; width: 35%; position: relative; right: 258px; bottom: 90px;">
            <!-- 하단 소개항목/목차 -->
            <div class="bottom_book_contents">
                <strong id="book_contents">목차</strong>
                    <div class="contents_inside">
                        <p>
                            <br>
                            <%=contentList%>
                        </p>
                    </div>
            </div>
        </div>
        
		<%	
			}
		%>
		
		 
        

                        <br><br><br><br><br>
        </div>

    <%@ include file="../Common/u_footer.jsp" %>
</body>
</html>