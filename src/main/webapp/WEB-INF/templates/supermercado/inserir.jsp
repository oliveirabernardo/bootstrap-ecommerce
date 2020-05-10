<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

        <h1>Cadastrar Supermercado</h1>
        <form:form action="/supermercado/inserirAction" method="post" modelAttribute="supermercado">
            <form:button>Cadastrar</form:button>
        </form:form>

<c:import url="../template/footer.jsp" />
