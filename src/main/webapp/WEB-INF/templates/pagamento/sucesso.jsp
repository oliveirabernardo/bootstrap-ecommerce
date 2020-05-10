<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp" />

<h1>Carrinho</h1>
<br />

<h3>Obrigado pela compra! Volte sempre</h3>

Seu pagamento de R$${valor} no ${pagamento.getNome()} foi confirmado!

<a href="/cliente/carrinho">Voltar</a>

<c:import url="../template/footer.jsp" />
