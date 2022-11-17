/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2022-11-15 20:59:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.*;
import java.sql.*;
import java.io.*;
import java.*;
import controllers.*;
import model.Artists;
import model.Arts;
import java.util.ArrayList;

public final class artsearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("controllers");
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.Artists");
    _jspx_imports_classes.add("model.Arts");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
 

ArrayList<Arts> listAllArts = (ArrayList<Arts>) request.getAttribute("listAllArts");  
 
String dataDeExposicao;

String dataDePublicacao;

String searchArt = (request.getAttribute("searchArt") == null) ? "" : request.getAttribute("searchArt").toString(); 


      out.write("   \r\n");
      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html id=\"html5\" lang=\"en-US\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/home.css\"/>\r\n");
      out.write("\r\n");
      out.write("        <title>WODA</title>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"icon\" href=\"images/logos/LogoWODA2.png\" type=\"image/gif\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <!-- \r\n");
      out.write("    <section id=\"statusSistema\">\r\n");
      out.write("\r\n");
      out.write("    </section>\r\n");
      out.write("     -->\r\n");
      out.write("\r\n");
      out.write("    <header>\r\n");
      out.write("\r\n");
      out.write("        <section id=\"sectionMenu\">\r\n");
      out.write("\r\n");
      out.write("            <section id=\"sectionButtons\">\r\n");
      out.write("\r\n");
      out.write("                <button type=\"button\" id=\"seacherButton\" class=\"Buttons\">\r\n");
      out.write("\r\n");
      out.write("                    <img class=\"ImagesButtons\" id=\"imageSeacherButton\" src=\"images/icons/pesquisar04.png\" alt=\"\"\r\n");
      out.write("                        onclick=\"openClose(seacher,'display','menuSeacher')\">\r\n");
      out.write("\r\n");
      out.write("                </button>\r\n");
      out.write("\r\n");
      out.write("                <button type=\"button\" id=\"registerButton\" class=\"Buttons\">\r\n");
      out.write("\r\n");
      out.write("                    <img class=\"ImagesButtons\" id=\"imageRegisterButton\" src=\"images/icons/cadastrar.png\" alt=\"\"\r\n");
      out.write("                        onclick=\"openPage('artistregister.html', '_self')\">\r\n");
      out.write("\r\n");
      out.write("                </button>\r\n");
      out.write("\r\n");
      out.write("                <button type=\"button\" id=\"configButton\" class=\"Buttons\">\r\n");
      out.write("\r\n");
      out.write("                    <img class=\"ImagesButtons\" id=\"imageConfigButton\" src=\"images/icons/configurações02.png\" alt=\"\"\r\n");
      out.write("                        onclick=\"openClose(config,'display','menuConfig')\">\r\n");
      out.write("\r\n");
      out.write("                </button>\r\n");
      out.write("\r\n");
      out.write("                <button type=\"button\" id=\"infoButton\" class=\"Buttons\">\r\n");
      out.write("\r\n");
      out.write("                    <img class=\"ImagesButtons\" id=\"imageInfoButton\" src=\"images/icons/info.png\" alt=\"\"\r\n");
      out.write("                        onclick=\"openClose(info,'display','menuInfo')\">\r\n");
      out.write("\r\n");
      out.write("                </button>\r\n");
      out.write("\r\n");
      out.write("            </section>\r\n");
      out.write("\r\n");
      out.write("            <section id=\"sectionMenuButton\">\r\n");
      out.write("\r\n");
      out.write("                <button type=\"button\" id=\"buttonMenu\">\r\n");
      out.write("\r\n");
      out.write("                    <img id=\"imagemButtonMenu\" src=\"images/icons/menu01.png\" alt=\"\"\r\n");
      out.write("                        onclick=\"openClose(sectionButtons,'visibility','menuMain')\">\r\n");
      out.write("\r\n");
      out.write("                </button>\r\n");
      out.write("\r\n");
      out.write("            </section>\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <section id=\"config\">\r\n");
      out.write("\r\n");
      out.write("            <table>\r\n");
      out.write("\r\n");
      out.write("                <th>\r\n");
      out.write("\r\n");
      out.write("                    <h3>SAVE SYSTEM <br> ACTIONS</h3>\r\n");
      out.write("\r\n");
      out.write("                <td>\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"saveStatus\">ON\r\n");
      out.write("                        <input type=\"radio\" name=\"saveStatus\" id=\"saveStatusOn\"\r\n");
      out.write("                            onchange=\"saveConfig('statusSaveConfig',true)\"></label>\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"saveStatus\">OFF\r\n");
      out.write("                        <input type=\"radio\" name=\"saveStatus\" id=\"saveStatusOff\"\r\n");
      out.write("                            onchange=\"saveConfig('statusSaveConfig',false)\"></label>\r\n");
      out.write("\r\n");
      out.write("                </td>\r\n");
      out.write("\r\n");
      out.write("                </th>\r\n");
      out.write("\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        <section id=\"seacher\">\r\n");
      out.write("\r\n");
      out.write("            <section id=\"sectionSeacher\">\r\n");
      out.write("\r\n");
      out.write("				<section id=\"subSectionSeacher\">          \r\n");
      out.write("\r\n");
      out.write("                	<form action=\"searcharts\">\r\n");
      out.write("                	\r\n");
      out.write("                		<fieldset>\r\n");
      out.write("\r\n");
      out.write("                			<legend class=\"LegendResgiter\">\r\n");
      out.write("\r\n");
      out.write("								<button id=\"searchButton\" type=\"button\" Class=\"Buttons\" onclick=\"submitSearcher(mySearch.value,'arts')\">\r\n");
      out.write("           							\r\n");
      out.write("           							<img class=\"Buttons\" src=\"images/icons/pesquisar02.png\" alt=\"\" >\r\n");
      out.write("								\r\n");
      out.write("								</button>\r\n");
      out.write("        \r\n");
      out.write("                			</legend>\r\n");
      out.write("\r\n");
      out.write("                    	<input id=\"mySearchArts\" type=\"search\" name=\"searchinput\" placeholder=\"Seacher\" onchange=\"submitSearcher(this.value,'arts')\" onkeyup=\"changeButton(searchButton)\" value=\"");
