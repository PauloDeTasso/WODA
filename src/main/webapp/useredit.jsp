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

                    <img class="ImagesButtons" id="imageSeacherButton" src="images/icons/pesquisar04.png" alt=""
                        onclick="openPage('artistsearch','_self')">

                </button>                
                
        		<button type="button" Class="Buttons" onclick="openPage('searcharts','_self')">

                <img class="Buttons" src="images/icons/pesquisar05.png" alt="">

	            </button>

                <button type="button" id="registerButton" class="Buttons">

                    <img class="ImagesButtons" id="imageRegisterButton" src="images/icons/cadastrar.png" alt=""
                        onclick="openPage('addartist', '_self')">

                </button>

                <button type="button" id="infoButton" class="Buttons">

                    <img class="ImagesButtons" id="imageInfoButton" src="images/icons/info.png" alt=""
                        onclick="openClose(info,'display','menuInfo')">

                </button>

    			<button type="button" id="registerButton" class="Buttons">

                    <img class="ImagesButtons" id="imageRegisterButton" src="images/icons/fechar03.png" alt=""
                        onclick="openPage('index.html', '_self')">

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
    
    	<form id="formRegisterUser" name="formregisteruser" action="useredit" method="post" onreset="clear()">

            <fieldset>

                <legend class="LegendResgiter">

				<a href="users">	
                
                    <img class="Buttons" src="images/icons/USUARIOS08.png" alt="">
				
				</a>
				
                </legend>

                <table class="tableForm">
                
                    <tr>
                    
                        <td>

                            <input id="idInput" type="number" name="userid" maxlength="5" size='5' placeholder="ID"
                                value="<%out.print(authentication.getUserId());%>" readonly>

                        </td>
					
                    </tr>

                    <tr>
                    
                        <td>

                            <input type="text" name="userlogin" maxlength="50" size='50' placeholder="LOGIN" value="<%out.print(authentication.getUserLogin());%>"
                                required>

                        </td>                      
                        
                    </tr>

                    <tr>
                     
                        <td>

                            <input id="passwordInput" type="password" name="userpassword" maxlength="50" size='50' placeholder="PASSWORD"
                             value="<%out.print(authentication.getUserPassword());%>"   required>
									              					
                        </td>    
                        
                        <td>
									
							<button class="buttonView" type="button" onclick="showPassword()">
              					                                	
              					<img id="imgViewPassword" class="ImagesView" src="images/icons/veresconder.png" alt="">
              					
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

            Dev - Paulo de Tasso <br>
            Senior Full Stack Developer <br>
            World of digital artists - WODA®

            <img class="ImagesButtons" src="images/icons/SUPORTE01.png" alt="">

        </section>

		<section id="sectionUserEdit">
                             	 
             <button type="button" class="Buttons" onclick="openCloseSection(sectionTableSeacher,'display', true)">
                 
                 <img class="ImagesButtons" src="images/icons/USUARIOS09.png" alt="">
             
              </button>
                                    
        </section>       

 		<section id="sectionTableSeacher">

			<section id="sectionCloseUserEdit">
                             	 
            	 <button type="button" class="Buttons" onclick="openCloseSection(sectionTableSeacher,'display', false)">
                 
            	     <img id="imageButton" src="images/icons/fechar01.png" alt="">
             
           	   </button>
                                    
       		</section>
       		
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
										
                                    		<img class="ImagesButtons" src="images/icons/editar03.png"alt="">
                                    		
										</a>
	
                                	</button>
                                	
                                	<button type="button" class="Buttons">
									
										<a href="javascript: removeUser('<%=listAllUsers.get(i).getUserId()%>','<%=listAllUsers.get(i).getUserLogin()%>')">
										
											<img class="ImagesButtons" src="images/icons/deletar01Vazio.png" alt="">
											
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