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
  <div class="input_box">
    <form action="delete?contentPage=delete" method = "post">
      <div class = "search-title">
        <h3>회원 탈퇴 페이지</h3>
      </div>
    <section class = "form-search">
      <div class = "find-name">
      	<label>${loginUser.userId} 님 탈퇴를 원하시면</label>
      	<br>
        <label>비밀번호를 입력하세요.</label>
        <br>
        <input type="text" name="userPwd" class = "btn-name" placeholder = "비밀번호 입력">
      </div>
    </section>
      <br>
    <div class ="btnSearch">
      <input type="submit" name="enter" value="탈퇴">
      <a href="changeInfo.do"><input type="button" name="cancle" value="취소"></a>
    </div>
    </form>
  </div>
  <br>
</body>
</html>