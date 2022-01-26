<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="Resources/css/QnA/u_qna_write.css">
    
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
<%@ include file="../Common/a_menubar.jsp" %>
<div class="container">
<div class="row">
  <!-- BEGIN SEARCH RESULT -->
  <div class="bbiv">
    <div class="">
        <a href="home" class="breadcrumbtext"><img id="home_icon" src="Resources/img/i_con/home_icon.png" alt="홈아이콘"></a> > 
        <a href="qna" class="breadcrumbtext">게시판</a> >
        <a href="event" class="breadcrumbtext">이벤트</a> > 
        <a href="#" class="breadcrumbtext">이벤트수정</a> 
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
            <a class="community" href="event"><h4>공지사항</h4></a>
            <a class="community" href="qna"><h4>Q&A</h4></a>
            <a class="community" href="event"><h4>이벤트</h4></a>
            <!-- END FILTER BY CATEGORY -->
            
            <div class="padding"></div>
            
            <div class="padding"></div>
            
          </div>
          <!-- END FILTERS -->
          <!-- BEGIN RESULT -->
          <div class="col-md-10">
            <h2>이벤트수정</h2>
            <form action="eventupdate" method="post" enctype="multipart/form-data">
            	<input type="text" id="eventno" name="eventno" value="${eventNo}" style="display: none;">
                <input type="text" id="eventtitle" name="eventtitle" class="form-control mt-4 mb-2"
                    placeholder="제목을 입력해주세요." required value="${eventTitle}">
                <div class="form-group">
                    <textarea class="form-control" rows="10" name="eventcontent"
                        placeholder="내용을 입력해주세요" required
                    >${eventContent}</textarea>
                </div>
                이벤트 기간 : <input type="date" name="startdate" value="${eventStart}"> <h4 style="display: inline;">~</h4> <input type="date" name="enddate" value="${eventEnd}"><br>
                <br>
                <input type="file" name="eventimg"><br>
                <div class="writeBtn">
                    <a href="event"><button type="button" class="btn btn-primary" style="background-color: #6c757d; border-color: #6c757d;">취소</button></a>
                    <button type="submit" class="btn btn-primary">이벤트수정</button>
                </div>
            </form>
        
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
    <%@ include file="../Common/a_footer.jsp" %>
</body>
</html>