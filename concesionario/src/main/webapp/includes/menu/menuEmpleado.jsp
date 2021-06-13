<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Login</title>
      <link rel="stylesheet" href="../../css/estilos.css">
    </head>
    <body>
      <%@include file="../header.jsp" %>

      <h1>Gestor Empleados</h1>
      <div class="menu">
        <a href="../paginasempleado/formularioInsertarEmpleado.jsp">Nuevo</a>
        <a href="../paginasempleado/formularioModificarEmpleado.jsp">Modificar</a>
        <a href="../paginasempleado/formularioEliminarEmpleado.jsp">Eliminar</a>
        <a href="../paginasempleado/listadoEmpleados.jsp">Listado</a>
        <a href="../paginasempleado/formularioBuscarEmpleado.jsp">Buscar</a>
     </div>

      <%@include file="../footer.jsp" %>
    </body>
</html>