out.println(searchArt);
      out.write("\" autofocus>\r\n");
      out.write("						\r\n");
      out.write("						<button type=\"button\" Class=\"Buttons\" onclick=\"openPage('main','_self')\">\r\n");
      out.write("           							\r\n");
      out.write("           					<img class=\"Buttons\" src=\"images/icons/voltar.png\" alt=\"\" >\r\n");
      out.write("								\r\n");
      out.write("						</button>\r\n");
      out.write("						\r\n");
      out.write("						</fieldset>\r\n");
      out.write("\r\n");
      out.write("                	</form>\r\n");
      out.write("\r\n");
      out.write("				</section>\r\n");
      out.write("\r\n");
      out.write("            </section>\r\n");
      out.write("\r\n");
      out.write("            <section id=\"sectionTableSeacher\">\r\n");
      out.write("\r\n");
      out.write("                 <table id=\"tableArts\" class=\"tabela\">\r\n");
      out.write("\r\n");
      out.write("                    <thead>\r\n");
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("\r\n");
      out.write("                            <th>\r\n");
      out.write("                                ID\r\n");
      out.write("                            </th>\r\n");
      out.write("\r\n");
      out.write("                            <th>\r\n");
      out.write("                                NAME\r\n");
      out.write("                            </th>\r\n");
      out.write("\r\n");
      out.write("                            <th>\r\n");
      out.write("                                DESCRIPTION\r\n");
      out.write("                            </th>\r\n");
      out.write("\r\n");
      out.write("                            <th>\r\n");
      out.write("                             	EXPOSURE DATE\r\n");
      out.write("                            </th>\r\n");
      out.write("\r\n");
      out.write("                            <th>\r\n");
      out.write("                                PUBLICATION DATE\r\n");
      out.write("                            </th>\r\n");
      out.write("                            \r\n");
      out.write("                            <th>\r\n");
      out.write("                                ARTIST'S\r\n");
      out.write("                            </th>\r\n");
      out.write("                                                          \r\n");
      out.write("                            <th>\r\n");
      out.write("                               ADMIN OPTIONS\r\n");
      out.write("                            </th>                         \r\n");
      out.write("\r\n");
      out.write("                        </tr>\r\n");
      out.write("\r\n");
      out.write("                    </thead>\r\n");
      out.write("\r\n");
      out.write("                    <tbody>\r\n");
      out.write("\r\n");
      out.write("                        ");
