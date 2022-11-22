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

        <section id="config">

            <table>

                <th>

                    <h3>SAVE SYSTEM <br> ACTIONS</h3>

                <td>

                    <label for="saveStatus">ON
                        <input type="radio" name="saveStatus" id="saveStatusOn"
                            onchange="saveConfig('statusSaveConfig',true)"></label>

                    <label for="saveStatus">OFF
                        <input type="radio" name="saveStatus" id="saveStatusOff"
                            onchange="saveConfig('statusSaveConfig',false)"></label>

                </td>

                </th>

            </table>

        </section>

        <section id="seacher">
        
            <section id="sectionSeacher">

				<section id="subSectionSeacher">          

                	<form action="seacher">
                	
                		<fieldset>

                			<legend class="LegendResgiter">

								<button id="searchButton" type="button" Class="Buttons" onclick="submitSearcher(mySearchArtists.value,'artists')">
           							
           							<img class="Buttons" src="images/icons/pesquisar04.png" alt="" >
								
								</button>
        
                			</legend>

                    	<input id="mySearchArtists" type="search" name="searchinput" placeholder="Seacher" onchange="submitSearcher(mySearchArtists.value,'artists')" onkeyup="changeButton(searchButton)" value="<%out.println(searchArtist);%>" autofocus>
						
						<button type="button" Class="Buttons" onclick="submitSearcher(mySearchArtists.value,'artists')">
           							
           					<img class="Buttons" src="images/icons/PESQUISAR01.png" alt="" >
								
						</button>
						
						</fieldset>

                	</form>

				</section>

            </section>

            <section id="sectionTableSeacher">

                <table id="tableArtists" class="tabela">

                    <thead>

                        <tr>

                            <th>
                                ID
                            </th>

                            <th>
                                NAME
                            </th>

                            <th>
                                E-MAIL
                            </th>

                            <th>
                               GENDER
                            </th>

                            <th>
                                BIRTHDAY
                            </th>
                            
                              <th>
                                NATIONALITY
                            </th>
                            
                              <th>
                                CPF
                            </th>                                                      

                        </tr>

                    </thead>

                    <tbody>

                        <%for (int i=0; i < listArtistsAllOrderName.size(); i++)
                          
                        { %>
                        
                            <tr>
                                <td>
                                	<%=listArtistsAllOrderName.get(i).getIdArtist()%>
                                </td>
                                <td>
                                
                                   <a href="artist?idartist=<%=listArtistsAllOrderName.get(i).getIdArtist()%>">
                                   
                                   <%=listArtistsAllOrderName.get(i).getNome()%>
                                   
                                   </a> 
                                   
                                </td>
                                <td>
                                    <%=listArtistsAllOrderName.get(i).getEmail()%>
                                </td>
                                <td>
                                    <%=listArtistsAllOrderName.get(i).getSexo()%>
                                </td>
                                <td>
                                    <%=listArtistsAllOrderName.get(i).getDatadenascimento("br")%>
                                </td>
                                <td>
                                    <%=listArtistsAllOrderName.get(i).getNacionalidade()%>
                                </td>
                                <td>
                                    <%=(listArtistsAllOrderName.get(i).getCpf() == null) ? "Don't have!" : listArtistsAllOrderName.get(i).getCpf()%>
                                </td>                                                             
                                                              
                            </tr>          
                                                        
                            <%} %>  
          
                    </tbody>

                </table>

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

    <script src="js/artistsearch.js">

    </script>

</html>