<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page errorPage = "../error/error.jsp" %>

<html>
    <body>
        <jsp:useBean id="clienteController" class="es.iespuertodelacruz.concesionario.controlador.ClienteController" />

        <% String dni = request.getParameter("dni"); %>

        <% clienteController.eliminar(dni); %>

        <meta http-equiv = "refresh" content = " 1 ; url = ../menu/menuCliente.jsp"/>
    </body>
</html>