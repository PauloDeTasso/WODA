<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ page import="model.Artists"%>
    
    <%@ page import="java.util.ArrayList"%>
    
        
  <%
  
  
  ArrayList<Artists> lista = (ArrayList<Artists>) request.getAttribute("contatos");
  
  
    /*
    REMOVE A CHECAGEM DESNECESSARIA DO ARRAYLIST DO CODIGO NO ECLIPSE:
    */
    
  /*
  
  //TESTE DE RECEBIMENTO:
	  
  for (int i = 0; i < lista.size(); i++)
  {
		  out.println(lista.get(i).getIdcon());
		  out.println(lista.get(i).getNome());
		  out.println(lista.get(i).getFone());
		  out.println(lista.get(i).getEmail());
		 }
*/
  %>  

<!DOCTYPE html>
<html id="html5" lang="en-US">

    <head>

        <meta charset="UTF-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="css/home.css"/>

        <title>WODA</title>

        <link rel="icon" href="images/logos/LogoWODA2.png" type="image/gif">

    </head>

    <!-- 
    <section id="statusSistema">

    </section>
     -->

    <header>

        <section id="sectionMenu">

            <section id="sectionButtons">

                <button type="button" id="seacherButton" class="Buttons">

                    <img class="ImagesButtons" id="imageSeacherButton" src="images/icons/pesquisar04.png" alt=""
                        onclick="openClose(seacher,'display','menuSeacher')">

                </button>

                <button type="button" id="registerButton" class="Buttons">

                    <img class="ImagesButtons" id="imageRegisterButton" src="images/icons/cadastrar.png" alt=""
                        onclick="openPagina('artistregister.html', '_self')">

                </button>

                <button type="button" id="configButton" class="Buttons">

                    <img class="ImagesButtons" id="imageConfigButton" src="images/icons/configurações02.png" alt=""
                        onclick="openClose(config,'display','menuConfig')">

                </button>

                <button type="button" id="infoButton" class="Buttons">

                    <img class="ImagesButtons" id="imageInfoButton" src="images/icons/info.png" alt=""
                        onclick="openClose(info,'display','menuInfo')">

                </button>

            </section>

            <section id="sectionMenuButton">

                <button type="button" id="buttonMenu">

                    <img id="imagemButtonMenu" src="images/icons/menu01.png" alt=""
                        onclick="openClose(sectionButtons,'visibility','menuMain')">

                </button>

            </section>

        </section>

    </header>

    <body>

        <section id="config">

            <table>

                <th>

                    <h3>SAVE SYSTEM <br> ACTIONS</h3>

                <td>

                    <label for="saveStatus">ON
                        <input type="radio" name="saveStatus" id="saveStatusOn"
                            onchange="saveConfig('statusSaveConfig',true)"></label>

                    <label for="saveStatus">OFF
                        <input type="radio" name="saveStatus" id="saveStatusOff"
                            onchange="saveConfig('statusSaveConfig',false)"></label>

                </td>

                </th>

            </table>

        </section>

        <section id="seacher">

            <section id="sectionSeacher">

				<section id="subSectionSeacher">

                	<button class="Buttons" type="submit" value="Seacher" autofocus>

                    	<img class="ImagesButton" src="images/icons/pesquisar02.png" alt="" width="70px">

                	</button>

                	<form action="seacher">

                    	<input type="text" name="seacherText" placeholder="Seacher">

                    	<label>
                        	<input type="radio" name="seacherCheckbox" value="Authors" checked />
                        	Authors</label>
                    	<label>
                    	    <input type="radio" name="seacherCheckbox" value="Arts"> Arts</label>

                	</form>

				</section>

            </section>

            <section id="sectionTableSeacher">

                <table id="tabela">

                    <thead>

                        <tr>

                            <th>
                                ID
                            </th>

                            <th>
                                NAME
                            </th>

                            <th>
                                E-MAIL
                            </th>

                            <th>
                               GENDER
                            </th>

                            <th>
                                BIRTHDAY
                            </th>
                            
                              <th>
                                NATIONALITY
                            </th>
                            
                              <th>
                                CPF
                            </th>      
                            
                              <th>
                               ADMIN OPTIONS
                            </th>                         

                        </tr>

                    </thead>

                    <tbody>

                        <%for (int i=0; i < lista.size(); i++) { %>
                            <tr>
                                <td>
                                    <%=lista.get(i).getIdcon()%>
                                </td>
                                <td>
                                    <%=lista.get(i).getNome()%>
                                </td>
                                <td>
                                    <%=lista.get(i).getEmail()%>
                                </td>
                                <td>
                                    <%=lista.get(i).getSexo()%>
                                </td>
                                <td>
                                    <%=lista.get(i).getDatadenascimento("br")%>
                                </td>
                                <td>
                                    <%=lista.get(i).getNacionalidade()%>
                                </td>
                                <td>
                                    <%=lista.get(i).getCpf()%>
                                </td>
                                <td>
                                
                                <section id="buttonsAdminOptions"> 
                                   
                                	<button type="button" id="editButton" class="Buttons">

                                    	<img class="ImagesButtons" id="imageEditButton" src="images/icons/editar03.png"
                                        alt="" onclick="openPagina('select?idcon=<%=lista.get(i).getIdcon() %>','_self')">

                                	</button>
                                	
                                	<button type="button" id="editButton" class="Buttons">

                                    	<img class="ImagesButtons" id="imageEditButton"
                                        src="images/icons/deletar01Vazio.png" alt="" onclick="openPagina('javascript: confirmar(<%=lista.get(i).getIdcon() %>)','_self')">

                                	</button>
                                  
                                  <!-- 
                                
                                  <a href="select?idcon=<%=lista.get(i).getIdcon() %>" class="Botao1">Editar</a>
                                  
                                  <a href="javascript: confirmar(<%=lista.get(i).getIdcon() %>)"
                                        class="Botao2">Excluir</a>
                              	 -->                                     
                                    
                              	</section>
                              	
                                </td>
                            </tr>
                            <%} %>

                    </tbody>

                </table>

            </section>

        </section>

        <section id="sectionGallery">

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/artistsandarts/leonard-de-vinci.jpg" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/artistsandarts/monalisa.png" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/logos/LogoWODA2.png" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/artistsandarts/monalisa.png" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->


            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/author/01.jpg" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/logos/LogoWODA.png" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/author/02.jpg" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->


            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/artistsandarts/leonard-de-vinci.jpg" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/artistsandarts/monalisa.png" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/logos/LogoWODA2.png" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/artistsandarts/monalisa.png" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->


            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/author/01.jpg" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/logos/LogoWODA.png" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="images/author/02.jpg" alt=""
                        onclick="openPagina('artist.html','_self')">

                </section>

            </section>

            <!-- ART -->

        </section>

        <section id="info">

            Dev - Paulo de Tasso <br>
            Senior Full Stack Developer <br>
            World of digital artists - WODA®

            <img class="ImagesButtons" src="images/icons/SUPORTE01.png" alt="">

        </section>

    </body>

    <!--  

    <div class="load">
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
    </div>
-->

    <footer>

        <section id="sectionFooter">

            World of digital artists - WODA®

        </section>

    </footer>

    <script src="js/home.js">

    </script>

</html>