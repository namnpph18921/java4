<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 08/03/2024
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
Mã sinh viên : ${students.get(0).getCode()}
Tên : ${students.get(0).getName()}
</body>
</html>
