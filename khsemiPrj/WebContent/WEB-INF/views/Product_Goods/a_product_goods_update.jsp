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
    <!-- jQuery  -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>Document</title>
    
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
    <link rel="stylesheet" href="Resources/css/Product_Goods/a_product_goods_update.css">


</head>
<body>

<%@ include file="../Common/a_menubar.jsp" %>


    <div id="route">
        <img id="home_icon"src="Resources/img/i_con/home_icon.png" alt="">
        <div id="aa">
            <!-- <a href="" id="route">홈</a>  -->
            &nbsp; > 
            <a href="" id="rr">상품관리_굿즈</a>
        </div>
    </div>

    <!-------------------------------- 검색----------------------------------- -->
    <div id="search_div" class="clearfix" style="float: left;">
        <input type="text" class="form-control"id="search" placeholder="굿즈명으로 검색하세요" style="float: left;">
    </div>
        <button type="submit" id="searchbtn" class="btn-outline-secondary">
            <img id="searchbtn_img" src="Resources/img/i_con/search.png" alt="검색" >
        </button>
    
    <div id="main">
        <div id="side">
            <h2>굿즈 관리</h2>
            <br><div id="hrr"></div><br>
            <a id="rr" href="gcon1"><h3>굿즈 등록</h3></a>
            <a id="rr" href="gcon2"><h3>굿즈 수정/삭제</h3></a>
        </div>
        <div id="main2">
            <h3>굿즈 수정/삭제</h3>            
                <table class="table-hover">
                    <thead>
                        <tr>
                            <th>상품번호</th>
                            <th>상품이름</th>
                            <th>이미지</th>
                            <th>단가</th>
                            <th>재고</th>
                            <th>판매수</th>
                            <th>좋아요</th>
                            <th>상품설명</th>
                            <th>상품유형</th>
                            <th>굿즈번호</th>
                            <th>굿즈유형</th>
                            <th>제조사</th>
                            <th>원산지</th>
                        </tr>
                    </thead>
                    <tbody id="tbody">
                    <c:forEach items="${goodsList}" var="g" varStatus="status"> 
                        <tr id="tval" >
					        <td>${g.pro_no}</td>
					        <td>${g.pro_name}</td>
					        <td>${g.pro_img}</td>
					        <td>${g.unit_price}</td>
					        <td>${g.stock}</td>
					        <td>${g.sales}</td>
					        <td>${g.pro_like}</td>
					        <td>${g.description}</td>
					        <td>${g.pro_type}</td>
					        <td>${g.md_no}</td>
					        <td>${g.md_cate}</td>
					        <td>${g.maker}</td>
					        <td>${g.country}</td>
					    </tr>
                     </c:forEach> 
                </tbody>
                </table>
        
        
            <!------------------------페이저---------------------------------------------->
                <div id="nav">
                  <nav id="pagecontrolinner">
                         <ul class="pagination">
                			<li class="page-item"><a id="prePage" class="page-link" href="gcon2?currentPage=${page.prePage()}"> < </a></li>
	            				<c:forEach var="i" begin="${page.startNo()}" end="${page.endNo()}">
	            				<li class="page-item"><a name="currentPage" class="page-link" href="gcon2?currentPage=${i}" value="${i}">${i}</a></li>
		            			</c:forEach>
                			<li class="page-item"><a class="page-link" href="gcon2?currentPage=${page.nextPage()}"> > </a></li>
             			 </ul>                  
                     </nav>
                </div>
        
        
            <!------------------------- 등록/수정 버튼 ------------------------------------>
            <div id="b2">
                <!-- <div style="text-align: center;">
                    <button type="submit" class="btn1">상품 조회</button>
                    <i class="fas fa-chevron-down"></i>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <i class="fas fa-chevron-up"></i>
                    <button type="submit" class="btn1">상품 수정</button>
                </div> -->
            </div>
            
            <form method="get" >
            
            <table id="table2">
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
                        <th>굿즈번호</th>
                        <th>굿즈유형</th>
                        <th>제조사</th>
                        <th>원산지</th>
                </thead>
                <tbody>
               		 <tr id="view">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr id="update">
			            <td><input id="proN" type="text" name="pro_no" readonly/></td>
			            <td><input class="a" id="proName" type="text" name="pro_name"></td>
			            <td><!-- <input id="img" type="file" accept="image/jpeg,.png" name="goodsimg"> --></td>
			            <td><input class="b" id="price" type="number" name="unit_price"></td>
			            <td><input class="b" id="stock" type="number" name="stock"></td>
			            <td><input class="c" id="sale" type="number" name="sales" disabled/></td>
			            <td><input class="c" id="like" type="number" name="pro_like" disabled/></td>
			            <td><!-- <input id="inf" type="file" accept="image/jpeg,.png" name="goodsinf"> --></td>
			            <td><input class="c" id="type" type="text" name="pro_type" disabled/></td>
			            <td><input class="c" id="mdNo" type="text" name="md_no" disabled/></td>
			            <td>
			                <select id="cate" name="category" style="width: 100%; font-size: small;">
			                        <option value="생활용품">생활용품</option>
			                        <option value="문구/활용서">문구</option>
			                        <option value="인형">인형</option>
			                        <option selected>----------</option>
			                </select>
			            </td>
			            <td><input class="b" id="maker" type="text" name="maker"></td>
			            <td><input class="b" id="country" type="text" name="country"></td>
                    </tr>
                </tbody>
            </table>
            <div id="del">
            	<input type="hidden" name="currentpage" value="${currentPage}"/>
    			<input type="hidden" name="search" value="${search}"/>
            	<input type="submit" value="상품 수정" onclick="javascript: form.action='goods_update';"/>
            </form>
    			<button value="상품 삭제" id="delete" onclick="delMD()"/>상품 삭제</button>
            </div>
            
        </div><!-- main2 -->
	 </div><!-- main1 -->

    <script>
        $(function(){

            $('#tbody>tr').click(function(){
                const num0 = $(this).children().eq(0).text();
                const num1 = $(this).children().eq(1).text();
                const num2 = $(this).children().eq(2).text();
                const num3 = $(this).children().eq(3).text();
                const num4 = $(this).children().eq(4).text();
                const num5 = $(this).children().eq(5).text();
                const num6 = $(this).children().eq(6).text();
                const num7 = $(this).children().eq(7).text();
                const num8 = $(this).children().eq(8).text();
                const num9 = $(this).children().eq(9).text();
                const num10 = $(this).children().eq(10).text();
                const num11 = $(this).children().eq(11).text();
                const num12 = $(this).children().eq(12).text();
                          
             	$('#view').children().eq(0).text(num0);
                $('#view').children().eq(1).text(num1);
                $('#view').children().eq(2).text(num2);
                $('#view').children().eq(3).text(num3);
                $('#view').children().eq(4).text(num4);
                $('#view').children().eq(5).text(num5);
                $('#view').children().eq(6).text(num6);
                $('#view').children().eq(7).text(num7);
                $('#view').children().eq(8).text(num8);
                $('#view').children().eq(9).text(num9);
                $('#view').children().eq(10).text(num10);
                $('#view').children().eq(11).text(num11);
                $('#view').children().eq(12).text(num12);
                
             /* $('#update').children().eq(0).text(num0); */
                $('#update').children().eq(5).text(num5);
                $('#update').children().eq(6).text(num6);
                $('#update').children().eq(8).text(num8);
                $('#update').children().eq(9).text(num9);    
             
                
               var pro_no = $(this).children().eq(0).text();
               console.log(pro_no);
 			   $("#proN").val(pro_no);
 			  console.log($("#proN").val());

            });

        });    
    </script> 
   
	<script>
	
	function delMD(){          
		$.ajax({         
		url : "/devbooks/goods_delete",
		method: "post",
		data : {
			'pro_no' : $("#proN").val()
			}
	});        
		}
	</script>



    <br><br><br><br>
  <%@ include file="../Common/a_footer.jsp" %>
</body>
</html>

    