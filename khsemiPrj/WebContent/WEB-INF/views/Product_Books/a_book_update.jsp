<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.dev.probook.model.ProbookVO"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도서 정보 수정</title>
    
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
    <link rel="stylesheet" href="Resources/css/Product_Books/a_book_update.css">

	<style type="text/css">
		
		#productNumberbox {
		    width: 50px;
		}
		#productNamebox {
		    width: 200px;
		}
		#imageLinkbox {
		    width: 220px;
		}
		#productPricebox {
		    width: 60px;
		}
		#productStockbox {
		    width: 60px;
		}
		#productSaleCountbox {
		    width: 60px;
		}
		#productLikeCountbox {
		    width: 60px;
		}
		#productDescriptbox {
			width: 200px;
		}
		#bookNumberbox {
		    width: 50px;
		}
		#writerNamebox {
		    width: 150px;
		}
		#publisherbox {
		    width: 150px;
		}
		#enrollDatebox {
		    
		}
		#contentListbox {
		    width: 150px;
		}
		#searchbar {
			width: 250px;
		}
		
		#main
		{
		    width: 2300px;
		    height: 1200px;
		    padding: 40px;
		    background-color: #dcdcdc;
		    margin-top: 10px;
		    margin-left: 10px;
		    border-radius: 10px;
		}
		
		#side
		{
		    width: 10%;
		    height: 100%;
		    display: inline;
		    float: left;
		}
		#main2
		{
		    width: 90%;
		    height: 100%;
		    display: inline;
		    float: left;
		}
		
	</style>
	
	<script type="text/javascript">
		window.onload = function() {
			date = ${d.enrollDate};
		}
		
	</script>

