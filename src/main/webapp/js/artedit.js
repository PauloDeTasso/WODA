
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

var passwordInput = document.getElementsByClassName('passwordInput');

var nameValidate;
 
var nameValidate, descriptionValidate, dateValidate;
 
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

var formRegisterArt = document.getElementById("formRegisterArt");

var dateType;

var msgName = document.getElementById("msgName");
var msgDescription = document.getElementById("msgDescription");
var msgPublicationDate = document.getElementById("msgPublicationDate");
var msgExposureDate = document.getElementById("msgExposureDate");
var msgImage = document.getElementById("msgImage");
var msgStatus = document.getElementById("msgStatus");
var filesInputArts = document.getElementById("filesInputArts");
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

function validateName(valor)
{
    if (valor == "" || valor == null)
    {
        msgName.innerHTML = "Inform art name!";
        nameValidate = false;
    } else
    {
        msgName.innerHTML = "<font color= 'green'>Ok</font>";
        nameValidate = true;
    }
}

//

function validateDescription(value)
{
    if (value == null || value == "" || value == undefined)
    {        
        msgDescription.innerHTML = "Enter art description!";
        descriptionValidate = false;
    } else 
    {
		msgDescription.innerHTML = "<font color= 'green'>Ok</font>";
        descriptionValidate = true;
    }
}

//

var datetype;

function validateDate(campo, msgAlert)
{
	datetype = campo;
	
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
		dateValidate = true;
		msgAlert.innerHTML = "<font color= 'green'>Ok</font>";
	}else
	{
		dateValidate = false;
		msgAlert.innerHTML = "Invalid date!";
	}
	
	//
	
	if (campo == "publicationDate")
    {		
		if (publicationDate.value)
    	{  	  			
 			 exposureDate.style.visibility = "hidden";
 			 msgExposureDate.style.visibility = "hidden"
 	  		 dateTypeInput.value = campo;
 	  		 
  		} else
  		{   
    		exposureDate.style.visibility = "visible";
    		msgExposureDate.style.visibility = "visible";
    		dateTypeInput.value = "null";
    	}    

    } else if (campo == "exposureDate")
    {               
        if (exposureDate.value)
    	{  			
  			publicationDate.style.visibility = "hidden";
  			msgPublicationDate.style.visibility = "hidden";
  			dateTypeInput.value = campo;
  	
  		} else
  		{ 
 			publicationDate.style.visibility = "visible";
 			msgPublicationDate.style.visibility = "visible";
 			dateTypeInput.value = "null";
 		} 
 		
    } else
    {
        //
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
}

//

formRegisterArt.onreset = function ()
{
    clear();
};

//

function formValidate(form)
{  	
		switch(nameValidate)
		{
			case true:
			
			msgName.innerHTML = "<font color= 'green'>Ok</font>";
			
			break;
			
			case false:
			
			msgName.innerHTML = "Inform art name!";
			
			break;
			
			default:
			
			msgName.innerHTML = "Name invalid!";
		}
		
		//
		
		switch(descriptionValidate)
		{
			case true:
			
			msgDescription.innerHTML = "<font color= 'green'>Ok</font>";
			
			break;
			
			case false:
			
			msgDescription.innerHTML = "Description invalid!";
			
			break;
			
			default:
			
			msgDescription.innerHTML = "Description invalid!";
		}
		
		//
		
		if(datetype == "exposureDate")
		{
			switch(dateValidate)
			{
				case true:
			
					msgExposureDate.innerHTML = "<font color= 'green'>Ok</font>";
			
				break;
			
				case false:
			
					msgExposureDate.innerHTML = "Inform art exposure date!";
			
				break;
			
				default:
			
					msgExposureDate.innerHTML = "Date invalid!";
			}
					
		}else if(datetype == "publicationDate")
		{
			switch(dateValidate)
			{
				case true:
			
					msgPublicationDate.innerHTML = "<font color= 'green'>Ok</font>";
			
				break;
			
				case false:
			
					msgPublicationDate.innerHTML = "Inform art publication date!";
			
				break;
			
				default:
			
					msgPublicationDate.innerHTML = "Date invalid!";
			}			
		}else
		{
			msgPublicationDate.innerHTML = "Inform art publication date!";
			msgExposureDate.innerHTML = "Inform art exposure date!";
		}	
	
	if(nameValidate && descriptionValidate && dateValidate)
	{  							
    	document.forms[ form ].submit();   
    		
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

function selectSelects()
{			
	validateName(nameInputEdit.value);
	validateDescription(descriptionInputEdit.value);		
		
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
}

//

setTimeout(() =>
{	
    selectSelects();
    
}, 1000);

 selectSelects(); 