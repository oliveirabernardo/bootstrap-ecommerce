<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

<h1>Cadastro</h1>
<form:form action="/cliente/cadastroAction" method="post" modelAttribute="cliente">
    <fieldset>
        <legend>Dados do Cliente:</legend>
        <label>Nome:</label>
        <form:input path="nome" />
        <label>Senha:</label>
        <form:input path="senha" />
    </fieldset>

    <form:button>Cadastrar</form:button>
</form:form>

<c:import url="../template/footer.jsp" />
