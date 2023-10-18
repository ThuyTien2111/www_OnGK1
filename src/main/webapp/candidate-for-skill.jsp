<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entity.Job" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="vn.edu.iuh.fit.entity.Candidate" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 18/10/2023
  Time: 9:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ứng viên cho bạn</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Ứng viên cho bạn</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Tên ứng viên:</th>
            <th>Số điện thoại:</th>
            <th>Nơi ở:</th>
            <th>Ngày sinh:</th>
            <th>Email:</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Candidate> candidates = (List<Candidate>) request.getAttribute("cadidates");
            for (Candidate c : candidates) {
                LocalDate dob = c.getDob();
                String dobFormat = dob.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        %>
        <tr>
            <td><%=c.getFull_name()%></td>
            <td><%=c.getPhone()%></td>
            <td><%=c.getAddress().getCity()%></td>
            <td><%=dobFormat%></td>
            <td><%=c.getEmail()%></td>
            <td>
                <a href="https://www.google.com/intl/vi/gmail/about/" class="btn btn-primary">Gửi mail mời</a>
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
