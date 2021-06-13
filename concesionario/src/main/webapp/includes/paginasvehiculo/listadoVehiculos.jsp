<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import='java.util.ArrayList' %>
<%@ page errorPage = "../error/error.jsp" %>
<%@page import='es.iespuertodelacruz.concesionario.api.Vehiculo' %>
<%@page import='es.iespuertodelacruz.concesionario.controlador.VehiculoController' %>

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Listado de Vehiculos</title>
  <link rel="stylesheet" href="../../css/estilos.css">
</head>
  <%@include file="../header.jsp" %>

  <body>

    <jsp:useBean id="vehiculoController" class="es.iespuertodelacruz.concesionario.controlador.VehiculoController"/>


        <% ArrayList<Vehiculo> vehiculos = vehiculoController.listadoVehiculos(); %>
        <br><br><br><br>
        <table style="border: 1px;">
          <tr>
            <th>Bastidor</th>
            <th>Matricula</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Color</th>
            <th>Precio</th>
            <th>Motor</th>
            <th>Potencia</th>
            <th>Cilindrada</th>
            <th>Tipo</th>
            <th>Estado</th>
            <th>Extras</th>
          </tr>
          <% for(int i = 0; i < vehiculos.size(); i++){ %>
            <% Vehiculo vehiculo = vehiculos.get(i); %>
              <tr>
                <td><%= vehiculo.getBastidor()%></td>
                <td><%= vehiculo.getMatricula()%></td>
                <td><%= vehiculo.getMarca()%></td>
                <td><%= vehiculo.getModelo()%></td>
                <td><%= vehiculo.getColor()%></td>
                <td><%= vehiculo.getPrecio()%></td>
                <td><%= vehiculo.getMotor()%></td>
                <td><%= vehiculo.getPotencia()%></td>
                <td><%= vehiculo.getCilindrada()%></td>
                <td><%= vehiculo.getTipo()%></td>
                <td><%= vehiculo.getEstado()%></td>
                <td><%= vehiculo.getExtrasInstalados()%></td>
              </tr>
            <% } %> 
        </table>


    
  </body>
  <%@include file="../footer.jsp" %>
</html>