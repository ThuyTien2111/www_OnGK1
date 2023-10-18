<%--
  Created by IntelliJ IDEA.
  User: my
  Date: 18/10/2023
  Time: 8:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập ứng viên</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <h2>Đăng nhập ứng viên</h2>
    <%
        String error= (String) request.getAttribute("error");
        if(error!=null && !error.isEmpty()){
    %>
    <div class="alert alert-danger"><%=error%></div>
    <%
        }
    %>
    <form action="candidateControl?action=login" method="post">
        <div class="form-group">
            <label for="candID">ID ứng viên:</label>
            <input class="form-control" type="text" id="candID" name="candID">
        </div>
        <div class="form-group">
            <label for="pass">Mật khẩu:</label>
            <input class="form-control" type="password" id="pass" name="pass">
        </div>
        <button type="submit" class="btn btn-primary">Đăng nhập</button>
    </form>

</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
