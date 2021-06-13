<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulario Cliente</title>
        <link rel="stylesheet" href="../../css/estilos.css">
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <div class="formulario-unico">
            <form method="POST" action="buscarCliente.jsp">
                <label>Dni: </label> <input type="text" name="dni" placeholder="00000000X"><br>
                <input type="submit" value="Finalizar">
            </form>
        </div>
        <%@include file="../footer.jsp" %>
    </body>
</html>