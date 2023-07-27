
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="http://localhost:8080/students?action=edit" method="post">

    <input type="text" name="id" value="${students.id}">
    <input type="text" name="name" value="${students.name}" >
    <input type="text" name="age" value="${students.age}">
    <input type="text" name="image" value="${students.image}">
    <button>Sửa</button>
</form>
</body>
</html>
