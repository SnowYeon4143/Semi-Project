<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>가입 실패</title>

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

        .success_join {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 40vh;
        }

        .success_msg {
            font-family: system-ui, serif;
            font-size: 2rem;
            padding: 3rem;
            border-radius: 1rem;
            text-align: center;
        }

        .go_home {
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: 5px;
            margin-left: -60px;
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>
    <div class="input_box">
        <div class="success_join">
            <span class="success_msg">
                <br>
                회원가입에 실패하였습니다.
                <br>
                확인버튼을 누르면 회원가입 페이지로 이동합니다.
            </span>
        </div>
        <div class="go_home">
            <button class="btn btn-default" style="background-color: #2D313C; border-radius: 2px solid #2D313C; height: 50px; width: 150px;"><a style=" color: white;" href="join">확인</a></button>
        </div>
    </div>
    <br>
</body>
</html>