
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
    <link rel="stylesheet" href="../css/contacto.scss">
</head>

<body>
    <%@include file="header.jsp" %>
    
    <div id="logo">
        <h1><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Contactanos</i></h1>
    </div>
    <section class="stark-login">
        <br><br><br>
        <form action="" method="GET">
            <div id="fade-box">
                <input type="text" name="nombre" id="nombre" placeholder="Nombre" required>
                <input type="text" name="email" id="email" placeholder="Email" required>
                <input type="text" name="asunto" id="asunto" placeholder="Asunto" required>
                <input type="text" name="mensaje" id="mensaje" placeholder="Mensaje" required>

                <button type="submit">Enviar</button>
            </div>
        </form>

    </section>

    <div id="circle1">
        <div id="inner-cirlce1">
            <h2> </h2>
        </div>
    </div>



    
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>



    <script src="js/index.js"></script>



    <%@include file="footer.jsp" %>
</body>
</html>