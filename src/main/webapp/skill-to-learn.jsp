<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entity.Skill" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 18/10/2023
  Time: 10:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kỹ năng cần học</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<h2>Một số kỹ năng bạn có thể học:</h2>
<table class="table">
    <thead>
    <tr>
        <th>Tên kỹ năng</th>
        <th>Mô tả</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Skill> skills= (List<Skill>) request.getAttribute("skills");
        for (Skill s:skills) {
    %>
    <tr>
        <td><%=s.getSkill_name()%></td>
        <td><%=s.getSkill_desc()%></td>
        <td>
            <a href="" class="btn btn-primary">Học</a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
