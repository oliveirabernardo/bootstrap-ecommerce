<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

        <h3>Alterar Forma de Pagamento</h3>
        <form:form action="/supermercado/pagamento/alterarAction" method="post" modelAttribute="pagamento">
            <fieldset>
                <form:hidden path="id"/>
                <label for="nome">Nome:</label>
                <form:input path="nome"/>
                <label for="taxa">Taxa:</label>
                <form:input path="taxa"/>
            </fieldset>

            <form:button>Alterar</form:button>
        </form:form>

<c:import url="../template/footer.jsp" />