</head>
<body>

	<%@ include file="../Common/a_menubar.jsp" %>


    <div id="route">
        <img id="home_icon"src="Resources/img/i_con/home_icon.png" alt="">
        <div id="aa">
            <!-- <a href="" id="route">홈</a>  -->
            &nbsp; > 
            <a href="" id="tt">상품관리_도서</a>
        </div>
    </div>

    <!-------------------------------- 검색----------------------------------- -->


    <div id="main">
        <div id="side">
            <h1>도서 관리</h1>
            <br><div id="hrr"></div><br>
            <a href="bookinsert"><h3>도서 등록</h3></a>
            <a href=""><h3>도서 수정</h3></a>
        </div>
        <div id="main2">
            <h3>도서 조회</h3> 
      
            		<div id="searcharea">
					     <form action="bookupdate" method="get">
					         <select id="selectbutton" name="searchtype">
					             <option value="PRO_NAME">책 제목</option>
					         </select>
					    
					         <input id="searchbar" type="text" placeholder="책 제목으로 검색" name="searchvalue">
					         <button type="submit">검색</button>
					     </form>
					 </div>
            
                <table class="table-hover">
                    <thead>
                        <tr class="table-success">
                            <th>상품번호</th>
                            <th>상품이름</th>
                            <th>이미지</th>
                            <th>단가</th>
                            <th>재고</th>
                            <th>판매수</th>
                            <th>좋아요</th>
                            <th>상품설명</th>
                            <th>상품유형</th>
                            <th>책번호</th>
                            <th>저자</th>
                            <th>출판사</th>
                            <th>출판일</th>
                            <th>카테고리</th>
                            <th>목차</th>
                        </tr>
                    </thead>
                    <tbody>
							<c:forEach items="${data}" var="d">
		                    	<tr class="primary">
		                    		<td>${d.productNumber}</td>
		                    		<td>${d.productName}</td>
		                            <td><img alt="" src="${d.imageLink}" style="width: 70px; height: 90px;"></td>               
		                            <td>${d.productPrice}</td>
		                            <td>${d.productStock}</td>
		                            <td>${d.productSaleCount}</td>
		                            <td>${d.productLikeCount}</td>
		                            <td>${d.productDescript}</td>
		                            <td>${d.productType}</td>
		                            <td>${d.bookNumber}</td>
		                            <td>${d.writerName}</td>
		                            <td>${d.publisher}</td>
		                            <td>${d.enrollDate}</td>
		                            <td>${d.categoty}</td>
		                            <td>${d.productLikeCount}</td>
		                        </tr>
	                    	</c:forEach>
	                    	
                	</tbody>
                </table>
                
                <hr>
    
            <!-- -----------------------페이저----------------------------- -->
                <div id="pagecontrol">
					 <nav id="pagecontrolinner" aria-label="Page navigation example">
					     <ul class="pagination">
					          <c:forEach var="i" begin="1" end="10" step="1">
					              <c:if test="${i <= maxPage}">
					                   <li class="page-item">
					                       <a class="page-link" href="bookupdate?currentPage=${i}">${i}</a>
					                   </li>
					               </c:if>
					          </c:forEach>
					      </ul>
					  </nav>
				</div>
	
            <!-- ----------------------- 등록/수정 버튼 ----------------------------- -->
            
                <hr>
                
                <h3>도서 정보 수정</h3>
                <h6>* 주의! 상단 도서 정보 기능에서 책을 검색하여 수정. 책은 한 권만 수정할 것!</h6>
                <h6>* 주의! 출판일을 변경하지 않을 경우, 기존 입력 데이터를 그대로 다시 입력해주세요.</h6>
                
                <form action="bookupdateinsert" method="post" enctype="multipart/form-data">

					<select name="searchtype" style="width: 60px; font-size: small;">
			            <optgroup label="검색값 설정">
			            <option value="PRO_NAME">책 이름</option>
			            </optgroup>
		            </select>

					
					<select name="searchtype2" style="width: 60px; font-size: small;">
			            <optgroup label="검색값 설정">
			            <option value="BOOK_NO">책 번호</option>
			            </optgroup>
		            </select>


					<input id="searchbar" type="text" placeholder="책 제목 입력" name="searchvalue">

					<input id="searchbar" type="text" placeholder="책 번호 입력" name="searchvalue2">
                
                    <table class="table-hover">
	                    <thead>
	                        <tr class="table-success">
	                            <th>상품이름</th>
	                            <th>이미지 링크</th>
	                            <th>단가</th>
	                            <th>재고</th>
	                            <th>판매수</th>
	                            <th>좋아요</th>
	                            <th>상품설명</th>
	                            <th>상품유형</th>
	                            <th>저자</th>
	                            <th>출판사</th>
	                            <th>출판일</th>
	                            <th>카테고리</th>
	                            <th>목차</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                    	<c:forEach items="${data}" var="d" begin="0" end="0" step="1">
		                        <tr class="primary">
		                            <td><input type="text" name="proName" value="${d.productName}" id="productNamebox"></td>
		                            <td><input type="file" name="upload" id="imageLinkbox"></td>                  
		                            <td><input type="text" name="productPrice" value="${d.productPrice}" id="productPricebox"></td>
		                            <td><input type="text" name="productStock" value="${d.productStock}" id="productStockbox"></td>
		                            <td><input type="text" name="productSaleCount" value="${d.productSaleCount}" id="productSaleCountbox"></td>
		                            <td><input type="text" name="productLikeCount" value="${d.productLikeCount}" id="productLikeCountbox"></td>
		                            <td><input type="text" name="productDescript" value="${d.productDescript}" id="productDescriptbox"></td>
		                            <td>
		                                <select name="productType" style="width: 60px; font-size: small;">
		                                     <optgroup label="주제별">
		                                         <option value="${d.productType}">${d.productType}</option>
		                                         <option value="도서">도서</option>
		                                         <option value="굿즈">굿즈</option>
		                                     </optgroup>
		                                </select>
		                            </td>
		                            <td><input type="text" name="writerName" value="${d.writerName}" id="writerNamebox"></td>
		                            <td><input type="text" name="publisher" value="${d.publisher}" id="publisherbox"></td>
		                            <td>
		                            	${d.enrollDate} <br>
		                            	<input type="date" name="enrollDate" value="${d.enrollDate}" id="enrollDatebox">
		                            </td>
		                            <td>
		                                <select name="category" style="width: 120px; font-size: small;">
		                                      <optgroup label="주제별">
		                                      	  <option value="${d.categoty}">${d.categoty}</option>
		                                          <option value="프로그래밍언어">프로그래밍언어</option>
		                                          <option value="엑셀/활용서">엑셀/활용서</option>
		                                          <option value="IT자격증">IT자격증</option>
		                                      </optgroup>
		                                      <optgroup label="프로그래밍">
		                                          <option value="딥러닝">딥러닝</option>
		                                          <option value="머신러닝">머신러닝</option>
		                                          <option value="인공지능">인공지능</option>
		                                          <option value="안드로이드">안드로이드</option>
		                                          <option value="유니티">유니티</option>
		                                      </optgroup>
		                                 </select>
		                            </td>
		                            <td><input type="text" name="contentList" value="${d.contentList}" id="contentListbox"></td>
		                         </tr>		
	                         </c:forEach>
	                         
	                    </tbody>
	                </table>
                    
                    <div id="del">
                    	<input type="submit" class="btn1" value="상품 정보 수정">
                    </div>
                </form>
            


        </div><!-- main2 -->
    </div><!-- main -->

    <br><br><br><br>
    
    <%@ include file="../Common/a_footer.jsp" %>
</body>
</html>

    