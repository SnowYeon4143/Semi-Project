<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dev.member.model.vo.MemberVo" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <!-- CSS 파일 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/Member/u_login.css">

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
    
    <!-- jQuery -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
    
    <style type="text/css">
    	/* 아이디 텍스트 */
		#userId {
		    position: relative;
		    top: 20px;
		    margin: auto;
		}
		
		/* 비밀번호 텍스트 */
		#userPwd {
		    position: relative;
		    top: 60px;
		    margin: auto;
		}
    </style>
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
    <!-- 위치 링크 -->
    <a href=""><img src="${pageContext.request.contextPath}/Resources/img/i_con/home_icon.png" id="home_icon"></a>
    <a href="" id="placeLink">> 로그인</a>
    <form action="login" method="post">
	    <div class="inputBox">
	        <p id="loginBox">로그인</p>
	        <br><br>
	            <div id="id" class="md-form">
	                <input type="text" name="userId" id="userId" class="form-control w-50">
	                <label for="inputId" style="position: relative; bottom: 45px;">아이디</label>
	            </div>
	            <div id="pwd" class="md-form">
	                <input type="password" name="userPwd" id="userPwd" class="form-control w-50">
	                <label for="inputPwd" style="position: relative; bottom: 5px;">비밀번호</label>
	            </div>
	            
	        <br><br><br>
	            <div id="login_Btn">
	                <a href="loginUserHome"><input type="submit" class="btn btn-primary" id="submit" value="로그인"></a>
	            </div>
	        <br>
	        <div class="find_Info">
	            <a href="idsearch" style="color: #2D313C;">아이디 찾기</a>
	            | 
	            <a href="pwdsearch" style="color: #2D313C;">비밀번호 찾기</a>
	        </div>
	        <br>
	        <div id="sign_Up">
	            <label for="" id="sign_Up">회원이 아니신가요?</label>
	            <a href="join"><strong style="font-weight: bold; color: #2D313C;">회원가입</strong></a>
	        </div>
	    </div>
    </form>
    <br><br><br><br><br><br><br><br>
    <% if(id.equals("admin")) { %>
        <%@ include file="../Common/a_footer.jsp" %>
    <% } else if(session.getAttribute("loginUser") != null) { %>
        <%@ include file="../Common/u_footer.jsp" %>
    <% } %>
</body>
</html>