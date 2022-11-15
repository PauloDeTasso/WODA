

var formRegisterArtist = document.getElementById("formRegisterArtist");
var formRegisterArt = document.getElementById("formRegisterArt");
var dateType;

if (formRegisterArtist)
{
    var msgName = document.getElementById("msgName");
    var msgEmail = document.getElementById("msgEmail");
    var msgGender = document.getElementById("msgGender");
    var msgBirthday = document.getElementById("msgBirthday");
    var msgNationality = document.getElementById("msgNationality");
    var nationality = document.getElementById("nationality");
    var cpf = document.getElementById("cpf");
    var msgCpf = document.getElementById("msgCpf");
    var msgStatus = document.getElementById("msgStatus");
    var fileInputArtist = document.getElementById("fileInputArtist");
    var listArtist = document.getElementById("listArtist");
    var sectionCpf = document.getElementById("sectionCpf");
    var cpfOriginal;
}

if (formRegisterArt)
{
    var msgName = document.getElementById("msgName");
    var msgDescription = document.getElementById("msgDescription");
    var msgPublicationDate = document.getElementById("msgPublicationDate");
    var msgExposureDate = document.getElementById("msgExposureDate");
    var msgImage = document.getElementById("msgImage");
    var msgStatus = document.getElementById("msgStatus");
    var filesInputArts = document.getElementById("filesInputArts");
    var listArts = document.getElementById("listArts");
    var publicationDate = document.getElementById("publicationDate");
    var exposureDate = document.getElementById("exposureDate");
    var associatesOn = document.getElementById("associatesOn");
    var associatesOff = document.getElementById("associatesOff");    
    var dateTypeInput = document.getElementById("dateTypeInput");
}

//

function validacaoEmail(campo)
{
    usuario = campo.value.substring(0, campo.value.indexOf("@"));
    dominio = campo.value.substring(campo.value.indexOf("@") + 1, campo.value.length);

    if ((usuario.length >= 1) &&
        (dominio.length >= 3) &&
        (usuario.search("@") == -1) &&
        (dominio.search("@") == -1) &&
        (usuario.search(" ") == -1) &&
        (dominio.search(" ") == -1) &&
        (dominio.search(".") != -1) &&
        (dominio.indexOf(".") >= 1) &&
        (dominio.lastIndexOf(".") < dominio.length - 1))
    {
        msgEmail.innerHTML = "<font color= 'green'>Ok</font>";
    }
    else
    {
        msgEmail.innerHTML = "Invalid email!";
    }
}

////


function validateDate(campo, msgAlert)
{
    var data = document.getElementById(campo).value;

    data = data.replace(/\//g, "-");

    var data_array = data.split("-");

    if (data_array[ 0 ].length != 4)
    {
        data = data_array[ 2 ] + "-" + data_array[ 1 ] + "-" + data_array[ 0 ];
    }

    var hoje = new Date();

    var nasc = new Date(data);

    var idade = hoje.getFullYear() - nasc.getFullYear();

    var m = hoje.getMonth() - nasc.getMonth();

    if (m < 0 || (m === 0 && hoje.getDate() < nasc.getDate())) idade--;

    if (idade < 18)
    {
        msgAlert.innerHTML = "Invalid date!";
    } else
    {
        msgAlert.innerHTML = "<font color= 'green'>Ok</font>";
    }

    if (campo == "publicationDate")
    {
		if (publicationDate.value)
    	{  	  			
 			 exposureDate.style.visibility = "hidden";
 			 dateType = "publicationDate";
 	  		 dateTypeInput.value = dateType;
 	  		 
  		} else
  		{   
    		exposureDate.style.visibility = "visible";
    		dateType = "null";
    		dateTypeInput.value = dateType;
    	}    

    } else if (campo == "exposureDate")
    {
                
        if (exposureDate.value)
    	{  			
  			publicationDate.style.visibility = "hidden";
  			dateType = "exposureDate";
  			dateTypeInput.value = dateType;
  	
  		} else
  		{ 
 			publicationDate.style.visibility = "visible";
 			dateType = "null";
 			dateTypeInput.value = dateType;
 		} 
 		
    } else
    {
        //
    }   
}

/*

function validateDate(campo, msgAlert)
{
    var data = document.getElementById(campo).value;

    data = data.replace(/\//g, "-");

    var data_array = data.split("-");

    if (data_array[ 0 ].length != 4)
    {
        data = data_array[ 2 ] + "-" + data_array[ 1 ] + "-" + data_array[ 0 ];
    }

    var hoje = new Date();

    var nasc = new Date(data);

    var idade = hoje.getFullYear() - nasc.getFullYear();

    var m = hoje.getMonth() - nasc.getMonth();

    if (m < 0 || (m === 0 && hoje.getDate() < nasc.getDate())) idade--;

    if (idade < 18)
    {
        msgAlert.innerHTML = "Invalid date!";
    } else
    {
        msgAlert.innerHTML = "<font color= 'green'>Ok</font>";
    }

    if (campo == "publicationDate")
    {
        exposureDate.style.visibility = "hidden";

    } else if (campo == "exposureDate")
    {
        publicationDate.style.visibility = "hidden";
    } else
    {
        //
    }
}

*/

/////

function TestaCPF(strCPF)
{
    var Soma;
    var Resto;
    Soma = 0;
    if (strCPF == null) return false;

    for (i = 1; i <= 9; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10))) return false;

    Soma = 0;
    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11))) return false;
    return true;
}

