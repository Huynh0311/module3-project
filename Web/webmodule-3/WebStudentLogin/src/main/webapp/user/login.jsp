<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/userLogin.css" type="text/css">
    <title>Document</title>
</head>
<body>
<form action="http://localhost:8080/user?action=login" method="post">
    <div>
        <p>Nhập tài khoản</p>
        <input type="text" name="username">
    </div>
    <div>
        <p>Nhập mật khẩu</p>
        <input type="password" name="password">
    </div>
    <div>
        <button style="margin-top: 14px">Đăng nhập</button>
    </div>
</form>
</body>
</html>
