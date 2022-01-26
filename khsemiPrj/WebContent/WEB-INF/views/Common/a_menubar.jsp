<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메뉴바</title>
    <link rel="stylesheet" href="Resources/css/Common/a_menubar.css">
    
   <!-- 개인 코드에서 사용한 부트스트랩 -->
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> -->
    <script src="https://kit.fontawesome.com/d088eb3922.js" crossorigin="anonymous"></script>

    
    <!-- 공용으로 사용할 부트스트랩 -->
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
    <nav class="navbar">
        <!-- <div class="navbar-center"> -->
            <span class="nav-icon">
                <img src="Resources/img/Logo/로고 사진 연그레이.png" alt="logo" style="width: 50px;">
                <img src="Resources/img/Logo/로고 글자 연그레이.png" alt="logo_text" style="width: 100px;">
            </span>
            <div id="menu">
                <ul class="main1">
                    <li><a href="bookinsert">상품관리</a>
                        <ul class="main2">
                            <li><a href="bookinsert">책 관리</a></li>
                            <li><a href="gcon1">굿즈 관리</a></li>
                        </ul>
                    </li>
                    <li><a href="#">회원관리</a></li>
                    <li><a href="#">주문내역관리</a></li>
                    <li><a href="qna">게시판</a></li>
                </ul>
            </div>

            <div class="cart-btn">
            <a href="mdRecommend">
            	<span class="nav-icon" style="color:#eee">
                    MD추천 관리
                </span>
            </a>
                
                <!-- <div class="cart-items">0</div> -->
            </div>
            <div id="menu2">
                <ul class="main1">
                    <li><a href="#"><i class="fas fa-user fa-2x" style="color: #eee;"></i></a>
                        <ul class="main2">
                            <li><a href="reviewreport">도서리뷰 신고내역</a></li>
                            <li><a href="mrReport">굿즈리뷰 신고내역</a></li>
                            <li><a href="qnareport">QnA 신고내역</a></li>
                            <li><a href="logout">로그아웃</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        <!-- </div> -->
    </nav>
</body>
</html>