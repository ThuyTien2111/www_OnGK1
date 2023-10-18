<%@ page import="vn.edu.iuh.fit.service.SkillService" %>
<%@ page import="vn.edu.iuh.fit.entity.Skill" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 18/10/2023
  Time: 3:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Kỹ năng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Danh sách kỹ năng</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Tên kỹ năng</th>
            <th>Mô tả</th>
            <th>Phân loại</th>
        </tr>
        </thead>
        <tbody>
        <%
            SkillService skillService = new SkillService();
            List<Skill> skills = skillService.getAllSkill();

            int pageSize = 5; // Số công việc trên mỗi trang
            int currentPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, skills.size());
            List<Skill> skillsOnPage = skills.subList(startIndex, endIndex);
            //Xử lý type of skill
            String type="";
            for (Skill skill : skillsOnPage) {
                if(skill.getSkill_type()==0){
                    type="BASE";
                }
                else if(skill.getSkill_type()==1){
                    type="SOFT";
                }
                else if(skill.getSkill_type()==2){
                    type="HARD";
                }
        %>
        <tr>
            <td><%=skill.getSkill_name()%></td>
            <td><%=skill.getSkill_desc()%></td>
            <td><%=type%></td>
            <td>
                <a href="skillControl?action=updateSkill&skillID=<%=skill.getSkill_id()%>" class="btn btn-warning">Sửa</a>
            </td>
            <td>
                <a href="skillControl?action=deleteSkill&skillID=<%=skill.getSkill_id()%>" class="btn btn-danger">Xóa</a>
            </td>
            <td>
                <a href="skillControl?action=activeSkill&skillID=<%=skill.getSkill_id()%>" class="btn btn-info">Active</a>
            </td>
            <td>
                <a href="candidateControl?action=findCandidate&skillID=<%=skill.getSkill_id()%>" class="btn btn-success">Tìm ứng viên</a>
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
            int totalPages = (int) Math.ceil((double) skills.size() / pageSize);
            for (int i = 1; i <= totalPages; i++) {
        %>
        <li class="page-item <%= i == currentPage ? "active" : "" %>">
            <a class="page-link" href="skill.jsp?page=<%= i %>"><%= i %></a>
        </li>
        <%
            }
        %>
    </ul>
    <a href="add-skill.jsp" class="btn btn-primary">Thêm kỹ năng</a>

</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
