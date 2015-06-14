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

public class addPeliculas extends TagSupport
{
    private String titulo, formato, numerocds, fecha, caratula, imagen, calidad, foto, estreno, argumento, observaciones, actores, director;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getNumerocds() {
        return numerocds;
    }

    public void setNumerocds(String numerocds) {
        this.numerocds = numerocds;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstreno() {
        return estreno;
    }

    public void setEstrenos(String estrenos) {
        this.estreno = estreno;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

   
    
    Connection conn;
    ResultSet rset;


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
        if (peticion.getParameter("titulo")!=null){ 
         titulo=peticion.getParameter("titulo") ;
         formato=peticion.getParameter("formato");
         numerocds=peticion.getParameter("numerocds");
         fecha=peticion.getParameter("fecha");
         caratula=peticion.getParameter("caratula");
         imagen=peticion.getParameter("imagen");
         calidad=peticion.getParameter("calidad");
         foto=peticion.getParameter("foto");
         estreno=peticion.getParameter("estreno");
         argumento=peticion.getParameter("argumento");
         observaciones=peticion.getParameter("observaciones");
         actores=peticion.getParameter("actores");
         director=peticion.getParameter("director");
         
         
         String insert="insert into pelis values(?,?,?,sq_codpeli.nextval,to_date(?,'dd-mm-yyyy'),?,?,?,?,to_date(?,'dd-mm-yyyy'),?,?,?,?)";
        
        
        PreparedStatement ps = conn.prepareStatement(insert);
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
        
        int num = ps.executeUpdate();
        if(num==1){
            pageContext.getOut().write("<p> Pelicula añadida correctamente</p>");
        }
        else{
            pageContext.getOut().write("<p> Error, fallo en el alta</p>");
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