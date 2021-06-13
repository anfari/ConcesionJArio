<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulario Venta</title>
        <link rel="stylesheet" href="../../css/estilos.css">
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <div class="formulario-venta">
            <form method="POST" action="realizarVenta.jsp">
                <label>Codigo Empleado: </label> <input type="text" name="codigoEmpleado" placeholder="234"><br>
                <label>Codigo Cliente: </label> <input type="text" name="codigoCliente" placeholder="12345"><br>
                <label>Numero de Bastidor: </label> <input type="text" name="numeroBastidor" placeholder="VSSZZZ6KZ1R149941"><br>
                <input type="submit" value="Vender">
                
            </form>
        </div>
        <%@include file="../footer.jsp" %>
    </body>
</html>