<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>a6_독자리뷰신고</title>
	<link rel="stylesheet" href="./Resources/css/Product_Books/a_book_review_report.css">
	
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

    <div class="home">
        <a href="#"><img src="Resources/img/i_con/home_icon.png" id="icon3"></a>
        <label> > </label>
        <a href="#" id="gs">회원관리</a>
        <label> > </label>
        <a href="#" id="gs">독자리뷰 신고리스트</a>
    </div>

    <br><br><br><br>

    <h2>독자 리뷰_신고 리스트</h2>
    
    <br><br><br><br>

    <form>
        <div>
            <table>
                <tr>
                    <th id="book2"><img src="Resources/img/Bookcover/자바의정석.JPG" id="book1"></th>
                    <th id="lab1"> 
                        <img src="Resources/img/i_con/wish2_icon.png" id="wish">

                        <br>

                        <label> 
                            수학에 수학의 정석이 있다면, 자바에는 자바의 정석이 있다.
                            <br>
                            자바의 정석은 나와 참 깊은 책이기는 *ㄹ.. 이해 1도 못하겠다 
                            <br> 
                            강의를 듣지 않으면 쉽게 이해 힘듬.
                        </label>

                        <br><br>

                        <label >작성자 : jackand</label>
                        <br><br>
                        <label>작성날짜 : 2021.08.25</label>

                        <input type="submit" id="btn1" value="신고취소">
                        <input type="submit" id="btn2" value="삭제">
                    </th>
                </tr>
            </table>

            <br><br>
            <hr>
            <br>

            <table>
                <tr>
                    <td id="book3"><img src="Resources/img/Bookcover/it지식.JPG" id="book1"></td>
                    <td id="lab1"> 
                        <img src="Resources/img/i_con/wish2_icon.png" id="wish">

                        <br>

                        <label> 
                            개념에 대한 설명을 위키백과 그대로 퍼온 쓰ㅡ레기같은 책임. 
                            <br>
                            저자가 개념 설명에 대한 개념이 부족한건지, 
                            <br>
                            자신의 얕은 지식을 자랑하는건지 의도를 모르겠음. 
                            <br>
                            이딴 책 살바에 그 돈으로 더욱 유용한 일을 할 수 있을 것임.
                        </label>

                        <br><br>

                        <label >작성자 : gn040545</label>
                        <br><br>
                        <label>작성날짜 : 2021.12.01</label>

                        <input type="submit" id="btn1" value="신고취소">
                        <input type="submit" id="btn2" value="삭제">
                    </td>
                </tr>
            </table>

            <br><br>
            <hr>
            <br>

            <table>
                <tr>
                    <td id="book3"><img src="Resources/img/Bookcover/몰입.JPG" id="book1"></td>
                    <td id="lab1"> 
                        <img src="Resources/img/i_con/wish2_icon.png" id="wish">

                        <br>

                        <label> 
                            설명이 너무 빈약하고 실행결과 사진도 이해가 안감.
                            <br>
                            아예 기본을 모르는 초보나 입문자들에겐 어려울 수 있는 책임.
                        </label>

                        <br><br>

                        <label >작성자 : jj5555</label>
                        <br><br>
                        <label>작성날짜 : 2021.10.18</label>

                        <input type="submit" id="btn1" value="신고취소">
                        <input type="submit" id="btn2" value="삭제">
                    </td>
                </tr>
            </table>
        </div>
    </form>

    <br><br><br><br><br><br>
    <br><br><br><br><br><br>
    <br><br><br><br><br><br>

	<%@ include file="../Common/a_footer.jsp" %>
</body>
</html>