<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    
    import="model.*"
    import="java.util.ArrayList"     
%>

<%

//String associatesOn = (String) request.getAttribute("associatesOn");

//String checkedIds[] = (String[]) request.getAttribute("checkedIds");
	
//String checkedNames[] = (String[]) request.getAttribute("checkedNames");

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

    <!-- 
    <section id="statusSistema">

    </section>
     -->

    <header>

        <section id="sectionMenu">

            <section id="sectionButtons">

                 <button type="button" id="seacherButton" class="Buttons">

                    <img class="ImagesButtons" id="imageSeacherButton" src="images/icons/pesquisar04.png" alt=""
                        onclick="openPage('artistsearch','_self')">

                </button>                
                
        		<button type="button" Class="Buttons" onclick="openPage('searcharts','_self')">

                <img class="Buttons" src="images/icons/pesquisar05.png" alt="">

	            </button>

                <button type="button" id="registerButton" class="Buttons">

                    <img class="ImagesButtons" id="imageRegisterButton" src="images/icons/cadastrar.png" alt=""
                        onclick="openPage('addartist', '_self')">

                </button>

                <button type="button" id="configButton" class="Buttons">

                    <img class="ImagesButtons" id="imageConfigButton" src="images/icons/configurações02.png" alt=""
                        onclick="openClose(config,'display','menuConfig')">

                </button>

                <button type="button" id="infoButton" class="Buttons">

                    <img class="ImagesButtons" id="imageInfoButton" src="images/icons/info.png" alt=""
                        onclick="openClose(info,'display','menuInfo')">

                </button>

    			<button type="button" id="registerButton" class="Buttons">

                    <img class="ImagesButtons" id="imageRegisterButton" src="images/icons/fechar03.png" alt=""
                        onclick="openPage('index.html', '_self')">

                </button>

            </section>

            <section id="sectionMenuButton">

                <button type="button" id="buttonMenu">

                    <img id="imagemButtonMenu" src="images/icons/menu01.png" alt=""
                        onclick="openClose(sectionButtons,'visibility')">

                </button>

            </section>

        </section>

    </header>

    <body>

        <section class="SectionArtsArtist">

            <!-- ARTS 1 -->

            <section id="artArtist" class="ArtsArtist">

                    <section class="TitlesAuthor">
                     <%=listArt.get(0).getName()%>
                    </section>

                <section id="buttonsZoom">

                    <section class="EditButtonsSection">

                        <section id="sectionButtonsArtist">

                           <button type="button" class="Buttons">                                    	
                                      
                                        <a href="arteditselect?idart=<%=listArt.get(0).getIdart()%>&name=<%=listArt.get(0).getName()%>&description=<%=listArt.get(0).getDescription()%>&exposureDate=<%=listArt.get(0).getDataDeExposicao()%>&publicationDate=<%=listArt.get(0).getDataDePublicacao()%>&artistname=<%out.print(request.getAttribute("name"));%>">										
        								 <img class="ImagesButtons" src="images/icons/editar03.png" alt="">                                    	
										</a>
                                	
                                	</button>
                                	

                        </section>

                        <section id="sectionButtonsArtist">

                         
                                	<button type="button" class="Buttons">

										<a href="javascript: removeArtConfirm('<%=listArt.get(0).getIdart()%>','<%=listArt.get(0).getName()%>')">
											<img class="ImagesButtons" src="images/icons/deletar01Vazio.png" alt="">
										</a>
										
                                	</button>

                        </section>

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

        </section>

        <section id="info">

            Dev - Paulo de Tasso <br>
            Senior Full Stack Developer <br>
            World of digital artists - WODA®

            <img class="ImagesButtons" src="images/icons/SUPORTE01.png" alt="">

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

</html>