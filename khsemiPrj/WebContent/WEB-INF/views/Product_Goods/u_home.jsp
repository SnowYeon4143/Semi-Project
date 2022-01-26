<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dev.member.model.vo.MemberVo" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
/* Make the image fully responsive */
.carousel-inner img {
  width: 100%;
  height: 100%;
}
</style>


<link rel="stylesheet" href="Resources/css/Product_Goods/u_home.css">

</head>
<body>
<%
    String id = "";
    if(session.getAttribute("loginUser") != null) {
        MemberVo member = (MemberVo)session.getAttribute("loginUser");
        id = member.getUserId();
    }
%>

<% if(id.equals("admin")) { %>
    <%@ include file="../Common/a_menubar.jsp" %>
<% } else if(session.getAttribute("loginUser") != null) { %>
    <%@ include file="../Common/u_menubar_login.jsp" %>
<% } else if(session.getAttribute("loginUser") == null) { %>
    <%@ include file="../Common/u_menubar.jsp" %>
<% } %>
<div class="parallax"> 
  <div id="aa">
    <div id="bb">
      <div id="bb1"><img src="Resources/img/Logo/로고 사진 연그레이.png" id="icon">DEV BOOKS</div>
        <div id="bb2">
          IT인을 위한 온라인 북 스토어<br>
            다양한 IT 서적을 찾고 계신가요?<br>
            방대한 종류의 IT 자격증 서적과<br>
            전문적인 개발자들을 위한 프로그래밍 서적까지,<br>
            오직 IT인들을 위한 온라인 북 스토어<br>
            <span style="font-size: 45px;">DEV BOOKS 입니다.</span><br>
        </div>
    </div>
  </div> 
</div>

<div class="parallax">
  <div style="width:100%; height: 200px;"></div>

<!-- --------------------------------- carousel---------------------------------  -->

<div class="col-sm-5" id="wrap">
    <div id="demo" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active" ></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
      </ul>
      
      <!-- The slideshow -->
      <div class="carousel-inner row">
        <div class="carousel-item active">
          <div id="slide1">
            <div id="img">
                <div id="numbertext">1 / 3</div>
                <img id="book" src="Resources/img/Bookcover/자바의정석.JPG">
                <div id="txt">
                  <h3>MD 추천</h3>
                  <h4>자바의 정석</h4>
                  <span>남궁성 | 강산북스 | 27000원 <br><br>
                    자바의 정석</span>
                </div>
              </div><!-- img -->
          </div>
        </div>
        <div class="carousel-item">
          <div id="slide1">
            <div id="img">
                <div id="numbertext">2 / 3</div>
                <img id="book" src="Resources/img/Bookcover/몰입.JPG">
                <div id="txt">
                  <h3>MD 추천</h3>
                  <h4>자바의 정석</h4>
                  <span>남궁성 | 강산북스 | 27000원 <br><br>
                    자바의 정석</span>
                </div>
              </div><!-- img -->
            </div>
        </div>
        <div class="carousel-item">
          <div id="slide1">
            <div id="img">
                <div id="numbertext">3 / 3</div>
                <img id="book" src="Resources/img/Bookcover/it지식.JPG">
                <div id="txt">
                  <h3>MD 추천</h3>
                  <h4>자바의 정석</h4>
                  <span>남궁성 | 강산북스 | 27000원 <br><br>
                    자바의 정석</span>
                </div>
              </div><!-- img -->
            </div>
        </div>
      </div>
      
      <!-- Left and right controls -->
      <a class="carousel-control-prev" id="right" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
      </a>
      <a class="carousel-control-next" id="left" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
      </a>
    </div>

</div><!-- wrap -->
<div id="bg"></div>

        <%@ include file="../Common/u_footer.jsp" %>

</body>
</html>
    