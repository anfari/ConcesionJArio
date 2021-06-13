<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import='es.iespuertodelacruz.concesionario.api.Vehiculo' %>
<%@ page errorPage = "../error/error.jsp" %>

<html>
    <head>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <jsp:useBean id="vehiculoController" class="es.iespuertodelacruz.concesionario.controlador.VehiculoController" />

        <% String bastidor = request.getParameter("bastidor"); %>
        <% String matricula = request.getParameter("matricula"); %>
        <% String marca = request.getParameter("marca"); %>
        <% String modelo = request.getParameter("modelo"); %>
        <% String color = request.getParameter("color"); %>
        <% String precioString = request.getParameter("precio"); %>
        <% double precio = Double.valueOf(precioString); %>
        <% String motor = request.getParameter("motor"); %>
        <% String potenciaString = request.getParameter("potencia"); %>
        <% int potencia = Integer.parseInt(potenciaString); %>
        <% String cilindrada = request.getParameter("cilindrada"); %>
        <% String tipo = request.getParameter("tipo"); %>
        <% String estado = request.getParameter("estado"); %>
        <% String extras = request.getParameter("extras"); %>

        <% Vehiculo vehiculo = new Vehiculo(bastidor, matricula, marca, modelo, color, precio, extras, motor, potencia, cilindrada, tipo, estado); %>

        <% vehiculoController.modificar(vehiculo); %>

        <meta http-equiv = "refresh" content = " 1 ; url = ../menu/menuVehiculo.jsp"/>
    </body>
</html>