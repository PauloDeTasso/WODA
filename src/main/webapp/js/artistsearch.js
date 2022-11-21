
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

//SE SALVE ESTADO FOR TRUE ENTAO:

if (localStorage.getItem("statusSaveConfig") == "true")
{
    if (localStorage.getItem('menuMain') == "true")
    {
        sectionButtons.style.visibility = "visible";

    } else if (localStorage.getItem('menuMain') == "false")
    {
        sectionButtons.style.visibility = "hidden";

    } else
    {
        sectionButtons.style.visibility = "hidden";
    }

    //

    if (localStorage.getItem('menuSeacher') == "true")
    {
        seacher.style.display = "flex";

    } else if (localStorage.getItem('menuSeacher') == "false")
    {
        seacher.style.display = "none";

    } else
    {
        seacher.style.display = "none";
    }

    saveStatusOn.checked = true;
    saveStatusOff.checked = false;

} else if (localStorage.getItem("statusSaveConfig") == "false")
{
    saveStatusOn.checked = false;
    saveStatusOff.checked = true;

} else
{
    saveStatusOn.checked = true;
    saveStatusOff.checked = false;
}

//

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

                localStorage.setItem(conteiner, true);

            } else 
            {
                elemento.style.display = "none";

                localStorage.setItem(conteiner, false);
            }

            break;

        case "visibility":

            if (propriedadeCabecalho == "hidden")
            {
                elemento.style.visibility = "visible";

                localStorage.setItem(conteiner, true);

            } else 
            {
                elemento.style.visibility = "hidden";

                localStorage.setItem(conteiner, false);
            }

            break;

        default:

    }
}

function saveConfig(option, status)
{
    switch (option)
    {
        case "statusSaveConfig":

            if (status == true)
            {
                localStorage.setItem("statusSaveConfig", true);

            } else if (status == false)
            {
                localStorage.setItem("statusSaveConfig", false);

            } else
            {
                localStorage.setItem("statusSaveConfig", false);
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

