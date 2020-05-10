<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

        <h3>Alterar Produto</h3>
        <form:form action="/produto/alterarAction" method="post" modelAttribute="produto">
            <fieldset>
                <form:hidden path="id"/>
                <label>Tipo:</label>
                <form:input path="tipo" />
                <label>Marca:</label>
                <form:input path="marca" />
                <label>Preço:</label>
                <form:input path="valor" />
                <label>Quantidade:</label>
                <form:input path="quantidadeEstoque" />
            </fieldset>

            <form:button>Alterar</form:button>
        </form:form>

<c:import url="../template/footer.jsp" />
