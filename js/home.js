var botaoLogin = document.getElementById('body');

var secaoMenu = document.getElementById('secaoMenu');

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

function abrirPagina(link, target)
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

function abrirMenu()
{
    //secaoMenu.style.visible = "visible";
}