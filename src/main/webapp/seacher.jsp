<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ page import="model.Artists"%>
    
    <%@ page import="java.util.ArrayList"%>
    
        
  <%
  
  ArrayList<Artists> lista = (ArrayList<Artists>)
  
  request.getAttribute("contatos");
  
    /*
    REMOVE A CHECAGEM DESNECESSARIA DO ARRAYLIST DO CODIGO NO ECLIPSE:
    */
    
  /*
  
  //TESTE DE RECEBIMENTO:
	  
  for (int i = 0; i < lista.size(); i++)
  {
		  out.println(lista.get(i).getIdcon());
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

        <link rel="stylesheet" href="../css/home.css" />

        <title>WODA</title>

        <link rel="icon" href="../images/logos/LogoWODA2.png" type="image/gif">

    </head>

    <!-- 
    <section id="statusSistema">

    </section>
     -->

    <header>

        <section id="sectionMenu">

            <section id="sectionButtons">

                <button type="button" id="seacherButton" class="Buttons">

                    <img class="ImagesButtons" id="imageSeacherButton" src="../images/icons/pesquisar.png" alt=""
                        onclick="openMenu()">

                </button>

                <button type="button" id="registerButton" class="Buttons">

                    <img class="ImagesButtons" id="imageRegisterButton" src="../images/icons/cadastrar.png" alt=""
                        onclick="openMenu()">

                </button>

                <button type="button" id="configButton" class="Buttons">

                    <img class="ImagesButtons" id="imageConfigButton" src="../images/icons/configurações.png" alt=""
                        onclick="openMenu()">

                </button>

                <button type="button" id="infoButton" class="Buttons">

                    <img class="ImagesButtons" id="imageInfoButton" src="../images/icons/info.png" alt=""
                        onclick="openMenu()">

                </button>

            </section>

            <section id="sectionMenuButton">

                <button type="button" id="buttonMenu">

                    <img id="imagemButtonMenu" src="../images/icons/menu01.png" alt="" onclick="openMenu()">

                </button>

            </section>

        </section>

    </header>

    <body>

        <section id="seacher">

            <img src="../images/icons/pesquisar.png" alt="" width="70px">

            <form action="seacher">

                <input type="text" name="seacherText" placeholder="Seacher">

                <label>
                    <input type="radio" name="seacherCheckbox" value="Authors" />
                    Authors</label>
                <label>
                    <input type="radio" name="seacherCheckbox" value="Arts"> Arts</label>

            </form>

        </section>

        <section id="tableSeacher">
            <table id="tabela">

                <thead>

                    <tr>

                        <th>
                            ID
                        </th>

                        <th>
                            NOME
                        </th>

                    </tr>

                </thead>

                <tbody>

                    <%for (int i=0; i < lista.size(); i++) { %>

                        <tr>

                            <td>
                                <%=lista.get(i).getIdcon()%>
                            </td>

                            <td>
                                <%=lista.get(i).getNome()%>
                            </td>

                            <td>

                                <a href="select?idcon=<%=lista.get(i).getIdcon() %>" class="Botao1">Editar</a>

                                <a href="javascript: confirmar(<%=lista.get(i).getIdcon() %>)"
                                    class="Botao2">Excluir</a>

                            </td>

                        </tr>

                        <%} %>

                </tbody>

            </table>

        </section>

        <section id="sectionGallery">

            <!-- ART -->

            <section class="SectionArts">

                <section class="SectionImageArts">

                    <img class="ImagesArts" src="../images/logos/LogoWODA2.png" alt="">

                </section>

                <!-- AUTHOR -->

                <section class="SectionAuthorArts">

                    <section class="TitlesAuthor">

                        <a href=""> ARTIST: NOME.</a>

                    </section>

                </section>

            </section>

            <!-- ART -->

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

    <script src="../js/home.js">

    </script>

</html>