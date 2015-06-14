package customtag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.jsp.*;
import javax.servlet.jsp.JspTagException;
import static javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

public class peliculas extends TagSupport
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
   
        
        String select=" select titulo, estreno, rownum from (select titulo,estreno from pelis order by estreno desc) where rownum<=?";
        int number = Integer.parseInt(numero);
        PreparedStatement ps = conn.prepareStatement(select);
        ps.setInt(1, number);
         
        rset = ps.executeQuery();
        pageContext.getOut().write("<table>");
        

         while(rset.next()) {
                     
                    pageContext.getOut().write("<tr><td>"+rset.getString("titulo")+"</td></tr>"); 
 
           }
            pageContext.getOut().write("</table>");
           
        
      }catch(SQLException e){
        System.out.println("Error SQL: "+e);
       }  
      catch (IOException ex){
            throw new JspTagException("Excepcion " + ex.toString());
        }
        return  EVAL_PAGE;
    }
}