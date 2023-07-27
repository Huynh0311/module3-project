<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Age</td>
            <td>Image</td>
            <td colspan="2">Action</td>
        </tr>
        <c:forEach items="${students}" var="studnet">
            <tr>
                <td>${studnet.id}</td>
                <td>${studnet.name}</td>
                <td>${studnet.age}</td>
                <td><img src="${studnet.image}" alt=""></td>
                <td>Sửa</td>
                <td><a href="http://localhost:8080/students?action=delete"&id="${studnet.id}">Xóa</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
