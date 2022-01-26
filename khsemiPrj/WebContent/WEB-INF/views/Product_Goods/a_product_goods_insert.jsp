<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script> 

    <!-- 아이콘 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <!-- css -->
     <link rel="stylesheet" href="Resources/css/Product_Goods/a_product_goods_insert.css">


</head>
<body>
<%@ include file="../Common/a_menubar.jsp" %>


    <div id="route">
        <img id="home_icon"src="Resources/img/i_con/home_icon.png" alt="">
        <div id="aa">
            <!-- <a href="" id="route">홈</a>  -->
            &nbsp; > 
            <a href="" id="tt">상품관리_굿즈</a>
        </div>
    </div>


    <div id="main">
        <div id="side">
            <h2>굿즈 관리</h2>
            <br><div id="hrr"></div><br>
            <a id="a" href="gcon1"><h3>굿즈 등록</h3></a>
            <a id="a" href="gcon2"><h3>굿즈 수정/삭제</h3></a>
        </div>
        <div id="main2">
            <form action="gcon1" method="post" enctype="multipart/form-data">
                <h3>굿즈 등록</h3>
                <div id="mainR">
                    <table>
                        <tr>
                            <td>상품이름</td>
                            <td><input type="text" name="pro_name"></td>
                        </tr>
                        <tr>
                            <td>단가</td>
                            <td><input type="text" name="unit_price"></td>
                        </tr>
                        <tr>
                            <td>재고</td>
                            <td><input type="text" name="stock"></td>
                        </tr>
                        <tr>
                            <td>카테고리</td>
                            <td>
                                <select name="category" style="width: 100%; font-size: small;">
                                    <option value="생활용품">생활용품</option>
                                    <option value="문구">문구</option>
                                    <option value="전자">전자</option>
                                    <option selected>-------------</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>이미지</td>
                            <td><input type="file" accept="image/jpeg,.png" name="goodsimg"></td>
                        </tr>
                       <tr>
                            <td>상품설명</td>
                            <td><input type="file" accept="image/jpeg,.png" name="goodsinf"></td>
                       </tr>
                    </table>                
                </div>
                <div id="mainL">
                    <table>
        <tr>
            <td>제조사</td>
            <td><input type="text" name="maker"></td>
        </tr>
        <tr>
            <td>원산지</td>
            <td><input type="text" name="country"></td>
        </tr>
    </table>
                </div>
                <div id="btn">
                    <input class="btn btn-outline-secondary btn-lg" type="submit" value="등록" id="submit">
                </div>
            </form>
        </div><!-- main2 -->
    </div>




    <br><br><br><br>
 <%@ include file="../Common/a_footer.jsp" %>
</body>
</html>

    