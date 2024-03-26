<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 18/03/2024
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh muc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<table class="table container">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Ma</th>
        <th scope="col">Ten</th>
        <th scope="col">Trang thai</th>
        <th scope="col">Ngay tao</th>
        <th scope="col">Ngay sua</th>
        <th scope="col">Chức năng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhMucs}" var = "dm" varStatus="status">
        <tr>
            <th scope="row">${status.index + 1}</th>
            <td>${dm.ma}</td>
            <td>${dm.ten}</td>
            <td>${dm.trangThai}</td>
            <td>${dm.ngayTao}</td>
            <td>${dm.ngaySua}</td>
            <td class="row">
                <button class="col-sm btn btn-warning"><a href="/DanhMucServlet/detail?code=${dm.ma}">Detail</a></button>
                <button class="col-sm btn btn-danger"><a href="/DanhMucServlet/delete?code=${dm.ma}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
