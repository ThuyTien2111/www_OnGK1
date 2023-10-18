<%--
  Created by IntelliJ IDEA.
  User: my
  Date: 18/10/2023
  Time: 3:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm kỹ năng mới</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Thêm kỹ năng</h2>
    <form action="skillControl?action=addSkill" method="post">
        <div class="form-group">
            <label for="skillID">Id kỹ năng:</label>
            <input type="text" class="form-control" id="skillID" name="skillID">
        </div>
        <div class="form-group">
            <label for="skillName">Tên kỹ năng:</label>
            <input type="text" class="form-control" id="skillName" name="skillName">
        </div>
        <div class="form-group">
            <label for="skillDes">Mô tả: </label>
            <input type="text" class="form-control" id="skillDes" name="skillDes">
        </div>
        <div class="form-group">
            <label for="skillType">Phân loại kỹ năng:</label>
            <select class="form-control" id="skillType", name="skillType">
                <option value="0">BASE</option>
                <option value="1">SOFT</option>
                <option value="2">HARD</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Hoàn thành</button>
    </form>

</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
