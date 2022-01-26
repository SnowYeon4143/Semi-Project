<%@page import="com.dev.member.model.vo.MemberVo"%>
<%@page import="com.dev.paging.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리상품보기(굿즈)</title>

    <!-- 내부 스타일시트 -->
    <link rel="stylesheet" href="./Resources/css/Product_Goods/u_category_goods_list.css">
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
            <a href="#">카테고리상품보기(굿즈)</a>
        </div>

        <div><h1 id="pagetitle">카테고리상품보기(굿즈)</h1></div>

    </header>

    <section>
        <nav id="submenu">
            <a id="submenuscript">카테고리 SKU : ${total} 개</a>
            <div id="blank"></div>
            <a href="javascript:likedesc()" id="submenubotton"><span class="icon-thumbsup"></span> 추천 순</a>
            <a href="javascript:salesdesc()" id="submenubotton"><span class="icon-coin-dollar"></span> 판매 순</a>
        </nav>

        <!-- 컨텐츠 내부 배경 영역 (padding: 40px;) -->
        <div id="maincontentdeployarea" class="maincontentarea">
           <!-- 컨텐츠 배치 영역 (padding: 40px;) -->
           <div id="maincontent01area" class="maincontentarea">

                <!-- 컨텐츠 배치 첫번째 영역 (padding: 40px;) -->
                <div id="contentarea">
                   
                   
            <c:set var="a" value="0" /> 
			<c:set var="b" value="3" /> 

			<table> 

			<c:forEach items="${goodsList}" var="g" varStatus="status"> 
			<c:if test="${a%b == 0 }"> 
			<tr> 
			</c:if>

			<td>
			<div id="goodsarea">
               <div class="image-box"><img src="${g.pro_img}" class="image-thumnail" id="goodscover" onclick="detail(${g.pro_no})"/></div>
               <div id="goodstitle">
                   <h5>${g.pro_name}</h5>
                   <h6>${g.maker}</h6>
                   <span id="proNo">${g.pro_no }</span>
                   <span>추천 ${g.pro_like} | 판매 ${g.sales}</span>
               </div>
               <div id="goodsinf">
                       ${g.unit_price}원
                    <input type="hidden" name=proNo${status.index}  value="${g.pro_no}"/>
                    <%-- <button class="icon-heart1" id="like" onclick="addCart(proNo${status.index})"/></button> --%>
                    <button class="icon-shopping-cart" id="addcart" onclick="addCart(${g.pro_no})"/></button>	
               </div>
           </div>
			</td> 
			
			
			<c:if test="${a%b == b-1}"> 
			</tr> 
			</c:if> 
			<c:set var="a" value="${a+1}"/> 
			</c:forEach> 
			</table>
                   
            
            
            <c:if test="${desc == 'none'}"> 
				<div id="pagecontrol">
                  <nav id="pagecontrolinner" aria-label="Page navigation example">
                         <ul class="pagination">
                			<li class="page-item"><a id="prePage" class="page-link" href="gca?currentPage=${page.prePage()}"> < </a></li>
                			<%
                			System.out.println( "swy : " + ((Paging)request.getAttribute("page")).startNo() );	
                			System.out.println( "swy : " + ((Paging)request.getAttribute("page")).endNo() );	
                			%>
                			 <c:forEach var="i" begin="${4}" end="${4}">
	            				<%--  <c:forEach var="i" begin="${page.startNo()}" end="${page.endNo()}"> --%>
	            				<li class="page-item"><a name="currentPage" class="page-link" href="gca?currentPage=${i}" value="${i}">${i}</a></li>
		            			</c:forEach>
                			<li class="page-item"><a class="page-link" href="gca?currentPage=${page.nextPage()}"> > </a></li>
             			 </ul>                  
                     </nav>
                </div>
			</c:if>
			<c:if test="${desc == 'likedesc'}"> 
				<div id="pagecontrol">
                  <nav id="pagecontrolinner" aria-label="Page navigation example">
                         <ul class="pagination">
                			<li class="page-item"><a id="prePage" class="page-link" href="gca_likedesc?currentPage=${page.prePage()}"> < </a></li>
	            				<c:forEach var="i" begin="${page.startNo()}" end="${page.endNo()}">
	            				<li class="page-item"><a name="currentPage" class="page-link" href="gca_likedesc?currentPage=${i}" value="${i}">${i}</a></li>
		            			</c:forEach>
                			<li class="page-item"><a class="page-link" href="gca?currentPage=${page.nextPage()}"> > </a></li>
             			 </ul>                  
                     </nav>
                </div>
			</c:if> 
			<c:if test="${desc == 'salesdesc'}"> 
				<div id="pagecontrol">
                  <nav id="pagecontrolinner" aria-label="Page navigation example">
                         <ul class="pagination">
                			<li class="page-item"><a id="prePage" class="page-link" href="gca_salesdesc?currentPage=${page.prePage()}"> < </a></li>
	            				<c:forEach var="i" begin="${page.startNo()}" end="${page.endNo()}">
	            				<li class="page-item"><a name="currentPage" class="page-link" href="gca_salesdesc?currentPage=${i}" value="${i}">${i}</a></li>
		            			</c:forEach>
                			<li class="page-item"><a class="page-link" href="gca?currentPage=${page.nextPage()}"> > </a></li>
             			 </ul>                  
                     </nav>
                </div>
			</c:if> 
                   
                   
                   
              
                
                
                </div><!-- 컨텐츠 배치 영역 (padding: 40px;) -->
            </div><!-- 컨텐츠 내부 배경 영역 (padding: 40px;) -->
    </section>
 
	 
<script>
var likedesc = function(){

	$.ajax({
		type: 'get',
		url: "/devbooks/gca_likedesc",
		data: {desc:"likedesc"},
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data) {
			$('body').html(data);
		},
		error: function(request, status, error) {
			alert(error);
		}
	});
};


var salesdesc = function(){

	$.ajax({
		type: 'get',
		url: "/devbooks/gca_salesdesc",
		data: {desc:"salesdesc"},
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data) {
			$('body').html(data);
		},
		error: function(request, status, error) {
			alert(error);
		}
	});
};

</script>

<script>

function addCart(pronum){
			console.log(pronum);
			/* var proNum = document.getElementsByName(pronum); */
            var url = 'addcart?pro_no=' + pronum ;
            window.open(url, "_self");
    };
    
function addLike(proNum){
    var url = 'addlike?pro_no=' + proNum;
    window.open(url, "_self");
    };

</script>
<script>
function detail(proNum){
    var url = 'gd?pro_no=' + proNum;
    window.open(url, "_self");
    };

</script>


 




    <%@ include file="../Common/u_footer.jsp" %>

</body>
</html>