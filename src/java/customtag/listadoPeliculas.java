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

public class listadoPeliculas extends TagSupport
{
    String numero;
    Connection conn;
    

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
         
   
        String consulta;
        int posicion;
        int numeroregistros=0;
        HttpServletRequest peticion = ( HttpServletRequest )pageContext.getRequest();
        if(peticion.getParameter("posicion")!=null){
            posicion=Integer.parseInt(peticion.getParameter("posicion"));
        }else{
            posicion=1;
        }

        try{
         
                Statement sentencia = conn.createStatement();
                consulta="SELECT peli_cod, titulo, formato, numerocds FROM (SELECT tablapelis.*, ROWNUM rnum FROM (SELECT peli_cod, titulo, formato, numerocds FROM pelis ORDER BY peli_cod) tablapelis WHERE ROWNUM < "+(posicion+5)+") WHERE rnum >= "+posicion;
                ResultSet rs=sentencia.executeQuery(consulta);
                Statement sentencia2 = conn.createStatement();
                ResultSet rs2 = sentencia2.executeQuery("SELECT COUNT(*) AS NUMERO FROM pelis");
                rs2.next();
                numeroregistros = rs2.getInt("NUMERO");
                rs2.close();
                pageContext.getOut().write("<table>");
                pageContext.getOut().write("<tr><th class='cabecera'>Numero</th><th class='cabecera'>Titulo</th><th class='cabecera'>Formato</th><th class='cabecera'>NumeroCDs</th><th class='cabecera' colspan=2>Acciones</th></tr>");

                while(rs.next())
                {
                    
                    pageContext.getOut().write("<tr><td>"+rs.getString("peli_cod")+"</td>");
                    pageContext.getOut().write("<td>"+rs.getString("titulo")+"</td>");
                    pageContext.getOut().write("<td>"+rs.getString("formato")+"</td>");
                    pageContext.getOut().write("<td>"+rs.getString("numerocds")+"</td>");
                    pageContext.getOut().write("<td><a href='modificar.jsp?codigo="+ rs.getString("peli_cod")+"'>Modificar</a></td>");
                    pageContext.getOut().write("<td><a href='borrar.jsp?codigo="+ rs.getString("peli_cod")+"'>Borrar</a></td>");
                    pageContext.getOut().write("</tr>");
                }
                pageContext.getOut().write("</table>");
                int numpagina = 1;
                for (int i=0;i < numeroregistros; i+=20)
                {
                    int aux = i + 1;
                    pageContext.getOut().write("<a href='listadopeliculas.jsp?posicion="+ aux + "'>["+aux+"-"+(aux+19)+"]</a>&nbsp;");
                    numpagina++;
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