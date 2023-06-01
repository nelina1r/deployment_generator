<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Создание Service конфигурации</title>
    <style>
        .form-container {
            max-width: 400px;
            margin: 0 auto;
        }
        .form-container .form-group {
            text-align: left;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">
        <h2 class="text-center">Создание Service конфигурации</h2>
        <form:form action="createService" method="post" modelAttribute="serviceConfig">
            <div class="form-group">
                <label for="serviceName">serviceName:</label>
                <form:input path="serviceName" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="containerName">containerName:</label>
                <form:input path="containerName" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="protocolType">protocolType:</label>
                <form:input path="protocolType" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="portNumber">portNumber:</label>
                <form:input path="portNumber" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="targetPort">targetPort:</label>
                <form:input path="targetPort" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="serviceType">serviceType:</label>
                <form:input path="serviceType" class="form-control"/>
            </div>
            <div class="text-center">
                <input type="submit" value="Сгенерировать" class="btn btn-primary">
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
