<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

        <h3>Cadastrar Forma de Pagamento</h3>
        <form:form action="/supermercado/pagamento/inserirAction" method="post" modelAttribute="pagamento">
            <fieldset>
                <legend>Dados da Forma de Pagamento:</legend>
                <label>Nome:</label>
                <form:input path="nome" />
                <label>Taxa:</label>
                <form:input path="taxa" />
            </fieldset>

            <form:button>Cadastrar</form:button>
        </form:form>

<c:import url="../template/footer.jsp" />