for (int i=0; i < listAllArts.size(); i++)
                          
                        { 
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                	");
      out.print(listAllArts.get(i).getIdart());
      out.write("\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                   <a href=\"art?idArt=");
      out.print(listAllArts.get(i).getIdart());
      out.write('"');
      out.write('>');
      out.print(listAllArts.get(i).getName());
      out.write("</a> \r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                    ");
      out.print(listAllArts.get(i).getDescription());
      out.write("\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                     ");

                           		    dataDeExposicao = (listAllArts.get(i).getDataDeExposicao() == null) ? "" : listAllArts.get(i).getDataDeExposicao(); 
                           		 	
                           			out.print(dataDeExposicao);
                           		 	
      out.write("\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                   ");

                           			dataDePublicacao = (listAllArts.get(i).getDataDePublicacao() == null) ? "" : listAllArts.get(i).getDataDePublicacao(); 
                           		 	
                       				out.print(dataDePublicacao);
                       		 		
      out.write("\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                    \r\n");
      out.write("                                </td>                                                                                        \r\n");
      out.write("                                \r\n");
      out.write("                                <td>\r\n");
      out.write("                                \r\n");
      out.write("                                <section class=\"buttonsAdminOptions\"> \r\n");
      out.write("                                   \r\n");
      out.write("                                	<button type=\"button\" class=\"Buttons\">\r\n");
      out.write("                                    	\r\n");
      out.write("										<a href=\"selectartedit?idArt=");
      out.print(listAllArts.get(i).getIdart());
      out.write("&name=");
      out.print(listAllArts.get(i).getName());
      out.write("&description=");
      out.print(listAllArts.get(i).getDescription());
      out.write("&exposuredate=");
      out.print(listAllArts.get(i).getDataDeExposicao());
      out.write("&publicationdate=");
      out.print(listAllArts.get(i).getDataDePublicacao());
      out.write("&artistsextra\">\r\n");
      out.write("										<img class=\"ImagesButtons\" src=\"images/icons/editar03.png\" alt=\"\">                                    	\r\n");
      out.write("										</a>\r\n");
      out.write("                                	\r\n");
      out.write("                                	</button>\r\n");
      out.write("                                	\r\n");
      out.write("                                	<button type=\"button\" class=\"Buttons\">\r\n");
      out.write("\r\n");
      out.write("										<a href=\"javascript: confirmar(");
      out.print(listAllArts.get(i).getIdart());
      out.write(",'art')\">\r\n");
      out.write("											<img class=\"ImagesButtons\" src=\"images/icons/deletar01Vazio.png\" alt=\"\">\r\n");
      out.write("										</a>\r\n");
      out.write("										\r\n");
      out.write("                                	</button>\r\n");
      out.write("                                  \r\n");
      out.write("                              	</section>\r\n");
      out.write("                              	\r\n");
      out.write("                                </td>\r\n");
      out.write("                                \r\n");
      out.write("                            </tr>          \r\n");
      out.write("                                                        \r\n");
      out.write("                            ");
} 
      out.write("  \r\n");
      out.write("          \r\n");
      out.write("                    </tbody>\r\n");
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("\r\n");
      out.write("			</section>	\r\n");
      out.write("			\r\n");
      out.write("		</section>\r\n");
      out.write("       \r\n");
      out.write("        <section id=\"info\">\r\n");
      out.write("\r\n");
      out.write("            Dev - Paulo de Tasso <br>\r\n");
      out.write("            Senior Full Stack Developer <br>\r\n");
      out.write("            World of digital artists - WODA®\r\n");
      out.write("\r\n");
      out.write("            <img class=\"ImagesButtons\" src=\"images/icons/SUPORTE01.png\" alt=\"\">\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("    <!--  \r\n");
      out.write("\r\n");
      out.write("    <div class=\"load\">\r\n");
      out.write("        <div class=\"dot\"></div>\r\n");
      out.write("        <div class=\"dot\"></div>\r\n");
      out.write("        <div class=\"dot\"></div>\r\n");
      out.write("        <div class=\"dot\"></div>\r\n");
      out.write("        <div class=\"dot\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("    <footer>\r\n");
      out.write("\r\n");
      out.write("        <section id=\"sectionFooter\">\r\n");
      out.write("\r\n");
      out.write("            World of digital artists - WODA®\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("    </footer>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"js/home.js\">\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
