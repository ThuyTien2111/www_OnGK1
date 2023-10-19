<%@ page import="vn.edu.iuh.fit.service.CandidateSkillService" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entity.Job" %>
<%@ page import="vn.edu.iuh.fit.service.JobSkillService" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 18/10/2023
  Time: 8:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Công việc cho bạn</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Công việc cho bạn</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Tên công việc</th>
            <th>Mô tả công việc</th>
            <th>Tên công ty</th>
            <th>Mức lương đề xuất</th>
        </tr>
        </thead>
        <tbody>
        <%
            long candID = Long.parseLong(request.getParameter("candID"));
            CandidateSkillService candidateSkillService = new CandidateSkillService();
            JobSkillService jobSkillService=new JobSkillService();
            List<Job> jobForU = candidateSkillService.getJobForCandidateOrderBySkill(candID);
            for (Job j : jobForU) {
                Integer price=jobSkillService.calcProposedSalary(j.getJob_id());
        %>
        <tr>
            <td><%=j.getJob_name()%></td>
            <td><%=j.getJob_desc()%></td>
            <td><%=j.getCompany().getComp_name()%></td>
            <td><%=price.toString()%> $</td>
            <td>
                <a href="" class="btn btn-success">Apply</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <a href="candidateControl?action=learnSkill&candID=<%=candID%>" class="btn btn-warning">Skill bạn chưa có?</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
