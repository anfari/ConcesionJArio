<%@ page errorPage = "includes/error/loginError.jsp" %>
<%@ page import="es.iespuertodelacruz.concesionario.controlador.EmpleadoController" %>
<%@ page import= "es.iespuertodelacruz.concesionario.exception.PersistenciaException" %>
<% try { %>
<% es.iespuertodelacruz.concesionario.controlador.EmpleadoController empleadoController = new EmpleadoController();  %>
<% } catch (PersistenciaException e) { System.out.println(e); } %>

<html>
    <body>
        <h1>Verificar datos</h1>
        <jsp:useBean id="empleadoController" class="es.iespuertodelacruz.concesionario.controlador.EmpleadoController"/>

        <% String usuario = request.getParameter("usuario"); %>
        <% String contrasenia = request.getParameter("contrasenia"); %>
          
        <% String rango =  empleadoController.comprobarCredenciales(usuario, contrasenia);%> 
        <%if(rango.equalsIgnoreCase("Gerente")){%>
            <meta http-equiv = "refresh" content = " 1 ; url = includes/test.jsp"/>
        <%}%>
        <%if(rango.equalsIgnoreCase("Empleado")){%>
            <meta http-equiv = "refresh" content = " 1 ; url = includes/oindex.jsp"/>
        <%}else{%>
            Error! El USUARIO es INVALIDO<br/>
        <%}%>  
    </body>
</html>