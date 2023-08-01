<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main">
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Age</td>
            <td>Image</td>
            <td colspan="2">Action</td>
        </tr>
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td><img src="${student.image}" alt=""></td>
        </tr>
    </table>
    <div>
        <a href="http://localhost:8080//students?action=findAll">Về trang chủ</a>
    </div>
</div>
</body>
</html>
