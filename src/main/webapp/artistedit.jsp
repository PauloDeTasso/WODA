<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

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

                <button type="button" id="seacherButton" class="ButtonsRegister">

                    <img class="ImagesButtons" id="imageSeacherButton" src="images/icons/voltar.png" alt=""
                        onclick="openPage('main', '_self')">

                </button>

                <button type="button" id="infoButton" class="ButtonsRegister">

                    <img class="ImagesButtons" id="imageInfoButton" src="images/icons/info.png" alt=""
                        onclick="openClose(info,'display','menuInfo')">

                </button>

            </section>

            <section id="sectionMenuButton">

                <button type="button" id="buttonMenu">

                    <img id="imagemButtonMenu" src="images/icons/menu01.png" alt=""
                        onclick="openClose(sectionButtons,'visibility')">

                </button>

            </section>

        </section>

    </header>

    <body>

        <form id="formRegisterArtist" name="formregisterartist" action="update" method="get" onreset="clear()">

            <fieldset>

                <legend class="LegendResgiter">

                    <img class="Buttons" src="images/icons/ARTIST01.png" alt="">

                    <img class="Buttons" src="images/icons/ARTIST02.png" alt="">

                </legend>

                <table>

                    <tr>
                        <td>

                            <input type="text" name="idartist" size='5' placeholder="ID" value="<%out.print(request.getAttribute("idArtist"));%>" readonly>

                        </td>
                        <td>
                            <div id="msgIdArtist" class="AlertMsgs"></div>
                        </td>
                    </tr>

                    <tr>
                        <td>

                            <input type="text" name="name" maxlength="60" size='65' placeholder="Name"
                                onchange="verificarNome(this.value)" value="<%out.print(request.getAttribute("name"));%>" required>

                        </td>
                        <td>
                            <div id="msgName" class="AlertMsgs">
                                *
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>

                            <input type="email" name="email" onchange="validacaoEmail(formRegister.email)"
                                maxlength="60" size='65' placeholder="E-mail" value="<%out.print(request.getAttribute("email"));%>">

                        </td>
                        <td>
                            <div id="msgEmail" class="AlertMsgs">

                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>

                            <select name="gender" onchange="verificarGenero(this.value)">

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

								<option value="<%out.print(request.getAttribute("gender"));%>" selected>
								<%out.print(request.getAttribute("gender"));%>
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
                                onfocus="(this.type='date')" onchange="validateDate('birthday',msgBirthday)" value="<%out.print(request.getAttribute("birthday"));%>" required>

                        </td>
                        <td>
                            <div id="msgBirthday" class="AlertMsgs">
                                *
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>

                            <select id="nationality" name="nationality" onchange="verificarNacionalidade(this.value)"
                                required>

                                <option value="nationality" selected>...Nationality...</option>
                                <option value="África do Sul">África do Sul</option>
                                <option value="Albânia">Albânia</option>
                                <option value="Alemanha">Alemanha</option>
                                <option value="Andorra">Andorra</option>
                                <option value="Angola">Angola</option>
                                <option value="Anguilla">Anguilla</option>
                                <option value="Antigua">Antigua</option>
                                <option value="Arábia Saudita">Arábia Saudita</option>
                                <option value="Argentina">Argentina</option>
                                <option value="Armênia">Armênia</option>
                                <option value="Aruba">Aruba</option>
                                <option value="Austrália">Austrália</option>
                                <option value="Áustria">Áustria</option>
                                <option value="Azerbaijão">Azerbaijão</option>
                                <option value="Bahamas">Bahamas</option>
                                <option value="Bahrein">Bahrein</option>
                                <option value="Bangladesh">Bangladesh</option>
                                <option value="Barbados">Barbados</option>
                                <option value="Bélgica">Bélgica</option>
                                <option value="Benin">Benin</option>
                                <option value="Bermudas">Bermudas</option>
                                <option value="Botsuana">Botsuana</option>
                                <option value="Brasil">Brasil</option>
                                <option value="Brunei">Brunei</option>
                                <option value="Bulgária">Bulgária</option>
                                <option value="Burkina Fasso">Burkina Fasso</option>
                                <option value="Cabo Verde">Cabo Verde</option>
                                <option value="Camarões">Camarões</option>
                                <option value="Camboja">Camboja</option>
                                <option value="Canadá">Canadá</option>
                                <option value="Cazaquistão">Cazaquistão</option>
                                <option value="Chade">Chade</option>
                                <option value="Chile">Chile</option>
                                <option value="China">China</option>
                                <option value="Cidade do Vaticano">Cidade do Vaticano</option>
                                <option value="Colômbia">Colômbia</option>
                                <option value="Congo">Congo</option>
                                <option value="Coréia do Sul">Coréia do Sul</option>
                                <option value="Costa do Marfim">Costa do Marfim</option>
                                <option value="Costa Rica">Costa Rica</option>
                                <option value="Croácia">Croácia</option>
                                <option value="Dinamarca">Dinamarca</option>
                                <option value="Djibuti">Djibuti</option>
                                <option value="Dominica">Dominica</option>
                                <option value="EUA">EUA</option>
                                <option value="Egito">Egito</option>
                                <option value="El Salvador">El Salvador</option>
                                <option value="Emirados Árabes">Emirados Árabes</option>
                                <option value="Equador">Equador</option>
                                <option value="Eritréia">Eritréia</option>
                                <option value="Escócia">Escócia</option>
                                <option value="Eslováquia">Eslováquia</option>
                                <option value="Eslovênia">Eslovênia</option>
                                <option value="Espanha">Espanha</option>
                                <option value="Estônia">Estônia</option>
                                <option value="Etiópia">Etiópia</option>
                                <option value="Fiji">Fiji</option>
                                <option value="Filipinas">Filipinas</option>
                                <option value="Finlândia">Finlândia</option>
                                <option value="França">França</option>
                                <option value="Gabão">Gabão</option>
                                <option value="Gâmbia">Gâmbia</option>
                                <option value="Gana">Gana</option>
                                <option value="Geórgia">Geórgia</option>
                                <option value="Gibraltar">Gibraltar</option>
                                <option value="Granada">Granada</option>
                                <option value="Grécia">Grécia</option>
                                <option value="Guadalupe">Guadalupe</option>
                                <option value="Guam">Guam</option>
                                <option value="Guatemala">Guatemala</option>
                                <option value="Guiana">Guiana</option>
                                <option value="Guiana Francesa">Guiana Francesa</option>
                                <option value="Guiné-bissau">Guiné-bissau</option>
                                <option value="Haiti">Haiti</option>
                                <option value="Holanda">Holanda</option>
                                <option value="Honduras">Honduras</option>
                                <option value="Hong Kong">Hong Kong</option>
                                <option value="Hungria">Hungria</option>
                                <option value="Iêmen">Iêmen</option>
                                <option value="Ilhas Cayman">Ilhas Cayman</option>
                                <option value="Ilhas Cook">Ilhas Cook</option>
                                <option value="Ilhas Curaçao">Ilhas Curaçao</option>
                                <option value="Ilhas Marshall">Ilhas Marshall</option>
                                <option value="Ilhas Turks &#038; Caicos">Ilhas Turks e Caicos</option>
                                <option value="Ilhas Virgens (brit.)">Ilhas Virgens (brit.)</option>
                                <option value="Ilhas Virgens(amer.)">Ilhas Virgens(amer.)</option>
                                <option value="Ilhas Wallis e Futuna">Ilhas Wallis e Futuna</option>
                                <option value="Índia">Índia</option>
                                <option value="Indonésia">Indonésia</option>
                                <option value="Inglaterra">Inglaterra</option>
                                <option value="Irlanda">Irlanda</option>
                                <option value="Islândia">Islândia</option>
                                <option value="Israel">Israel</option>
                                <option value="Itália">Itália</option>
                                <option value="Jamaica">Jamaica</option>
                                <option value="Japão">Japão</option>
                                <option value="Jordânia">Jordânia</option>
                                <option value="Kuwait">Kuwait</option>
                                <option value="Latvia">Latvia</option>
                                <option value="Líbano">Líbano</option>
                                <option value="Liechtenstein">Liechtenstein</option>
                                <option value="Lituânia">Lituânia</option>
                                <option value="Luxemburgo">Luxemburgo</option>
                                <option value="Macau">Macau</option>
                                <option value="Macedônia">Macedônia</option>
                                <option value="Madagascar">Madagascar</option>
                                <option value="Malásia">Malásia</option>
                                <option value="Malaui">Malaui</option>
                                <option value="Mali">Mali</option>
                                <option value="Malta">Malta</option>
                                <option value="Marrocos">Marrocos</option>
                                <option value="Martinica">Martinica</option>
                                <option value="Mauritânia">Mauritânia</option>
                                <option value="Mauritius">Mauritius</option>
                                <option value="México">México</option>
                                <option value="Moldova">Moldova</option>
                                <option value="Mônaco">Mônaco</option>
                                <option value="Montserrat">Montserrat</option>
                                <option value="Nepal">Nepal</option>
                                <option value="Nicarágua">Nicarágua</option>
                                <option value="Niger">Niger</option>
                                <option value="Nigéria">Nigéria</option>
                                <option value="Noruega">Noruega</option>
                                <option value="Nova Caledônia">Nova Caledônia</option>
                                <option value="Nova Zelândia">Nova Zelândia</option>
                                <option value="Omã">Omã</option>
                                <option value="Palau">Palau</option>
                                <option value="Panamá">Panamá</option>
                                <option value="Papua-nova Guiné">Papua-nova Guiné</option>
                                <option value="Paquistão">Paquistão</option>
                                <option value="Peru">Peru</option>
                                <option value="Polinésia Francesa">Polinésia Francesa</option>
                                <option value="Polônia">Polônia</option>
                                <option value="Porto Rico">Porto Rico</option>
                                <option value="Portugal">Portugal</option>
                                <option value="Qatar">Qatar</option>
                                <option value="Quênia">Quênia</option>
                                <option value="Rep. Dominicana">Rep. Dominicana</option>
                                <option value="Rep. Tcheca">Rep. Tcheca</option>
                                <option value="Reunion">Reunion</option>
                                <option value="Romênia">Romênia</option>
                                <option value="Ruanda">Ruanda</option>
                                <option value="Rússia">Rússia</option>
                                <option value="Saipan">Saipan</option>
                                <option value="Samoa Americana">Samoa Americana</option>
                                <option value="Senegal">Senegal</option>
                                <option value="Serra Leone">Serra Leone</option>
                                <option value="Seychelles">Seychelles</option>
                                <option value="Singapura">Singapura</option>
                                <option value="Síria">Síria</option>
                                <option value="Sri Lanka">Sri Lanka</option>
                                <option value="St. Kitts &#038; Nevis">St. Kitts E Nevis</option>
                                <option value="St. Lúcia">St. Lúcia</option>
                                <option value="St. Vincent">St. Vincent</option>
                                <option value="Sudão">Sudão</option>
                                <option value="Suécia">Suécia</option>
                                <option value="Suiça">Suiça</option>
                                <option value="Suriname">Suriname</option>
                                <option value="Tailândia">Tailândia</option>
                                <option value="Taiwan">Taiwan</option>
                                <option value="Tanzânia">Tanzânia</option>
                                <option value="Togo">Togo</option>
                                <option value="Trinidad &#038; Tobago">Trinidad E Tobago</option>
                                <option value="Tunísia">Tunísia</option>
                                <option value="Turquia">Turquia</option>
                                <option value="Ucrânia">Ucrânia</option>
                                <option value="Uganda">Uganda</option>
                                <option value="Uruguai">Uruguai</option>
                                <option value="Venezuela">Venezuela</option>
                                <option value="Vietnã">Vietnã</option>
                                <option value="Zaire">Zaire</option>
                                <option value="Zâmbia">Zâmbia</option>
                                <option value="Zimbábue">Zimbábue</option>
                                <option value="<%out.print(request.getAttribute("nationality"));%>" selected>
								<%out.print(request.getAttribute("nationality"));%>
								</option>

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

                            <input type="text" id="cpf" name="cpf" onchange="formatarCpf()" maxlength="11" size='11'
                                placeholder="CPF" value="<%out.print(request.getAttribute("cpf"));%>" required>

                        </td>

                        <td>
                            <div id="msgCpf" class="AlertMsgs">
                                *
                            </div>
                        </td>

                    </tr>                  

                </table>


                <section class="SectionButtons">

                    <section id="msgStatus" class="AlertMsgs">

                    </section>


                    <button type="reset" class="Buttons">

                        <img class="ImagesButtonsRegister" src="images/icons/LIMPAR.png" alt="">

                    </button>

                    <button type="submit" id="submitButton" class="Buttons" onclick="validar('formRegisterArtist')">

                        <img class="ImagesButtonsRegister" src="images/icons/save01.png" alt="">

                    </button>

                </section>

            </fieldset>

        </form>

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

    <script src="js/validator.js">

    </script>

</html>

