
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
	/*
	if(link == "index.html")
	{
		var confirmarSair = confirm("CONFIRM QUIT?");
		
		if(confirmarSair)
		{
			window.open(link, target);
		}
					
	}esle
	{
    	this.open(link, target);
    }*/
    
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

function zoom(image, zoom)
{
    var estiloCabecalho = window.getComputedStyle(image);
    var propriedadeCabecalho = estiloCabecalho.getPropertyValue(width);

    if (zoom == "in")
    {
        for (let i = 0; i < image.length; i++)
        {
            image[ i ].style.width = '100%';
        }

    } else if (zoom == "out")
    {
        for (let i = 0; i < image.length; i++)
        {
            image[ i ].style.width = '10%';
        }

    } else
    {
        for (let i = 0; i < image.length; i++)
        {
            image[ i ].style.width = propriedadeCabecalho;
        }
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

function InserirImagem(url)
 {
        let img = document.createElement("img");
        img.src=url;
        document.body.appendChild(img);
    }

/////CRIAR LINK PARA O BLOB:

/*
<a download="hello.txt" href='#' id="link">Download</a>

let blob = new Blob(["Hello, world!"], {type: 'text/plain'});

link.href = URL.createObjectURL(blob);
*/

/////////////////////////////////////////////////////
////Aqui está o código semelhante que faz com que o usuário
// baixe o arquivo dinamicamente criado Blob, sem nenhum HTML:

/*
let link = document.createElement('a');

link.download = 'hello.txt';

let blob = new Blob(['Hello, world!'], {type: 'text/plain'});

link.href = URL.createObjectURL(blob);

link.click();

URL.revokeObjectURL(link.href);
*/

/////////////////////////////////
////TRANSFORMAR BLOB EM BASE64:

/*

let link = document.createElement('a');

link.download = 'hello.txt';

let blob = new Blob(['Hello, world!'], {type: 'text/plain'});

let reader = new FileReader();
*/

 // converts the blob to base64 and calls onload
//reader.readAsDataURL(blob);
/*
reader.onload = function() 
{
 data url
  //link.href = reader.result; 
  //link.click();
};
*/

///////////////////
//URL DE UMA DATA BASE64:
//<img src="data:image/png;base64,R0lGODlhDAAMAKIFAF5LAP/zxAAAANyuAP/gaP///wAAAAAAACH5BAEAAAUALAAAAAAMAAwAAAMlWLPcGjDKFYi9lxKBOaGcF35DhWHamZUW0K4mAbiwWtuf0uxFAgA7">


////////////////////
//USANDO BASE64 EM IMAGEM

/*	
	var image = document.createElement('image');
    image.src = 'data:image/bmp;base64,'+Base64.encode(blob);
    document.body.appendChild(image);
    
*/

//


mySearchArts.addEventListener("search",()=>
{
	submitSearcher(mySearchArts.value,"arts");
},false);

//

mySearchArtists.addEventListener("search",()=>
{
	submitSearcher(mySearchArtists.value,"artists");
},false);

//


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


var selectGender = document.querySelector("#selectGender");

var optionsGender = [...selectGender.options];

var selectNationality = document.querySelector("#selectNationality");

var optionsNationality = [...selectNationality.options];

//

/*

<option value="<%out.print(request.getAttribute("nationality"));%>" selected>
								<%out.print(request.getAttribute("nationality"));%>
								</option>

*/

function selectSelects()
{
	for (var i = 0; i < optionsGender.length; i++)
	{
		if(valueGenderJs.value == optionsGender[i].value)
		{
			optionsGender[i].selected = true;
		}
	}
	
	for (var i = 0; i < optionsNationality.length; i++)
	{
		if(valueNationalityJs.value == optionsNationality[i].value)
		{
			optionsNationality[i].selected = true;
		}
	}
}

 
setTimeout(() =>
{	
    selectSelects();
    
}, 5000);

 selectSelects();

