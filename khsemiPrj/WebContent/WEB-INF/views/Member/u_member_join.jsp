<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <!-- CSS 파일 -->
    <!-- *이클립스 오류로 인한 css 원본 파일 불러오기 실패 -->
    <!-- *회원정보 변경 css파일로 대체하였음 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/Member/u_change_memberInfo.css">
    
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
    	/* 첫번째 이메일 입력 인풋 */
		#userEmail {
		    width: 155px !important;
		    height: 38px;
		}
		
		/* 두번째 이메일 선택 인풋 */
		#inputEmail {
		    position: relative;
		    width: 158px !important;
		    height: 38px;
		    left: 370px;
		    bottom: 117px !important;
		}
    </style>
	
	<!-- 생년월일 셀렉트 박스 -->
	<script>
	$(document).ready(function(){
	    var now = new Date(); 
	    var year = now.getFullYear();
	    var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1);
	    var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate());

	    //년도 selectbox
	    for(var i = 1900 ; i <= year ; i++) {
	        $('#year').append('<option value="' + i + '">' + i + '년</option>');
	    }

	    // 월별 selectbox
	    for(var i=1; i <= 12; i++) {
	        var mm = i > 9 ? i : "0"+i ; $('#month').append('<option value="' + mm + '">' + mm + '월</option>');
	    }

	    // 일별 selectbox
	    for(var i=1; i <= 31; i++) {
	        var dd = i > 9 ? i : "0"+i ;
	        $('#day').append('<option value="' + dd + '">' + dd+ '일</option>');
	    }

	$("#year > option[value="+year+"]").attr("selected", "true");
	$("#month > option[value="+mon+"]").attr("selected", "true");
	$("#day > option[value="+day+"]").attr("selected", "true");

	})
	</script>
