
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

var searchOption = document.getElementsByName('searchoption');

/////////

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

function confirmar(id,type)
{
	if(type == "artist")
	{		
    	var resposta = confirm("Delete this artist?");

	    if (resposta === true)
    	{
        	//TESTE DE RECEBIMENTO:
        	//alert(idcon);

        	//ENCAMINHANDO A REQUISIÇÃO PARA O SERVET USANDO JAVASCRIPT JUNTO COM O PARAMETRO 'IDCON'

        	window.location.href = "deleteartist?idartist=" + id;
    	}
    }else if(type == "art")
    {
		var resposta = confirm("Delete this art?");

	    if (resposta === true)
    	{
        	//TESTE DE RECEBIMENTO:
        	//alert(idcon);

        	//ENCAMINHANDO A REQUISIÇÃO PARA O SERVET USANDO JAVASCRIPT JUNTO COM O PARAMETRO 'IDCON'

        	window.location.href = "deleteart?idart=" + id;
		}
	}else
	{
		alert("Error! Could not delete!");
	}
}


mySearchArtists.addEventListener("search",()=>
{
	submitSearcher(mySearchArtists.value,"artists");
},false);

//

function submitSearcher(value,type)
{		
	switch(type)
	{
		case 'artists':
		/*
		if(value == null || value == undefined ||value == "" || value == " ")
		{
		
		}else
		{
			*/
	 	window.location.href = "searchartist?text=" + value;
		//}
		
		break;
		
		case 'arts':
		/*
		if(value == null || value == undefined ||value == "" || value == " ")
		{
		
		}else
		{*/
	 	for (let i = 0; i < searchOption.length; i++)
            {
                if (searchOption[ i ].checked)
                {
                    window.location.href = "searcharts?text=" + value + "&option=" + searchOption[ i ].value;
                }
            }
		//}
		
		break;
		
		default:		
	}	
};

function changeButton(button)
{
	var estiloCabecalho = window.getComputedStyle(button);
    var propriedadeCabecalho = estiloCabecalho.getPropertyValue('opacity');
    
    
	if(propriedadeCabecalho == 1)
	{
		button.style.opacity = "0.8";
	}else
	{
		button.style.opacity = "1";
	}
}

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