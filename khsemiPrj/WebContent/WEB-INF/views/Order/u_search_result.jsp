<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="Resources/css/Order/u_search_result.css">

    <!-- 기존에 쓰던 부트스트랩 -->
    <!-- <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->

    <!-- 공용으로 사용할 부트스트랩 -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <style>
		#home_icon {
    		width: 23px;
    		height: 21px;
  		}
  		 .bbiv {
        	position: relative;
        	left: 30px;
        	top: 10px;
        	padding-bottom: 20px;
    	}
	</style>
</head>

<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<%@ include file="../Common/u_menubar.jsp" %>
<div class="container">
<div class="row">
  <div class="bbiv">
    <div class="">
        <a href="#" class="breadcrumbtext"><img id="home_icon" src="Resources/img/i_con/home_icon.png" alt="홈아이콘"></a> > 
        <a href="#" class="breadcrumbtext">검색결과</a>
    </div>
  </div>
  
  <div class="col-md-12">
    <div class="grid search">
      <div class="grid-body">
        <div class="row">
          <!-- BEGIN FILTERS -->
          <div class="col-md-3">
            <h2 class="grid-title"><i class="fa fa-filter"></i> 필터</h2>
            <hr>
            <!-- BEGIN FILTER BY CATEGORY -->
            <h4>카테고리:</h4>
            <div class="checkbox">
              <label><input type="checkbox" class="icheck"> 프로그래밍 언어</label>
            </div>
            <div class="checkbox">
              <label><input type="checkbox" class="icheck"> 엑셀 / 활용서</label>
            </div>
            <div class="checkbox">
              <label><input type="checkbox" class="icheck"> it자격증</label>
            </div>
            <div class="checkbox">
              <label><input type="checkbox" class="icheck"> 딥러닝</label>
            </div>
            <div class="checkbox">
              <label><input type="checkbox" class="icheck"> 머신러닝</label>
            </div>
            <div class="checkbox">
              <label><input type="checkbox" class="icheck"> 인공지능</label>
            </div>
            <div class="checkbox">
              <label><input type="checkbox" class="icheck"> 안드로이드</label>
            </div>
            <div class="checkbox">
              <label><input type="checkbox" class="icheck"> 유니티</label>
            </div>
            <!-- END FILTER BY CATEGORY -->
            
            <div class="padding"></div>
            
            <!-- BEGIN FILTER BY DATE -->
            <h4>날짜 검색:</h4>
            From
            <div class="input-group date form_date" data-date="2014-06-14T05:25:07Z" data-date-format="dd-mm-yyyy" data-link-field="dtp_input1">
              <input type="text" class="form-control">
              <span class="input-group-addon bg-blue"><i class="fa fa-th"></i></span>
            </div>
            <input type="hidden" id="dtp_input1" value="">
            
            To
            <div class="input-group date form_date" data-date="2014-06-14T05:25:07Z" data-date-format="dd-mm-yyyy" data-link-field="dtp_input2">
              <input type="text" class="form-control">
              <span class="input-group-addon bg-blue"><i class="fa fa-th"></i></span>
            </div>
            <input type="hidden" id="dtp_input2" value="">
            <!-- END FILTER BY DATE -->
            
            <div class="padding"></div>
            
            <!-- BEGIN FILTER BY PRICE -->
            <!-- <h4>금액 검색:</h4>
            Between <div id="price1">$300</div> to <div id="price2">$800</div>
            <div class="slider-primary">
              <div class="slider slider-horizontal" style="width: 152px;"><div class="slider-track"><div class="slider-selection" style="left: 30%; width: 50%;"></div><div class="slider-handle round" style="left: 30%;"></div><div class="slider-handle round" style="left: 80%;"></div></div><div class="tooltip top hide" style="top: -30px; left: 50.1px;"><div class="tooltip-arrow"></div><div class="tooltip-inner">300 : 800</div></div><input type="text" class="slider" value="" data-slider-min="0" data-slider-max="1000" data-slider-step="1" data-slider-value="[300,800]" data-slider-tooltip="hide"></div>
            </div> -->
            <!-- END FILTER BY PRICE -->
          </div>
          <!-- END FILTERS -->
          <!-- BEGIN RESULT -->
          <div class="col-md-9">
            <h2><span style="color: #c0392b;">"프로그래밍"</span> 검색결과</h2>
            <hr>
            <!-- BEGIN SEARCH INPUT -->
            
            <!-- END SEARCH INPUT -->
            
            <div class="padding"></div>
            
            <div class="row">
              <!-- BEGIN ORDER RESULT -->
              <div class="col-sm-6">
                <div class="btn-group">
                  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    정렬 <span class="caret"></span>
                  </button>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">이름순</a></li>
                    <li><a href="#">날짜순</a></li>
                    <li><a href="#">구매순</a></li>
                    <li><a href="#">평점순</a></li>
                  </ul>
                </div>
              </div>
              <!-- END ORDER RESULT -->
              
              <div class="col-md-6 text-right">
                <div class="btn-group">
                  <!-- <button type="button" class="btn btn-default active"><i class="fa fa-list"></i></button>
                  <button type="button" class="btn btn-default"><i class="fa fa-th"></i></button> -->
                </div>
              </div>
            </div>
            
            <!-- BEGIN TABLE RESULT -->
            <div class="table-responsive">
              <table class="table table-hover">
                <tbody><tr>
                  <td class="number text-center">1</td>
                  <td class="image"><img src="https://via.placeholder.com/400x300/FF8C00" alt=""></td>
                  <td class="product"><strong>상품 1번</strong>
                  <br>홍길동 지음 | 책나무퍼블리싱 | 2021년 12월
                  <br>주제별 > 프로그래밍 언어</td>
                  <td class="price text-right">30,000원</td>
                  <td class="price text-right"><button type="button" class="btn btn-primary">장바구니</button></td>
                </tr>
                <tr>
                  <td class="number text-center">2</td>
                  <td class="image"><img src="https://via.placeholder.com/400x300/5F9EA0" alt=""></td>
                  <td class="product"><strong>상품 2</strong><br>홍길동 지음 | 책나무퍼블리싱 | 2021년 12월
                    <br>주제별 > 프로그래밍 언어</td>
                    <td class="price text-right">30,000원</td>
                    <td class="price text-right"><button type="button" class="btn btn-primary">장바구니</button></td>
                </tr>
                <tr>
                  <td class="number text-center">3</td>
                  <td class="image"><img src="https://via.placeholder.com/400x300" alt=""></td>
                  <td class="product"><strong>Product 3</strong><br>홍길동 지음 | 책나무퍼블리싱 | 2021년 12월
                    <br>주제별 > 프로그래밍 언어</td>
                    <td class="price text-right">30,000원</td>
                    <td class="price text-right"><button type="button" class="btn btn-primary">장바구니</button></td>
                </tr>
                <tr>
                  <td class="number text-center">4</td>
                  <td class="image"><img src="https://via.placeholder.com/400x300/8A2BE2" alt=""></td>
                  <td class="product"><strong>상품 4</strong><br>홍길동 지음 | 책나무퍼블리싱 | 2021년 12월
                    <br>주제별 > 프로그래밍 언어</td>
                    <td class="price text-right">30,000원</td>
                    <td class="price text-right"><button type="button" class="btn btn-primary">장바구니</button></td>
                </tr>
                <tr>
                  <td class="number text-center">5</td>
                  <td class="image"><img src="https://via.placeholder.com/400x300" alt=""></td>
                  <td class="product"><strong>상품 5</strong><br>홍길동 지음 | 책나무퍼블리싱 | 2021년 12월
                    <br>주제별 > 프로그래밍 언어</td>
                    <td class="price text-right">30,000원</td>
                    <td class="price text-right"><button type="button" class="btn btn-primary">장바구니</button></td>
                </tr>
                <tr>
                  <td class="number text-center">6</td>
                  <td class="image"><img src="https://via.placeholder.com/400x300/6495ED" alt=""></td>
                  <td class="product"><strong>상품 6</strong><br>홍길동 지음 | 책나무퍼블리싱 | 2021년 12월
                    <br>주제별 > 프로그래밍 언어</td>
                    <td class="price text-right">30,000원</td>
                    <td class="price text-right"><button type="button" class="btn btn-primary">장바구니</button></td>
                </tr>
                <tr>
                  <td class="number text-center">7</td>
                  <td class="image"><img src="https://via.placeholder.com/400x300/DC143C" alt=""></td>
                  <td class="product"><strong>상품 7</strong><br>홍길동 지음 | 책나무퍼블리싱 | 2021년 12월
                    <br>주제별 > 프로그래밍 언어</td>
                    <td class="price text-right">30,000원</td>
                    <td class="price text-right"><button type="button" class="btn btn-primary">장바구니</button></td>
                </tr>
                <tr>
                  <td class="number text-center">8</td>
                  <td class="image"><img src="https://via.placeholder.com/400x300/9932CC" alt=""></td>
                  <td class="product"><strong>상품 8</strong><br>홍길동 지음 | 책나무퍼블리싱 | 2021년 12월
                    <br>주제별 > 프로그래밍 언어</td>
                    <td class="price text-right">30,000원</td>
                    <td class="price text-right"><button type="button" class="btn btn-primary">장바구니</button></td>
                </tr>
              </tbody></table>
            </div>
            <!-- END TABLE RESULT -->
            
            <!-- BEGIN PAGINATION -->
            <ul class="pagination">
              <li class="page-item"><a class="page-link" href="#"> << </a></li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item"><a class="page-link" href="#"> >> </a></li>
            </ul>
            <!-- END PAGINATION -->
          </div>
          <!-- END RESULT -->
        </div>
      </div>
    </div>
  </div>
  <!-- END SEARCH RESULT -->
</div>
</div>

    
    <script type="text/javascript">
    
    </script>
    
    <%@ include file="../Common/u_footer.jsp" %>
</body>
</html>