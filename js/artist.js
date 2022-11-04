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

/////////

function openPagina(link, target)
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

function zoom(image, zoom)
{
    var imageArtistWidth = image.clientWidth;

    if (zoom == "in")
    {
        image.style.width = (imageArtistWidth + 100) + "px";

    } else if (zoom == "out")
    {
        image.style.width = (imageArtistWidth - 100) + "px";

    } else
    {
        image.style.width = (imageArtistWidth - 100) + "px";
    }

}
