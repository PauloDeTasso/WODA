/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2022-11-14 20:30:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.*;
import java.util.ArrayList;

public final class artedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");

 ArrayList<Artists> listAllArtist = (ArrayList<Artists>) request.getAttribute("listAllArtists");  

      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!DOCTYPE html>\r\n");
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
      out.write("        <link rel=\"stylesheet\" href=\"css/register.css\" />\r\n");
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
      out.write("                <button type=\"button\" id=\"seacherButton\" class=\"ButtonsRegister\">\r\n");
      out.write("\r\n");
      out.write("                    <img class=\"ImagesButtons\" id=\"imageSeacherButton\" src=\"images/icons/voltar.png\" alt=\"\"\r\n");
      out.write("                        onclick=\"openPage('main', '_self')\">\r\n");
      out.write("\r\n");
      out.write("                </button>\r\n");
      out.write("\r\n");
      out.write("                <button type=\"button\" id=\"infoButton\" class=\"ButtonsRegister\">\r\n");
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
      out.write("                        onclick=\"openClose(sectionButtons,'visibility')\">\r\n");
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
      out.write("        <form id=\"formRegisterArt\" name=\"formregisterart\" enctype=\"multipart/form-data\" action=\"artregister\"\r\n");
      out.write("            method=\"post\" onreset=\"clear()\">\r\n");
      out.write("\r\n");
      out.write("            <fieldset>\r\n");
      out.write("\r\n");
      out.write("                <legend class=\"LegendResgiter\">\r\n");
      out.write("\r\n");
      out.write("                    <img class=\"Buttons\" src=\"images/icons/images02.png\" alt=\"\">\r\n");
      out.write("\r\n");
      out.write("                </legend>\r\n");
      out.write("\r\n");
      out.write("                <table>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("\r\n");
      out.write("                            <input type=\"text\" name=\"idArt\" size='10' placeholder=\"ID\" readonly>\r\n");
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <div id=\"msgIdArtist\" class=\"AlertMsgs\"></div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("\r\n");
      out.write("                            <input type=\"text\" name=\"name\" maxlength=\"60\" size='65' placeholder=\"ART NAME\"\r\n");
      out.write("                                onchange=\"verificarNome(this.value)\" required>\r\n");
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <div id=\"msgName\" class=\"AlertMsgs\"></div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("\r\n");
      out.write("                            <input type=\"text\" id=\"description\" name=\"description\"\r\n");
      out.write("                                onchange=\"descriptionValidate(this.value)\" maxlength=\"240\" placeholder=\"ART DESCRIPTION\"\r\n");
      out.write("                                required>\r\n");
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <div id=\"msgDescription\" class=\"AlertMsgs\"></div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("\r\n");
      out.write("                        <td>\r\n");
      out.write("\r\n");
      out.write("                            <input type=\"text\" name=\"publicationdate\" id=\"publicationDate\"\r\n");
      out.write("                                placeholder=\"...PUBLICATION DATE...\" onfocus=\"(this.type='date')\"\r\n");
      out.write("                                onchange=\"validateDate('publicationDate',msgPublicationDate)\" required>\r\n");
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <div id=\"msgPublicationDate\" class=\"AlertMsgs\"></div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("\r\n");
      out.write("                        <td>\r\n");
      out.write("\r\n");
      out.write("                            <input type=\"text\" name=\"exposuredate\" id=\"exposureDate\" placeholder=\"...EXPOSURE DATE...\"\r\n");
      out.write("                                onfocus=\"(this.type='date')\" onchange=\"validateDate('exposureDate',msgExposureDate)\"\r\n");
      out.write("                                required>\r\n");
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <div id=\"msgExposureDate\" class=\"AlertMsgs\"></div>\r\n");
      out.write("                        </td>\r\n");
      out.write("\r\n");
      out.write("                    </tr>                    \r\n");
      out.write("\r\n");
      out.write(" <tr>\r\n");
      out.write("                    						\r\n");
      out.write("                        <td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    	<h3 class=\"TitlesH3\">\r\n");
      out.write("							ARTIST:\r\n");
      out.write("						</h3>\r\n");
      out.write("\r\n");
      out.write("                            <input class=\"idInput\" type=\"text\" name=\"artist\" maxlength=\"60\" size='65'\r\n");
      out.write("                                value=\"");