//

function formatarCpf()
{
    cpfOriginal = cpf.value;

    if (cpf.value)
    {
        cpf.value = cpf.value.match(/.{1,3}/g).join(".").replace(/\.(?=[^.]*$)/, "-");
    }

    msgCpf.innerHTML = TestaCPF(cpfOriginal) ? "<font color= 'green'>Ok</font>" : "Invalid CPF";
}

////

function verificarNacionalidade(valor)
{
    if (valor == "nationality" || valor == "" || valor == null)
    {
        msgNationality.innerHTML = "Inform your nationality!";
    } else
    {
        msgNationality.innerHTML = "<font color= 'green'>Ok</font>";
    }

  statusCpf();
}

//

function verificarGenero(valor)
{
    if (valor == "gender" || valor == null)
    {
        msgGender.innerHTML = "Inform your gender!";
    } else
    {
        msgGender.innerHTML = "<font color= 'green'>Ok</font>";
    }
}

//

function verificarNome(valor)
{
    if (valor == "" || valor == null)
    {
        msgName.innerHTML = "Inform your name!";
    } else
    {
        msgName.innerHTML = "<font color= 'green'>Ok</font>";
    }
}

function descriptionValidate(value)
{
    if (value != null || value != "" || value != undefined)
    {
        msgDescription.innerHTML = "<font color= 'green'>Ok</font>";
    } else 
    {
        msgDescription.innerHTML = "Enter a description!";
    }
}

//

function clear()
{
    if (formRegisterArtist)
    {
        msgName.innerHTML = "*";
        msgEmail.innerHTML = "";
        msgGender.innerHTML = "";
        msgBirthday.innerHTML = "*";
        msgNationality.innerHTML = "*";
        msgImage.innerHTML = "";
        msgCpf.innerHTML = "*";
        msgStatus.innerHTML = "";
        //

        listArtist.innerHTML = "";
        listArtist.style.backgroundColor = "rgba(0, 0, 0, 0)";
        listArtist.style.backgroundColor = "rgb(255, 192, 120)";
    }

    if (formRegisterArt)
    {
        msgName.innerHTML = "";
        msgDescription.innerHTML = "";
        msgPublicationDate.innerHTML = "";
        msgExposureDate.innerHTML = "";
        msgImage.innerHTML = "";
        msgStatus.innerHTML = "";
        exposureDate.type = "text";
        publicationDate.type = "text";
        exposureDate.style.visibility = "visible";
        publicationDate.style.visibility = "visible";
        //

        listArts.innerHTML = "";
        listArts.style.backgroundColor = "rgba(0, 0, 0, 0)";
        listArts.style.backgroundColor = "rgb(255, 192, 120)";
    }
}

