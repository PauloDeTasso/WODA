
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

function openPage(link, target)
{
    window.open(link, target);
};

function detectar_mobile()
{
    if (navigator.userAgent.match(/Android/i)
        || navigator.userAgent.match(/webOS/i)
        || navigator.userAgent.match(/iPhone/i)
        || navigator.userAgent.match(/iPad/i)
        || navigator.userAgent.match(/iPod/i)
        || navigator.userAgent.match(/BlackBerry/i)
        || navigator.userAgent.match(/Windows Phone/i)
    )
    {
        return true;
    }
    else
    {
        return false;
    }
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

    var msgName = document.getElementById("msgName");
    var msgEmail = document.getElementById("msgEmail");
    var msgGender = document.getElementById("msgGender");
    var msgBirthday = document.getElementById("msgBirthday");
    var msgNationality = document.getElementById("msgNationality");
    var selectNationality = document.getElementById("selectNationality");
    var cpf = document.getElementById("cpf");
    var msgCpf = document.getElementById("msgCpf");
    var msgStatus = document.getElementById("msgStatus");
    var fileInputArtist = document.getElementById("fileInputArtist");
    var listArtist = document.getElementById("listArtist");
    var sectionCpf = document.getElementById("sectionCpf");
    var cpfOriginal;
    var valueGenderJs = document.getElementById("valueGenderJs");
    var valueNationalityJs = document.getElementById("valueNationalityJs");    


    var msgName = document.getElementById("msgName");
    var msgEmail = document.getElementById("msgEmail");
    var msgGender = document.getElementById("msgGender");
    var msgBirthday = document.getElementById("msgBirthday");
    var msgNationality = document.getElementById("msgNationality");
    var selectNationality = document.getElementById("selectNationality");
    var cpfInput = document.getElementById("cpf");
   
    var publicationDate = document.getElementById("publicationDate");
    var exposureDate = document.getElementById("exposureDate");
    var associatesOn = document.getElementById("associatesOn");
    var associatesOff = document.getElementById("associatesOff");    
    var dateTypeInput = document.getElementById("dateTypeInput");

function validacaoEmail(campo, email)
{	
	var listEmailArtists = document.getElementsByName('listEmailArtists');
	
    usuario = campo.value.substring(0, campo.value.indexOf("@"));
    dominio = campo.value.substring(campo.value.indexOf("@") + 1, campo.value.length);

    if ((usuario.length >= 1) &&
        (dominio.length >= 3) &&
        (usuario.search("@") == -1) &&
        (dominio.search("@") == -1) &&
        (usuario.search(" ") == -1) &&
        (dominio.search(" ") == -1) &&
        (dominio.search(".") != -1) &&
        (dominio.indexOf(".") >= 1) &&
        (dominio.lastIndexOf(".") < dominio.length - 1))
    {
		msgEmail.innerHTML = "<font color= 'green'>Ok</font>";
		emailValidate = true;
	
		for(i=0; i<listEmailArtists.length; i++)
		{
			if(listEmailArtists[i].value == email)
			{
				alert("Email existing in the database!");
				msgEmail.innerHTML = "Email existing in the database!";
				emailValidate = false;
			}
		}
				
	}else
    {    	
        msgEmail.innerHTML = "Invalid email!";
        emailValidate = false;
    }
}

////


function validateDate(campo, msgAlert)
{
	var date = document.getElementById(campo).value;

	var ano = parseInt(date.slice(0, 4));

	var mes = date.slice(5, 7);

	var dia = parseInt(date.slice(8, 10));

	var diaValidate;

	var mesValidate;

	var anoValidate;
		
	date = date.replace(/\//g, "-");

    var date_array = date.split("-");

    if (date_array[ 0 ].length != 4)
    {
        date = date_array[ 2 ] + "-" + date_array[ 1 ] + "-" + date_array[ 0 ];
    }

    var hoje = new Date();

    var nasc = new Date(date);

    var idade = hoje.getFullYear() - nasc.getFullYear();

    var m = hoje.getMonth() - nasc.getMonth();

    if (m < 0 || (m === 0 && hoje.getDate() < nasc.getDate())) idade--;

    if (idade < 0)
    {
        msgAlert.innerHTML = "Invalid date!";
        ageValidate = false;
    } else
    {
        msgAlert.innerHTML = "<font color= 'green'>Ok</font>";
        ageValidate = true;
    }
		
	switch(mes)
	{
    	case "01": case "03": case "05": case "07": case "08": case "10": case "12":
     
     		if(dia <= 31 && dia > 0)
     		{
     			msgAlert.innerHTML = "Valid day!";
     			diaValidate = true;
     		}else
     		{ 
	 			msgAlert.innerHTML = "Invalid day!";
	 			diaValidate = false;
     		}
      
     	 	mesValidate = true;
     	     	
    		break ;
     
     	case "04": case "06": case "09": case "11":
     
     		if(dia <= 30 && dia > 0)
       		{
       			msgAlert.innerHTML = "Valid day!";
       			diaValidate = true;
       	
      		}else
       		{
       			msgAlert.innerHTML = "Invalid day!";
       			diaValidate = false;
      		}
      	
      		mesValidate = true;
      		      	
     	break ;
     
     	case "02":
      
      		if((ano%400 == 0) || (ano%4==0 && ano%100!=0))
       		{
       			if( dia <= 29 && dia > 0)
        		{
        			msgAlert.innerHTML = "Valid day!";        			
        		
       			}else
        		{
        			msgAlert.innerHTML = "Invalid day!";        			
      			}
      
      		}else       
			{      
	 			if( dia <= 28 && dia > 0)
     			{
	   				msgAlert.innerHTML = "Valid day!";
	   				diaValidate = true;
      		
      			}else
      			{
        			msgAlert.innerHTML = "Invalid day!";
        			diaValidate = false;        		
    			}   			
    		}
    
   	 		mesValidate = true;	
    	    	
    	break;
    
    	default:
        
        	mesValidate = false;
        	anoValidate = false;
        	msgAlert.innerHTML = "Invalid date!";       
	} 
			
	var date2 = new Date();
	var year = date2.getFullYear();
	
	if(ano <= year)
	{
		anoValidate = true;
	}else
	{
		anoValidate = false;
	}
				
	if(diaValidate && mesValidate && anoValidate && ageValidate)
	{
		birthdayValidate = true;
		msgAlert.innerHTML = "<font color= 'green'>Ok</font>";
	}else
	{
		birthdayValidate = false;
		msgAlert.innerHTML = "Invalid date!";
	}
}

/////

function TestaCPF(strCPF)
{
    var Soma;
    var Resto;
    Soma = 0;
    
    if (strCPF == 00000000000) return false;
    
    if (strCPF == null) return false;

    for (i = 1; i <= 9; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10))) return false;

    Soma = 0;
    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11))) return false;
    return true;
}

