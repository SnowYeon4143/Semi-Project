<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>a6_3_QnA신고</title>
	<link rel="stylesheet" href="./Resources/css/QnA/a_qna_report.css">
	
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

	<%@ include file="../Common/a_menubar.jsp" %>
	
    <div class="home">
        <a href="adminHome"><img src="Resources/img/i_con/home_icon.png" id="icon3"></a>
        <label> > </label>
        <a href="#" id="gs">QnA_신고리스트</a>
    </div>

    <br><br><br><br>
    <h2>QnA_신고 리스트</h2>
    <br>

    <form>
        <div>
        	<hr>
			<c:forEach items="${qnaList}" var="q">
				<table>
                <tr>
                    <th></th>
                    <th id="lab1"> 

                        <br>
                        <label >작성날짜 : <fmt:formatDate value="${q.qnaDate}" pattern="yy.MM.dd" /></label>
                        <br>
                        <label >작성자 : ${q.qnaId}</label>

                        <br><br>
                        <label><b>${q.qnaTitle}</b></label>
                        <br>

                        <label> 
                            ${q.qnaContent}
                        </label>

                        <a href="reportcancel?qnaNo=${q.qnaNo}"><input type="button" id="btn1" value="신고취소"></a>
                        <a href="qnareportdelete?qnaNo=${q.qnaNo}"><input type="button" id="btn2" value="삭제"></a>
                    </th>
                </tr>
            </table>

            <br><br>
            <hr>
            <br>
			</c:forEach>
        </div>
    </form>
    
    <br><br>
    
    <!-- BEGIN PAGINATION -->
            <ul class="pagination">
                <li class="page-item"><a id="prePage" class="page-link" > < </a></li>
	            	<c:forEach var="i" begin="${page.startNo()}" end="${page.endNo()}">
	            		<li class="page-item"><a name="currentPage" class="page-link" href="qnareport?currentPage=${i}" value="${i}">${i}</a></li>
		            </c:forEach>
                <li class="page-item"><a class="page-link" href="qnareport?currentPage=${page.nextPage() }"> > </a></li>
             </ul>
            <!-- END PAGINATION -->
    
    <%@ include file="../Common/a_footer.jsp" %>
    
</body>
</html>