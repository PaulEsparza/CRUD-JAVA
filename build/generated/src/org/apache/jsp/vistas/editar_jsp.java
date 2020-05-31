package org.apache.jsp.vistas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import app.modelo.Usuario;
import app.dao.UsuarioDAOMySQL;

public final class editar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>EDITAR</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
            UsuarioDAOMySQL dao = new UsuarioDAOMySQL();
            int id = Integer.parseInt((String)request.getParameter("idU"));
            Usuario u = (Usuario) dao.consulta(id);
        
      out.write("\n");
      out.write("        <form action=\"Controlador\" method=\"POST\">\n");
      out.write("            Alias:<input type=\"text\" name=\"alias\" value=\"");
      out.print( u.getAlias() );
      out.write("\"><br>\n");
      out.write("            Nombre:<input type=\"text\" name=\"nombre\" value=\"");
      out.print( u.getNombre());
      out.write("\"><br>\n");
      out.write("            Apellidos:<input type=\"text\" name=\"apellidos\" value=\"");
      out.print( u.getApellidos());
      out.write("\"><br>\n");
      out.write("            Contraseña:<input type=\"text\" name=\"contrasena\" value=\"");
      out.print( u.getContrasena());
      out.write("\"><br>\n");
      out.write("            Correo:<input type=\"text\" name=\"email\" value=\"");
      out.print( u.getEmail());
      out.write("\"><br>\n");
      out.write("            <input type=\"hidden\" name=\"txtId\" value=\"");
      out.print( u.getId());
      out.write("\">\n");
      out.write("            <button type=\"submit\" name=\"btnEditar\">Editar</button><br>\n");
      out.write("            <a href=\"Controlador?accion=listar\">Cancelar</a>\n");
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