//

function formatarCpf(cpf)
{		
	var listCpfArtists = document.getElementsByName('listCpfArtists');
	
	if(cpf == "null" || cpf == null || cpf == undefined || cpf == "")
	{
		cpf = "00000000000";
		cpfOriginal = cpf;
		
	}else
	{
		if(TestaCPF(cpf))
		{
   			cpfOriginal = cpf;
    
    		cpfInput.value = cpf.match(/.{1,3}/g).join(".").replace(/\.(?=[^.]*$)/, "-");    
				
			if(TestaCPF(cpfOriginal))
			{
				msgCpf.innerHTML = "<font color= 'green'>Ok</font>" 
				cpfValidate	= true;	
			}else
			{
				msgCpf.innerHTML = "Invalid CPF";
				cpfValidate	= false;	
			}			
				
			for(i=0; i<listCpfArtists.length; i++)
			{
				if(listCpfArtists[i].value == cpfOriginal)
				{
					alert("Cpf existing in the database!");
					msgCpf.innerHTML = "Cpf existing in the database!";		
					cpfValidate	= false;	
				}
			}
				
		}else
		{
		msgCpf.innerHTML = "Invalid CPF";
		cpfValidate	= false;
		}
	}
}

////

function verificarNacionalidade(valor)
{
    if (valor == "nationality" || valor == "" || valor == null || valor == "null")
    {
        msgNationality.innerHTML = "Inform your nationality!";
        nationalityValidate = false;
    } else
    {
        msgNationality.innerHTML = "<font color= 'green'>Ok</font>";
        nationalityValidate = true;
    }

  statusCpf();
}

