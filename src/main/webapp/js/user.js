
var botaoLogin = document.getElementById('body');

var html = document.getElementsByTagName('html');

var header = document.getElementsByTagName('header');

var sectionMenu = document.getElementById('sectionMenu');

var sectionButtons = document.getElementById('sectionButtons');

var seacher = document.getElementById('seacher');

var saveStatusOn = document.getElementById('saveStatusOn');

var saveStatusOff = document.getElementById('saveStatusOff');

var mySearchArtists = document.getElementById('mySearchArtists');

var mySearchArts = document.getElementById('mySearchArts');

var searchButton = document.getElementById('searchButton');

var ImagesArtist = document.getElementsByClassName('ImagesArtist');

var nameValidate, emailValidate, genderValidate, birthdayValidate, nationalityValidate, cpfValidate;

var sectionUserEdit = document.getElementById('sectionUserEdit');

var sectionTableSeacher = document.getElementById('sectionTableSeacher');

var sectionCloseUserEdit = document.getElementById('sectionCloseUserEdit');

var imgViewPassword = document.getElementById('imgViewPassword');

var passwordInput = document.getElementById('passwordInput');

/////////

var selectNationality = document.querySelector("#selectNationality");



 
var botaoLogin = document.getElementById('body');

var html = document.getElementsByTagName('html');

var header = document.getElementsByTagName('header');

var sectionMenu = document.getElementById('sectionMenu');

var sectionButtons = document.getElementById('sectionButtons');

var seacher = document.getElementById('seacher');

var saveStatusOn = document.getElementById('saveStatusOn');

var saveStatusOff = document.getElementById('saveStatusOff');

var mySearchArtists = document.getElementById('mySearchArtists');

var mySearchArts = document.getElementById('mySearchArts');

var searchButton = document.getElementById('searchButton');

var ImagesArtist = document.getElementsByClassName('ImagesArtist');

//////////////

var formRegisterArtist = document.getElementById("formRegisterArtist");

var dateType;

    var msgStatus = document.getElementById("msgStatus");
    var fileInputArtist = document.getElementById("fileInputArtist");
    var sectionCpf = document.getElementById("sectionCpf");
    var cpfOriginal;
    var valueGenderJs = document.getElementById("valueGenderJs");
    var valueNationalityJs = document.getElementById("valueNationalityJs");    


    var msgName = document.getElementById("msgName");
    var msgEmail = document.getElementById("msgEmail");
    var msgGender = document.getElementById("msgGender");
    var msgBirthday = document.getElementById("msgBirthday");
    var msgNationality = document.getElementById("msgNationality");
    var msgCpf = document.getElementById("msgCpf");
    var cpfInput = document.getElementById("cpf");
   
    var publicationDate = document.getElementById("publicationDate");
    var exposureDate = document.getElementById("exposureDate");
    var associatesOn = document.getElementById("associatesOn");
    var associatesOff = document.getElementById("associatesOff");    
    var dateTypeInput = document.getElementById("dateTypeInput");



function openPage(link, target)
{
    window.open(link, target);
};


function openCloseSection(elemento, propriedade, action)
{
    switch (propriedade)
    {
        case "display":

		if(action)
		{
        	elemento.style.display = "flex";
		
		}else
		{
			elemento.style.display = "none";
		}
        
        case "visibility":

		if(action)
		{
            elemento.style.visibility = "visible";
            
		}else
		{
	 
	 		elemento.style.visibility = "hidden";
		}
            break;

        default:
    }
}

////

function openClose(elemento, propriedade)
{
    var estiloCabecalho = window.getComputedStyle(elemento);
    var propriedadeCabecalho = estiloCabecalho.getPropertyValue(propriedade);

    switch (propriedade)
    {
        case "display":

            if (propriedadeCabecalho == "none")
            {
                elemento.style.display = "flex";

            } else 
            {
                elemento.style.display = "none";
            }

            break;

        case "visibility":

            if (propriedadeCabecalho == "hidden")
            {
                elemento.style.visibility = "visible";

            } else 
            {
                elemento.style.visibility = "hidden";
            }

            break;

        default:

    }
}

//

function verificarNome(valor)
{
    if (valor == "" || valor == null)
    {
        msgName.innerHTML = "Inform artist name!";
        nameValidate = false;
    } else
    {
        msgName.innerHTML = "<font color= 'green'>Ok</font>";
        nameValidate = true;
    }
}

//

function verificarGenero(valor)
{
    if (valor == "gender" || valor == null)
    {
        msgGender.innerHTML = "Inform artist gender!";
        genderValidate = false;
    } else if(valor == "MALE" || valor == "FEMALE" || valor == "OTHER")
    {
        msgGender.innerHTML = "<font color= 'green'>Ok</font>";
        genderValidate = true;
    }else
    {
		msgGender.innerHTML = "Gender Invalid!";
        genderValidate = false;
	}
}

