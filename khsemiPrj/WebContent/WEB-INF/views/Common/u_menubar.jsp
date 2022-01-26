<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴바</title>
    <link rel="stylesheet" href="Resources/css/Common/u_menubar.css">
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
            	<a href="home"><img src="Resources/img/Logo/로고 사진 연그레이.png" alt="logo" style="width: 50px;"></a>
            	<a href="home"><img src="Resources/img/Logo/로고 글자 연그레이.png" alt="logo_text" style="width: 100px;"></a>
            </span>
            <div id="menu">
                <ul class="main1">
                    <li><a href="#"><i id="menu" class="fas fa-bars fa-2x" style="color: #eee;"></i></a>
                        <ul class="main2">
                            <li><a href="programinglang">주제별</a>
                                <ul class="main3">
                                    <li><a href="programinglang">프로그래밍 언어</a></li>
                                    <li><a href="programinglang">엑셀 / 활용서</a></li>
                                    <li><a href="programinglang">IT 자격증</a></li>
                                </ul>
                            </li>
                            <li><a href="programinglang">프로그래밍</a>
                                <ul class="main3">
                                    <li><a href="programinglang">딥러닝</a></li>
                                    <li><a href="programinglang">머신러닝</a></li>
                                    <li><a href="programinglang">인공지능</a></li>
                                    <li><a href="programinglang">안드로이드</a></li>
                                    <li><a href="programinglang">유니티</a></li>
                                </ul>
                            </li>
                            
                            <li><a href="gca">굿즈</a>
								<ul class="main3">
									<li><a href="gca?category=생활용품">생활용품</a></li>
									<li><a href="gca?category=문구">문구</a></li>
									<li><a href="gca?category=전자">전자</a></li>
								</ul>
							</li>
					</ul>
                    </li>
                    <li><a href="bestseller">베스트</a></li>
                    <li><a href="newproducts">신상품</a></li>
                    <li><a href="qna">게시판</a></li>
             
                </ul>
            </div>
            
            <form class="form-inline" action="bookdetail" method="get">
                <div class="inputDiv">
                	<select id="selectbutton" name="searchtype" hidden="">
						<option value="PRO_NAME">책 제목</option>
					</select>
                    <input class="form-control mr-sm-2" type="text" placeholder="책 제목을 정확하게 입력해주세요." name="searchvalue">
                <button type="submit" style="background-color: #2D313C; border: none;"><i id="search" class="fas fa-search fa-2x" type="submit"></i></button>
                </div>
            </form>
            
            <div class="cart-btn">
                <span class="nav-icon" style="color:#eee">
                	<a id="menu_cart" href="cart" style="color:#eee">
                		<i class="fas fa-cart-plus"></i>
                	</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </span>
                <div class="cart-items">0</div>
            </div>
            <div id="menu2">
                <ul class="main1">
                    <li><a href="login">로그인</a></li>
                    <li><a href="join">회원가입</a></li>
                </ul>
            </div>
    </nav>
</body>
</html>