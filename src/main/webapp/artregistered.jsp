<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    
    import="model.*"
    import="java.util.ArrayList"     
%>

<%

String associatesOn = (String) request.getAttribute("associatesOn");

String checkedIds[] = (String[]) request.getAttribute("checkedIds");
		 
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

                <button type="button" id="seacherButton" class="Buttons">

                    <img class="ImagesButtons" id="imageSeacherButton" src="images/icons/voltar.png" alt=""
                        onclick="openPage('main', '_self')">

                </button>

                <button type="button" id="infoButton" class="Buttons">

                    <img class="ImagesButtons" id="imageInfoButton" src="images/icons/info.png" alt=""
                        onclick="openClose(info,'display','menuInfo')">

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

                <section id="buttonsZoom">

                    <section class="TitlesAuthor">
                     <%out.print(request.getAttribute("nameArt"));%>
                    </section>

                </section>

                <section id="buttonsZoom">

                    <section class="EditButtonsSection">

                        <section id="sectionButtonsArtist">

                            <button type="button" id="editButton" class="Buttons" onclick="openPage('artedit','_self')">

                                <img class="ImagesButtons" id="imageEditButton" src="images/icons/editar03.png"
                                    alt="">

                            </button>

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
							
								<a href="artist?idArtist=<%out.print(request.getAttribute("idArtist"));%>">
                        			<%out.print(request.getAttribute("nameArtist"));%>
								</a>                               				                   				        
                        	
                        	</section>	

						<%if(associatesOn.equals("YES"))
  						{							

   							for (int i = 0; i < checkedIds.length; i++)   
                        	{                       	
                        	%> 
								<section class="ArtistsExtras">   
							
									<a href="artist?idArtist=
									<% if(associatesOn.equals("YES"))
  										 {%>
											<%=checkedIds[i]%>">
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

    <script src="js/artist.js">

    </script>

    <script src="js/validator.js">

    </script>
    
    <script src="js/home.js">

    </script>

</html>