out.print(request.getAttribute("artistName"));
      out.write("\" readonly>\r\n");
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        \r\n");
      out.write("                        <td>\r\n");
      out.write("                    \r\n");
      out.write("                            <div id=\"msgIdArtist\" class=\"AlertMsgs\"></div>\r\n");
      out.write("                    \r\n");
      out.write("                        </td>\r\n");
      out.write("                    \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr>\r\n");
      out.write("\r\n");
      out.write("                        <td>\r\n");
      out.write("                                          \r\n");
      out.write("							<h3 class=\"TitlesH3\">\r\n");
      out.write("								ASSOCIATES ARTISTS: \r\n");
      out.write("							</h3>		\r\n");
      out.write("							\r\n");
      out.write("							<section id=\"sectionAssociate\">\r\n");
      out.write("							\r\n");
      out.write("								<input type=\"radio\" id=\"associatesOn\" name=\"associates\" value=\"YES\" onchange=\"openCloseSection(sectionAssociateList,'visibility',true)\">\r\n");
      out.write("  								<label for=\"associates\">YES</label>\r\n");
      out.write("  						\r\n");
      out.write("								<input type=\"radio\" id=\"associatesOff\" name=\"associates\" value=\"NO\" onchange=\"openCloseSection(sectionAssociateList,'visibility',false)\" checked>\r\n");
      out.write("								<label for=\"associates\">NO</label>\r\n");
      out.write("                       			\r\n");
      out.write("                       		</section>														\r\n");
      out.write("                            	\r\n");
      out.write("                            <section id=\"sectionAssociateList\">\r\n");
      out.write("                                                    \r\n");
      out.write("                    	   		<table>\r\n");
      out.write("                   			 	 \r\n");
      out.write("                   			 	   ");
for (int i=0; i < listAllArtist.size(); i++)
                          		   {    
                         				 if(listAllArtist.get(i).getNome().equals(request.getAttribute("artistName")))
                         				 {
                         					 
                         				 }else
                         				 {
                         					
      out.write("     \r\n");
      out.write("                   			\r\n");
      out.write("                   			 		<tr>\r\n");
      out.write("                        				\r\n");
      out.write("                        				<td class=\"idArtist\">                               				\r\n");
      out.write("                         				     \r\n");
      out.write("                          				 <input type=\"checkbox\" name=\"");
      out.print(listAllArtist.get(i).getIdArtist());
      out.write("\">\r\n");
      out.write("                       					\r\n");
      out.write("                         				         ");
      out.print(listAllArtist.get(i).getNome());
      out.write("         					  \r\n");
      out.write("                                              \r\n");
      out.write("                       					</td>\r\n");
      out.write("                       					\r\n");
      out.write("                        			</tr>           \r\n");
      out.write("                        			            \r\n");
      out.write("                        	 	  ");

                        	 	  		} 
                        	 	
                         		  }
                   			 	   
      out.write(" \r\n");
      out.write("                         \r\n");
      out.write("                        		</table>                        \r\n");
      out.write("                                 \r\n");
      out.write("                            </section>\r\n");
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <div id=\"msgExtraArtistId\" class=\"AlertMsgs\"></div>\r\n");
      out.write("                        </td>\r\n");
      out.write("\r\n");
      out.write("                    </tr>                  \r\n");
      out.write("\r\n");
      out.write("					<tr>\r\n");
      out.write("					\r\n");
      out.write("						<td>\r\n");
      out.write("\r\n");
      out.write("							<input type=\"hidden\" id=\"dateTypeInput\" name=\"datetype\">\r\n");
      out.write("\r\n");
      out.write("						</td>\r\n");
      out.write("					\r\n");
      out.write("					</tr>\r\n");
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("\r\n");
      out.write("                <section class=\"SectionButtons\">\r\n");
      out.write("\r\n");
      out.write("                    <section id=\"msgStatus\" class=\"AlertMsgs\">\r\n");
      out.write("\r\n");
      out.write("                    </section>\r\n");
      out.write("\r\n");
      out.write("                    <button type=\"reset\" class=\"Buttons\">\r\n");
      out.write("\r\n");
      out.write("                        <img class=\"ImagesButtonsRegister\" src=\"images/icons/LIMPAR.png\" alt=\"\">\r\n");
      out.write("\r\n");
      out.write("                    </button>\r\n");
      out.write("\r\n");
      out.write("                    <button type=\"submit\" id=\"submitButton\" class=\"Buttons\" onclick=\"validar('formregisterart')\">\r\n");
      out.write("\r\n");
      out.write("                        <img class=\"ImagesButtonsRegister\" src=\"images/icons/save01.png\" alt=\"\">\r\n");
      out.write("\r\n");
      out.write("                    </button>\r\n");
      out.write("\r\n");
      out.write("                </section>\r\n");
      out.write("\r\n");
      out.write("            </fieldset>\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
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
      out.write("    <div class=\"load\">\r\n");
      out.write("        <div class=\"dot\"></div>\r\n");
      out.write("        <div class=\"dot\"></div>\r\n");
      out.write("        <div class=\"dot\"></div>\r\n");
      out.write("        <div class=\"dot\"></div>\r\n");
      out.write("        <div class=\"dot\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    -->\r\n");
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
      out.write("    <script src=\"js/validator.js\">\r\n");
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
