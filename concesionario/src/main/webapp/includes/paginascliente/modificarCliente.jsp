<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import='es.iespuertodelacruz.concesionario.api.Cliente' %>
<%@page import='es.iespuertodelacruz.concesionario.api.Direccion' %>
<%@ page errorPage = "../error/error.jsp" %>

<html>
    <head>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <jsp:useBean id="clienteController" class="es.iespuertodelacruz.concesionario.controlador.ClienteController" />

        <% String codigoCliente = request.getParameter("codigoCliente"); %>
        <% String dni = request.getParameter("dni"); %>
        <% String nombre = request.getParameter("nombre"); %>
        <% String apellidos = request.getParameter("apellidos"); %>
        <% String fechaNacimiento = request.getParameter("fechaNacimiento"); %>
        <% String telefono = request.getParameter("telefono"); %>
        <% String pais = request.getParameter("pais"); %>
        <% String provincia = request.getParameter("provincia"); %>
        <% String ciudad = request.getParameter("ciudad"); %>
        <% String calle = request.getParameter("calle"); %>
        <% String num = request.getParameter("numero"); %>
        <% int numero = Integer.parseInt(num); %>
        <% String codigoPostal = request.getParameter("codigoPostal"); %>

        <% Direccion direccion = new Direccion(dni, calle, numero, codigoPostal, provincia, ciudad, pais); %>
        <% Cliente cliente = new Cliente(codigoCliente, nombre, apellidos, dni, fechaNacimiento, telefono, direccion); %>

        <% clienteController.modificar(cliente); %>

        <meta http-equiv = "refresh" content = " 1 ; url = ../menu/menuCliente.jsp"/>
    </body>
</html>