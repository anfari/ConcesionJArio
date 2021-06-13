<%@ page errorPage = "error/error.jsp" %>
<%@ page import="es.iespuertodelacruz.concesionario.controlador.EmpleadoController" %>
<%@ page import= "es.iespuertodelacruz.concesionario.exception.*" %>
<% try { %>
<% es.iespuertodelacruz.concesionario.controlador.EmpleadoController empleadoController = new EmpleadoController();  %>
<% } catch (PersistenciaException e) { System.out.println(e); } %>

<html>
    <head>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <h1>Verificando datos</h1>
        <jsp:useBean id="empleadoController" class="es.iespuertodelacruz.concesionario.controlador.EmpleadoController"/>

        <% String usuario = request.getParameter("usuario"); %>
        <% String contrasenia = request.getParameter("contrasenia"); %>
          
        <% String rango =  empleadoController.comprobarCredenciales(usuario, contrasenia);%> 
        <%if(rango.equalsIgnoreCase("Gerente")){%>
            <meta http-equiv = "refresh" content = " 1 ; url = menu/menuGerente.jsp"/>
        <%}%>
        <%if(rango.equalsIgnoreCase("Empleado")){%>
            <meta http-equiv = "refresh" content = " 1 ; url = menu/menuEmpleados.jsp"/>
        <%}%> 
    </body>
</html>