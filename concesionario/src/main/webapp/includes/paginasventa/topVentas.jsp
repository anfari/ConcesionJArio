<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import='java.util.ArrayList' %>
<%@ page errorPage = "../error/loginError.jsp" %>
<%@page import='es.iespuertodelacruz.concesionario.controlador.VentaController' %>


<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Test</title>
  <link rel="stylesheet" href="../../css/estilos.css">
</head>
    <%@include file="../header.jsp" %>

  <body>

    <jsp:useBean id="ventaController" class="es.iespuertodelacruz.concesionario.controlador.VentaController"/>

    <div class="top-ventas">
        <% ArrayList<String> topVentas = ventaController.agruparVentas(); %>
        <table style="border: 1px;">
            <h2>TOP 5</h2>
            <% for(int i = 0; i < 5; i++){ %>
                <% String topVenta = topVentas.get(i); %>
                <p><%= topVentas.get(i)%></p>
            <% } %> 
        </table>
    </div>

    <%@include file="../footer.jsp" %>
  </body>

</html>