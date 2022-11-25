<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    
    import="model.*"
    import="java.util.ArrayList"     
%>
    
<%

ArrayList<Authentication> listAllUsers = (ArrayList<Authentication>) request.getAttribute("listAllUsers");  

%>
 

<!DOCTYPE html>
<html id="html5" lang="en-US">

    <head>

        <meta charset="UTF-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="css/register.css" />
        
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

                    <img id="imagemButtonMenu" src="images/icons/menu03.png" alt=""
                        onclick="abrirOptions()">

                </button>

            </section>

        </section>

    </header> 		
        
    <body>
    
    	<form id="formRegisterUser" name="formregisteruser" action="useradd" method="post" onreset="clear()">

            <fieldset>

                <legend class="LegendResgiter">

                    <img class="Buttons2" src="images/icons/userAdd01.png" alt="">

                </legend>

                <table class="tableForm">
                
                    <tr>
                
                        <td>

                            <input id="idInput" type="number" name="userid" placeholder="ID"
                                value="" required>

                        </td>
					
                    </tr>

                    <tr>
                       
                        <td>

                            <input type="text" name="userlogin" maxlength="50" size="50" placeholder="LOGIN"
                                value="" required>

                        </td>                      
                        
                    </tr>

                    <tr>
                     
                        <td>

              					<input id="passwordInput" type="password" name="userpassword" maxlength="50" size="50" placeholder="PASSWORD"
                                value="" required>
                                          					
                        </td>          
                    
                    	<td>
									
							<button class="buttonView" type="button" onclick="showPassword()">
              					                                	
              					<img id="imgViewPassword" class="ImagesView" src="images/icons/esconder01.png" alt="">
              					
              				</button>
                    	
                    	 </td>     
                    
                    </tr>                    
                    
                    <tr>
                    
                    	<td>
						
							<button type="reset" class="Buttons">

                     			<img class="ImagesButtonsRegister" src="images/icons/LIMPAR.png" alt="">

                   			</button>
                
						</td>
					
						<td>
					
                   	 		<button type="submit" formmethod="post" id="submitButton" class="Buttons">

                   	    	<img class="ImagesButtonsRegister" src="images/icons/save01.png" alt="">

                     		</button>

                		</td>                		
                        
                   	</tr>
                              
                </table>

            </fieldset>

        </form>		

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

		<section id="sectionUserEdit">
                             	 
             <button type="button" class="Buttons" onclick="openClose(sectionTableSeacher,'display')">
                 
                 <img class="ImageButton3" src="images/icons/USUARIOS09.png" alt="">
             
              </button>
                                    
        </section>       

 		<section id="sectionTableSeacher">

        	<table id="tableArtists" class="tabela">

            	<thead>

                	<tr>

                    	<th>
                	        ID
                        </th>

                        <th>
    	                    LOGIN
                        </th>

                        <th>
	                        PASSWORD
                        </th>      
                               
                        <th>
	                        OPTIONS
                        </th>                                              

                    </tr>

                    </thead>

                    <tbody>

                        <%for (int i=0; i < listAllUsers.size(); i++)
                          
                        { %>
                        
                        	<tr>
                                <td>
                                	<%=listAllUsers.get(i).getUserId()%>
                                </td>
                            
                                <td>        
                                   
                                   <%=listAllUsers.get(i).getUserLogin()%>
                                   
                                </td>
                            
                                <td>
                                
                                    <%=listAllUsers.get(i).getUserPassword()%>
                                    
                                </td>
                                                        
                            	<td class="tdOption">
                            	
                                	<button type="button" class="Buttons">

										<a href="userselect?userid=<%=listAllUsers.get(i).getUserId()%>&userlogin=<%=listAllUsers.get(i).getUserLogin()%>&userpassword=<%=listAllUsers.get(i).getUserPassword()%>">
										
                                    		<img class="ImageButton3" src="images/icons/userEdit01.png"alt="">
                                    		
										</a>
	
                                	</button>
                                	
                                	<button type="button" class="Buttons">
									
										<a href="javascript: removeUser('<%=listAllUsers.get(i).getUserId()%>','<%=listAllUsers.get(i).getUserLogin()%>','<%=listAllUsers.get(i).getUserPassword()%>')">
										
											<img class="ImageButton3" src="images/icons/userDelete01.png" alt="">
											
										</a>

                                	</button>  
                                	
								</td>                               
                            
                            </tr>                                 
                                                        
                            <%} %>  
          
                    </tbody>

                </table>

			</section>

    </body>

    <footer>

        <section id="sectionFooter">

            World of digital artists - WODA®

        </section>      

    </footer>

    <script src="js/artistregister.js">

    </script>    

</html>