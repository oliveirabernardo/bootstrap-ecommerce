<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Supermercado</title>
</head>
<body>

<h1>Login</h1>
<h2>${mensagem}</h2>
<form method="post" action="${pageContext.request.contextPath}/cliente/login">
    <label>Usuário</label>
    <input name="username"/>
    <label>Senha</label>
    <input type="password" name="password"/>
    <input type="submit" value="Logar"/>
</form>

<a href="/cliente/cadastro">Não tem login? Cadastre-se</a>
<br />
Credenciais de ADMINISTRADOR: Usuario(admin) Senha(admin)

<c:import url="../template/footer.jsp" />
