<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page errorPage = "../error/error.jsp" %>

<html>
    <head>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <jsp:useBean id="empleadoController" class="es.iespuertodelacruz.concesionario.controlador.EmpleadoController" />

        <% String dni = request.getParameter("dni"); %>

        <% empleadoController.eliminar(dni); %>

        <meta http-equiv = "refresh" content = " 1 ; url = ../menu/menuEmpleado.jsp"/>
    </body>
</html>