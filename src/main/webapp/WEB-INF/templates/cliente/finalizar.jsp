<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

        <h1>Carrinho</h1>
        <br />

<h3>Escolha seu método de pagamento preferido</h3>

		<table border>
			<tr><th>Nome</th><th>Taxa</th></tr>
			<c:forEach items="${pagamento}" var="metodo">
			<tr>
				<td>${metodo.getNome()}</td>
				<td>${metodo.getTaxa()}</td>
				<td><a href="/cliente/pedido?id=${metodo.getId()}">Escolher</a></td>
			</tr>
			</c:forEach>
		</table>

<c:import url="../template/footer.jsp" />
