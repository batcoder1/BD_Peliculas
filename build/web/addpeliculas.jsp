<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="etiquetas" prefix="Peliculas"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
     <center>
         
         <Peliculas:addpelis/>
        <form name="form1" action="peliculas.jsp">
            
        
        <table>
            <h1>Añadir peliculas</h1>
            <tr>
                <td>Titulo</td><td><input type="text" name="titulo"></td>
            </tr>
            <tr>
                <td>Formato</td><td><input type="text" name="formato"></td>
            </tr>
            <tr>
                <td>Numero Cds</td><td><input type="text" name="numerocds"></td>   
            </tr>
            <tr>
                <td>Fecha</td><td><input type="text" name="fecha"></td>
                
            </tr>    
            <tr>
                <td>Caratula</td><td><input type="text" name="caratula"></td>
            </tr>    
            <tr>
                <td>Imagen</td><td><input type="text" name="imagen"></td>
            </tr>
            <tr>
                <td>Calidad</td><td><input type="text" name="calidad"></td>
            </tr>    
            <tr>
                <td>Foto</td><td><input type="text" name="foto"></td>
            </tr>    
            <tr>
                <td>Estreno</td><td><input type="text" name="estreno"></td>
            </tr>    
               
            <tr>
                <td>Argumento</td><td><input type="text" name="argumento"></td>
            </tr>    
            <tr>
                <td>Observaciones</td><td><input type="text" name="observaciones"></td>
            </tr>
            <tr>
                <td>Actores</td><td><input type="text" name="actores"></td>
            </tr>
            <tr>
                <td>Director</td><td><input type="text" name="director"></td>
            </tr>    
        </table>
            <input type="submit">
        </form>
       
     </center>
    </body>
</html>
