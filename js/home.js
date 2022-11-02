var botaoLogin = document.getElementById('body');

var html = document.getElementsByTagName('html');

var header = document.getElementsByTagName('header');

var sectionMenu = document.getElementById('sectionMenu');

var sectionButtons = document.getElementById('sectionButtons');

/////////

function alterarImagem(pagina)
{
    if (pagina == "")
    {

    } else if (pagina == "")
    {

    } else
    {

    }
};

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

if (detectar_mobile())
{

} else
{

};

////

function openMenu()
{
    var estiloCabecalho = window.getComputedStyle(sectionButtons);
    var propriedadeCabecalho = estiloCabecalho.getPropertyValue('visibility');

    if (propriedadeCabecalho == "hidden")
    {
        sectionButtons.style.visibility = "visible";
    } else 
    {
        sectionButtons.style.visibility = "hidden";
    }
}
