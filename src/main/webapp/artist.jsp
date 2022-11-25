<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    
       import="model.*"
    import="java.util.ArrayList"     
%>
    
<%

ArrayList<Artists> listArtistAllByIdArtist = (ArrayList<Artists>) request.getAttribute("listArtistAllByIdArtist");  

ArrayList<Arts> listAllArtsArtist = (ArrayList<Arts>) request.getAttribute("listAllArtsArtist");  

String dataDeExposicao;

String dataDePublicacao;

%>
    
<!DOCTYPE html>
<html id="html5" lang="en-US">

    <head>

        <meta charset="UTF-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="css/artist.css" />

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

                <button type="button" class="Buttons4">

                    <img class="ImageButton3" id="imageSeacherButton" src="images/icons/pesquisar04.png" alt=""
                        onclick="openPage('artistsearch','_self')">

                </button>                
                
        		<button type="button" Class="Buttons4" onclick="openPage('searcharts','_self')">

                <img class="ImageButton3" src="images/icons/pesquisar05.png" alt="">

	            </button>

                <button type="button" class="Buttons4">

                    <img class="ImageButton3" id="imageRegisterButton" src="images/icons/cadastrar.png" alt=""
                        onclick="openPage('addartist', '_self')">

                </button>

                <button type="button" class="Buttons4">

                    <img class="ImageButton3" id="imageConfigButton" src="images/icons/configurações02.png" alt=""
                        onclick="openCloseOption(config,'display')">

                </button>

                <button type="button" class="Buttons4">

                    <img class="ImageButton3" id="imageInfoButton" src="images/icons/info.png" alt=""
                        onclick="openClose(info,'display')">

                </button>

    			<button type="button" class="Buttons4">

                    <img class="ImageButton3" id="imageRegisterButton" src="images/icons/fechar03.png" alt=""
                        onclick="openPage('index.html', '_self')">

                </button>

            </section>

            <section id="sectionMenuButton">

                <button type="button" id="buttonMenu">

                    <img id="imagemButtonMenu" src="images/icons/menu03.png" alt=""
                        onclick="abrirOptions()">

                </button>

            </section>

        </section>

    </header>

    <body>

        <section id="sectionArtist">

           <fieldset>

            <!-- ARTIST -->

            <section class="SectionArtistArts">

                    <section class="TitlesAuthor">
                       <%out.print(request.getAttribute("name"));%>
                    </section>

                <section class="SectionImageArtist">

                    <section class="buttonsZoom">

                        <section class="EditButtonsSection">

                            <section>

                                <button type="button" class="Buttons" onclick="openPage('selectartistedit?idartist=<%out.print(request.getAttribute("idArtist"));%>','_self')">

                                    <img class="ImageButton3" src="images/icons/editar03.png"
                                        alt="">

                                </button>

                            </section>

                            <section>

                                <button type="button" class="Buttons">
									
									<a href="javascript: confirmar(<%out.print(request.getAttribute("idArtist"));%>,'artist')">
										<img class="ImageButton3" src="images/icons/deletar01Vazio.png" alt="">
									</a>

                                </button>

                            </section>

                        </section>

                    </section>

                    <section class="SectionAuthorArts">

                        <section class="SectionDataArtist">

                            <section class="DataTitlesArtist">

                                <section class="TitlesArtist">

                                    ARTIST:

                                </section>

                                <section class="DataArtist">
                                      <%out.print(request.getAttribute("name"));%>
                                </section>

                            </section>

                            <section class="DataTitlesArtist">

                                <section class="TitlesArtist">

                                    GENDER:

                                </section>

                                <section class="DataArtist">

                                      <%out.print(request.getAttribute("gender"));%>

                                </section>

                            </section>

                            <section class="DataTitlesArtist">

                                <section class="TitlesArtist">

                                    E-MAIL:

                                </section>

                                <section class="DataArtist">

                                     <%out.print(request.getAttribute("email"));%>

                                </section>

                            </section>

                            <section class="DataTitlesArtist">

                                <section class="TitlesArtist">

                                    BIRTH DATE:

                                </section>

                                <section class="DataArtist">

                                     <%out.print(request.getAttribute("birthday"));%>

                                </section>

                            </section>

                            <section class="DataTitlesArtist">

                                <section class="TitlesArtist">

                                    NATIONALITY:

                                </section>

                                <section class="DataArtist">

                                      <%out.print(request.getAttribute("nationality"));%>

                                </section>

                            </section>

                            <section class="DataTitlesArtist">

                                <section class="TitlesArtist">

                                    CPF:

                                </section>

                                <section class="DataArtist">

                                      <%out.print(request.getAttribute("cpf"));%>

                                </section>

                            </section>

                        </section>

                    </section>

                </section>

                <!-- ADD ARTS -->

                <section id="sectionRegisterButtons">

                    <section id="registerButton">                        

                        <button type="button" class="Button3" onclick="openPage('addart','_self')">

                            <img class="ImageButton3" id="imageRegisterButton" src="images/icons/artAdd01.png"
                                alt="">

                        </button>

                    </section>

                </section>

                <section class="SectionArtsArtist">       		      			
       			
 					<!-- ART -->

 					<%for (int i=0; i < listAllArtsArtist.size(); i++)
                	{    
               		%>
 				
                    <section class="ArtsArtist">

                            <section class="TitlesAuthor">
                            
                            	<a href="art?idart=<%=listAllArtsArtist.get(i).getIdart()%>">
                               		<%=listAllArtsArtist.get(i).getName()%>
								</a>
                            
                            </section>


                        <section class="buttonsZoom">

                            <section class="EditButtonsSection">

                                <section>

                                    <button type="button" class="Buttons">
 									
 									<a href="arteditselect?idart=<%=listAllArtsArtist.get(i).getIdart()%>&name=<%=listAllArtsArtist.get(i).getIdart()%>&description=<%=listAllArtsArtist.get(i).getIdart()%>&exposureDate=<%=listAllArtsArtist.get(i).getIdart()%>&publicationDate=<%=listAllArtsArtist.get(i).getIdart()%>&artistname=<%out.print(request.getAttribute("name"));%>">										
                                        <img class="ImageButton3" 
                                            src="images/icons/editar03.png" alt="">
									</a>
 
                                    </button>

                                </section>

                                <section>

                                    <button type="button" class="Buttons">

                                       <a href="javascript: removeConfirm('<%out.print(request.getAttribute("idArtist"));%>','<%=listAllArtsArtist.get(i).getIdart()%>','<%out.print(request.getAttribute("name"));%>','<%=listAllArtsArtist.get(i).getName()%>')">
											<img class="ImageButton3" src="images/icons/deletar01Vazio.png" alt="">
									   </a>

                                    </button>

                                </section>

                            </section>

                        </section>

                        <section class="TitlesArts">

                            <section class="TitlesNames">
                            
                            	ART:

                                <section class="Names">

									<a href="art?idart=<%=listAllArtsArtist.get(i).getIdart()%>">
                               			<%=listAllArtsArtist.get(i).getName()%>
									</a>
   
                                </section>

                            </section>

                            <section class="TitlesNames">
                            
                                <h3>Description:</h3>

                                <p class="TextDescription">
                                    <%=listAllArtsArtist.get(i).getDescription()%>
                                </p>

                            </section>

                            <section class="TitlesNames">
                            
                                EXHIBITION DATE:

                                <section class="Data">
                           		    <%
                           		    dataDeExposicao = (listAllArtsArtist.get(i).getDataDeExposicao() == null) ? "" : listAllArtsArtist.get(i).getDataDeExposicao("br"); 
                           		 	
                           			out.print(dataDeExposicao);
                           		 	%>
                                </section>

                            </section>

                            <section class="TitlesNames">
                            
                                PUBLICATION DATE:

                                <section class="Data">
                               		<%
                           			dataDePublicacao = (listAllArtsArtist.get(i).getDataDePublicacao() == null) ? "" : listAllArtsArtist.get(i).getDataDePublicacao("br"); 
                           		 	
                       				out.print(dataDePublicacao);
                       		 		%>
                                </section>

                            </section>                            

                        </section>

                    </section>
					
					<%								
					}
 					%>	
					
					<!-- ART -->
 										
                </section>

            </section>            

		 </fieldset>
		 
        </section>

		<section id="config">

			<section class="SectionRegisterButtons2">

                    	<h3>SAVE SYSTEM <br> ACTIONS</h3>
                				
                   	 	<label for="saveStatus">ON
                       		 <input type="radio" name="saveStatus" id="saveStatusOn"
                            onchange="saveConfig('statusSaveConfig',true)"></label>

                    	<label for="saveStatus">OFF
                      	  <input type="radio" name="saveStatus" id="saveStatusOff"
                            onchange="saveConfig('statusSaveConfig',false)"></label>

            </section> 	

			<section class="SectionRegisterButtons2">							

                    	<h3>REGISTER USERS</h3>
                    	
                  		<button type="button" class="Buttons3">

                   			<img class="Images" src="images/icons/USUARIOS08.png" alt=""
                        	onclick="openPage('users','_self')">

               			</button>

			</section>
				
        </section>     

      <section id="info">
            
            WODA®<br>
            World of digital artists<br>
			Developer App: <br>
			Paulo de Tasso - Brazil <br>
            Software Application - Full Stack<br>

			<a href=mailto:atedimento.site@gmail.com?subject=Contact_WODA>
          	  <img class="ImageButton3" src="images/icons/SUPORTE01.png" alt="">
			</a>
			
        </section>

    </body>

    <footer>

        <section id="sectionFooter">

            World of digital artists - WODA®

        </section>

    </footer>

    <script src="js/artist.js">

    </script>

    <script src="js/validator.js">

    </script>

 	<script src="js/home.js">

    </script>
</html>