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

    <!-- 
    <section id="statusSistema">

    </section>
     -->

    <header>

        <section id="sectionMenu">

            <section id="sectionButtons">

  				<button type="button" Class="Buttons" onclick="openPage('main','_self')">

                	<img class="Buttons" src="images/icons/voltar.png" alt="">

            	</button>

                <button type="button" id="seacherButton" class="Buttons">

                    <img class="ImagesButtons" id="imageSeacherButton" src="images/icons/pesquisar04.png" alt=""
                        onclick="openPage('artistsearch','_self')">

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

                    <form action="searcharts">

                        <fieldset>

                            <legend class="LegendResgiter">

                                <button id="searchButton" type="button" Class="Buttons"
                                    onclick="submitSearcher(mySearchArts.value,'arts')">

                                    <img class="Buttons" src="images/icons/pesquisar05.png" alt="">

                                </button>

                            </legend>

                            <input id="mySearchArts" type="search" name="searchinput" placeholder="Seacher"
                                onkeyup="changeButton(searchButton)" value="<%out.println(searchArt);%>" autofocus>

                            <button type="button" Class="Buttons" onclick="submitSearcher(mySearchArts.value,'arts')">

                                <img class="Buttons" src="images/icons/PESQUISAR01.png" alt="">

                            </button>

                            <section id="sectionAssociate">

                                <input type="radio" id="associatesOn" name="searchoption" value="name" <%=optionName%>>
                                  <label for="searchoption">NAME</label>
                                 
                                <input type="radio" id="associatesOff" name="searchoption" value="description" <%=optionDescription%>>
                                <label for="searchoption">DESCRIPTION</label>

                            </section>

                        </fieldset>

                    </form>

                </section>

            </section>

            <section id="sectionTableSeacher">

                 <table id="tableArts" class="tabela">

                    <thead>

                        <tr>

                            <th>
                                ID
                            </th>

                            <th>
                                NAME
                            </th>

                            <th>
                                DESCRIPTION
                            </th>

                            <th>
                             	EXPOSURE DATE
                            </th>

                            <th>
                                PUBLICATION DATE
                            </th>                                                 

                        </tr>

                    </thead>

                    <tbody>

                        <%for (int i=0; i < listAllArts.size(); i++)                          
                        { 
                        %>
                            <tr>
                                <td>
                                	<%=listAllArts.get(i).getIdart()%>
                                </td>
                                <td>
                                
                                   <a href="art?idart=<%=listAllArts.get(i).getIdart()%>">
                                   <%=listAllArts.get(i).getName()%>
                                   </a> 
                                   
                                </td>
                                <td>
                                    <%=listAllArts.get(i).getDescription()%>
                                </td>
                                <td>
                                     <%
                           		    dataDeExposicao = (listAllArts.get(i).getDataDeExposicao() == null) ? "" : listAllArts.get(i).getDataDeExposicao("br"); 
                           		 	
                           			out.print(dataDeExposicao);
                           		 	%>
                                </td>
                                <td>
                                   <%
                           			dataDePublicacao = (listAllArts.get(i).getDataDePublicacao() == null) ? "" : listAllArts.get(i).getDataDePublicacao("br"); 
                           		 	
                       				out.print(dataDePublicacao);
                       		 		%>
                                </td>                                                                                                                  
                                                               
                            </tr>          
                                                        
                            <%
                            }
                        	%>  
          
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

    <script src="js/artsearch.js">

    </script>

</html>