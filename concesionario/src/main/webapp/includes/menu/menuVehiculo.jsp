<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Login</title>
      <link rel="stylesheet" href="../../css/estilos.css">
    </head>
    <body>
      <%@include file="../header.jsp" %>

      <h1>Gestor Vehiculos</h1>
      <div class="menu">
        <a href="../paginasvehiculo/formularioInsertarVehiculo.jsp">Nuevo</a>
        <a href="../paginasvehiculo/formularioModificarVehiculo.jsp">Modificar</a>
        <a href="../paginasvehiculo/formularioEliminarVehiculo.jsp">Eliminar</a>
        <a href="../paginasvehiculo/listadoVehiculos.jsp">Listado</a>
        <a href="../paginasvehiculo/formularioBuscarVehiculo.jsp">Buscar</a>
     </div>

      <%@include file="../footer.jsp" %>
    </body>
</html>