<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import='java.util.ArrayList' %>
<%@ page errorPage = "../error/error.jsp" %>
<%@page import='es.iespuertodelacruz.concesionario.api.Empleado' %>
<%@page import='es.iespuertodelacruz.concesionario.api.Persona' %>
<%@page import='es.iespuertodelacruz.concesionario.api.Direccion' %>

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Listado Empleados</title>
  <link rel="stylesheet" href="../../css/estilos.css">
</head>
  <%@include file="../header.jsp" %>

  <body>

    <jsp:useBean id="empleadoController" class="es.iespuertodelacruz.concesionario.controlador.EmpleadoController"/>


        <% ArrayList<Empleado> empleados = empleadoController.listadoEmpleados(); %>
        <br><br><br><br>
        <table style="border: 1px;">
          <tr>
            <th>Codigo Empleado</th>
            <th>Rango</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Dni</th>
            <th>Fecha Nacimiento</th>
            <th>Telefono</th>
            <th>Calle</th>
            <th>Numero</th>
            <th>Ciudad</th>
            <th>Provincia</th>
            <th>Pais</th>
            <th>Codigo Postal</th>
          </tr>
          <% for(int i = 0; i < empleados.size(); i++){ %>
            <% Empleado empleado = empleados.get(i); %>
            <% Persona persona = empleadoController.generarPersona(empleado); %>
            <% Direccion direccion = persona.getDireccion(); %>
              <tr>
                <td><%= empleado.getCodigoEmpleado()%></td>
                <td><%= empleado.getRango()%></td>
                <td><%= persona.getNombre()%></td>
                <td><%= persona.getApellidos()%></td>
                <td><%= persona.getDni()%></td>
                <td><%= persona.getFechaNacimiento()%></td>
                <td><%= persona.getTelefono()%></td>
                <td><%= direccion.getCalle()%></td>
                <td><%= direccion.getNumero()%></td>
                <td><%= direccion.getCiudad()%></td>
                <td><%= direccion.getProvincia()%></td>
                <td><%= direccion.getPais()%></td>
                <td><%= direccion.getCodigoPostal()%></td>
              </tr>
            <% } %> 
        </table>


    
  </body>
  <%@include file="../footer.jsp" %>
</html>