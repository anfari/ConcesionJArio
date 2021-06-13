<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page errorPage = "../error/error.jsp" %>

<html>
    <body>
        <jsp:useBean id="vehiculoController" class="es.iespuertodelacruz.concesionario.controlador.VehiculoController" />

        <% String bastidor = request.getParameter("bastidor"); %>

        <% vehiculoController.eliminar(bastidor); %>

        <meta http-equiv = "refresh" content = " 1 ; url = ../menu/menuVehiculo.jsp"/>
    </body>
</html>