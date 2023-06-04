<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/5.3.0/css/bootstrap.min.css" />">
    <script src="<c:url value="/webjars/jquery/3.6.0/jquery.min.js" />"></script>
    <script src="<c:url value="/webjars/bootstrap/5.3.0/js/bootstrap.min.js" />"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <title>Генератор конфигураций</title>
</head>
<body>
<div class="container">
    <div class="text-center">
        <h1>Генератор конфигураций</h1>
        <h3><a href="/deployment" class="btn btn-primary">Deployment-конфигурация</a></h3>
        <h3><a href="/service" class="btn btn-primary">Service-конфигурация</a></h3>
    </div>
</div>
</body>
</html>
