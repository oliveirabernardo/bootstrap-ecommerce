<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

        <h3>Lista de filiais</h3>
        <br />

		<table border>
			<tr><th>Mercado</th><th>Clientes</th><th>Formas de Pagamento</th><th>Estoque</th></tr>
				<c:forEach items="${mercados}" var="mercado">
					<tr>
						<td>Mercado ${mercado.getId()}</td>
						<td><a href="/supermercado/clientes">Acessar</a></td>
						<td><a href="/supermercado/pagamento">Acessar</a></td>
						<td><a href="/produto/">Acessar</a></td>
					</tr>
				</c:forEach>
		</table>

		<a href="${pageContext.request.contextPath}/supermercado/inserir">Cadastrar Mercado</a>

<c:import url="../template/footer.jsp" />
