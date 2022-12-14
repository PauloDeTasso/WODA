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

ArrayList<Arts> listAllArts = (ArrayList<Arts>) request.getAttribute("listAllArts");  
 
String dataDeExposicao;

String dataDePublicacao;

String searchArt = (request.getAttribute("searchArt") == null) ? "" : request.getAttribute("searchArt").toString(); 

String optionName;
String optionDescription;

if(request.getAttribute("searchOption").equals("name"))
{
	optionName = "checked";
	optionDescription = "";
	
}else if(request.getAttribute("searchOption").equals("description"))
{
	optionName = "";
	optionDescription = "checked";
}else
{
	optionName = "checked";
	optionDescription = "";
}

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

    <header>

        <section id="sectionMenu">

            <section id="sectionButtons">

                <button type="button" id="seacherButton" class="Buttons">

                    <img class="Buttons" id="imageSeacherButton" src="images/icons/pesquisar04.png" alt=""
                        onclick="openPage('artistsearch','_self')">

                </button>                
                
                <button type="button" id="registerButton" class="Buttons">

                    <img class="Buttons" id="imageRegisterButton" src="images/icons/artistsadd01.png" alt=""
                        onclick="openPage('addartist', '_self')">

                </button>

                <button type="button" id="configButton" class="Buttons">

                    <img class="ImageButton3" src="images/icons/USUARIOS08.png" alt=""
                        	onclick="openPage('users','_self')">

                </button>

                <button type="button" id="infoButton" class="Buttons">

                    <img class="Buttons" id="imageInfoButton" src="images/icons/info.png" alt=""
                        onclick="openClose(info,'display')">

                </button>

    			<button type="button" id="registerButton" class="Buttons">

                    <img class="ImageButton3" id="imageRegisterButton" src="images/icons/exit01.png" alt=""
                        onclick="openPage('javascript: exit()', '_self')">

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

                    <form action="searcharts">

                        <fieldset>

                            <legend class="LegendResgiter">

                                    <img class="Buttons2" src="images/icons/pesquisar05.png" alt="">

                            </legend>

                            <input id="mySearchArts" type="search" name="searchinput" placeholder="Seacher"
                                onkeyup="changeButton(searchButton)" value="<%out.println(searchArt);%>" autofocus>

                            <button type="button" Class="Buttons" onclick="submitSearcher(mySearchArts.value,'arts')">

                                <img class="Buttons" src="images/icons/PESQUISAR01.png" alt="">

                            </button>

                            <section id="sectionAssociate">

                                <input type="radio" id="associatesOn" name="searchoption" value="name" <%=optionName%>>
                                ?? <label for="searchoption">NAME</label>
                                ??
                                <input type="radio" id="associatesOff" name="searchoption" value="description" <%=optionDescription%>>
                                <label for="searchoption">DESCRIPTION</label>

                            </section>

                        </fieldset>

                    </form>

                </section>

            </section>

            <section id="sectionTableSeacher">

				<section id="titleArt">
                	ART'S:
                </section>                                          

                <section id="listArts">
                 
                	<%for (int i=0; i < listAllArts.size(); i++)                          
                    { 
                    %>
                            
                    <section class="Arts" onclick="openPage('art?idart=<%=listAllArts.get(i).getIdart()%>','_self')">
                                
                    	<a href="art?idart=<%=listAllArts.get(i).getIdart()%>">
                    	
                    		<%=listAllArts.get(i).getName()%>
                   		
                   		</a>                                    
                                                                
                    	<hr>                                
								
						<p>
                               	
                    		<%=listAllArts.get(i).getDescription()%>
                               	 	
                    	</p>
                                
              		</section>                                          
                                                        
                   <%
                   }
                   %>  
          				
          		</section>           				

			</section>	
			
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

    <script src="js/artsearch.js">

    </script>

</html>