<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

                <section id="buttonsZoom">                   

                    <section class="TitlesAuthor">
                       <%out.print(request.getAttribute("name"));%>
                    </section>

                </section>

                <section id="sectionImageArtist" class="SectionImageArtist">

                    <section id="buttonsZoom">

                        <section class="EditButtonsSection">

                            <section id="sectionButtonsArtist">

                                <button type="button" id="editButton" class="Buttons" onclick="openPage('selectartistedit?idArtist=<%out.print(request.getAttribute("idArtist"));%>','_self')">

                                    <img class="ImagesButtons" id="imageEditButton" src="images/icons/editar03.png"
                                        alt="">

                                </button>

                            </section>

                            <section id="sectionButtonsArtist">

                                <button type="button" id="editButton" class="Buttons" onclick="openPage('javascript: confirmar(<%out.print(request.getAttribute("idArtist"));%>)','_self')">

                                    <img class="ImagesButtons" id="imageEditButton"
                                        src="images/icons/deletar01Vazio.png" alt="">

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

                                <section class="DataArtist" onclick="openPage('artist.html','_self')">
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

                <!-- ARTS -->

                <section id="sectionRegisterButtons">

                    <section class="TitlesNames">                        

                        <button type="button" class="Buttons" onclick="openPage('artregister.html','_self')">

                            <img class="ImagesButtons" id="imageRegisterButton" src="images/icons/cadastrar.png"
                                alt="">

                        </button>

                    </section>

                </section>

                <section class="SectionArtsArtist">

                    <!-- ARTS 1 -->

                    <section id="artArtist" class="ArtsArtist">

                        <section id="buttonsZoom">

                            <section class="TitlesAuthor">
                                MONA LISA
                            </section>

                        </section>

                        <section id="buttonsZoom">

                            <section class="EditButtonsSection">

                                <section id="sectionButtonsArtist">

                                    <button type="button" id="editButton" class="Buttons">

                                        <img class="ImagesButtons" id="imageEditButton"
                                            src="images/icons/editar03.png" alt="">

                                    </button>

                                </section>

                                <section id="sectionButtonsArtist">

                                    <button type="button" id="editButton" class="Buttons">

                                        <img class="ImagesButtons" id="imageEditButton"
                                            src="images/icons/deletar01Vazio.png" alt="">

                                    </button>

                                </section>

                            </section>

                        </section>

                        <section class="TitlesArts">

                            <section class="TitlesNames">ART:

                                <section class="Names" id="artName" onclick="openPage('art.jsp','_self')">

                                    Mona Lisa

                                </section>

                            </section>

                            <section class="TitlesNames">
                                <h3>Description:</h3>


                                <p class="TextDescription">
                                    The painting represents a woman with an introspective and somewhat shy expression.
                                    Her
                                    narrow smile is very seductive, if a little conservative. Her body represents the
                                    standard of beauty for women in Leonardo's time.
                                </p>

                            </section>

                            <section class="TitlesNames">
                                EXHIBITION DATE:

                                <section class="Data">
                                    01/01/2001
                                </section>

                            </section>

                            <section class="TitlesNames">
                                PUBLICATION DATE:

                                <section class="Data">
                                    01/01/2001
                                </section>

                            </section>

                            <section class="TitlesNames">
                                PARTICIPATING ARTIST:


                                <section class="Names" onclick="openPage('art.jsp','_self')">

                                    None

                                </section>

                            </section>

                        </section>

                    </section>

                    <!-- ARTS 2 -->

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

    <script src="js/artist.js">

    </script>

    <script src="js/validator.js">

    </script>

 	<script src="js/home.js">

    </script>
</html>