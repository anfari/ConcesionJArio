<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Login</title>
      <link rel="stylesheet" href="../../css/estilos.css">
    </head>
    <body>
      <%@include file="../header.jsp" %>

      <h1>Gestor Clientes</h1>
      <div class="menu">
        <a href="../paginascliente/formularioInsertarCliente.jsp">Nuevo</a>
        <a href="../paginascliente/formularioModificarCliente.jsp">Modificar</a>
        <a href="../paginascliente/formularioEliminarCliente.jsp">Eliminar</a>
        <a href="../paginascliente/listadoClientes.jsp">Listado</a>
        <a href="../paginascliente/formularioBuscarCliente.jsp">Buscar</a>
     </div>

      <%@include file="../footer.jsp" %>
    </body>
</html>