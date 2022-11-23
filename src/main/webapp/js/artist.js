var botaoLogin = document.getElementById('body');

var html = document.getElementsByTagName('html');

var header = document.getElementsByTagName('header');

var sectionMenu = document.getElementById('sectionMenu');

var sectionButtons = document.getElementById('sectionButtons');

var seacher = document.getElementById('seacher');

var saveStatusOn = document.getElementById('saveStatusOn');

var saveStatusOff = document.getElementById('saveStatusOff');

//var ImagesArtist = document.getElementsByClassName('ImagesArtist');

var imageArtist = document.getElementById('imageArtist');

var ArtsArtist = document.getElementsByClassName('ArtsArtist');

var artArtist = document.getElementById('artArtist');

var sectionImageArtist = document.getElementById('sectionImageArtist');

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

    }}

function removeConfirm(idArtist,idArt,nameArtist,nameArt)
{	
		var resposta = confirm("Disassociating art " + "(" + nameArt + ") from (" + nameArtist + ") ?");

	    if (resposta === true)
    	{      		
        	window.location.href = "removeassociate?idartist=" + idArtist + "&idart=" + idArt;
		}

}

function removeArtConfirm(idArt,nameArt)
{	
		var resposta = confirm("Delete art " + "(" + nameArt + ") from all artists?");

	    if (resposta === true)
    	{      		
        	window.location.href = "deleteart?idart=" + idArt;
		}
}