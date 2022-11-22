
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

var nameValidate;

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

//

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
