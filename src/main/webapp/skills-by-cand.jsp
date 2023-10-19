<%@ page import="vn.edu.iuh.fit.service.CandidateService" %>
<%@ page import="java.util.Map" %>
<%@ page import="vn.edu.iuh.fit.entity.Candidate" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 19/10/2023
  Time: 3:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thống kê số lượng kỹ năng theo ứng viên</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Thống kê số lượng kỹ năng theo ứng viên</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Tên ứng viên</th>
            <th>Số điện thoại</th>
            <th>Nơi ở</th>
            <th>Ngày sinh</th>
            <th>Email</th>
            <th>Số lượng skill</th>
        </tr>
        </thead>
        <tbody>
        <%
            CandidateService candidateService=new CandidateService();
            Map<Candidate, Long> map=candidateService.getTotalSkillByCand();
            for (Map.Entry<Candidate, Long> entry:map.entrySet()) {
                LocalDate dob=entry.getKey().getDob();
                String dobFormat=dob.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        %>
        <tr>
            <td><%=entry.getKey().getFull_name()%></td>
            <td><%=entry.getKey().getPhone()%></td>
            <td><%=entry.getKey().getAddress().getCity()%></td>
            <td><%=dobFormat%></td>
            <td><%=entry.getKey().getEmail()%></td>
            <td><%=entry.getValue()%></td>
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
