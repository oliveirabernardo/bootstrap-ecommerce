<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

        <h1>Formas de Pagamento</h1>
<a href="${pageContext.request.contextPath}/supermercado/pagamento/inserir">Cadastrar Forma de Pagamento</a>
<table border>
    <tr><th>ID</th><th>Tipo</th><th>Taxa</th></tr>
    <c:forEach items="${formasPagamento}" var="pagamento">
        <tr>
            <td>${pagamento.getId()}</td>
            <td>${pagamento.getNome()}</td>
            <td>R$${pagamento.getTaxa()}</td>
            <td>
                <a href="/supermercado/pagamento/alterar?id=${pagamento.getId()}">Alterar</a>
                <a href="/supermercado/pagamento/remover?id=${pagamento.getId()}">Remover</a>
            </td>

        </tr>
    </c:forEach>

<c:import url="../template/footer.jsp" />
