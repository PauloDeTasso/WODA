<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    
    import="model.*"
    import="java.util.ArrayList"     
%>
    
<%
 ArrayList<Artists> listArtistsAllOrderName = (ArrayList<Artists>) request.getAttribute("listArtistsAllOrderName");  

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

                    <img class="ImageButton3" id="imageRegisterButton" src="images/icons/artistsadd01.png" alt=""
                        onclick="openPage('addartist', '_self')">

                </button>

                <button type="button" id="configButton" class="Buttons">

                    <img class="ImageButton3" src="images/icons/USUARIOS08.png" alt=""
                        	onclick="openPage('users','_self')">

                </button>

                <button type="button" id="infoButton" class="Buttons">

                    <img class="ImageButton3" id="imageInfoButton" src="images/icons/info.png" alt=""
                        onclick="openClose(info,'display')">

                </button>

    			<button type="button" id="registerButton" class="Buttons">

                    <img class="ImageButton3" id="imageRegisterButton" src="images/icons/exit01.png" alt=""
                        onclick="openPage('javascript: exit()', '_self')">

                </button>

            </section>

            <section id="sectionMenuButton">

                <button type="button" id="buttonMenu">

                    <img id="imagemButtonMenu" src="images/icons/menu03.png" alt=""
                        onclick="abrirOptions()">

                </button>

            </section>

        </section>

    </header>

    <body>

        <form id="formRegisterArt" name="formregisterart" action="artregister"
            method="post" onreset="clear()">

            <fieldset>

                <legend class="LegendResgiter">

                    <img class="Buttons2" src="images/icons/artAdd01.png" alt="">

                </legend>

                <table class="tableForm">
                    <tr>
                        <td>

                            <input type="text" name="name" maxlength="40" size="40" placeholder="ART NAME"
                                onblur="validateName(this.value)" onchange="validateName(this.value)" required>

                        </td>
                        <td>
                            <div id="msgName" class="AlertMsgs"></div>
                        </td>
                    </tr>

                    <tr>
                        <td>

                            <input type="text" id="description" name="description"
                                onblur="validateDescription(this.value)" onchange="validateDescription(this.value)" maxlength="240" size="40" placeholder="ART DESCRIPTION"
                                required>

                        </td>
                        <td>
                            <div id="msgDescription" class="AlertMsgs"></div>
                        </td>
                    </tr>

                    <tr>

                        <td>

                            <input type="text" name="publicationdate" id="publicationDate"
                                placeholder="PUBLICATION DATE" onfocus="(this.type='date')" min="1900-01-01"                                
                                onblur="validateDate('publicationDate',msgPublicationDate)" onchange="validateDate('publicationDate',msgPublicationDate)" value="" required>

                        </td>
                        <td>
                            <div id="msgPublicationDate" class="AlertMsgs"></div>
                        </td>
                    </tr>

                    <tr>

                        <td>

                            <input type="text" name="exposuredate" id="exposureDate" placeholder="EXPOSURE DATE"
                                onfocus="(this.type='date')" min="1900-01-01" onblur="validateDate('exposureDate',msgExposureDate)" onchange="validateDate('exposureDate',msgExposureDate)" value=""
                                required>

                        </td>

                        <td>
                            <div id="msgExposureDate" class="AlertMsgs"></div>
                        </td>

                    </tr>       
                    
                    <tr>
                    						
                        <td>


                    	<h3 class="TitlesH3">
							ARTIST:
						</h3>

                            <input class="idInput" type="text" name="artist" maxlength="60" size='65'
                                value="<%=request.getAttribute("artistName")%>" readonly>

                        </td>
                        
                        <td>
                    
                            <div id="msgIdArtist" class="AlertMsgs"></div>
                    
                        </td>
                    
                    </tr>
                    
                    <tr>

                        <td>
                                          
							<h3 class="TitlesH3">
								ASSOCIATES ARTISTS: 
							</h3>		
							
							<section id="sectionAssociate">
							
								<input type="radio" id="associatesOn" name="associates" value="YES" onblur="openCloseSection(sectionAssociateList,'display',true)" onchange="openCloseSection(sectionAssociateList,'display',true)">
?? 								<label for="associates">YES</label>
?? 						
								<input type="radio" id="associatesOff" name="associates" value="NO" onblur="openCloseSection(sectionAssociateList,'display',false)" onchange="openCloseSection(sectionAssociateList,'display',false)" checked>
								<label for="associates">NO</label>
                       			
                       		</section>														
                            	
                            <section id="sectionAssociateList">
                                                    
                    	   		<table>
                   			 	 
                   			 	   <%for (int i=0; i < listArtistsAllOrderName.size(); i++)
                          		   {    
                         				 if(listArtistsAllOrderName.get(i).getNome().equals(request.getAttribute("artistName")))
                         				 {
                         					 
                         				 }else
                         				 {
                         					%>     
                   			
                   			 		<tr>
                        				
                        				<td class="idArtist">                               				
                         				     
                          				 <input type="checkbox" name="checkallids" value="<%=listArtistsAllOrderName.get(i).getIdArtist()%>">
                       					 
                         				         <%=listArtistsAllOrderName.get(i).getNome()%>          
                       					</td>
                       					
                        			</tr>           
                        			            
                        	 	   <%
                        	 	  		} 
                        	 	
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

							<input type="hidden" id="dateTypeInput" name="datetype">

						</td>
					
					</tr>
                
                </table>

                <section class="SectionButtons">

                    <section id="msgStatus" class="AlertMsgs">

                    </section>

                    <button type="reset" class="Buttons">

                        <img class="ImagesButtonsRegister" src="images/icons/LIMPAR.png" alt="">

                    </button>

                    <button type="button" id="submitButton" class="Buttons" onclick="formValidate('formRegisterArt')">

                        <img class="ImagesButtonsRegister" src="images/icons/save01.png" alt="">

                    </button>

                </section>

            </fieldset>

        </form>               

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

    <script src="js/artregister.js">

    </script>

</html>