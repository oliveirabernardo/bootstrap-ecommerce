<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Supermercado</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script
</head>
<body>
<c:choose>
<c:when test="${sessionScope.id == 1}">
	<c:import url="../template/menuAdmin.jsp"></c:import>
</c:when>
<c:otherwise>
	<c:import url="../template/menu.jsp"></c:import>
</c:otherwise>
</c:choose>
