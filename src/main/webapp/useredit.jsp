<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    
    import="model.*"
    import="java.util.ArrayList"     
%>
    
<%

Authentication authentication = (Authentication) request.getAttribute("authentication");  

ArrayList<Authentication> listAllUsers = (ArrayList<Authentication>) request.getAttribute("listAllUsers");  

%>
 

<!DOCTYPE html>
<html id="html5" lang="en-US">

    <head>

        <meta charset="UTF-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="css/user.css" />

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

                <img class="ImageButton3" src="images/icons/pesquisar05.png" alt="">

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
    
    	<form id="formRegisterUser" name="formregisteruser" action="useredit" method="post" onreset="clear()">

            <fieldset>

                <legend class="LegendResgiter">

                    <img class="Buttons2" src="images/icons/userEdit01.png" alt="">
								
                </legend>

                <table class="tableForm">
                
                    <tr>
                    
                        <td>

                            <input id="idInputEdit" type="number" name="userid" placeholder="ID"
                                value="<%out.print(authentication.getUserId());%>" min="1" max="1000" readonly>

                        </td>
					
                    </tr>

                    <tr>
                    
                        <td>

                            <input type="text" name="userlogin" maxlength="20" size="20" placeholder="LOGIN" value="<%out.print(authentication.getUserLogin());%>"
                                required>

                        </td>                      
                        
                    </tr>

                    <tr>
                     
                        <td>

                            <input id="passwordInput" type="password" name="userpassword" maxlength="20" size="20" placeholder="PASSWORD"
                             value="<%out.print(authentication.getUserPassword());%>"   required>
									              					
                        </td>    
                        
                        <td id="userTd">
									
							<button class="buttonView" type="button" onclick="showPassword()">
              					                                	
              					<img id="imgViewPassword" class="ImagesView" src="images/icons/esconder01.png" alt="">
              					
              				</button>
                    	
                    	 </td>        
                    
                    </tr>
                    
                    <tr>
                    
                    	<td>
						
							<button type="button" class="ButtonsDisabled">

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
			Developer: <br>
			Paulo de Tasso<br>
            Web Software Application<br>
            Full Stack<br>			
			
			 <button type="button" id="seacherButton" class="Buttons">

             	<a href=mailto:atedimento.site@gmail.com?subject=Contact_WODA>
             	
          	  		<img class="ImageButton3" src="images/icons/SUPORTE01.png" alt="">
          	  		
				</a>

             </button>      
			
        </section>

		<section id="sectionUserEdit">
                             	 
             <button type="button" class="Buttons" onclick="openClose(sectionTableSeacher,'display')">
                 
                 <img class="ImagesButtonsRegister" src="images/icons/userList01.png" alt="">
             
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
										
                                    		<img class="ImagesButtonsRegister" src="images/icons/userEdit01.png"alt="">
                                    		
										</a>
	
                                	</button>
                                	
                                	<button type="button" class="Buttons">
									
										<a href="javascript: removeUser('<%=listAllUsers.get(i).getUserId()%>','<%=listAllUsers.get(i).getUserLogin()%>')">
										
											<img class="ImagesButtonsRegister" src="images/icons/userDelete01.png" alt="">
											
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

    <script src="js/user.js">

    </script>    

</html>