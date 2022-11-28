<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  
    import="model.*" 
    import="java.sql.*" 
    import="java.io.*"
    import="java.*"
    import="controllers.*"
    import="model.Artists"
    import="model.Arts"
    import="java.util.ArrayList"
%>

  
<% 

ArrayList<Artists> listArtistsAllOrderName = (ArrayList<Artists>) request.getAttribute("listArtistsAllOrderName");    
  
String searchArtist = (request.getAttribute("searchArtist") == null) ? "" : request.getAttribute("searchArtist").toString(); 
    
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

        <section id="seacher">
        
            <section id="sectionSeacher">

				<section id="subSectionSeacher">          

                	<form action="seacher">
                	
                		<fieldset>

                		 <legend class="LegendResgiter">

                   			 <img class="Buttons2" src="images/icons/ARTIST01.png" alt="">

                   			 <img class="Buttons2" src="images/icons/ARTIST02.png" alt="">

                		</legend>

                    	<input id="mySearchArtists" type="search" name="searchinput" placeholder="Seacher" onchange="submitSearcher(mySearchArtists.value,'artists')" onkeyup="changeButton(searchButton)" value="<%out.println(searchArtist);%>" autofocus>
						
						<button type="button" Class="Buttons" onclick="submitSearcher(mySearchArtists.value,'artists')">
           							
           					<img class="Buttons" src="images/icons/pesquisar04.png" alt="" >
								
						</button>
						
						</fieldset>

                	</form>

				</section>

            </section>	
			
			 <section id="sectionTableSeacher">

				<section id="titleArt">
                	 ARTIST'S:
                </section>                                          

                <section id="listArts">
                 
                 
                <%for (int i=0; i < listArtistsAllOrderName.size(); i++)
                          
                { %>                                                    
                	
                	<section class="Arts" onclick="openPage('artist?idartist=<%=listArtistsAllOrderName.get(i).getIdArtist()%>','_self')">
                                
                    	<a href="artist?idartist=<%=listArtistsAllOrderName.get(i).getIdArtist()%>">
                                   
                        	<%=listArtistsAllOrderName.get(i).getNome()%>   
                                   
                        </a> 
                                   
                        <hr>

						<p>
						
                            <%=listArtistsAllOrderName.get(i).getEmail()%>
                       
                        </p>
                                  	
                   </section>      
                                                        
              <%
              }
              %>         
          				
          		</section>           				

			</section>		

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

    <script src="js/artistsearch.js">

    </script>

</html>