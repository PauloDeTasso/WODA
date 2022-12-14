<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    
    import="model.*"
    import="java.util.ArrayList"     
%>
    
<%

ArrayList<Arts> listArtsAllOrderName = (ArrayList<Arts>) request.getAttribute("listArtsAllOrderName");  

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

                <img class="ImageButton3" src="images/icons/pesquisar05.png" alt="">

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

 		 <%
         for (int i=0; i < listArtistsAllOrderName.size(); i++)
         {	 
         %>                              				
         	<input type="hidden" name="listEmailArtists" value="<%=listArtistsAllOrderName.get(i).getEmail()%>" checked>
         	<input type="hidden" name="listCpfArtists" value="<%=listArtistsAllOrderName.get(i).getCpf()%>" checked> 
         <%
         }
         %>
        
    <body>

        <form id="formRegisterArtist" name="formregisterartist" action="artistregister" method="post" onreset="clear()">

            <fieldset>

                <legend class="LegendResgiter">

                    <img class="Buttons2" src="images/icons/ARTIST01.png" alt="">

					<img class="Buttons2" src="images/icons/ARTIST02.png" alt="">

                </legend>

                <table class="tableForm">
                    <tr>
                        <td>

                            <input type="text" name="name" maxlength="57" size='57' placeholder="Name"
                                onblur="verificarNome(this.value)" onchange="verificarNome(this.value)" required>

                        </td>
                        <td>
                            <div id="msgName" class="AlertMsgs">
                                *
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>

                            <input type="email" name="email" onblur="validacaoEmail(formRegisterArtist.email, this.value)" onchange="validacaoEmail(formRegisterArtist.email, this.value)" maxlength="57" size='57' placeholder="E-mail">

                        </td>
                        <td>
                            <div id="msgEmail" class="AlertMsgs">

                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>

                            <select name="gender" onblur="verificarGenero(this.value)" onchange="verificarGenero(this.value)">

                                <option value="gender" selected>...Gender...</option>

                                <option value="MALE">
                                    MALE
                                </option>

                                <option value="FEMALE">
                                    FEMALE
                                </option>

                                <option value="OTHER">
                                    OTHER
                                </option>

                            </select>

                        </td>
                        <td>
                            <div id="msgGender" class="AlertMsgs">

                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>

                            <input type="text" name="birthday" id="birthday" placeholder="...Birthday..."
                                onfocus="(this.type='date')" min="1900-01-01" onblur="validateDate('birthday',msgBirthday)" onchange="validateDate('birthday',msgBirthday)" required>

                        </td>
                        <td>
                            <div id="msgBirthday" class="AlertMsgs">
                                *
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>

                            <select id="selectNationality" name="nationality" onblur="verificarNacionalidade(this.value)" onchange="verificarNacionalidade(this.value)"
                                required>

                                <option value="nationality" selected>...Nationality...</option>
                                <option value="??frica do Sul">??frica do Sul</option>
                                <option value="Alb??nia">Alb??nia</option>
                                <option value="Alemanha">Alemanha</option>
                                <option value="Andorra">Andorra</option>
                                <option value="Angola">Angola</option>
                                <option value="Anguilla">Anguilla</option>
                                <option value="Antigua">Antigua</option>
                                <option value="Ar??bia Saudita">Ar??bia Saudita</option>
                                <option value="Argentina">Argentina</option>
                                <option value="Arm??nia">Arm??nia</option>
                                <option value="Aruba">Aruba</option>
                                <option value="Austr??lia">Austr??lia</option>
                                <option value="??ustria">??ustria</option>
                                <option value="Azerbaij??o">Azerbaij??o</option>
                                <option value="Bahamas">Bahamas</option>
                                <option value="Bahrein">Bahrein</option>
                                <option value="Bangladesh">Bangladesh</option>
                                <option value="Barbados">Barbados</option>
                                <option value="B??lgica">B??lgica</option>
                                <option value="Benin">Benin</option>
                                <option value="Bermudas">Bermudas</option>
                                <option value="Botsuana">Botsuana</option>
                                <option value="Brasil">Brasil</option>
                                <option value="Brunei">Brunei</option>
                                <option value="Bulg??ria">Bulg??ria</option>
                                <option value="Burkina Fasso">Burkina Fasso</option>
                                <option value="Cabo Verde">Cabo Verde</option>
                                <option value="Camar??es">Camar??es</option>
                                <option value="Camboja">Camboja</option>
                                <option value="Canad??">Canad??</option>
                                <option value="Cazaquist??o">Cazaquist??o</option>
                                <option value="Chade">Chade</option>
                                <option value="Chile">Chile</option>
                                <option value="China">China</option>
                                <option value="Cidade do Vaticano">Cidade do Vaticano</option>
                                <option value="Col??mbia">Col??mbia</option>
                                <option value="Congo">Congo</option>
                                <option value="Cor??ia do Sul">Cor??ia do Sul</option>
                                <option value="Costa do Marfim">Costa do Marfim</option>
                                <option value="Costa Rica">Costa Rica</option>
                                <option value="Cro??cia">Cro??cia</option>
                                <option value="Dinamarca">Dinamarca</option>
                                <option value="Djibuti">Djibuti</option>
                                <option value="Dominica">Dominica</option>
                                <option value="EUA">EUA</option>
                                <option value="Egito">Egito</option>
                                <option value="El Salvador">El Salvador</option>
                                <option value="Emirados ??rabes">Emirados ??rabes</option>
                                <option value="Equador">Equador</option>
                                <option value="Eritr??ia">Eritr??ia</option>
                                <option value="Esc??cia">Esc??cia</option>
                                <option value="Eslov??quia">Eslov??quia</option>
                                <option value="Eslov??nia">Eslov??nia</option>
                                <option value="Espanha">Espanha</option>
                                <option value="Est??nia">Est??nia</option>
                                <option value="Eti??pia">Eti??pia</option>
                                <option value="Fiji">Fiji</option>
                                <option value="Filipinas">Filipinas</option>
                                <option value="Finl??ndia">Finl??ndia</option>
                                <option value="Fran??a">Fran??a</option>
                                <option value="Gab??o">Gab??o</option>
                                <option value="G??mbia">G??mbia</option>
                                <option value="Gana">Gana</option>
                                <option value="Ge??rgia">Ge??rgia</option>
                                <option value="Gibraltar">Gibraltar</option>
                                <option value="Granada">Granada</option>
                                <option value="Gr??cia">Gr??cia</option>
                                <option value="Guadalupe">Guadalupe</option>
                                <option value="Guam">Guam</option>
                                <option value="Guatemala">Guatemala</option>
                                <option value="Guiana">Guiana</option>
                                <option value="Guiana Francesa">Guiana Francesa</option>
                                <option value="Guin??-bissau">Guin??-bissau</option>
                                <option value="Haiti">Haiti</option>
                                <option value="Holanda">Holanda</option>
                                <option value="Honduras">Honduras</option>
                                <option value="Hong Kong">Hong Kong</option>
                                <option value="Hungria">Hungria</option>
                                <option value="I??men">I??men</option>
                                <option value="Ilhas Cayman">Ilhas Cayman</option>
                                <option value="Ilhas Cook">Ilhas Cook</option>
                                <option value="Ilhas Cura??ao">Ilhas Cura??ao</option>
                                <option value="Ilhas Marshall">Ilhas Marshall</option>
                                <option value="Ilhas Turks &#038; Caicos">Ilhas Turks e Caicos</option>
                                <option value="Ilhas Virgens (brit.)">Ilhas Virgens (brit.)</option>
                                <option value="Ilhas Virgens(amer.)">Ilhas Virgens(amer.)</option>
                                <option value="Ilhas Wallis e Futuna">Ilhas Wallis e Futuna</option>
                                <option value="??ndia">??ndia</option>
                                <option value="Indon??sia">Indon??sia</option>
                                <option value="Inglaterra">Inglaterra</option>
                                <option value="Irlanda">Irlanda</option>
                                <option value="Isl??ndia">Isl??ndia</option>
                                <option value="Israel">Israel</option>
                                <option value="It??lia">It??lia</option>
                                <option value="Jamaica">Jamaica</option>
                                <option value="Jap??o">Jap??o</option>
                                <option value="Jord??nia">Jord??nia</option>
                                <option value="Kuwait">Kuwait</option>
                                <option value="Latvia">Latvia</option>
                                <option value="L??bano">L??bano</option>
                                <option value="Liechtenstein">Liechtenstein</option>
                                <option value="Litu??nia">Litu??nia</option>
                                <option value="Luxemburgo">Luxemburgo</option>
                                <option value="Macau">Macau</option>
                                <option value="Maced??nia">Maced??nia</option>
                                <option value="Madagascar">Madagascar</option>
                                <option value="Mal??sia">Mal??sia</option>
                                <option value="Malaui">Malaui</option>
                                <option value="Mali">Mali</option>
                                <option value="Malta">Malta</option>
                                <option value="Marrocos">Marrocos</option>
                                <option value="Martinica">Martinica</option>
                                <option value="Maurit??nia">Maurit??nia</option>
                                <option value="Mauritius">Mauritius</option>
                                <option value="M??xico">M??xico</option>
                                <option value="Moldova">Moldova</option>
                                <option value="M??naco">M??naco</option>
                                <option value="Montserrat">Montserrat</option>
                                <option value="Nepal">Nepal</option>
                                <option value="Nicar??gua">Nicar??gua</option>
                                <option value="Niger">Niger</option>
                                <option value="Nig??ria">Nig??ria</option>
                                <option value="Noruega">Noruega</option>
                                <option value="Nova Caled??nia">Nova Caled??nia</option>
                                <option value="Nova Zel??ndia">Nova Zel??ndia</option>
                                <option value="Om??">Om??</option>
                                <option value="Palau">Palau</option>
                                <option value="Panam??">Panam??</option>
                                <option value="Papua-nova Guin??">Papua-nova Guin??</option>
                                <option value="Paquist??o">Paquist??o</option>
                                <option value="Peru">Peru</option>
                                <option value="Polin??sia Francesa">Polin??sia Francesa</option>
                                <option value="Pol??nia">Pol??nia</option>
                                <option value="Porto Rico">Porto Rico</option>
                                <option value="Portugal">Portugal</option>
                                <option value="Qatar">Qatar</option>
                                <option value="Qu??nia">Qu??nia</option>
                                <option value="Rep. Dominicana">Rep. Dominicana</option>
                                <option value="Rep. Tcheca">Rep. Tcheca</option>
                                <option value="Reunion">Reunion</option>
                                <option value="Rom??nia">Rom??nia</option>
                                <option value="Ruanda">Ruanda</option>
                                <option value="R??ssia">R??ssia</option>
                                <option value="Saipan">Saipan</option>
                                <option value="Samoa Americana">Samoa Americana</option>
                                <option value="Senegal">Senegal</option>
                                <option value="Serra Leone">Serra Leone</option>
                                <option value="Seychelles">Seychelles</option>
                                <option value="Singapura">Singapura</option>
                                <option value="S??ria">S??ria</option>
                                <option value="Sri Lanka">Sri Lanka</option>
                                <option value="St. Kitts &#038; Nevis">St. Kitts E Nevis</option>
                                <option value="St. L??cia">St. L??cia</option>
                                <option value="St. Vincent">St. Vincent</option>
                                <option value="Sud??o">Sud??o</option>
                                <option value="Su??cia">Su??cia</option>
                                <option value="Sui??a">Sui??a</option>
                                <option value="Suriname">Suriname</option>
                                <option value="Tail??ndia">Tail??ndia</option>
                                <option value="Taiwan">Taiwan</option>
                                <option value="Tanz??nia">Tanz??nia</option>
                                <option value="Togo">Togo</option>
                                <option value="Trinidad &#038; Tobago">Trinidad E Tobago</option>
                                <option value="Tun??sia">Tun??sia</option>
                                <option value="Turquia">Turquia</option>
                                <option value="Ucr??nia">Ucr??nia</option>
                                <option value="Uganda">Uganda</option>
                                <option value="Uruguai">Uruguai</option>
                                <option value="Venezuela">Venezuela</option>
                                <option value="Vietn??">Vietn??</option>
                                <option value="Zaire">Zaire</option>
                                <option value="Z??mbia">Z??mbia</option>
                                <option value="Zimb??bue">Zimb??bue</option>

                            </select>

                        </td>
                        <td>
                            <div id="msgNationality" class="AlertMsgs">
                                *
                            </div>
                        </td>
                    </tr>

                    <tr id="sectionCpf">
                        <td>

                            <input type="text" id="cpf" name="cpf" maxlength="11" size='11'
                                placeholder="CPF" onblur="formatarCpf(this.value)" onchange="formatarCpf(this.value)" required>

                        </td>

                        <td>
                            <div id="msgCpf" class="AlertMsgs">
                                *
                            </div>
                        </td>

                    </tr>
                    
                    <tr>

                        <td>
                                          
							<h3 class="TitlesH3">
								ASSOCIATES ARTS: 
							</h3>		
							
							<section id="sectionAssociate">
							
								<input type="radio" id="associatesOn" name="associates" value="YES" onchange="openCloseSection(sectionAssociateList,'display',true)">
?? 								<label for="associates">YES</label>
?? 						
								<input type="radio" id="associatesOff" name="associates" value="NO" onchange="openCloseSection(sectionAssociateList,'display',false)" checked>
								<label for="associates">NO</label>
                       			
                       		</section>														
                            	
                            <section id="sectionAssociateList">
                                                    
                    	   		<table>
                   			 	 
                   			 	   <%for (int i=0; i < listArtsAllOrderName.size(); i++)
                          		   {	 
                         		   %>     
                   			
                   			 		<tr>
                        				
                        				<td class="idArtist">                               				
                         				     
                          				 <input type="checkbox" name="checkallidsarts" value="<%=listArtsAllOrderName.get(i).getIdart()%>">
                       					
                       					<%=listArtsAllOrderName.get(i).getName()%>  
                         				               
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
                    
                </table>


                <section class="SectionButtons">

                    <section id="msgStatus" class="AlertMsgs">

                    </section>


                    <button type="reset" class="Buttons">

                        <img class="ImagesButtonsRegister" src="images/icons/LIMPAR.png" alt="">

                    </button>

                    <button type="button" id="submitButton" class="Buttons" onclick="formValidate('formregisterartist')">

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

    <script src="js/artistregister.js">

    </script>    

</html>