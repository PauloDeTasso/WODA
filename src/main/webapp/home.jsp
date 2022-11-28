<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" 
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

                    <img class="ImageButton3" id="imageSeacherButton" src="images/icons/pesquisar04.png" alt=""
                        onclick="openPage('artistsearch','_self')">

                </button>                
                
        		<button type="button" Class="Buttons" onclick="openPage('searcharts','_self')">

                	<img class="Buttons" src="images/icons/pesquisar05.png" alt="">

	            </button>

                <button type="button" id="registerButton" class="Buttons">

                    <img class="ImageButton3" id="imageRegisterButton" src="images/icons/cadastrar.png" alt=""
                        onclick="openPage('addartist', '_self')">

                </button>

                <button type="button" id="configButton" class="Buttons">

                    <img class="ImageButton3" id="imageConfigButton" src="images/icons/configurações02.png" alt=""
                        onclick="openCloseOption(config,'display')">

                </button>

                <button type="button" id="infoButton" class="Buttons">

                    <img class="ImageButton3" id="imageInfoButton" src="images/icons/info.png" alt=""
                        onclick="openClose(info,'display')">

                </button>

    			<button type="button" id="registerButton" class="Buttons">

                    <img class="ImageButton3" id="imageRegisterButton" src="images/icons/fechar03.png" alt=""
                        onclick="openPage('index.html', '_self')">

                </button>

            </section>

            <section id="sectionMenuButton">

                <button type="button" id="buttonMenu">

                    <img id="imagemButtonMenu" src="images/icons/menu03.png" alt="" onclick="abrirOptions()">

                </button>

            </section>

        </section>

    </header>

    <body>

        <section id="config">
       
			<section class="SectionRegisterButtons2">							

            	<h3>REGISTER USERS</h3>
                    	
                <button type="button" class="Buttons">

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

		<section id="secaoPopup" class="modal-container">

                <section class="modal">

                    <button class="fechar" onclick="abrirFecharPopup()">
                        x
                    </button>

                    <h5>
                        Copyright (c) 2021 Paulo de Tasso
                    </h5>

                    <p>
                    	TEXTO
                    </p>

                </section>

            </section>

			
			<section id="flutuante">

            <p id="status">
                Hello! How can I help you!
            </p>

            <button id="botaoAbrirStatus" type="button" onclick="abrirFecharStatus()">
                <img id="imagemBotaoStatus" src="images/icons/SUPORTE01.png" alt="Icone fechar status!" width="10px"
                    height="auto">
            </button>

        </section>
			
    </body>

    <footer>

        <section id="sectionFooter">

            World of digital artists - WODA®

        </section>

    </footer>

    <script src="js/home.js">

    </script>

</html>