<%@page import="java.util.List"%>
<%@page import="com.dev.order.vo.OrderListVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="co"%>
    
    <%
    	List<OrderListVo> dataList = (List<OrderListVo>)request.getAttribute("data");
    %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>u12_주문내역조회</title>
	<link rel="stylesheet" href="./Resources/css/Order/u_order_list.css">
	
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

	<%@ include file="../Common/u_menubar.jsp" %>

    <form>
        <div class="src">
            <a href="#"><img src="Resources/img/i_con/home_icon.png"id="icon3"></a>
            <label> > </label>
            <a href="#" id="mypage">마이페이지</a>
            <label> > </label>
            <a href="#" id="ordercheck">주문내역조회</a>
        </div>

<%
int totamt = 0;
int i = 0;
   for(OrderListVo l : dataList)
   {
   	int pro_no = l.getPro_no();
   	String pro_img = l.getPro_img();
  		String pro_name = l.getPro_name();
  		int unit_price = l.getUnit_price();
  		int quantity = l.getQuantity();
  		int amt = l.getAmt();
  		totamt = totamt + amt;
%>	

		
        <table class="t1" >
            <tr >
                <th colspan="3"></th>
                <th id="cg">출고준비</th>
                <th></th>
                <th></th>
                <th id="ordate1" colspan="2">주문일자 : 2021/12/15</th>
                <th id="ordate2">배송지 : 강원도 춘천시</th>
                <th></th>
            </tr>

            <tr>
                <td id="gc1-3"></td>
                <td id="gc1-2" ><img src="Resources/img/Bookcover/자바의정석.JPG" id="img"></td>
                <td id="gc1-2" ></td>
                <td id="gc1-2" colspan="2"></td>
                <td id="gc1-2"></td>
                <td id="gc1-5" colspan="2"></td>
                <td id="gc1-3"></td>
                
            </tr>

            <tr>
                <td id="gc1-2" colspan="3"></td>
                <td id="gc" colspan="2"><b>자바의 정석</b> (외3)</td>
                <td id="gc1-2"></td>
                <td id="gc1-2"></td>
                <td id="gc">89,000￦</td>
                <td id="gc1-3"></td>
            </tr>

            <tr>
                <td id="gc1-2" colspan="3"></td>
                <td id="bg" colspan="2">· 자바의 정석</td>
                <td id="bg"></td>
                <td id="bg">1권</td>
                <td id="bg">32,000￦</td>
                <td id="gc1-2" colspan="3"></td>
            </tr>

            <tr>
                <td id="gc1-2" colspan="3"></td>
                <td id="bg" colspan="2">· SQL의 정석</td>
                <td id="bg"></td>
                <td id="bg">1권</td>
                <td id="bg">25,000￦</td>
                <td id="gc1-2" colspan="3"></td>
            </tr>

            <tr>
                <td id="gc1-2" colspan="3"></td>
                <td id="bg" colspan="2">· DO IT! Java</td>
                <td id="bg"></td>
                <td id="bg">1권</td>
                <td id="bg">32,000￦</td>
                <td id="gc1-2" colspan="3"></td>
            </tr>
            
<%
	i = i +1;
   }
%> 

            <tr>
                <td id="gc1-4" colspan="9"></td>
                <!-- <td id="gc1-4" ></td>
                <td id="gc1-4" ></td>
                <td id="gc1-4" ></td>
                <td id="gc1-4" ></td>
                <td id="gc1-4" colspan="3" ></td> -->
            </tr>
        </table>

        <br><br>

        <table class="t2" >
            <tr >
                <th colspan="3"></th>
                <th id="cg">배송 중</th>
                <th></th>
                <th></th>
                <th id="ordate1" colspan="2">주문일자: 2021-12-15</th>
                <th id="ordate2">배송지 : 강원도 춘천시</th>
            </tr>

            <tr>
                <td id="gc1-3"></td>
                <td id="gc1-2" ><img src="Resources/img/Bookcover/book_java4.png" id="img"></td>
                <td id="gc1-2" ></td>
                <td id="gc1-2" colspan="2"></td>
                <td id="gc1-2"></td>
               <td id="gc1-5" colspan="2"></td>
                <td id="gc1-3"></td>
                
            </tr>

            <tr>
                <td id="gc1-2" colspan="3"></td>
                <td id="gc" colspan="2"><b>코어 자바스크립트</b> (외2)</td>
                <td id="gc1-2"></td>
                <td id="gc1-2"></td>
                <td id="gc">47,000￦</td>
                <td id="gc1-3"></td>

            </tr>

            <tr>
                <td id="gc1-2" colspan="3"></td>
                <td id="bg" colspan="2">· 코어 자바 스크립트</td>
                <td id="bg"></td>
                <td id="bg">1권</td>
                <td id="bg">22,000￦</td>
                <td id="gc1-2" colspan="3"></td>
            </tr>

            <tr>
                <td id="gc1-2" colspan="3"></td>
                <td id="bg" colspan="2">· SQL의 정석</td>
                <td id="bg"></td>
                <td id="bg">1권</td>
                <td id="bg">25,000￦</td>
                <td id="gc1-2" colspan="3"></td>
            </tr>

            <tr>
                <td id="gc1-4" colspan="9"></td>
                <!-- <td id="gc1-4" ></td>
                <td id="gc1-4" ></td>
                <td id="gc1-4" ></td>
                <td id="gc1-4" ></td>
                <td id="gc1-4" colspan="3" ></td> -->
            </tr>
        </table>
    </form>
    
    <br><br><br><br><br>
    <br><br><br><br><br>
    <br><br><br><br><br>
    
  <%--<%@ include file="../Common/u_footer.jsp" %> --%>	  
</body>
</html>