</head>
<body>
	<%@ include file="../Common/u_menubar.jsp" %>
     <!-- 위치 링크 -->
    <a href="home"><img src="${pageContext.request.contextPath}/Resources/img/i_con/home_icon.png" id="home_icon"></a>
    <a href="login" id="placeLink">> 로그인</a>
    <a href="join" id="placeLink">> 회원가입</a>
    <div id="inputBox">
        &nbsp;<h1>DEV BOOKS 회원가입</h1>
        <hr color ="#787878" width="90%" height="2px">
        &nbsp;<h3>기본 정보</h3>
        <form action="join" method="post">
            <div id="user_Info" class="col-xs-3">
                <ul class="wright_info">
                    <p class="text_info">아이디</p>
                    <input type="text" class="form-control box_size" name="userId" id="userId" placeholder="영문자, 숫자를 포함하여 총 4 ~ 12자로 입력." required>
                    <input type="button" name="dupCheck" id="dupCheck" class="form-control box_size" value="중복 확인">
                </ul>
                <ul class="wright_info" style="position: relative; left: 0px; bottom: 40px;">
                    <p class="text_info">비밀번호</p>
                    <input type="password" class="form-control box_size" name="userPwd" id="userPwd" placeholder="영문자, 숫자, 특수문자를 포함하여 총 8 ~ 15자로 입력." required>
                </ul>
                <ul class="wright_info" style="position: relative; left: 0px; bottom: 40px;">
                    <p class="text_info">비밀번호 확인</p>
                    <input type="password" class="form-control box_size" name="pwdCheck" id="pwdCheck" placeholder="위 비밀번호와 일치하게 입력해 주세요." required>
                    <input type="button" name="pwdCheckBtn" id="pwdCheckBtn" class="form-control box_size" value="비밀번호 확인" onclick="return pwdEquals();">
                </ul>
                <ul class="wright_info" style="position: relative; left: 0px; bottom: 80px;">
                    <p class="text_info">이름</p>
                    <input type="text" class="form-control box_size" name="userName" id="userName" placeholder="한글로 작성하며 2글자 이상으로 입력해 주세요." required>
                </ul>
                <ul class="wright_info" style="position: relative; left: 0px; bottom: 80px;">
                    <p class="text_info">이메일</p>
                    <input type="text" class="form-control box_size" name="userEmail" id="userEmail" placeholder="이메일을 입력하세요" required>
                    <label style="font-weight: bold; position: relative; left: 355px; bottom: 78px;">@</label>
                    <input type="text" class="form-control box_size" name="userEmail2" id="userEmail2" style="position: relative; width: 155px !important; height: 38px; left: 370px; bottom: 118px;">
                    <select name="site_Type" class="form-control box_size" name="select_site" id="select_site" title="이메일 선택" style="position: relative; width: 150px !important; height: 38px; left: 540px; bottom: 156px !important;">
                    	<option value="">  직접 입력  </option>
                    	<option value="naver.com">naver.com</option>
		                <option value="nate.com">nate.com</option>
		                <option value="gmail.com">gmail.com</option>
		                <option value="yahoo.com">yahoo.com</option>
		                <option value="hanmail.net">hanmail.net</option>
                    </select>
                </ul>
                <ul class="wright_info" style="position: relative; left: 0px; bottom: 190px;">
                    <p class="text_info">전화번호</p>
                    <input type="text" class="form-control box_size" name="userPhone" id="userPhone" placeholder="-를 제외하고 입력해 주세요." required>
                </ul>
                <ul class="wright_info" style="position: relative; left: 0px; bottom: 190px;">
                    <p class="text_info">주소</p>
                    <input type="text" class="form-control box_size" name="addr" id="addr" placeholder="주소를 입력하세요" required>
                    <input type="text" class="form-control box_size" name="addrDetail" id="addrDetail" placeholder="상세 주소를 입력하세요" required>
                </ul>
                <ul class="wright_info" style="position: relative; left: 0px; bottom: 190px;">
                    <p class="text_info">생년월일</p>
                    <select name="yy" class="form-control box_size" id="year"></select>
                    <select name="mm" class="form-control box_size" id="month"></select>
                    <select name="dd" class="form-control box_size" id="day"></select>
                </ul>
                <br>
        </div>
    <hr color ="#787878" width="90%" height="2px" style="position: relative; bottom: 320px;">
    <br><br>

               <input style="background-color: #2D313C; color: white;" type="submit" name="info_Submit" class="btn btn-default" id="info_Submit" value="회원 가입" onclick="return validate();">
    </div>
        </form>
    <%@ include file="../Common/u_footer.jsp" %>
    
    <!-- 이메일 주소 스크립트 -->
	<script>
        $( "#select_site" ).change(function(){
            $("#userEmail2").val( $("#select_site").val() );
        });
    </script>
    
    <!-- 아이디 중복확인 스크립트 -->
    <script>
        $("#dupCheck").on('click', function() {
            $.ajax ({
                url : '/devbooks/memberDupCheck',
                type : 'get',
                data : {
                   
                    id : $("#userId").val()
                },
                success : function(data) {
                    alert(data);
                    
                },
                error : function(err) {
                    alert("실패");
                }
            })
        })
    </script>

    <!-- 정규표현식 스크립트 -->
    <script>
    // 비밀번호 일치 확인 
    function pwdEquals() {
            var userPwd1 = document.getElementById('userPwd').value;
            var userPwd2 = document.getElementById('pwdCheck').value;

            if(userPwd1 == userPwd2) {
                alert('비밀번호가 일치합니다.');
                return true;
            } else {
                alert('비밀번호가 일치하지 않습니다.');
                document.getElementById('pwdCheck').value = '';
                document.getElementById('pwdCheck').focus();
                return false;
            };
        }

    function validate() {
        var id = document.getElementById('userId').value;
        var pwd = document.getElementById('userPwd').value;
        var pwd2 = document.getElementById('pwdCheck').value;
        var name = document.getElementById('userName').value;
        var phone = document.getElementById('userPhone').value;
        var address = document.getElementById('addr').value;
        var address2 = document.getElementById('addrDetail').value;

        // 아이디 검사
        if(!(/^[a-zA-Z0-9_\-]{5,20}$/.test(id))) {
             alert('영문 대.소문자, 숫자 _,-만 입력 가능하고 5에서 20자리를 입력해 주세요.');
             document.getElementById('userId').focus();
             return false;
        };

        // 비밀번호 검사
        if(!(/^[\w!@#$%^&*-]{8,15}$/.test(pwd))) {
            alert('영문자, 숫자, 특수문자를 포함하여 총 8 ~ 15자로 입력해 주세요.');
            document.getElementById('userPwd2').focus();
            return false;
        };

        // 이름 검사
        if(!(/^[가-힣]{2,4}$/.test(name))) {
            alert('2~4글자의 한글만 입력해 주세요.');
            document.getElementById('userName').focus();
            return false;
        };

        // 전화번호 검사
        if(!(/^01{1}[016789]{1}[0-9]{7,8}$/.test(phone))) {
            alert('-를 제외하고 입력해 주세요.');
            document.getElementById('userPhone').focus();
            return false;
        }

        // 주소 검사
        if(!(/^[a-zA-Zㄱ-힣0-9|s]*$/.test(address))) {
            alert('특수문자를 제외하고 입력해 주세요')
            document.getElementById('addr').focus();
            return false;
        }

        // 상세 주소 검사
        if(!(/^[a-zA-Zㄱ-힣0-9|s]*$/.test(address2))) {
            alert('특수문자를 제외하고 입력해 주세요')
            document.getElementById('addrDetail').focus();
            return false;
        }
    }
    </script>
</body>
</html>