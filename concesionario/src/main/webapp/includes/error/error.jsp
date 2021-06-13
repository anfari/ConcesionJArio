<%@page import="es.iespuertodelacruz.concesionario.exception.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Error</title>
        <link rel="stylesheet" href="../../css/error.scss">
        <link rel="stylesheet" href="../../css/estilos.css">
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <div class="noise"></div>
        <div class="overlay"></div>
        <div class="terminal">
            <% 
            Exception e = (Exception) exception;
                String message = e.getMessage();
            %>
            <h1>Error <span class="errorcode">:(</span></h1>
            <p class="output"><%=message %>.</p>
            <p class="output">Por favor prueba <a style="color: red;" href="javascript: history.go(-1)">vuelve</a> o <a style="color: blue;" href="http://localhost:8080/index.jsp">ve al inicio</a>.</p>
            <p class="output">Buena suerte.</p>
        </div>
        <%@include file="../footer.jsp" %>
    </body>
</html>