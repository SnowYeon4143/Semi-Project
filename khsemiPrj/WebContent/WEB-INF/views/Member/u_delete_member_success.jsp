<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dev.member.model.vo.MemberVo"%>
<%@page import="com.dev.member.model.dao.MemberDao"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 탈퇴</title>

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

    <style>
        body {
            background-color: #EEEEEE !important;
        }

        .input_box {
            background-color: white;
            border-radius: 1.5em;
            border: 2px solid black;
            width: 900px;
            height: 500px;
            margin: auto;
            margin-top: 150px;
        }

        h3 {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 20vh;
        }

        .form-search {
          position: relative;
          left : 330px;
        }

        .btnSearch {
          position: relative;
          left : 408px;
        }
    </style>
</head>
<body>
	 <%
        String id = (String)session.getAttribute("loginUser"); 
        String pwd = request.getParameter("userPwd");
        
        // 세션에서 아이디를, DeleteForm.jsp에서 입력받은 비밀번호를 가져온다.
        // 가져온 결과를 가지고 회원정보를 삭제한다. - 삭제결과를 반환
        MemberDao dao = MemberDao.getInstance();
        int check = dao.deleteMember(id, pwd);
        
        if(check == 1){
            session.invalidate(); // 삭제했다면 세션정보를 삭제한다.
    %>

  <div class="input_box">
      <div class = "search-title">
        <h3>회원정보가 삭제되었습니다.</h3>
      </div>
      <br>
    <div class ="btn">
      <a href="home"><input type="submit" name="enter" value="확인"></a>
    </div>
  </div>
  <br>
    <%    
         // 비밀번호가 틀릴경우 - 삭제가 안되었을 경우
        }else{
    %>
        <script>
            alert("비밀번호가 맞지 않습니다.");
            history.go(-1);
        </script>
    <%
        } 
    %>
</body>
</html>