<%@page import="com.dev.member.model.vo.MemberVo"%>
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
    <title>Document</title>
    <link rel="stylesheet" href="Resources/css/QnA/m_notice_detail.css" type="text/css">
    
    <!-- 공용으로 쓰는 부트스트랩 -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

    <!-- 기존에 쓰던 부트스트랩 -->
    <!-- <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	  <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->

    <style>
        #bdTitle {
            margin-bottom: 7px;
        }
    </style>
</head>

<body>
	<% String id = "";
	if (session.getAttribute("loginUser") != null) {
		MemberVo member = (MemberVo) session.getAttribute("loginUser");
		id = member.getUserId();
	} %>

	<% if (id.equals("admin")) { %>
	<%@ include file="../Common/a_menubar.jsp"%>
	<% } else if (session.getAttribute("loginUser") != null) { %>
	<%@ include file="../Common/u_menubar_login.jsp"%>
	<% } else if (session.getAttribute("loginUser") == null) { %>
	<%@ include file="../Common/u_menubar.jsp"%>
	<% } %>

	<div class="container">
<div class="row">
  <!-- BEGIN SEARCH RESULT -->
  <div class="bbiv">
    <div class="">
        <a href="home" class="breadcrumbtext"><img id="home_icon" src="Resources/img/i_con/home_icon.png" alt="홈아이콘"></a> > 
        <a href="qna" class="breadcrumbtext">게시판</a> >  
        <a href="notice" class="breadcrumbtext">공지사항</a> >  
        <a href="#" class="breadcrumbtext">상세보기</a> 
    </div>
  </div>
  
  <div class="col-md-12">
    <div class="grid search">
      <div class="grid-body">
        <div class="row">
          <!-- BEGIN FILTERS -->
          <div class="col-md-2">
            <h2 class="grid-title"> 커뮤니티</h2>
            <hr>
            
            <!-- BEGIN FILTER BY CATEGORY -->
            <a class="community" href="notice"><h4>공지사항</h4></a>
            <a class="community" href="qna"><h4>Q&A</h4></a>
            <a class="community" href="event"><h4>이벤트</h4></a>
            <!-- END FILTER BY CATEGORY -->
            
            <div class="padding"></div>
            
            <div class="padding"></div>
            
          </div>
          <!-- END FILTERS -->
          <!-- BEGIN RESULT -->
          <div class="col-md-10">
            <h2>상세보기</h2>
            <caption>공지사항</caption>
              <colgroup>
                  <col width="15%">
                  <col width="35%">
                  <col width="15%">
                  <col width="*">
              </colgroup>
            <table class="board_view table">
              <tbody>
                <tr>
                  <th style="width: 8%;">제목</th>
                  <td id="title" colspan="5">${n.noticeTitle}</td>
                </tr>
                <tr>
                  <th>작성일</th>
                  <td id="date"><fmt:formatDate value="${n.noticeDate}" pattern="yy.MM.dd"/></td>
                  <th style="width: 10%;">작성자</th>
                  <td id="author">관리자</td>
                  <th style="width: 10%;">조회수</th>
                  <td id="view">${n.noticeView}</td>
                </tr>
                <tr>
                  <td id="content" colspan="6">
                    ${n.noticeContent}
                  </td>
                </tr>
              </tbody>
          </table>
          <br>
          <a href="notice"><button class="btn btn-primary" style="background-color: #666666; border-color: #666666;">목록으로</button></a>
          <% if(id.equals("admin")) { %>
          <a href="noticeupdate?noticeNo=${n.noticeNo}&noticeTitle=${n.noticeTitle}&noticeContent=${n.noticeContent}"><button class="btn btn-primary" style="float: right;">수정</button></a>
          <a href="noticedelete?noticeNo=${n.noticeNo}"><button class="btn btn-primary" style="float: right; background-color: #d31c1c; border-color: #d31c1c;">삭제</button></a>
          <% } %>
          <hr>
        <!-- <hr/> -->
            <!-- END TABLE RESULT -->
            <!-- BEGIN PAGINATION -->

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
    
	<% if(id.equals("admin")) { %>
        <%@ include file="../Common/a_footer.jsp" %>
    <% } else if(session.getAttribute("loginUser") != null) { %>
        <%@ include file="../Common/u_footer.jsp" %>
    <% } %>
</body>
</html>