<%@ page import="vn.edu.iuh.fit.service.SkillService" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entity.Skill" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 18/10/2023
  Time: 5:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng tin tuyển dụng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <h2>Thêm tin tuyển dụng</h2>
    <form action="jobControl?action=addJob" method="post">
        <%
            long compID= (long) request.getAttribute("compID");
        %>
        <div class="form-group">
            <label for="compID">ID Công ty:</label>
            <input type="text" class="form-control" id="compID" name="compID" value="<%=compID%>" readonly>
        </div>
        <div class="form-group">
            <label for="jobID">ID Công việc:</label>
            <input type="text" class="form-control" id="jobID" name="jobID">
        </div>
        <div class="form-group">
            <label for="jobName">Tên công việc:</label>
            <input type="text" class="form-control" id="jobName" name="jobName">
        </div>
        <div class="form-group">
            <label for="jobDes">Mô tả công việc:</label>
            <input type="text" class="form-control" id="jobDes" name="jobDes">
        </div>
        <div>
            <%
                SkillService skillService = new SkillService();
                List<Skill> skills = skillService.getAllSkill();
            %>
            <label for="skills">Kỹ năng:</label>
            <select class="form-control" id="skills" name="skills" multiple>
                <% for (Skill skill : skills) { %>
                <option value="<%= skill.getSkill_id() %>"><%= skill.getSkill_name() %>
                </option>
                <% } %>
            </select>
        </div>
        <div>
            <label for="skillLevel">Mức độ kỹ năng:</label>
            <select class="form-control" id="skillLevel" name="skillLevel">
                <option value="0" >BEGINNER</option>
                <option value="1" >NORMAL</option>
                <option value="2" >ADVANCED</option>
            </select>
        </div>
        <div>
            <label for="moreInfo">Thông tin thêm:</label>
            <input type="text" class="form-control" id="moreInfo" name="moreInfo">
        </div>
        <button type="submit" class="btn btn-success">Đăng tin</button>
    </form>

</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
