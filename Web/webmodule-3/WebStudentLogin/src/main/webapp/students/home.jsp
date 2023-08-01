<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/studentHome.css" type="text/css">
    <title>Document</title>
</head>
<body>

<div class="header">
    <form action="http://localhost:8080/students" method="get">
        <div style="display: inline-block">
            <input type="hidden" name="action" value="searchStudent">
            <input type="text" name="name" placeholder="Nhập tên muốn tìm kiếm">
        </div>
        <div style="display: inline-block">
            <button>Tìm kiếm</button>
        </div>
    </form>
    <div style="display: inline-block">
        <a href="http://localhost:8080/user?action=logout">Đăng xuất</a>
    </div>
</div>
<div class="nav-bar">
    <div>
        <a href="http://localhost:8080/students?action=add">Thêm sinh viên</a>
    </div>
    <div style="margin-left: 4px;">
        <a href="http://localhost:8080/students?action=add">Thông tin người đăng nhập</a>
    </div>
</div>

<div class="main">
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Age</td>
            <td>Image</td>
            <td colspan="2">Action</td>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td><a href="http://localhost:8080/students?action=detail&id=${student.id}">${student.name}</a></td>
                <td>${student.age}</td>
                <td><img src="${student.image}" alt=""></td>
                <td><a href="http://localhost:8080/students?action=edit&id=${student.id}">Sửa</a></td>
                <td><a href="http://localhost:8080/students?action=delete&id=${student.id}">Xóa</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
