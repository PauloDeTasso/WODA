<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    
    import="model.*"
    import="java.util.ArrayList"     
%>

<%

ArrayList<Arts> listArt = (ArrayList<Arts>) request.getAttribute("Art");

ArrayList<Artists> listAllArtistForIdArtist = (ArrayList<Artists>) request.getAttribute("listAllArtistForIdArtist"); 

%>

<!DOCTYPE html>
<html id="html5" lang="en-US">

    <head>

        <meta charset="UTF-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="css/art.css" />

        <title>WODA</title>

        <link rel="icon" href="images/logos/LogoWODA2.png" type="image/gif">

    </head>

    <header>

         <section id="sectionMenu">

            <section id="sectionButtons">

                <button type="button" id="seacherButton" class="Buttons">

                    <img class="ImageButton3" id="imageSeacherButton" src="images/icons/pesquisar04.png" alt=""
                        onclick="openPage('artistsearch','_self')">

                </button>                
                
        		<button type="button" Class="Buttons" onclick="openPage('searcharts','_self')">

                <img class="Buttons" src="images/icons/pesquisar05.png" alt="">

	            </button>

                <button type="button" id="registerButton" class="Buttons">

                    <img class="ImageButton3" id="imageRegisterButton" src="images/icons/artistsadd01.png" alt=""
                        onclick="openPage('addartist', '_self')">

                </button>

                <button type="button" id="configButton" class="Buttons">

                    <img class="ImageButton3" src="images/icons/USUARIOS08.png" alt=""
                        	onclick="openPage('users','_self')">

                </button>

                <button type="button" id="infoButton" class="Buttons">

                    <img class="ImageButton3" id="imageInfoButton" src="images/icons/info.png" alt=""
                        onclick="openClose(info,'display')">

                </button>

    			<button type="button" id="registerButton" class="Buttons">

                    <img class="ImageButton3" id="imageRegisterButton" src="images/icons/exit01.png" alt=""
                        onclick="openPage('javascript: exit()', '_self')">

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

        <section class="SectionArtsArtist">

            <!-- ARTS 1 -->
            
            <fieldset>

                <legend class="LegendResgiter">

                    <img class="Buttons2" src="images/icons/art01.png" alt="">

                </legend>

            <section id="artArtist" class="ArtsArtist">

                    <section class="TitlesAuthor">
                     <%=listArt.get(0).getName()%>
                    </section>

                <section class="buttonsZoom">

                    <section class="EditButtonsSection">

                          			<button type="button" class="Buttons" onclick="openPage('arteditselect?idart=<%=listArt.get(0).getIdart()%>&name=<%=listArt.get(0).getName()%>&description=<%=listArt.get(0).getDescription()%>&exposureDate=<%=listArt.get(0).getDataDeExposicao()%>&publicationDate=<%=listArt.get(0).getDataDePublicacao()%>&artistname=<%=request.getAttribute("name")%>','_self')">                                    	
                                      
                                        <img class="ImageButton3" src="images/icons/editar03.png" alt="">                                    	
										                                	
                                	</button>                                	

                         
                                	<button type="button" class="Buttons" onclick="removeArtConfirm('<%=listArt.get(0).getIdart()%>','<%=listArt.get(0).getName()%>')">

											<img class="ImageButton3" src="images/icons/deletar01Vazio.png" alt="">
																				
                                	</button>

                    </section>

                </section>

                <section class="TitlesArts">

                    <section class="TitlesNames">ART:

                        <section class="Data">
						
						       <%=listArt.get(0).getName()%>

                        </section>

                    </section>

                    <section class="TitlesNames">
                        <h3>DESCRIPTION:</h3>


                        <p class="TextDescription">
                               <%=listArt.get(0).getDescription()%>
                        </p>

                    </section>

                    <section class="TitlesNames">
                        EXHIBITION DATE:

                        <section class="Data">
                           <%=(listArt.get(0).getDataDeExposicao() == null) ? "" : listArt.get(0).getDataDeExposicao("br")%>
                        </section>

                    </section>

                    <section class="TitlesNames">
                        PUBLICATION DATE:

                        <section class="Data">
                            <%=(listArt.get(0).getDataDePublicacao() == null) ? "" : listArt.get(0).getDataDePublicacao("br")%>
                        </section>

                    </section>

                    <section class="TitlesNames">

                        ARTIST'S:

                        <section class="ArtistsExtras">

							<section class="ArtistsExtras">   
							
							<%
							for (int i = 0; i < listAllArtistForIdArtist.size(); i++)
							{
								
							%>	
								<a href="artist?idartist=<%=listAllArtistForIdArtist.get(i).getIdArtist()%>">
                        			
                        			<%=listAllArtistForIdArtist.get(i).getNome()%>                        			
                          
								</a>   
								                            				                   				        
                        	<%								
							}
							%>
							
                        	</section>	
						
								<section class="ArtistsExtras">   
							
									<a href="artist?idartist=">
									
									</a>                               				                   				        
                        	
                       		 	</section>	            
                                      
   
                        </section>

                    </section>

                </section>

            </section>

		</fieldset>

        </section>                   

         <section id="info">
            
            WODA??<br>
            World of digital artists<br>
			Developer: <br>
			Paulo de Tasso<br>
            Web Software Application<br>
            Full Stack<br>			
			
			 <button type="button" id="seacherButton" class="Buttons" onclick="openPage('mailto:atedimento.site@gmail.com?subject=Contact_WODA','_self')">

          	  		<img class="ImageButton3" src="images/icons/SUPORTE01.png" alt="">
          	  						
             </button> 
			
        </section>

    </body>

    <footer>

        <section id="sectionFooter">

            World of digital artists - WODA??

        </section>

    </footer>

    <script src="js/artist.js">

    </script>

    <script src="js/validator.js">

    </script>

</html>