<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<!-- jQuery  -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    
    
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script> 

<!-- 아이콘 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
<!-- css -->
<link rel="stylesheet" href="Resources/css/Product_Goods/a_md_recommend.css">


</head>
<body>
	<%@ include file="../Common/a_menubar.jsp" %>
   
    <div id="route">
        <img id="home_icon"src="Resources/img/i_con/home_icon.png" alt="">
        <div id="aa">
            <!-- <a href="" id="route">홈</a>  -->
            &nbsp; > 
            <a href="" id="tt">MD추천 도서 관리</a>
        </div>
    </div>
<!-------------------------main------------------------------->
    <div class="row">
    	<div class="col-sm-12">
    		<div id="m1">
			    <h3>도서 수정/삭제</h3> 
			        <div id="search_div" class="clearfix">
			                <input name="search" type="text" placeholder="책 제목으로 검색하세요" style="float: left;">
			                <button type="submit" class="btn1" id="searchbtn">
			                    <img id="searchbtn_img" src="Resources/img/i_con/search.png" alt="검색" >
			                </button>
			            </div>
			    
			    <!----------------- 테이블 ------------------------->
			      <table class="table-hover">
			                    <thead>
			                        <tr>
			                            <th>상품번호</th>
			                            <th>상품이름</th>
			                            <th>이미지</th>
			                            <th>단가</th>
			                            <th>재고</th>
			                            <th>상품설명</th>
			                            <th>책번호</th>
			                            <th>저자</th>
			                            <th>출판사</th>
			                            <th>출판일</th>
			                            <th>카테고리</th>
			                        </tr>
			                    </thead>
			                    <tbody id="#tbody">
			                    <c:forEach items="${bookList}" var="b" varStatus="status">
			                        <tr>
			                            <td>${b.getProductNumber()}</td>
			                            <td>${b.getProductName()}</td>
			                            <td>${b.getImageLink()}</td>
			                            <td>${b.getProductPrice()}</td>
			                            <td>${b.getProductStock()}</td>
			                            <td>${b.getProductDescript()}</td>
			                            <td>${b.getBookNumber()}</td>
			                            <td>${b.getWriterName()}</td>
			                            <td>${b.getPublisher()}</td>
			                            <td>${b.getEnrollDate()}</td>
			                            <td>${b.getCategoty()}</td>
			                        </tr>
			                    
			                    </c:forEach>

			                </tbody>
			                </table>    
			    <!------------------------페이저------------------------------->
			        <ul class="pagination justify-content-center" style="margin:20px 0">
			  			 <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
			  			 <li class="page-item"><a class="page-link" href="#">1</a></li>
			 			 <li class="page-item"><a class="page-link" href="#">2</a></li>
			 			 <li class="page-item"><a class="page-link" href="#">3</a></li>
			 			 <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
					</ul>
			    <!---------------------버튼3------------------------->
			    <!-- <div id="b2">
			          <div>
			              <button type="submit" class="btn1">1페이지 ▼</button>
			              <button type="submit" class="btn1">2페이지 ▼</button>
			              <button type="submit" class="btn1">3페이지 ▼</button>
			          </div>
			     </div> -->
			    
			    <!------------------- 슬라이드 ---------------------->
			    <tr id="view">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
			    
			    
			    <div class="row">
				    <div class="col-sm-4">
				    <div id="slide">
			                
			                <div id="middle">
			                    <div id="img">
			                        <img id="book" src="">
			                    </div><!-- img -->
			                    <div id="txt">
			                        <h4 id="title"></h4><!-- 책 제목  -->
			                        <span id ="inf"></span><!-- 저자 / 출판사 / 가격 --><span id="proN" hidden>dd</span>
			                        <textarea name="" id="md" cols="30" rows="10"></textarea>
			                    </div>
			                </div>
			                    <button class="btn1" id="btn3">등록</button>
			            </div><!-- slide -->
				    </div>
				  </div>
				    
				    
				    
				    
			    </div>
   		 	</div><!-- m1 -->  
    	</div><!-- col12 -->
    </div><!-- row -->
    
    
    
    
    
<script>
        $(function(){
        	$('#tbody>tr').on("click", function(){
      
                const num0 = $(this).children().eq(0).text(); //proN
                const num1 = $(this).children().eq(1).text(); //name
                const num2 = $(this).children().eq(2).text(); //img
                const num3 = $(this).children().eq(3).text(); //price
                const num8 = $(this).children().eq(8).text(); //writer
                const num9 = $(this).children().eq(9).text(); //publisher
               /*  
                const num4 = $(this).children().eq(4).text(); //stock
                const num5 = $(this).children().eq(5).text(); //date
                const num6 = $(this).children().eq(6).text(); //bookNo
                const num7 = $(this).children().eq(7).text(); //descript 
                const num10 = $(this).children().eq(10).text(); //category
                */
                
                
                $('#view').children().eq(0).text(num0);
                $('#view').children().eq(1).text(num1);
                $('#view').children().eq(2).text(num2);
                $('#view').children().eq(3).text(num3);
                $('#view').children().eq(4).text(num8);
                $('#view').children().eq(5).text(num9);
                
                
                
                
                console.log(num0);
                          
             	$('#proN').text(num0);
                $('#title').text(num1);
              
                var bookcover = $('#book');
                bookcover.attr('src',num2);
                
                $('#inf').text(num8+"|"+num9+"|"+num3);
                
            });

        });    
</script> 
    
    
    
    
    
    
    
   

    <br><br>
<%@ include file="../Common/a_footer.jsp" %>
</body>
</html>

    