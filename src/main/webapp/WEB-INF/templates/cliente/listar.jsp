<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

        <h1>Clientes</h1>
        <br />

		<table border>
			<tr><th>ID</th><th>Nome</th></tr>
				<c:forEach items="${clientes}" var="cliente">
						<tr>
							<td>${cliente.getId()}</td>
							<td>${cliente.getNome()}</td>
						</tr>
				</c:forEach>
		</table>

<c:import url="../template/footer.jsp" />
