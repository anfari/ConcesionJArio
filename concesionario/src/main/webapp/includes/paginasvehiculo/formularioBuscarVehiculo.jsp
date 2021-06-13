<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulario Vehiculo</title>
        <link rel="stylesheet" href="../../css/estilos.css">
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <div class="formulario-unico">
            <form method="POST" action="buscarVehiculo.jsp">
                <label>Bastidor: </label> <input type="text" name="bastidor" placeholder="VSSZZZ6KZ1R149943"><br>
                <input type="submit" value="Finalizar">
            </form>
        </div>
        <%@include file="../footer.jsp" %>
    </body>
</html>