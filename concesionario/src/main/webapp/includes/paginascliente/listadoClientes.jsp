<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import='java.util.ArrayList' %>
<%@ page errorPage = "../error/error.jsp" %>
<%@page import='es.iespuertodelacruz.concesionario.api.Cliente' %>
<%@page import='es.iespuertodelacruz.concesionario.api.Persona' %>
<%@page import='es.iespuertodelacruz.concesionario.api.Direccion' %>

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Listado Clientes</title>
  <link rel="stylesheet" href="../../css/estilos.css">
</head>
  <%@include file="../header.jsp" %>

  <body>

    <jsp:useBean id="clienteController" class="es.iespuertodelacruz.concesionario.controlador.ClienteController"/>


        <% ArrayList<Cliente> clientes = clienteController.listadoClientes(); %>
        <br><br><br><br>
        <table style="border: 1px;">
          <tr>
            <th>Codigo Cliente</th>
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
          <% for(int i = 0; i < clientes.size(); i++){ %>
            <% Cliente cliente = clientes.get(i); %>
            <% Persona persona = clienteController.generarPersona(cliente); %>
            <% Direccion direccion = persona.getDireccion(); %>
              <tr>
                <td><%= cliente.getCodigoCliente()%></td>
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