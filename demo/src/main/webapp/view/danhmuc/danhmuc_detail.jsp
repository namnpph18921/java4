<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh muc detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

<form action="/DanhMucServlet/update?ma=${dm.ma}" method="post">
    <div class="mb-3">
        <label class="form-label">Ma </label>
        <input type="text" class="form-control" name="maMoi" value="${dm.ma}">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten</label>
        <input type="text" class="form-control" name="ten" value="${dm.ten}">
    </div>
    <div class="mb-3">
        <label class="form-label">Trang thai</label>
        <input type="text" class="form-control" name="trangThai" value="${dm.trangThai}">
    </div>
    <div class="mb-3">
        <label class="form-label">Ngay Tao</label>
        <input type="datetime-local" class="form-control" name="ngayTao" value="${dm.ngayTao}">
    </div>
    <div class="mb-3">
        <label class="form-label">Ngay sua</label>
        <input type="datetime-local" class="form-control" name="ngaySua" value="${dm.ngaySua}">
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
</form>

</body>
</html>