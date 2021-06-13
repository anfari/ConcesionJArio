<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulario Vehiculo</title>
        <link rel="stylesheet" href="../../css/estilos.css">
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <div class="formulario-cliente">
            <form method="POST" action="insertarVehiculo.jsp">
                <label>Bastidor: </label> <input type="text" name="bastidor" placeholder="VSSZZZ6KZ1R149943"><br>
                <label>Matricula: </label> <input type="text" name="matricula" placeholder="1234AAA"><br>
                <label>Marca: </label> <input type="text" name="marca" placeholder="Open"><br>
                <label>Modelo: </label> <input type="text" name="modelo" placeholder="Astra"><br>
                <label>Color: </label> <input type="text" name="color" placeholder="Blanco"><br>
                <label>Cilindrada: </label> <input type="text" name="cilindrada" placeholder="1400cc"><br>
                <label>Tipo de Motor: </label> <input type="text" name="motor" placeholder="Diesel/Gasolina"><br>
                <label>Potencia: </label> <input type="text" name="potencia" placeholder="120"><br>
                <label>Extras: </label> <input type="text" name="extras" placeholder="Llantas, alarma..."><br>
                <label>Precio: </label> <input type="text" name="precio" placeholder="15000"><br>
                <label>Tipo: </label> <input type="text" name="tipo" placeholder="Coche/Moto..."><br>
                <label>Estado: </label> <input type="text" name="estado" placeholder="Disponible/Vendido"><br>
                <input type="submit" value="Finalizar">
            </form>
            <br><br><br><br>
        </div>
        <%@include file="../footer.jsp" %>
    </body>
</html>