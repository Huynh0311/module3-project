
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <tr>
    <td>Id</td>
    <td>Tên</td>
    <td>Mật khẩu</td>
    <td>Role</td>
  </tr>
  <tr>
    <td>${user.userId}</td>
    <td>${user.name}</td>
    <td>${user.password}</td>
    <td>${user.role}</td>
  </tr>
</table>
</body>
</html>