//

function verificarGenero(valor)
{
    if (valor == "gender" || valor == null)
    {
        msgGender.innerHTML = "Inform your gender!";
         genderValidate = false;
    } else
    {
        msgGender.innerHTML = "<font color= 'green'>Ok</font>";
        genderValidate = true;
    }
}

//

function verificarNome(valor)
{
    if (valor == "" || valor == null)
    {
        msgName.innerHTML = "Inform your name!";
        nameValidate = false;
    } else
    {
        msgName.innerHTML = "<font color= 'green'>Ok</font>";
        nameValidate = true;
    }
}

function descriptionValidate(value)
{
    if (value != null || value != "" || value != undefined)
    {
        msgDescription.innerHTML = "<font color= 'green'>Ok</font>";
    } else 
    {
        msgDescription.innerHTML = "Enter a description!";
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
        //

        listArtist.innerHTML = "";
        listArtist.style.backgroundColor = "rgba(0, 0, 0, 0)";
        listArtist.style.backgroundColor = "rgb(255, 192, 120)";  
}

//
   
formRegisterArtist.onreset = function ()
{
	clear()
};

function validar(form)
{
    /*
    var nome = form.name.value;
	
    var email = form.email.value;
	
    var genero = form.gender.value;
    	
    var dataDeNascimento = form.birthday.value;
    	
    var nacionalidade = form.nationality.value;
    	
    var cpf = form.cpf.value;
	
    if(nome === "")
    {
        alert("Preencha o campo Nome");
    	
        frmContato.nome.focus();
        return false;
    	
    }else if (email === "")
    {
        alert("Preencha o campo E-mail");
    	
        frmContato.nome.focus();
        return false;
    	
    }else if (genero === "")
    {
        alert("Preencha o campo Gênero");
    	
        frmContato.nome.focus();
        return false;
    	
    }else if (dataDeNascimento === "")
    {
        alert("Preencha o campo Data de Nascimento");
    	
        frmContato.nome.focus();
        return false;
    	
    }else if (nacionalidade === "")
    {
        alert("Preencha o campo Nacionalidade");
    	
        frmContato.nome.focus();
        return false;
    	
    }else if (cpf === "")
    {
        alert("Preencha o campo CPF");
    	
        frmContato.nome.focus();
        return false;
    	
    }else
    {
        document.forms["formArtistRegister"].submit();
    }	
    */

    //document.forms["form"].submit();

    //alert(document.forms["form"].submit())
    	
    if (selectNationality.value == "Brasil")
    {
   	   if(TestaCPF(cpfOriginal))
		{
			cpf.value = cpfOriginal;    
    	}    
    }
    
    document.forms[ form ].submit();
}

function statusCpf()
{
	if (selectNationality.value == "Brasil")
    {
       sectionCpf.style.visibility = "visible";
   	   cpf.style.visibility = "visible";   	   
    } else 
    {		   
       cpf.style.visibility = "hidden";  
       sectionCpf.style.visibility = "hidden";  
    }
}


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

var selectGender = document.querySelector("#selectGender");

var optionsGender = [...selectGender.options];

var selectNationality = document.querySelector("#selectNationality");

var optionsNationality = [...selectNationality.options];

function selectSelects()
{
	for (var i = 0; i < optionsGender.length; i++)
	{
		if(valueGenderJs.value == optionsGender[i].value)
		{
			optionsGender[i].selected = true;
		}
	}
	
	for (var i = 0; i < optionsNationality.length; i++)
	{
		if(valueNationalityJs.value == optionsNationality[i].value)
		{
			optionsNationality[i].selected = true;
		}
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

setTimeout(() =>
{	
    selectSelects();
    
}, 2000);

 selectSelects();

setTimeout(() =>
{	
    statusCpf();
}, 2000);

statusCpf();
