<%@ page import="vn.edu.iuh.fit.entity.Job" %>
<%@ page import="vn.edu.iuh.fit.service.JobService" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entity.Skill" %>
<%@ page import="vn.edu.iuh.fit.service.SkillService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý công việc</title>
    <!-- Sử dụng Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h2>Danh sách công việc</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Tên công việc</th>
            <th>Mô tả</th>
            <th>Tên công ty</th>
            <th>Kỹ năng</th>
        </tr>
        </thead>
        <tbody>
        <%
            Long compID = request.getParameter("compID") != null ? Long.parseLong(request.getParameter("compID")) : null;

            JobService jobService = new JobService();
            List<Job> jobs = jobService.getAllJob();
            int pageSize = 5; // Số công việc trên mỗi trang
            int currentPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, jobs.size());
            List<Job> jobsOnPage = jobs.subList(startIndex, endIndex);

            for (Job job : jobsOnPage) {
        %>
        <tr>
            <td><%= job.getJob_name() %></td>
            <td><%= job.getJob_desc() %></td>
            <td><%= job.getCompany().getComp_name() %></td>
            <td>
                <ul>
                    <%
                        SkillService skillService = new SkillService();
                        List<Skill> skills = skillService.getSkillsForJob(job.getJob_id());
                        for (Skill skill : skills) {
                    %>
                    <li><%= skill.getSkill_name() %></li>
                    <%
                        }
                    %>
                </ul>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <!-- Phân trang -->
    <ul class="pagination">
        <%
            int totalPages = (int) Math.ceil((double) jobs.size() / pageSize);
            for (int i = 1; i <= totalPages; i++) {
        %>
        <li class="page-item <%= i == currentPage ? "active" : "" %>">
            <a class="page-link" href="job-manager.jsp?page=<%= i %>&compID=<%=compID%>"><%= i %></a>
        </li>
        <%
            }
        %>
    </ul>

    <a href="jobControl?action=addJob&compID=<%=compID%>" class="btn btn-primary">Đăng tin tuyển dụng</a>
    <a href="skill.jsp" class="btn btn-warning">Quản lý Skill</a>
    <a href="exp-candidate.jsp" class="btn btn-info">Tìm ứng viên có kinh nghiệm ?</a>
    <a href="no-exp-candidate.jsp" class="btn btn-danger">Bạn nhận đào tạo ứng viên ?</a>
    <a href="market-survey.jsp" class="btn btn-success">Khảo sát thị trường</a>

</div>

<!-- Sử dụng Bootstrap JS và jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
