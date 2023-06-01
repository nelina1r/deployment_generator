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
    <title>Создание Deployment конфигурации</title>
    <style>
        .form-container {
            max-width: 800px;
            margin: 0 auto;
        }
        .form-container .form-group label {
            text-align: left;
        }
        .loading-indicator {
            display: none;
            text-align: center;
            margin-top: 20px;
        }
    </style>
    <script>
        $(document).ready(function() {
            $("form").on("submit", function() {
                $(".loading-indicator").show();
            });
        });
    </script>
</head>
<body>
<div class="container">
    <div class="text-center">
        <h1>хуй</h1>
        <h2>Создание Deployment конфигурации</h2>
    </div>
    <div class="form-container">
        <form:form action="createDeployment" method="post" modelAttribute="deploymentConfig">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="serviceName">serviceName:</label>
                        <form:input path="serviceName" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="replicaCount">replicaCount:</label>
                        <form:input path="replicaCount" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="containerName">containerName:</label>
                        <form:input path="containerName" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="imageName">imageName:</label>
                        <form:input path="imageName" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="portNumber">portNumber:</label>
                        <form:input path="portNumber" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="strategyType">strategyType:</label>
                        <form:input path="strategyType" class="form-control"/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="maxUnavailable">maxUnavailable:</label>
                        <form:input path="maxUnavailable" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="maxSurge">maxSurge:</label>
                        <form:input path="maxSurge" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="limitCPU">limitCPU:</label>
                        <form:input path="limitCPU" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="limitMemory">limitMemory:</label>
                        <form:input path="limitMemory" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="requestCPU">requestCPU:</label>
                        <form:input path="requestCPU" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="requestMemory">requestMemory:</label>
                        <form:input path="requestMemory" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="envName">envName:</label>
                        <form:input path="envName" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="envValue">envValue:</label>
                        <form:input path="envValue" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="text-center">
                <input type="submit" value="Сгенерировать" class="btn btn-primary">
            </div>
            <div class="loading-indicator">
                <img src="https://i.gifer.com/3Ypj.gif" alt="Loading..." width="50" height="50">
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
