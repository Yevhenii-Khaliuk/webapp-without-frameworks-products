<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kerana
  Date: 23.02.19
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
    <h3>Product name: <c:out value="${product.productName}"/></h3>
    <h3>Description: <c:out value="${product.description}"/></h3>
    <h3>Price: <c:out value="${product.price}"/></h3>
</body>
</html>
