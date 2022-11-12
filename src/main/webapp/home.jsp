<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  
    import="model.*" 
    import="java.sql.*" 
    import="java.io.*"
    import="java.*"
    import="controllers.*"
%>
    
    <%@ page import="model.Artists"%>
    
     <%@ page import="model.*"%>
     
     <%@ page import="controllers.*"%>
    
    <%@ page import="java.util.ArrayList"%>
    
  <%
  
 ArrayList<Artists> lista = (ArrayList<Artists>) request.getAttribute("contatos");
   
    /*
    REMOVE A CHECAGEM DESNECESSARIA DO ARRAYLIST DO CODIGO NO ECLIPSE:
    */
    
  /*
  
  //TESTE DE RECEBIMENTO:
	  
  for (int i = 0; i < lista.size(); i++)
  {
		  out.println(lista.get(i).getIdArtist());
		  out.println(lista.get(i).getNome());
		  out.println(lista.get(i).getFone());
		  out.println(lista.get(i).getEmail());
		 }
*/
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

                <button type="button" id="seacherButton" class="Buttons">

                    <img class="ImagesButtons" id="imageSeacherButton" src="images/icons/pesquisar04.png" alt=""
                        onclick="openClose(seacher,'display','menuSeacher')">

                </button>

                <button type="button" id="registerButton" class="Buttons">

                    <img class="ImagesButtons" id="imageRegisterButton" src="images/icons/cadastrar.png" alt=""
                        onclick="openPage('artistregister.html', '_self')">

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

                   				<img class="Buttons" src="images/icons/pesquisar02.png" alt="">

                			</legend>

                    	<input type="search" name="seacherText" placeholder="Seacher">

                    	<label>
                        	<input type="radio" name="seacherCheckbox" value="Authors" checked />
                        	Authors</label>
                    	<label>
                    	    <input type="radio" name="seacherCheckbox" value="Arts"> Arts</label>
						
						</fieldset>

                	</form>

				</section>

            </section>

            <section id="sectionTableSeacher">

                <table id="tabela">

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
                            
                              <th>
                               ADMIN OPTIONS
                            </th>                         

                        </tr>

                    </thead>

                    <tbody>

					<%
					Blob blob;
                    Blob blobStream;
                    %>

                        <%for (int i=0; i < lista.size(); i++)
                          
                        { %>
                        
                            <tr>
                                <td>
                                	<%=lista.get(i).getIdArtist()%>
                                </td>
                                <td>
                                   <a href="artist?idArtist=<%=lista.get(i).getIdArtist()%>"><%=lista.get(i).getNome()%></a> 
                                </td>
                                <td>
                                    <%=lista.get(i).getEmail()%>
                                </td>
                                <td>
                                    <%=lista.get(i).getSexo()%>
                                </td>
                                <td>
                                    <%=lista.get(i).getDatadenascimento("br")%>
                                </td>
                                <td>
                                    <%=lista.get(i).getNacionalidade()%>
                                </td>
                                <td>
                                    <%=lista.get(i).getCpf()%>
                                </td>                                                             
                                
                                <td>
                                
                                <section class="buttonsAdminOptions"> 
                                   
                                	<button type="button" class="Buttons">
                                    	
										<a href="select?idArtist=<%=lista.get(i).getIdArtist()%>&name=<%=lista.get(i).getNome()%>&email=<%=lista.get(i).getEmail()%>&gender=<%=lista.get(i).getSexo()%>&birthday=<%=lista.get(i).getDatadenascimento()%>&nationality=<%=lista.get(i).getNacionalidade()%>&cpf=<%=lista.get(i).getCpf()%>">
										<img class="ImagesButtons" src="images/icons/editar03.png" alt="">                                    	
										</a>
                                	
                                	</button>
                                	
                                	<button type="button" class="Buttons">

										<a href="javascript: confirmar(<%=lista.get(i).getIdArtist() %>)">
											<img class="ImagesButtons" src="images/icons/deletar01Vazio.png" alt="">
										</a>
										
                                	</button>
                                  
                              	</section>
                              	
                                </td>
                                
                            </tr>
                                      
                              <%                                                       
                              
                              /*
                            	String fileName = "image.png";
                               
                                blob = lista.get(i).getImageartist();
    							                                
                                byte[] bin = blob.getBytes(1, (int) blob.length());
						
                                ByteArrayInputStream stream = new ByteArrayInputStream(bin);
										
                                ConnectionDB dao = new ConnectionDB();
																				
                                dao.imageArtistDB(stream);		                
                                                   
                                blob = lista.get(i).getImageartist();
                                                     
                                String fileName = "image.png";
                                                     
                                FileOutputStream fos = new FileOutputStream(fileName);
                 	                                
                                int len = (int) blob.length();

                                byte[] buf = blob.getBytes(1, len);

                                fos.write(buf, 0, len);
                                                     
                                InputStream is = blob.getBinaryStream();
                               
                                ObjectInputStream ois = new ObjectInputStream(is);
        						
                                //ois.readObject();
                                
                                
                                int b;
                                
                                while ((b = is.read()) != - 1 )
                                {                                   
                                	out.write(b);
                                }
                                
                                out.flush();
                                
                        		//fos.close();
                                
                        		ObjectInputStream is = new ObjectInputStream(blob.getBinaryStream());
                        						
                        		is.readObject();
                        		
                        		*/
                        		
                        		//
          
                        		
               //blob = lista.get(i).getImageartist();


                        		
				/*
				byte byteArray[] = blob.getBytes(3,(int)blob.length());
             
               */
               /*
              try
               {
            	  
            	 
            	  /*-
            	FileOutputStream fileOutStream = new FileOutputStream();
               
               //fos.write(byteArray);               

      		   int tamanhoBlob = (int) blob.length();

               byte[] bytesImage = blob.getBytes(1, tamanhoBlob);
               
               String ler = new FileInputStream(fileOutStream);              
               
               fos.write(bytesImage);
               
               fos.close();
               
               }catch (Exception e)
               {
            	   
               }
					
               */
					%>                                    
                                                        
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

    <script src="js/home.js">

    </script>

</html>