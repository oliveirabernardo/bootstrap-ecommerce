<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

        <h1>Estoque</h1>
        <br />

		<table border>
			<tr><th>Tipo</th><th>Marca</th><th>Valor</th></tr>
				<c:forEach items="${produtos}" var="produto">
					<c:if test="${produto.getQuantidadeEstoque() > 1}">
						<tr>
							<td>${produto.getTipo()}</td>
							<td>${produto.getMarca()}</td>
							<td>R$${produto.getValor()}</td>
							<td><a href="/cliente/comprar?id=${produto.getId()}">Comprar</a></td>
						</tr>
					</c:if>
				</c:forEach>
		</table>

<c:import url="../template/footer.jsp" />
