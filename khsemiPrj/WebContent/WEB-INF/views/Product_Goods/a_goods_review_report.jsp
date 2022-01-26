<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>a6_2_굿즈리뷰신고</title>
	<link rel="stylesheet" href="./Resources/css/Product_Goods/a_goods_review_report.css">
	
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

	<%@ include file="../Common/a_menubar.jsp" %>

<!-- 
	<nav>
		<img src="Resources/img/Logo/로고 사진 연그레이 s.png" id="icon1">
        <ul id="navi">
            <li><a href="#">상품관리</a></li>
            <li><a href="#">회원관리</a></li>
            <li><a href="#">주문내역관리</a></li>
            <li><a href="#">QnA</a></li>
            <li id="list4"><a href="#">관리자님</a></li>
        </ul>
    </nav>
-->

    <div class="home">
        <a href="#"><img src="Resources/img/i_con/home_icon.png" id="icon3"></a>
        <label> > </label>
        <a href="#" id="gs">회원관리</a>
        <label> > </label>
        <a href="#" id="gs">굿즈 리뷰_신고리스트</a>
    </div>

    <br><br><br><br>

    <h2>굿즈 리뷰_신고 리스트</h2>
    
    <br><br><br><br>

        <div >
        
        <c:forEach items="${mdReportList}" var="r" varStatus="status">
            <table>
                <tr>
                    <th id="book2"><img src="${r.getPro_img()}" id="book1"></th>
                    <th id="lab1"> 
                        <img src="Resources/img/i_con/wish2_icon.png" id="wish">

                        <br>

                        <label> 
                            ${r.getMr_cont()}
                        </label>

                        <br><br>

                        <label >작성자 : ${r.getId()}</label>
                        <br><br>
                        <label>작성날짜 : ${r.getMr_date()}</label>

                        <input type="submit" id="btn1" value="신고취소">
                        <input type="submit" id="btn2" value="삭제">
                    </th>
                </tr>
            </table>

            <br><br>
            <hr>
           </c:forEach>
           
            
        </div>


	<br><br><br><br><br><br>
    <br><br><br><br><br><br>
    <br><br><br><br><br><br>
    
	<%@ include file="../Common/a_footer.jsp" %>
  
</body>
</html>