//

if (formRegisterArtist)
{
    formRegisterArtist.onreset = function ()
    {
        clear()
    };
}

if (formRegisterArt)
{
    formRegisterArt.onreset = function ()
    {
        clear()
    };
}

function validar(form)
{
    /*
    var nome = form.name.value;
	
    var email = form.email.value;
	
    var genero = form.gender.value;
    	
    var dataDeNascimento = form.birthday.value;
    	
    var nacionalidade = form.nationality.value;
    	
    var cpf = form.cpf.value;
	
    if(nome === "")
    {
        alert("Preencha o campo Nome");
    	
        frmContato.nome.focus();
        return false;
    	
    }else if (email === "")
    {
        alert("Preencha o campo E-mail");
    	
        frmContato.nome.focus();
        return false;
    	
    }else if (genero === "")
    {
        alert("Preencha o campo Gênero");
    	
        frmContato.nome.focus();
        return false;
    	
    }else if (dataDeNascimento === "")
    {
        alert("Preencha o campo Data de Nascimento");
    	
        frmContato.nome.focus();
        return false;
    	
    }else if (nacionalidade === "")
    {
        alert("Preencha o campo Nacionalidade");
    	
        frmContato.nome.focus();
        return false;
    	
    }else if (cpf === "")
    {
        alert("Preencha o campo CPF");
    	
        frmContato.nome.focus();
        return false;
    	
    }else
    {
        document.forms["formArtistRegister"].submit();
    }	
    */

    //document.forms["form"].submit();

    //alert(document.forms["form"].submit())
    if (formRegisterArtist)
    {
		//cpf.value = cpfOriginal;
    }
    document.forms[ form ].submit();
}

////
/*
<input type="file" id="files" name="files[]" multiple />
<output id="list"></output>
*/

/*

var fileSelector = document.getElementById('file-selector');

fileSelector.onchange = function ()
{
    var fileList = event.target.files;

    output.innerHTML = fileList;
};

fileSelector.addEventListener('change', (event) =>
{
    var fileList = event.target.files;

    output.innerHTML = fileList;
});

*/

/*
// fileInput é um elemento HTML input: <input type="file" id="myfileinput" multiple>
var fileInput = document.getElementById("myfileinput");

// files é um objeto FileList (similar ao NodeList)
var files = fileInput.files;
var file;

// percorre os arquivos
for (var i = 0; i < files.length; i++) {

    // obtém o item
    file = files.item(i);
    // ou
    file = files[i];

    alert(file.name);
}
*/

//

function checked()
{
  var todosChecados = document.querySelectorAll('[name=checkall]:checked');
  //var todosChecados = document.querySelectorAll('[name=checkall]');
 											   
  var allChecks = [];
  
  for (var i = 0; i < todosChecados.length; i++)
  {
    // utilize o valor aqui, adicionei ao array para exemplo
    allChecks.push(todosChecados[i].value);
  }
    
  for (var i = 0; i < todosChecados.length; i++)
  {
	 alert(allChecks[i]);
  }  
}


function checked2()
{
  var todasAsOpcoes = document.getElementById('formRegisterArt')['checkall'];
 											   
  var checados = [];
  
  for (var i = 0; i < todasAsOpcoes.length; i++)
  {    
    if(todasAsOpcoes[i].checked)
    {
		checados.push(todasAsOpcoes[i].value);
	}	
  }
    
  for (var i = 0; i < checados.length; i++)
  {
	 alert(checados[i]);
  }  
}

function statusCpf()
{
if (nationality.value == "Brasil")
    {
        sectionCpf.style.visibility = "visible";
    	cpf.style.visibility = "visible";
    } else 
    {			
        sectionCpf.style.visibility = "hidden";      
        cpf.style.visibility = "hidden";  
    }
}

setTimeout(() =>
{	
    statusCpf();
}, 2000);

statusCpf();

//