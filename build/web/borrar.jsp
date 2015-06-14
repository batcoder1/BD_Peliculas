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
      <Center>
            <h1>Listado Peliculas</h1>
            <Peliculas:borrar/>
            <Peliculas:listadopelis/>
      </center>
        
    </body>
</html>

