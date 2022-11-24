<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    
    import="model.*"
    import="java.util.ArrayList"     
%>

<%

String associatesOn = (String) request.getAttribute("associatesOn");

String newidartistchecked[] = (String[]) request.getAttribute("newidartistchecked");
		 
ArrayList<Arts> listArt = (ArrayList<Arts>) request.getAttribute("Art");

ArrayList<NamesArtsArtist> checkNamesArtist = (ArrayList<NamesArtsArtist>) request.getAttribute("checkedNames");

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

                <button type="button" id="seacherButton" class="Buttons2">

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
                        onclick="openCloseOption(config,'display')">

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
                        onclick="openClose(sectionButtons,'visibility','menuMain')">

                </button>

            </section>

        </section>

    </header>

    <body>

        <section class="SectionArtsArtist">

            <!-- ARTS 1 -->
            
            <fieldset>

                <legend class="LegendResgiter">

                    <img class="Buttons" src="images/icons/art01.png" alt="">

                </legend>

            <section id="artArtist" class="ArtsArtist">

                <section id="buttonsZoom">

                    <section class="TitlesAuthor">
                     <%out.print(request.getAttribute("nameArt"));%>
                    </section>

                </section>

                <section id="buttonsZoom">

                    <section class="EditButtonsSection">

                        <section id="sectionButtonsArtist">

                            <a href="arteditselect?idart=<%out.print(request.getAttribute("idArt"));%>&name=<%out.print(request.getAttribute("nameArt"));%>&description=<%out.print(request.getAttribute("description"));%>&exposureDate=<%out.print(request.getAttribute("exposuredate"));%>&publicationDate=<%out.print(request.getAttribute("publicationdate"));%>&artistname=<%out.print(request.getAttribute("nameArtist"));%>">										
                                        <img class="ImagesButtons" 
                                            src="images/icons/editar03.png" alt="">
							</a>

                        </section>

                        <section id="sectionButtonsArtist">

                            <button type="button" id="editButton" class="Buttons">

                                <a href="javascript: confirmar(<%out.print(request.getAttribute("idArt"));%>,'art')">
									<img class="ImagesButtons" src="images/icons/deletar01Vazio.png" alt="">
								</a>

                            </button>

                        </section>

                    </section>

                </section>

                <section class="TitlesArts">

                    <section class="TitlesNames">ART:

                        <section class="Data">
						
						       <%out.print(request.getAttribute("nameArt"));%>

                        </section>

                    </section>

                    <section class="TitlesNames">
                        <h3>DESCRIPTION:</h3>


                        <p class="TextDescription">
                               <%out.print(request.getAttribute("description"));%>
                        </p>

                    </section>

                    <section class="TitlesNames">
                        EXHIBITION DATE:

                        <section class="Data">
                           <%out.print(request.getAttribute("exposuredate"));%>
                        </section>

                    </section>

                    <section class="TitlesNames">
                        PUBLICATION DATE:

                        <section class="Data">
                            <%out.print(request.getAttribute("publicationdate"));%>
                        </section>

                    </section>

                    <section class="TitlesNames">

                        ARTIST'S:

                        <section class="ArtistsExtras">

							<section class="ArtistsExtras">   
							
								<a href="artist?idartist=<%out.print(request.getAttribute("idArtist"));%>">
                        			<%out.print(request.getAttribute("nameArtist"));%>
								</a>                               				                   				        
                        	
                        	</section>	

						<%if(associatesOn.equals("YES"))
  						{							

   							for (int i = 0; i < newidartistchecked.length; i++)   
                        	{                       	
                        	%> 
								<section class="ArtistsExtras">   
							
									<a href="artist?idartist=
									<% if(associatesOn.equals("YES"))
  										 {%>
											<%=newidartistchecked[i]%>">
											<%=checkNamesArtist.get(i).getNameArt()%>
									<%   }%>
									</a>                               				                   				        
                        	  										
                       		 	</section>	            
                        	<%	
                         	}
  						}
                   		%>                 
   
                        </section>

                    </section>

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
                    	
                  		<button type="button" class="Buttons">

                   			<img class="Images" src="images/icons/USUARIOS08.png" alt=""
                        	onclick="openPage('users','_self')">

               			</button>

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
    
    <script src="js/home.js">

    </script>

</html>