

function validacaoEmail(field)
{
    usuario = field.value.substring(0, field.value.indexOf("@"));
    dominio = field.value.substring(field.value.indexOf("@") + 1, field.value.length);

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
        document.getElementById("msgemail").innerHTML = "E-mail válido";
        alert("E-mail valido");
    }
    else
    {
        document.getElementById("msgemail").innerHTML = "<font color='red'>E-mail inválido </font>";
        alert("E-mail invalido");
    }
}

////

function validadata()
{
    var data = document.getElementById("nascimento").value; // pega o valor do input
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
        alert("Pessoas menores de 18 não podem se cadastrar.");
        return false;
    }

    if (idade >= 18 && idade <= 60)
    {
        alert("Maior de 18, pode se cadastrar.");
        return true;
    }

    // se for maior que 60 não vai acontecer nada!
    return false;
}