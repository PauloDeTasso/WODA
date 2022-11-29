
var body = document.getElementById('body');

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

var status2 = document.getElementById('status');

/////////

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

//

 var optionAction;
  
 function abrirOptions()
{	
	if (optionAction == undefined ||optionAction == "undefined" || optionAction == true)
	{		
		sectionButtons.classList.toggle('abrirMenu');	
		
    	optionAction = false;
    	
    	
    	//sectionButtons.style.animation = "none";
    	
    	setTimeout(function ()
    	{
        sectionButtons.style.animation = "";
    	}, 1000);
    	
    }else
    {
	    sectionButtons.classList.toggle('fecharMenu');				 	
    	
    	optionAction = true;    	
    	
    	//sectionButtons.style.animation = "none";
    	
    	setTimeout(function ()
    	{
        sectionButtons.style.animation = "";	
    	}, 1000);
    	
	}	
}

/*
		Email.send
		(
		{
        	Host: "smtp.gmail.com",
        	Username: "sender@email_address.com",
        	Password: "Enter your password",
        	To: 'receiver@email_address.com',
        	From: "sender@email_address.com",
        	Subject: "Sending Email using javascript",
        	Body: "Well that was easy!!",
        	Attachments:
        	[
          	{
            	name: "File_Name_with_Extension",
            	path: "Full Path of the file"
          	}
          	]
      	}
      	)
*/

//onclick="openClose(sectionButtons,'visibility','menuMain')"


function abrirFecharPopup()
{
    var estiloPopup = window.getComputedStyle(secaoPopup);
    var estiloPropriedade = estiloPopup.getPropertyValue('display');

    if (estiloPropriedade == "none")    
    {
        secaoPopup.style.display = 'flex';
    } else
    {
        secaoPopup.style.display = 'none';
    }
}

var botaoStatus = document.getElementById('imagemBotaoStatus');

function abrirFecharStatus()
{
    var estiloStatus = window.getComputedStyle(nome);
    var valorEstiloStatus = estiloStatus.getPropertyValue('visibility');

    if (valorEstiloStatus == "hidden")    
    {
        flutuante.style.display = 'flex';
        nome.style.visibility = 'visible';
        botaoStatus.style.opacity = 1;
    } else
    {
        nome.style.visibility = 'hidden';
        flutuante.style.display = 'none';
        botaoStatus.style.opacity = 0.0;
    }
}

function exit()
{
	var exitResponse = confirm("Exit application?");

	    if (exitResponse === true)
    	{
        	window.location.href = "index.html";
    	}
}

//

function loadComplete()
{		
	document.getElementById('imagemButtonMenu').classList.add('opacidade01');			
}	

//

setInterval(()=>
{
	document.getElementById('imagemButtonMenu').classList.remove('opacidade01');
	document.getElementById('imagemButtonMenu').style.opacity = "0.9";		
},4000);

