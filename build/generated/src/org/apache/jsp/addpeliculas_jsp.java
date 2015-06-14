package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addpeliculas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/etiquetas/peliculas.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_Peliculas_addpelis_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_Peliculas_addpelis_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_Peliculas_addpelis_nobody.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");
      if (_jspx_meth_Peliculas_addpelis_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        <form name=\"form1\" action=\"addpeliculas.jsp\">\n");
      out.write("            \n");
      out.write("        \n");
      out.write("        <table class=\"circulo\">\n");
      out.write("            <tr>\n");
      out.write("                <td>Titulo</td><td><input type=\"text\" name=\"titulo\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Formato</td><td><input type=\"text\" name=\"formato\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Numero Cds</td><td><input type=\"text\" name=\"numerocds\"></td>   \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Fecha</td><td><input type=\"text\" name=\"fecha\"></td>\n");
      out.write("                \n");
      out.write("            </tr>    \n");
      out.write("            <tr>\n");
      out.write("                <td>Caratula</td><td><input type=\"text\" name=\"caratula\"></td>\n");
      out.write("            </tr>    \n");
      out.write("            <tr>\n");
      out.write("                <td>Imagen</td><td><input type=\"text\" name=\"imagen\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Calidad</td><td><input type=\"text\" name=\"calidad\"></td>\n");
      out.write("            </tr>    \n");
      out.write("            <tr>\n");
      out.write("                <td>Foto</td><td><input type=\"text\" name=\"foto\"></td>\n");
      out.write("            </tr>    \n");
      out.write("            <tr>\n");
      out.write("                <td>Estreno</td><td><input type=\"text\" name=\"estreno\"></td>\n");
      out.write("            </tr>    \n");
      out.write("               \n");
      out.write("            <tr>\n");
      out.write("                <td>Argumento</td><td><input type=\"text\" name=\"argumento\"></td>\n");
      out.write("            </tr>    \n");
      out.write("            <tr>\n");
      out.write("                <td>Observaciones</td><td><input type=\"text\" name=\"observaciones\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Actores</td><td><input type=\"text\" name=\"actores\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Director</td><td><input type=\"text\" name=\"director\"></td>\n");
      out.write("            </tr>    \n");
      out.write("        </table>\n");
      out.write("            <input type=\"submit\">\n");
      out.write("        </form>\n");
      out.write("       \n");
      out.write("   \n");
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

  private boolean _jspx_meth_Peliculas_addpelis_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  Peliculas:addpelis
    customtag.addPeliculas _jspx_th_Peliculas_addpelis_0 = (customtag.addPeliculas) _jspx_tagPool_Peliculas_addpelis_nobody.get(customtag.addPeliculas.class);
    _jspx_th_Peliculas_addpelis_0.setPageContext(_jspx_page_context);
    _jspx_th_Peliculas_addpelis_0.setParent(null);
    int _jspx_eval_Peliculas_addpelis_0 = _jspx_th_Peliculas_addpelis_0.doStartTag();
    if (_jspx_th_Peliculas_addpelis_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_Peliculas_addpelis_nobody.reuse(_jspx_th_Peliculas_addpelis_0);
      return true;
    }
    _jspx_tagPool_Peliculas_addpelis_nobody.reuse(_jspx_th_Peliculas_addpelis_0);
    return false;
  }
}
