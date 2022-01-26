<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도서 정보 등록</title>
    
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
    <link rel="stylesheet" href="Resources/css/Product_Books/a_book_insert.css">
	
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
    
    <!-- ROW 색상 변경 : tr태그에 table-색상 / text-색상 -->
    <div id="main">
        <!-- <table class="table table-striped table-bordered table-hover"> -->
        <div id="side">
            <h2>도서 관리</h2>
            <br><div id="hrr"></div><br>
            <a href=""><h3>도서 등록</h3></a>
            <a href="bookupdate"><h3>도서 수정</h3></a>
        </div>
        <div id="main2">
            <h3>도서 등록</h3> 
            
            <form action="bookinsert" method="post" id="textdata" enctype="multipart/form-data">
                <div id="mainR">
                    <table>
                        <tr>
                            <td>상품이름</td>
                            <td><input type="text" name="pro_name"></td>
                        </tr>
                        <tr>
                            <td>단가</td>
                            <td><input type="text" name="unit_price"></td>
                        </tr>
                        <tr>
                            <td>재고</td>
                            <td><input type="text" name="stock"></td>
                        </tr>
                        <tr>
                            <td>저자</td>
                            <td><input type="text" name="writer"></td>
                        </tr>
                        <tr>
                            <td>출판사</td>
                            <td><input type="text" name="book_pub"></td>
                        </tr>
                        <tr>
                            <td>출판일</td>
                            <td><input type="date" name="publ_date"></td>
                        </tr>
                        <tr>
                            <td>카테고리</td>
                            <td><select name="category" style="width: 200px; font-size: small;">
                                <optgroup label="주제별">
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
                            </select></td>
                        </tr>
                        <tr>
		            	 	<td>이미지</td>
		                    <td><input type="file" name="upload"></td>
                        </tr>
                    </table>                
                </div>
                <div id="mainL">
                    <label>상품설명</label><br>
                    <textarea name="descript" id="" cols="30" rows="10"></textarea><br><br><br>
                    <label>목차</label><br>
                    <textarea name="bookindex" id="" cols="30" rows="10"></textarea>
                </div>
                
                <div>
            		<input type="submit" class="btn btn-outline-secondary btn-lg" value="도서 등록">
           	 	</div>

            </form>

        </div><!-- main2 -->
            
    </div><!-- main -->

    <br><br><br><br>
    <%@ include file="../Common/a_footer.jsp" %>
</body>
</html>

    