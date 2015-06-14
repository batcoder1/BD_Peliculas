package customtag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.*;
import javax.servlet.jsp.JspTagException;
import static javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

public class modificar extends TagSupport
{
    String numero;
    Connection conn;
    ResultSet rset;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

 
    @Override
    public int doStartTag() throws JspTagException
    {
          try{
           DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
           conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle");
          }catch(SQLException e){
        System.out.println("Error SQL: "+e);
       }  
        return EVAL_BODY_INCLUDE;
    }

    @Override    
    public int doEndTag() throws JspTagException 
    {
        try{
   
        HttpServletRequest peticion = ( HttpServletRequest )pageContext.getRequest();
        
        if (peticion.getParameter("codigo")!=null){ 
            int number = Integer.parseInt(peticion.getParameter("codigo"));
            String select=" select titulo, formato, numerocds, peli_cod,to_char(fecha,'dd/mm/yyyy') as fecha, caratula, imagen, calidad, foto, to_char(estreno,'dd-mm-yyy') as estreno, argumento, observaciones, actores, director from pelis where peli_cod=?";

            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1, number);

            rset = ps.executeQuery();
             pageContext.getOut().write("<h1>Detalles de la Pelicula</h1>");
             pageContext.getOut().write("<form name='form1' action='modificar.jsp'>");
            pageContext.getOut().write("<table>");


             while(rset.next()) {

                        pageContext.getOut().write("<tr><td>Titulo</td><td><input type='text' name='titulo' value='"+rset.getString("titulo")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>Formato</td><td><input type='text' name='formato' value='"+rset.getString("formato")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>Numero CDs</td><td><input type='text' name='numerocds' value='"+rset.getString("numerocds")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>pelis_cod</td><td><input type='text' name='peli_cod' value='"+rset.getString("peli_cod")+"' readonly='true'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>Fecha</td><td><input type='text' name='fecha' value='"+rset.getString("fecha")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>Caratula</td><td><input type='text' name='caratula' value='"+rset.getString("caratula")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>Imagen</td><td><input type='text' name='imagen' value='"+rset.getString("imagen")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>Calidad</td><td><input type='text' name='calidad' value='"+rset.getString("calidad")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>foto</td><td><input type='text' name='foto' value='"+rset.getString("foto")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>Estreno</td><td><input type='text' name='estreno' value='"+rset.getString("estreno")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>Argumento</td><td><input type='text' name='argumento' value='"+rset.getString("argumento")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>Observaciones</td><td><input type='text' name='observaciones' value='"+rset.getString("observaciones")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>Actores</td><td><input type='text' name='actores' value='"+rset.getString("actores")+"'></td></tr>"); 
                        pageContext.getOut().write("<tr><td>Director</td><td><input type='text' name='director' value='"+rset.getString("director")+"'></td></tr>"); 



               }
                pageContext.getOut().write("</table>");
                 pageContext.getOut().write("<input type='submit' value='Modificar datos'>");
                pageContext.getOut().write("</form>");
        }
        else{
            String titulo=peticion.getParameter("titulo") ;
            String formato=peticion.getParameter("formato");
            String numerocds=peticion.getParameter("numerocds");
            String peli_cod=peticion.getParameter("peli_cod");
            String fecha=peticion.getParameter("fecha");
            String caratula=peticion.getParameter("caratula");
            String imagen=peticion.getParameter("imagen");
            String calidad=peticion.getParameter("calidad");
            String foto=peticion.getParameter("foto");
            String estreno=peticion.getParameter("estreno");
            String argumento=peticion.getParameter("argumento");
            String observaciones=peticion.getParameter("observaciones");
            String actores=peticion.getParameter("actores");
            String director=peticion.getParameter("director");
         
        String update="update pelis set titulo=?,formato=?,numerocds=?,fecha=to_date(?,'dd-mm-yyyy'),caratula=?,imagen=?,calidad=?,foto=?,estreno=to_date(?,'dd-mm-yyyy'),argumento=?,observaciones=?,actores=?,director=? where peli_cod=?";
        
             
        PreparedStatement ps = conn.prepareStatement(update);
        ps.setString(1, titulo);
        ps.setString(2, formato);
        ps.setString(3, numerocds);
        ps.setString(4, fecha);
        ps.setString(5, caratula);
        ps.setString(6, imagen);
        ps.setString(7, calidad);
        ps.setString(8, foto);
        ps.setString(9, estreno);
        ps.setString(10, argumento);
        ps.setString(11, observaciones);
        ps.setString(12, actores);
        ps.setString(13, director);
        ps.setString(14,peli_cod);
        
        int num = ps.executeUpdate();
        if(num==1){
            pageContext.getOut().write("<p> Pelicula modificada correctamente</p>");
        }
        else{
            pageContext.getOut().write("<p> Error, fallo en la modificacion </p>");
        }   
        }
            
          }catch(SQLException e){
            System.out.println("Error SQL: "+e);
           }  
          catch (IOException ex){
                throw new JspTagException("Excepcion " + ex.toString());
            }
        
        return  EVAL_PAGE;
    }
}