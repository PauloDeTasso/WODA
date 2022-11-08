var msgName = document.getElementById("msgName");
var msgEmail = document.getElementById("msgEmail");
var msgGender = document.getElementById("msgGender");
var msgBirthday = document.getElementById("msgBirthday");
var msgNationality = document.getElementById("msgNationality");
var msgCpf = document.getElementById("msgCpf");
var msgStatus = document.getElementById("msgStatus");

var formRegister = document.getElementById("formRegister");

var cpf = document.getElementById("cpf");
var nationality = document.getElementById("nationality");

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

function validadata()
{
    var data = document.getElementById("birthday").value; // pega o valor do input
    data = data.replace(/\//g, "-"); // substitui eventuais barras (ex. IE) "/" por hífen "-"
    var data_array = data.split("-"); // quebra a data em array

    // para o IE onde será inserido no formato dd/MM/yyyy
    if (data_array[ 0 ].length != 4)
    {
        data = data_array[ 2 ] + "-" + data_array[ 1 ] + "-" + data_array[ 0 ]; // remonto a data no formato yyyy/MM/dd
    }

    // comparo as datas e calculo a idade
    var hoje = new Date();
    var nasc = new Date(data);
    var idade = hoje.getFullYear() - nasc.getFullYear();
    var m = hoje.getMonth() - nasc.getMonth();
    if (m < 0 || (m === 0 && hoje.getDate() < nasc.getDate())) idade--;


    if (idade < 18)
    {
        msgBirthday.innerHTML = "Only for over 18s!";
    } else
    {
        msgBirthday.innerHTML = "<font color= 'green'>Ok</font>";
    }
}

/////

function TestaCPF(strCPF)
{
    var Soma;
    var Resto;
    Soma = 0;
    if (strCPF == "00000000000") return false;

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

var strCPF = "12345678909";

//alert(TestaCPF(strCPF));

//
var cpf = document.querySelector("#cpf");
var msgCpf = document.getElementById("msgCpf")
var cpfOriginal;

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

    if (valor == "Brasil")
    {
        cpf.style.visibility = "visible";        
        
    } else 
    {
        cpf.style.visibility = "hidden";
    }
}

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

setTimeout(() =>
{
    if (nationality.value === "Brasil")
    {	
        cpf.style.visibility = "visible";
    } else 
    {
        cpf.style.visibility = "hidden";
    }
}, 2000);


function clear()
{
    msgName.innerHTML = "";
    msgEmail.innerHTML = "";
    msgGender.innerHTML = "";
    msgBirthday.innerHTML = "";
    msgNationality.innerHTML = "";
    msgCpf.innerHTML = "";
    msgStatus.innerHTML = "";
}

//

formRegister.onreset = function ()
{
    clear()
};

 function validar()
 {
	/*
	var nome = formRegister.name.value;
	
	var email = formRegister.email.value;
	
	var genero = formRegister.gender.value;
		
	var dataDeNascimento = formRegister.birthday.value;
		
	var nacionalidade = formRegister.nationality.value;
		
	var cpf = formRegister.cpf.value;
	
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
		
	//document.forms["formRegister"].submit();
		
	//alert(document.forms["formRegister"].submit())
	
	document.forms["formRegister"].submit();
}
