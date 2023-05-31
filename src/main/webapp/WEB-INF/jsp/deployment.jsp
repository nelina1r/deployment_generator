<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <title>Создание Deployment конфигурации</title>
</head>
<body>
<div align="center">
    <h2>Создание Deployment конфигурации</h2>
    <form:form action="createDeployment" method="post" modelAttribute="deploymentConfig">
        <table border="0" cellpadding="5">
            <tr>
                <td>serviceName: </td>
                <td><form:input path="serviceName" /></td>
            </tr>
            <tr>
                <td>replicaCount: </td>
                <td><form:input path="replicaCount" /></td>
            </tr>
            <tr>
                <td>containerName: </td>
                <td><form:input path="containerName" /></td>
            </tr>
            <tr>
                <td>imageName: </td>
                <td><form:input path="imageName" /></td>
            </tr>
            <tr>
                <td>portNumber: </td>
                <td><form:input path="portNumber" /></td>
            </tr>
            <tr>
                <td>strategyType: </td>
                <td><form:input path="strategyType" /></td>
            </tr>
            <tr>
                <td>maxUnavailable: </td>
                <td><form:input path="maxUnavailable" /></td>
            </tr>
            <tr>
                <td>maxSurge: </td>
                <td><form:input path="maxSurge" /></td>
            </tr>
            <tr>
                <td>limitCPU: </td>
                <td><form:input path="limitCPU" /></td>
            </tr>
            <tr>
                <td>limitMemory: </td>
                <td><form:input path="limitMemory" /></td>
            </tr>
            <tr>
                <td>requestCPU: </td>
                <td><form:input path="requestCPU" /></td>
            </tr>
            <tr>
                <td>requestMemory: </td>
                <td><form:input path="requestMemory" /></td>
            </tr>
            <tr>
                <td>envName: </td>
                <td><form:input path="envName" /></td>
            </tr>
            <tr>
                <td>envValue: </td>
                <td><form:input path="envValue" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Сгенерировать"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>