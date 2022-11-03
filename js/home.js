var botaoLogin = document.getElementById('body');

var html = document.getElementsByTagName('html');

var header = document.getElementsByTagName('header');

var sectionMenu = document.getElementById('sectionMenu');

var sectionButtons = document.getElementById('sectionButtons');

var seacher = document.getElementById('seacher');

var saveStatusOn = document.getElementById('saveStatusOn');

var saveStatusOff = document.getElementById('saveStatusOff');

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