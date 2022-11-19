<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    
       import="model.*"
    import="java.util.ArrayList"     
%>
    
<%

ArrayList<Artists> listArtistAllByIdArtist = (ArrayList<Artists>) request.getAttribute("listArtistAllByIdArtist");  

ArrayList<Arts> listAllArtsArtist = (ArrayList<Arts>) request.getAttribute("listAllArtsArtist");  
 

System.out.println("idArtist JSP: " + request.getAttribute("name"));

for (int i = 0; i < listArtistAllByIdArtist.size(); i++)
{
	System.out.println("listArtistAllByIdArtist:");
	System.out.println(listArtistAllByIdArtist.get(i).getNome());
	System.out.println(" *--* ");
}

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

        <section id="sectionArtist">

            <!-- ARTIST -->

            <section class="SectionArtistArts">

                <section class="buttonsZoom">                   

                    <section class="TitlesAuthor">
                       <%out.print(request.getAttribute("name"));%>
                    </section>

                </section>

                <section class="SectionImageArtist">

                    <section class="buttonsZoom">

                        <section class="EditButtonsSection">

                            <section>

                                <button type="button" class="Buttons" onclick="openPage('selectartistedit?idartist=<%out.print(request.getAttribute("idArtist"));%>','_self')">

                                    <img class="ImagesButtons" src="images/icons/editar03.png"
                                        alt="">

                                </button>

                            </section>

                            <section>

                                <button type="button" class="Buttons">
									
									<a href="javascript: confirmar(<%out.print(request.getAttribute("idArtist"));%>,'artist')">
										<img class="ImagesButtons" src="images/icons/deletar01Vazio.png" alt="">
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

                    <section class="TitlesNames">                        

                        <button type="button" class="Buttons" onclick="openPage('addart','_self')">

                            <img class="ImagesButtons" id="imageRegisterButton" src="images/icons/cadastrar.png"
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

                        <section class="buttonsZoom">

                            <section class="TitlesAuthor">
                            
                            	<a href="art?idart=<%=listAllArtsArtist.get(i).getIdart()%>">
                               		<%=listAllArtsArtist.get(i).getName()%>
								</a>
                            
                            </section>

                        </section>

                        <section class="buttonsZoom">

                            <section class="EditButtonsSection">

                                <section>

                                    <button type="button" class="Buttons">

                                        <img class="ImagesButtons" 
                                            src="images/icons/editar03.png" alt="">

                                    </button>

                                </section>

                                <section>

                                    <button type="button" class="Buttons">

                                       <a href="javascript: removeConfirm('<%out.print(request.getAttribute("idArtist"));%>','<%=listAllArtsArtist.get(i).getIdart()%>','<%out.print(request.getAttribute("name"));%>','<%=listAllArtsArtist.get(i).getName()%>')">
											<img class="ImagesButtons" src="images/icons/deletar01Vazio.png" alt="">
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