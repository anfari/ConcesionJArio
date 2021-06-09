<%@ page import="es.iespuertodelacruz.concesionario.controlador.EmpleadoController" %>
<%! es.iespuertodelacruz.concesionario.controlador.EmpleadoController empleadoController = new EmpleadoController();  %>

<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Validar Usuario</title>
       <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <h1>Verificar datos</h1>
        <jsp:useBean id="empleadoController" class="es.iespuertodelacruz.concesionario.controlador.EmpleadoController"/>
          
        <jsp:setProperty name="empleadoController" property="usuario"/>
        <jsp:setProperty name="empleadoController" property="contrasenia"/>
          
        <%rango =  empleadoController.comprobarCredenciales(usuario, contrasenia);%> 
        <%if(rango.equalsIgnoreCase("Gerente")){%>
            <meta http-equiv = "refresh" content = " 1 ; url = test.jsp"/>
        <%}%>
        <%if(rango.equalsIgnoreCase("Empleado")){%>
            <meta http-equiv = "refresh" content = " 1 ; url = oindex.jsp"/>
        <%}else{%>
            Error! El USUARIO es INVALIDO<br/>
        <%}%>  
    </body>
</html>