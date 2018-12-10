package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tabla_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function() {\n");
      out.write("                $('#ejemplo').DataTable({\n");
      out.write("                    \"language\":{\n");
      out.write("                            \"sProcessing\":     \"Procesando...\",\n");
      out.write("    \"sLengthMenu\":     \"Mostrar _MENU_ registros\",\n");
      out.write("    \"sZeroRecords\":    \"No se encontraron resultados\",\n");
      out.write("    \"sEmptyTable\":     \"Ningún dato disponible en esta tabla\",\n");
      out.write("    \"sInfo\":           \"Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros\",\n");
      out.write("    \"sInfoEmpty\":      \"Mostrando registros del 0 al 0 de un total de 0 registros\",\n");
      out.write("    \"sInfoFiltered\":   \"(filtrado de un total de _MAX_ registros)\",\n");
      out.write("    \"sInfoPostFix\":    \"\",\n");
      out.write("    \"sSearch\":         \"Buscar:\",\n");
      out.write("    \"sUrl\":            \"\",\n");
      out.write("    \"sInfoThousands\":  \",\",\n");
      out.write("    \"sLoadingRecords\": \"Cargando...\",\n");
      out.write("    \"oPaginate\": {\n");
      out.write("        \"sFirst\":    \"Primero\",\n");
      out.write("        \"sLast\":     \"Último\",\n");
      out.write("        \"sNext\":     \"Siguiente\",\n");
      out.write("        \"sPrevious\": \"Anterior\"\n");
      out.write("    },\n");
      out.write("    \"oAria\": {\n");
      out.write("        \"sSortAscending\":  \": Activar para ordenar la columna de manera ascendente\",\n");
      out.write("        \"sSortDescending\": \": Activar para ordenar la columna de manera descendente\"\n");
      out.write("    }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("    \n");
      out.write("                        \n");
      out.write("                        );\n");
      out.write("                \n");
      out.write("            } );\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <table id=\"ejemplo\" class=\"display\">\n");
      out.write("            \n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Nombre</th>\n");
      out.write("                    <th>Apellido</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Felipe</td>\n");
      out.write("                    <td>Gutierrez</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Carlos</td>\n");
      out.write("                    <td>Guzman</td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("            </tbody>\n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        \n");
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
