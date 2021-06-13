<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulario Empleado</title>
        <link rel="stylesheet" href="../../css/estilos.css">
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <div class="formulario-cliente">
            <form method="POST" action="modificarEmpleado.jsp">
                <label>Codigo Empleado: </label> <input type="text" name="codigoEmpleado" placeholder="1234"><br>
                <label>Rango: </label> <input type="text" name="rango" placeholder="Empleado"><br>
                <label>Contrasenia: </label> <input type="text" name="contrasenia" placeholder="empleadoXX?"><br>
                <label>Dni: </label> <input type="text" name="dni" placeholder="00000000X"><br>
                <label>Nombre: </label> <input type="text" name="nombre" placeholder="Juan"><br>
                <label>Apellidos: </label> <input type="text" name="apellidos" placeholder="Perez Benito"><br>
                <label>Fecha Nacimiento: </label> <input type="text" name="fechaNacimiento" placeholder="25/04/1994"><br>
                <label>Telefono: </label> <input type="text" name="telefono" placeholder="123456789"><br>

                <label>Pais: </label> <input type="text" name="pais" placeholder="Espana"><br>
                <label>Provincia: </label> <input type="text" name="provincia" placeholder="Santa Cruz de Tenerife"><br>
                <label>Ciudad: </label> <input type="text" name="ciudad" placeholder="Puerto de la Cruz"><br>
                <label>Calle: </label> <input type="text" name="calle" placeholder="Avenida Ruiz"><br>
                <label>Numero: </label> <input type="text" name="numero" placeholder="5"><br>
                <label>Codigo Postal: </label> <input type="text" name="codigoPostal" placeholder="38400"><br>

                <input type="submit" value="Finalizar">
                
            </form>
            <br><br><br><br>
        </div>
        <%@include file="../footer.jsp" %>
    </body>
</html>