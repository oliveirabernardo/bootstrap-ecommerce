<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

        <h1>Produtos</h1>
        <br />

<table border>
	<tr><th>Tipo</th><th>Marca</th><th>Valor</th><th>Estoque</th><th>Codigo</th></tr>
	<c:forEach items="${produtos}" var="produto">
		<tr>
			<td>${produto.getTipo()}</td>
			<td>${produto.getMarca()}</td>
			<td>${produto.getValor()}</td>
			<td>${produto.getQuantidadeEstoque()}</td>
			<td>${produto.getId()}</td>
			<td>
				<a href="/produto/alterar?id=${produto.getId()}">Alterar</a>
				<a href="/produto/remover?id=${produto.getId()}">Remover</a>
			</td>

		</tr>
	</c:forEach>
</table>

<c:import url="../template/footer.jsp" />
