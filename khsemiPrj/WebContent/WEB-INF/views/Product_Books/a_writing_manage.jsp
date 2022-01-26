<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    <link rel="stylesheet" href="Resources/css/Product_Books/a_writing_manage.css">


</head>
<body>
<%@ include file="../Common/a_menubar.jsp" %>
    <div id="route">
        <img id="home_icon"src="Resources/img/i_con/home_icon.png" alt="">
        <div id="aa">
            <!-- <a href="" id="route">홈</a>  -->
            &nbsp; > 
            <a href="" id="tt">저서 관리</a>
        </div>
    </div>

    
    
    <!-- ROW 색상 변경 : tr태그에 table-색상 / text-색상... 적용 안됨 ㅜ  -->
    <div id="main">
        <!-- <table class="table table-striped table-bordered table-hover"> -->
            <div id="main1">
                <h2>저서 관리</h2>
                <br><div id="hrr"></div><br>
                <a href=""><h3>저자 등록/수정</h3></a>
                <a href=""><h3>저서 등록/수정</h3></a>
            </div>
            <div id="main2">
            <!-------------------------------- 검색----------------------------------- -->
             <div id="search_div" class="clearfix">
            </div>
                <input type="text" placeholder="저서명으로 검색하세요" style="float: left;">
                <button type="submit" class="btn1" id="searchbtn">
                    <img id="searchbtn_img" src="Resources/img/i_con/search.png" alt="검색" >
                </button>


            <table class="table-hover">
                <thead>
                    <tr class="table-success">
                        <th>저자번호</th>
                        <th>이름</th>
                        <th>출생년도</th>
                        <th>수상내역</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="primary">
                        <td>012121</td>
                        <td>김철수</td>
                        <td>1955</td>
                        <td>데이터데이터데이터데이터데이터데이터데이터데이터</td>                        
                    </tr>
                    <tr>
                        <td>데이터</td>
                        <td>데이터</td>
                        <td>데이터</td>
                        <td>데이터</td>
                    </tr>
                    <tr>
                        <td>데이터</td>
                        <td>데이터</td>
                        <td>데이터</td>
                        <td>데이터</td>
                    </tr>
                    <tr>
                        <td>데이터</td>
                        <td>데이터</td>
                        <td>데이터</td>
                        <td>데이터</td>
                    </tr>
            </tbody>
            </table>
    
    
        <!-- -----------------------페이저----------------------------- -->
        <ul class="pagination justify-content-center" style="margin:20px 0">
  			 <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
  			 <li class="page-item"><a class="page-link" href="#">1</a></li>
 			 <li class="page-item"><a class="page-link" href="#">2</a></li>
 			 <li class="page-item"><a class="page-link" href="#">3</a></li>
 			 <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
		</ul>

    
    
    
    
        <!-- ----------------------- 등록/수정 버튼 ----------------------------- -->
        <div id="b2">
            <!-- <div style="text-align: center;">
                <button type="submit" class="btn1">&nbsp;&nbsp;&nbsp;&nbsp;상품 조회&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                <i class="fas fa-chevron-down"></i>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <i class="fas fa-chevron-up"></i>
                <button type="submit" class="btn1">상품 등록/수정</button>
            </div> -->
        </div>
    
        <div id="bottom">
            <div id="btt1">
                <h2>저자 정보</h2>
                <br>
                저자 번호 : <span>1212</span><br>
                저자 이름 : <span>김철수</span><br>
                출생년도 : <span>1995</span><br>
                수상내역 :<span>가나다라마바사, 아자차카타파하상, 세종문학상</span><br>
                <br><div id="hrr"></div><br>
                <h3><저서></h4>
                <p>저서제목 출판사 출판일 </p>
                <p>저서제목 출판사 출판일 </p>
                <p>저서제목 출판사 출판일 </p>
            </div>
            <div id="btt2">
                <div id="addWrap">
                    <h3>저서 추가/수정/삭제</h3>
                        <table class="table-hover" id="addtb">
                            <tr>
                                <th>저서 제목</th>
                                <th>출판사</th>
                                <th>출판일</th>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                        <div id="b2">
                            <div style="text-align: center;">
                                <button type="submit" class="btn1">&nbsp;&nbsp;&nbsp;&nbsp;상품 조회&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                                <i class="fas fa-chevron-down"></i>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <i class="fas fa-chevron-up"></i>
                                <button type="submit" class="btn1">상품 등록/수정</button>
                            </div>
                        </div>
                        <div id="del">
                            <button type="submit" class="btn1">상품 삭제</button>
                        </div>
                        <table class="table-hover" id="addtb">
                            <tr>
                                <th>저서 제목</th>
                                <th>출판사</th>
                                <th>출판일</th>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                        
                </div>
            </div>
        </div><!-- bottom 끝 -->

        </div> <!-- main2 끝 -->
    
    </div>

    <br><br><br><br>
<%@ include file="../Common/a_footer.jsp" %>
</body>
</html>

    