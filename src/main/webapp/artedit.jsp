<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    
    import="model.*"
    import="java.util.ArrayList"     
	import="java.util.concurrent.CompletableFuture"
	import="java.util.concurrent.TimeUnit"
%>
    
<%

	ArrayList<Arts> listArtByIdArt = (ArrayList<Arts>) request.getAttribute("listArtByIdArt");  

    ArrayList<Artists> listAllArtistsOrderIdDesc = (ArrayList<Artists>) request.getAttribute("listAllArtistsOrderIdDesc");  

    ArrayList<IdsArtsArtist> listIdsArtistByIdArt = (ArrayList<IdsArtsArtist>) request.getAttribute("listIdsArtistByIdArt");  
      
    ArrayList<NamesArtsArtist> listNamesArtistByIdArtist = (ArrayList<NamesArtsArtist>) request.getAttribute("listNamesArtistByIdArtist");  
        
    String dateType = (String) request.getAttribute("dateType");
%>

    <!DOCTYPE html>
<html id="html5" lang="en-US">

    <head>

        <meta charset="UTF-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="css/register.css" />

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

                    <img id="imagemButtonMenu" src="images/icons/menu01.png" alt=""
                        onclick="abrirOptions()">

                </button>

            </section>

        </section>

    </header>

    <body>

        <form id="formRegisterArt" name="formregisterart" action="artedit"
            method="post" onreset="clear()">

            <fieldset>

                <legend class="LegendResgiter">

                    <img class="Buttons2" src="images/icons/artEdit01.png" alt="">

                </legend>

                <table class="tableForm">

                    <tr>
                        <td>

                            <input id="idInputEdit" type="text" name="idArt" size='10' placeholder="ID" value="<%=listArtByIdArt.get(0).getIdart()%>" readonly>
	
                        </td>
                        <td>
                            <div id="msgIdArtist" class="AlertMsgs"></div>
                        </td>
                    </tr>

                    <tr>
                        <td>

                            <input id="nameInputEdit" type="text" name="name" maxlength="60" size='65' placeholder="ART NAME"
                                onblur="validateName(this.value)" onchange="validateName(this.value)" value="<%=listArtByIdArt.get(0).getName()%>" required>

                        </td>
                        <td>
                            <div id="msgName" class="AlertMsgs"></div>
                        </td>
                    </tr>

                    <tr>
                        <td>

                            <input id="descriptionInputEdit" type="text" id="description" name="description"
                                onblur="validateDescription(this.value)" onchange="validateDescription(this.value)" maxlength="240" placeholder="ART DESCRIPTION" value="<%=listArtByIdArt.get(0).getDescription()%>"
                                required>

                        </td>
                        <td>
                            <div id="msgDescription" class="AlertMsgs"></div>
                        </td>
                    </tr>

                    <tr>

                        <td>

                            <input id="publicationDate" type="text" name="publicationdate" 
                            placeholder="...PUBLICATION DATE..." value="<%=(listArtByIdArt.get(0).getDataDePublicacao() == null) ? "" : listArtByIdArt.get(0).getDataDePublicacao()%>"
                            onfocus="(this.type='date')" onblur="validateDate('publicationDate',msgPublicationDate)" onchange="validateDate('publicationDate',msgPublicationDate)"  required>

                        </td>
                        <td>
                            <div id="msgPublicationDate" class="AlertMsgs"></div>
                        </td>
                    </tr>

                    <tr>

                        <td>

                            <input id="exposureDate" type="text" name="exposuredate" 
                            placeholder="...EXPOSURE DATE..." value="<%=(listArtByIdArt.get(0).getDataDeExposicao() == null) ? "" : listArtByIdArt.get(0).getDataDeExposicao()%>" 
                            onfocus="(this.type='date')" onblur="validateDate('exposureDate',msgExposureDate)" onchange="validateDate('exposureDate',msgExposureDate)" required>

                        </td>

                        <td>
                            <div id="msgExposureDate" class="AlertMsgs"></div>
                        </td>

                    </tr>                    

 					<tr>

                        <td>
                                          
							<h3 class="TitlesH3">
								ADD ASSOCIATES ARTISTS:
							</h3>		
							
							<section id="sectionAssociate">
							
								<input type="radio" id="associatesOn" name="associates" value="YES" onchange="openCloseSection(sectionAssociateList,'display',true)">
  								<label for="associates">YES</label>
  						
								<input type="radio" id="associatesOff" name="associates" value="NO" onchange="openCloseSection(sectionAssociateList,'display',false)" checked>
								<label for="associates">NO</label>
                       			
                       		</section>														
                            	
                            <section id="sectionAssociateList">                                                   
                    	   		             
                    	   		<table>
                   			 	
                   			 	<% 
                   			 		
								for (int i = 0; i < listAllArtistsOrderIdDesc.size(); i++)
								{
									
								%>													
									<tr>
                        				
  										<td class="idArtist">                               				
                         				     
                          					<input type="checkbox" name="newidartistchecked" value="<%=listAllArtistsOrderIdDesc.get(i).getIdArtist()%>">
                       					 
                         				    	<%=listAllArtistsOrderIdDesc.get(i).getNome()%>          
                       							
                       					</td>
                       					
                        			</tr>  
                        		<%
								}
								%>      
                         
                        		</table>                        
                                 
                            </section>
                        </td>

                        <td>
                            <div id="msgExtraArtistId" class="AlertMsgs"></div>
                        </td>

                    </tr>    				

					<tr>

                        <td>
                                          
							<h3 class="TitlesH3">
								EDIT ASSOCIATED ARTISTS: 
							</h3>		
							
							<section id="sectionAssociateEdit">
							
								<input type="radio" id="associatesOnEdit" name="associatesedit" value="YES" onchange="openCloseSection(sectionAssociateListEdit,'display',true)">
  								<label for="associates">YES</label>
  						
								<input type="radio" id="associatesOffEdit" name="associatesedit" value="NO" onchange="openCloseSection(sectionAssociateListEdit,'display',false)" checked>
								<label for="associates">NO</label>
                       			
                       		</section>														
                            	
                            <section id="sectionAssociateListEdit">                                                   
                    	   		             
                    	   		<table>
                   			 	
                   			 	<% 
                   			 		
								for (int i = 0; i < listNamesArtistByIdArtist.size(); i++)
								{
									
								%>													
									<tr>
                        				
  										<td class="idArtist">                               				
                         				     
                          					<input type="checkbox" name="editartistsidscheck" value="<%=listIdsArtistByIdArt.get(i).getIdArt()%>" checked>
                       					 
                       					 		<%=listNamesArtistByIdArtist.get(i).getNameArt()%>          
                       							
                       					</td>
                       					
                        			</tr>  
                        		<%
								}
								%>  
                         
                        		</table>                        
                                 
                            </section>
                        </td>

                        <td>
                            <div id="msgExtraArtistId2" class="AlertMsgs"></div>
                        </td>

                    </tr> 

					<tr>
					
						<td>

							<input type="hidden" id="dateTypeInput" name="datetype" value="">

							<input type="hidden" id=dateTypeInput2 name="datetype2" value="<%=dateType%>">

						</td>
					
					</tr>

                </table>

                <section class="SectionButtons">

                    <section id="msgStatus" class="AlertMsgs">

                    </section>

                    	<button type="button" class="ButtonsDisabled">

                        	<img class="ImagesButtonsRegister" src="images/icons/LIMPAR.png" alt="">

                   		</button>

                    <button type="button" id="submitButton" class="Buttons" onclick="formValidate('formregisterart')">

                        <img class="ImagesButtonsRegister" src="images/icons/save01.png" alt="">

                    </button>

                </section>

            </fieldset>

        </form>

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

    <script src="js/artedit.js">

    </script>

</html>