<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

        <h1>Carrinho</h1>
        <br />

		<table border>
			<tr><th>Tipo</th><th>Marca</th><th>Valor</th><th>Quantidade</th></tr>
			<c:forEach items="${items}" var="item">
			<tr>
				<td>${item.getProduto().getTipo()}</td>
				<td>${item.getProduto().getMarca()}</td>
				<td>R$${item.getProduto().getValor()}</td>
				<td>${item.getQuantidade()}</td>
				<td><a href="/carrinho/remover?id=${item.getProduto().getCodigo()}">Remover</a></td>
			</tr>
			</c:forEach>
		</table>

	<a href="/cliente/finalizar">Comprar</a>

<c:import url="../template/footer.jsp" />