//

function clear()
{
        msgName.innerHTML = "*";
        msgEmail.innerHTML = "";
        msgGender.innerHTML = "";
        msgBirthday.innerHTML = "*";
        msgNationality.innerHTML = "*";
        msgImage.innerHTML = "";
        msgCpf.innerHTML = "*";
        msgStatus.innerHTML = ""; 
}

//
   
formRegisterArtist.onreset = function ()
{
	clear()
};

function formValidate(form)
{    	          
	
	if (selectNationality.value != "Brasil")
  	{
		cpfValidate	= true;
	}
		switch(nameValidate)
		{
			case true:
			
			msgName.innerHTML = "<font color= 'green'>Ok</font>";
			
			break;
			
			case false:
			
			msgName.innerHTML = "Inform artist name!";
			
			break;
			
			default:
			
			msgName.innerHTML = "Name invalid!";
		}
		
		//
		
		switch(emailValidate)
		{
			case true:
			
			msgEmail.innerHTML = "<font color= 'green'>Ok</font>";
			
			break;
			
			case false:
			
			msgEmail.innerHTML = "E-mail invalid!";
			
			break;
			
			default:
			
			msgEmail.innerHTML = "E-mail invalid!";
		}
		
		//
		
		switch(genderValidate)
		{
			case true:
			
			msgGender.innerHTML = "<font color= 'green'>Ok</font>";
			
			break;
			
			case false:
			
			msgGender.innerHTML = "Inform artist gender!";
			
			break;
			
			default:
			
			msgGender.innerHTML = "Gender invalid!";
		}	
	
	
	if(nameValidate && emailValidate && genderValidate)
	{
		if (selectNationality.value == "Brasil")
  		{
   	   		if(TestaCPF(cpfOriginal))
			{
				cpfInput.value = cpfOriginal;  	
    			document.forms[ form ].submit();
    		}else
    		{
				msgCpf.innerHTML = "CPF invalid!!!";
			}    
			
    	}else
    	{
			cpfInput.value = cpfOriginal;   	
    		document.forms[ form ].submit();
		}
		
	}else
	{
		alert("CHECK ALL INVALID INFORMATION!")	
	}  
}

//

function openCloseOption(elemento, propriedade)
{
    var estiloCabecalho = window.getComputedStyle(elemento);
    var propriedadeCabecalho = estiloCabecalho.getPropertyValue(propriedade);

            if (propriedadeCabecalho == "none")
            {
                elemento.style.display = "grid";

            } else 
            {
                elemento.style.display = "none";
            }
}

//

 var optionAction;
  
 function abrirOptions()
{	
	if (optionAction == undefined ||optionAction == "undefined" || optionAction == true)
	{		
		sectionButtons.classList.toggle('abrirMenu');
				
    	//sectionButtons.classList.remove('abrirMenu');
    	//sectionButtons.classList.add('abrirMenu');
    	optionAction = false;
    	
    	//sectionButtons.style.animation = "none";
    	
    	setTimeout(function ()
    	{
        sectionButtons.style.animation = "";
    	}, 1000);
    	
    }else
    {
	    sectionButtons.classList.toggle('fecharMenu');		
		
    	//sectionButtons.classList.remove('fecharMenu');
    	//sectionButtons.classList.add('fecharMenu');
    	    	
    	optionAction = true;
    	
    	//sectionButtons.style.animation = "none";
    	
    	setTimeout(function ()
    	{
        sectionButtons.style.animation = "";
    	}, 1000);
    	
	}	
}

//

function showPassword()
{
	if(passwordInput.type == "password")
	{
		passwordInput.type = "text";	
		imgViewPassword.src = "images/icons/ver01.png";
		
	}else
	{
		passwordInput.type = "password";	
		imgViewPassword.src = "images/icons/esconder01.png";	
	}

}

//

function removeUser(id,login,password)
{	
		var resposta = confirm("Delete user " + "(" + login + ")?");

	    if (resposta === true)
    	{      		
        	window.location.href = "userremove?userid=" + id + "&userlogin=" + login + "&userpassword=" + password;
		}
}

//

function exit()
{
	var exitResponse = confirm("Exit application?");

	    if (exitResponse === true)
    	{
        	//TESTE DE RECEBIMENTO:
        	//alert(idcon);

        	//ENCAMINHANDO A REQUISIÇÃO PARA O SERVET USANDO JAVASCRIPT JUNTO COM O PARAMETRO 'IDCON'

        	window.location.href = "index.html";
    	}
}