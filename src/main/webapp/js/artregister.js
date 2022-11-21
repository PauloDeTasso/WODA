
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

/////////


 ////////////////////////
 /////////////////////
 ///////////////////////
 
 
 
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
var formRegisterArt = document.getElementById("formRegisterArt");
var dateType;

    var msgName = document.getElementById("msgName");
    var msgDescription = document.getElementById("msgDescription");
    var msgPublicationDate = document.getElementById("msgPublicationDate");
    var msgExposureDate = document.getElementById("msgExposureDate");
    var msgImage = document.getElementById("msgImage");
    var msgStatus = document.getElementById("msgStatus");
    var filesInputArts = document.getElementById("filesInputArts");
    var listArts = document.getElementById("listArts");
    var publicationDate = document.getElementById("publicationDate");
    var exposureDate = document.getElementById("exposureDate");
    var associatesOn = document.getElementById("associatesOn");
    var associatesOff = document.getElementById("associatesOff");    
    var dateTypeInput = document.getElementById("dateTypeInput");
    var dateTypeInput2 = document.getElementById("dateTypeInput2");

////

function openPage(link, target)
{
    window.open(link, target);
};

////

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

function openClose(elemento, propriedade, conteiner)
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


function validateDate(campo, msgAlert)
{
    var data = document.getElementById(campo).value;

    data = data.replace(/\//g, "-");

    var data_array = data.split("-");

    if (data_array[ 0 ].length != 4)
    {
        data = data_array[ 2 ] + "-" + data_array[ 1 ] + "-" + data_array[ 0 ];
    }

    var hoje = new Date();

    var nasc = new Date(data);

    var idade = hoje.getFullYear() - nasc.getFullYear();

    var m = hoje.getMonth() - nasc.getMonth();

    if (m < 0 || (m === 0 && hoje.getDate() < nasc.getDate())) idade--;

    if (idade < 18)
    {
        msgAlert.innerHTML = "Invalid date!";
    } else
    {
        msgAlert.innerHTML = "<font color= 'green'>Ok</font>";
    }

    if (campo == "publicationDate")
    {		
		if (publicationDate.value)
    	{  	  			
 			 exposureDate.style.visibility = "hidden";
 	  		 dateTypeInput.value = campo;
 	  		 
  		} else
  		{   
    		exposureDate.style.visibility = "visible";
    		dateTypeInput.value = "null";
    	}    

    } else if (campo == "exposureDate")
    {               
        if (exposureDate.value)
    	{  			
  			publicationDate.style.visibility = "hidden";
  			dateTypeInput.value = campo;
  	
  		} else
  		{ 
 			publicationDate.style.visibility = "visible";
 			dateTypeInput.value = "null";
 		} 
 		
    } else
    {
        //
    }   
}

function verificarGenero(valor)
{
    if (valor == "gender" || valor == null)
    {
        msgGender.innerHTML = "Inform your gender!";
    } else
    {
        msgGender.innerHTML = "<font color= 'green'>Ok</font>";
    }
}

//

function verificarNome(valor)
{
    if (valor == "" || valor == null)
    {
        msgName.innerHTML = "Inform your name!";
    } else
    {
        msgName.innerHTML = "<font color= 'green'>Ok</font>";
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
        msgName.innerHTML = "";
        msgDescription.innerHTML = "";
        msgPublicationDate.innerHTML = "";
        msgExposureDate.innerHTML = "";
        msgImage.innerHTML = "";
        msgStatus.innerHTML = "";
        exposureDate.type = "text";
        publicationDate.type = "text";
        exposureDate.style.visibility = "visible";
        publicationDate.style.visibility = "visible";
        //

        listArts.innerHTML = "";
        listArts.style.backgroundColor = "rgba(0, 0, 0, 0)";
        listArts.style.backgroundColor = "rgb(255, 192, 120)";    
}

//

    formRegisterArt.onreset = function ()
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
    document.forms[ form ].submit();
}

// 

setTimeout(()=>
{
	dateType = dateTypeInput2.value;

	if(dateType == 'publicationDate')
	{	
		validateDate(dateType, msgPublicationDate);
	
	}else if(dateType == 'exposureDate')
	{	
		validateDate(dateType,msgExposureDate);
	}else
	{
		alert("Choose a date!!")
	}
},2000);
