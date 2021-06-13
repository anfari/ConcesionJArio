<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import='es.iespuertodelacruz.concesionario.api.Empleado' %>
<%@page import='es.iespuertodelacruz.concesionario.api.Direccion' %>
<%@ page errorPage = "../error/error.jsp" %>

<html>
    <head>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <jsp:useBean id="empleadoController" class="es.iespuertodelacruz.concesionario.controlador.EmpleadoController" />

        <% String dni = request.getParameter("dni"); %>
        <% String rango = request.getParameter("rango"); %>
        <% String contrasenia = request.getParameter("contrasenia"); %>
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
        <% Empleado empleado = new Empleado(null, nombre, apellidos, dni, fechaNacimiento, telefono, direccion, rango, contrasenia); %>

        <% empleadoController.insertar(empleado); %>

        <meta http-equiv = "refresh" content = " 1 ; url = ../menu/menuEmpleado.jsp"/>
    </body>
</html>