<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

            <link rel="stylesheet" href="https://allyoucan.cloud/cdn/icofont/1.0.1/icofont.css" integrity="sha384-jbCTJB16Q17718YM9U22iJkhuGbS0Gd2LjaWb4YJEZToOPmnKDjySVa323U+W7Fv" crossorigin="anonymous">
            	<div class="container" id="book_review">
                            
                <c:choose>
		            <c:when test="${data eq null}">
		            	<div class="reviews-members pt-4 pb-4">
	                    	<div class="media">
		                    	<div class="media-body">
		                        	<div class="reviews-members-header">
										<h6 class="mb-1"><a class="text-black" href="#">리뷰가 존재하지 않는 상품입니다.</a></h6>
		                            </div>
		                    	</div>
		                	</div>
	                	</div>     
		            </c:when>
	                    		
                	<c:otherwise>
	                	<c:forEach items="${data}" var="d" begin="1" end="5" step="1">
	                    	<div class="reviews-members pt-4 pb-4">
	                        	<div class="media">
		                        	<div class="media-body">
		                            	<div class="reviews-members-header">
			                                <span class="star-rating float-right">
			                                	<a href="#"><i class='fas fa-bell fa-2x' style="position: relative; left: 3px; color: red;"></i></a>
			                                </span>
		                                    
		                                    <h6 class="mb-1"><a class="text-black" href="#">글쓴이</a></h6>
		                                    <p class="text-gray">${d.bookReviewDate}</p>
		                                </div>
		                                            
		                                            <!-- 리뷰 내용 -->
		                                <div class="reviews-members-body">
											${d.bookReviewContext}	
										</div>
		                                <div class="reviews-members-footer">
			                                <a class="total-like" href="#" style="background-color: #2D313C !important; color: white;"><i class="far fa-thumbs-up"></i>${d.bookReviewLikeCount}</a>
			                                 
			                                <a class="edit-delete-button float-right" href="#" style="background-color: #2D313C !important; color: white;"> 삭제</a>
			                                <a class="edit-delete-button float-right" href="#" style="background-color: white !important; color: black;"> 수정</a>
		                            	</div>
		                        	</div>
		                    	</div>
	                    	</div>      
				    	</c:forEach>
                	</c:otherwise>
                </c:choose>

	                <div class="bg-white rounded shadow-sm p-4 mb-5 rating-review-select-page">
	                	<h5 class="mb-4" style="font-weight: bold !important;">리뷰 작성</h5>
	                    <form action="bookdetailinsertreview" method="get">
	                        <div class="form-group">
		                        <label>내용</label>
		                        <input class="form-control" style="resize: none; height: 150px;" name="reviewinsert">
	                        </div>
	                        <div class="form-group">
	                        	<button class="btn btn-primary btn-m" type="submit" style="background-color: #2D313C !important; border: 1px solid #2D313C;"> 등록하기 </button>
	                    	</div>
	                    </form>
	                </div>
                </div> 	

                            
                            
                            

</body>
</html>