var botaoLogin = document.getElementById('body');

var imagemFacebook = document.getElementById('imagemFacebook');

var imagemSkype = document.getElementById('imagemSkype');

var imagemTwitter = document.getElementById('imagemTwitter');

var imagemInstagram = document.getElementById('imagemInstagram');

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

function iconeOpacidade(icone)
{
    icone.style.opacity = "1";
    icone.style.backgroundColor = "rgba(200,200,200,.5)";
}

function iconeOpacidadeMenor(icone)
{
    icone.style.opacity = ".5";
    icone.style.backgroundColor = "rgba(200,200,200,0)";
}

//

function validar(valor)
 {	    
	document.forms["formRegister"].submit();
}