<%@ page import="vn.edu.iuh.fit.service.CandidateService" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 19/10/2023
  Time: 2:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thống kê số ứng viên theo năm sinh</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Thống kê số ứng viên theo năm sinh</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Năm sinh</th>
            <th>Số ứng viên</th>
        </tr>
        </thead>
        <tbody>
        <%
            CandidateService candidateService=new CandidateService();
            Map<Integer, Long> map=candidateService.getCandByYearBorn();
            for (Map.Entry<Integer, Long> entry : map.entrySet()) {
        %>
        <tr>
            <td><%= entry.getKey() %></td>
            <td><%= entry.getValue() %></td>
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
