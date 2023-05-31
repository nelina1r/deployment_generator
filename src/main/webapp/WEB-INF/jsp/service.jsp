<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <title>Создание Service конфигурации</title>
</head>
<body>
<div align="center">
    <h2>Создание Service конфигурации</h2>
    <form:form action="createService" method="post" modelAttribute="serviceConfig">
        <table border="0" cellpadding="5">
            <tr>
                <td>serviceName: </td>
                <td><form:input path="serviceName" /></td>
            </tr>
            <tr>
                <td>containerName: </td>
                <td><form:input path="containerName" /></td>
            </tr>
            <tr>
                <td>protocolType: </td>
                <td><form:input path="protocolType" /></td>
            </tr>
            <tr>
                <td>portNumber: </td>
                <td><form:input path="portNumber" /></td>
            </tr>
            <tr>
                <td>targetPort: </td>
                <td><form:input path="targetPort" /></td>
            </tr>
            <tr>
                <td>serviceType: </td>
                <td><form:input path="serviceType" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Сгенерировать"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>