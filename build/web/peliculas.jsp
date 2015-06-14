<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="etiquetas" prefix="Peliculas"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link href="estilos.css" rel="stylesheet" type="text/css"/>
        <title>Peliculas</title>
    </head>
    <body>
        <center>
            <h1>Lista Ultimas Peliculas</h1>
            <Peliculas:pelis numero="10"/>
            <a href="listadopeliculas.jsp"> Pulse para acceder al listado de peliculas</a>
            <a href="addpeliculas.jsp">Pulse para añadir una pelicula</a>
            
        </center>
        
    </body>
</html>
