<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import='es.iespuertodelacruz.concesionario.api.Venta' %>
<%@page import='es.iespuertodelacruz.concesionario.api.Vehiculo' %>

<%@ page errorPage = "../error/error.jsp" %>

<html>
    <head>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <jsp:useBean id="ventaController" class="es.iespuertodelacruz.concesionario.controlador.VentaController" />
        <jsp:useBean id="vehiculoController" class="es.iespuertodelacruz.concesionario.controlador.VehiculoController" />

        <% String codigoEmpleado = request.getParameter("codigoEmpleado"); %>
        <% String codigoCliente = request.getParameter("codigoCliente"); %>
        <% String numeroBastidor = request.getParameter("numeroBastidor"); %>

        <% Venta venta = new Venta(null, codigoEmpleado, codigoCliente, numeroBastidor); %>
        <% Vehiculo vehiculo = vehiculoController.buscar(numeroBastidor); %>

        <% vehiculo.setEstado("Vendido"); %>
        <% ventaController.insertar(venta); %>
        <% vehiculoController.modificar(vehiculo); %>

        <meta http-equiv = "refresh" content = " 1 ; url = ../menu/menuVenta.jsp"/>
    </body>
</html>