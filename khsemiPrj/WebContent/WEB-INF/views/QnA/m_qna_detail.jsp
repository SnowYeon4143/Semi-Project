<%@page import="com.dev.qna.model.vo.QnaAnswersVo"%>
<%@page import="com.dev.qna.model.vo.QnaVo"%>
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
    <link rel="stylesheet" href="Resources/css/QnA/m_qna_detail.css">
    
    <!-- 공용으로 쓰는 부트스트랩 -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    
    <script src="https://kit.fontawesome.com/d088eb3922.js" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
    <!-- 기존에 쓰던 부트스트랩 -->
    <!-- <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	  <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
	
</head>

<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
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
	<div class="container">
  <div class="bbiv">
    <div class="">
        <a href="home" class="breadcrumbtext"><img id="home_icon" src="Resources/img/i_con/home_icon.png" alt="홈아이콘"></a> > 
        <a href="qna" class="breadcrumbtext">게시판</a> >
        <a href="qna" class="breadcrumbtext">Q&A</a> >
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
            <caption>Q&A</caption>
              <colgroup>
                  <col width="15%">
                  <col width="35%">
                  <col width="15%">
                  <col width="*">
              </colgroup>
            <input id="qnaNo" name="qnaNo" type="text" value="${q.qnaNo}" style="display: none;">
            <table class="board_view table" id="qna">
              <tbody>
                <tr>
                  <th style="width: 8%;">제목</th>
                  <td id="title" colspan="5">${q.qnaTitle}</td>
                </tr>
                <tr>
                  <th>작성일</th>
                  <td id="date"><fmt:formatDate value="${q.qnaDate}" pattern="yy.MM.dd"/></td>
                  <th style="width: 10%;">작성자</th>
                  <td id="author">${q.qnaId}</td>
                  <th style="width: 10%;">조회수</th>
                  <td id="view">${q.qnaView}</td>
                </tr>
                <tr>
                  <td id="content" colspan="6">
                    ${q.qnaContent}
                  </td>
                </tr>
              </tbody>
          </table>
          <br>
          <a href="qna"><button class="btn btn-primary" style="background-color: #666666; border-color: #666666;">목록으로</button></a>
          <c:set var="user" value="${loginUser}"></c:set>
          <% 
          		if(session.getAttribute("loginUser") != null) {
          			MemberVo member = (MemberVo)session.getAttribute("loginUser");
              		id = member.getUserId();
          		}
          		
          		QnaVo qna = (QnaVo)request.getAttribute("q");
          		String msg = (String)request.getAttribute("msg");
          		String qnaId = qna.getQnaId();
          		System.out.println(msg);
          %>
	      
	      <%-- 글 작성자의 id와 세션에 로그인된 id 값이 같거나 어드민인 경우에만 수정및 삭제 가능  --%>
	      <% if(id.equals(qnaId) || id.equals("admin")) { %>
	      		<a href="qnaupdate?qnaNo=${q.qnaNo}&qnaTitle=${q.qnaTitle}&qnaContent=${q.qnaContent}"><button class="btn btn-primary" style="float: right;">수정</button></a>
          		<a href="qnadelete?qnaNo=${q.qnaNo}"><button class="btn btn-primary" style="float: right; background-color: #d31c1c; border-color: #d31c1c;">삭제</button></a>
		  <% } %>
		  <a href="qnadtreport?qnaNo=${q.qnaNo}" style="float: right; text-decoration: none; color:red"><i class="fas fa-exclamation-triangle">신고</i></a>
          <hr>
          <h4>답변</h4>
			
          <% if(msg == "yes") { %>
          	<table class="table table-borderless">
            	<thead>
              		<tr>
                		<th colspan="2" width="80%">관리자</th>
                		<!-- <th></th> -->
                		<th><fmt:formatDate value="${a.ansDate}" pattern="yy.MM.dd"/>
                		<% if(id.equals("admin")) { %>
                		<a href="answersdelete?qnaNo=${q.qnaNo}"><button type="button" class="btn btn-danger">삭제</button></a>
                		<% } %>
                		</th>
              		</tr>
            	</thead>
            	<tbody> 
              		<tr>
                		<td colspan="2">${a.ansContent}</td>
                		<td><button class="btn" onclick="likeUp();"><i id="likeicon" class="far fa-thumbs-up fa-2x">+<span id="answerslike">${a.answersLike}</span></i></button></td>
              		</tr>
            	</tbody>
          	</table>
          <% } else if(msg == "no") { %>
          	<h6>아직 답변이 등록되지 않았습니다.</h6>
          <% } %>
          
          <%-- 어드민인 경우에만 답변 등록 가능, 답변이 이미 달린 질문엔 답변 불가  --%>
	      <% if(id.equals("admin") && msg=="no") {%>
	      	<form action="answers" method="post">
	      		<%-- qna번호 전달용 input --%>
	      		<input name="qnaNo" type="text" value="${q.qnaNo}" style="display: none">
            	<textarea name="coment" id="coment" cols="10" rows="5" placeholder="답변을 등록해주세요."></textarea>
            	<input id="submit" type="submit" class="btn btn-primary" value="답변 등록">
          	</form>
	      <%} %>
          </div>
        
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

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <script>
    	function likeUp() {
    		$.ajax({
    			url : "/devbooks/qnalike",
    			method : "GET",
    			data : {qnaNo : $("#qnaNo").val()},
    			success : function(like) {
    				$("#answerslike").text(like);
    				$("#likeicon").attr('class','fas fa-thumbs-up fa-2x');
    			},
    			error : function(like){
    				alert("error");
    			},
				complete : function(like){
					console.log("complete : " + result);
				}
    		});
    	}	
    </script>
    
   <% if(id.equals("admin")) { %>
        <%@ include file="../Common/a_footer.jsp" %>
    <% } else if(session.getAttribute("loginUser") != null) { %>
        <%@ include file="../Common/u_footer.jsp" %>
    <% } %>
</body>
</html>