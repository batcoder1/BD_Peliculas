package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class añadirpeliculas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"form1\" action=\"\">\n");
      out.write("            \n");
      out.write("        \n");
      out.write("        <table class=\"circulo\">\n");
      out.write("            <tr>\n");
      out.write("                <td>nombre</td><td><input type=\"text\" name=\"nombre\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>formato</td><td><input type=\"text\" name=\"formato\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>numerocds</td><td><input type=\"text\" name=\"numerocds\"></td>   \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>fecha</td><td><input type=\"text\" name=\"fecha\"></td>\n");
      out.write("            </tr>    \n");
      out.write("            <tr>\n");
      out.write("                <td>caratula</td><td><input type=\"text\" name=\"caratula\"></td>\n");
      out.write("            </tr>    \n");
      out.write("            <tr>\n");
      out.write("                <td>imagen</td><td><input type=\"text\" name=\"imagen\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>calidad</td><td><input type=\"text\" name=\"calidad\"></td>\n");
      out.write("            </tr>    \n");
      out.write("            <tr>\n");
      out.write("                <td>foto</td><td><input type=\"text\" name=\"foto\"></td>\n");
      out.write("            </tr>    \n");
      out.write("            <tr>\n");
      out.write("                 <td>estreno</td><td><input type=\"text\" name=\"estreno\"></td>\n");
      out.write("            </tr>    \n");
      out.write("               \n");
      out.write("            <tr>\n");
      out.write("                <td>argumento</td><td><input type=\"text\" name=\"argumento\"></td>\n");
      out.write("            </tr>    \n");
      out.write("            <tr>\n");
      out.write("                <td>observaciones</td><td><input type=\"text\" name=\"observaciones\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>actores</td><td><input type=\"text\" name=\"actores\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>director</td><td><input type=\"text\" name=\"director\"></td>\n");
      out.write("            </tr>    \n");
      out.write("        </table>\n");
      out.write("            <input type=\"submit\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
