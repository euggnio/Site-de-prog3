

function validarPedido(){
    var numero = document.getElementById("numero").value;
    var dataEmissao = document.getElementById("data").value;
    var data_entrega = document.getElementById("data_entrega").value;
    var precounit = document.getElementById("valor_frete").value;
    var id = document.getElementById("cliente_id").value;
    var id2 = document.getElementById("idProduto").value;
    var quantidade = document.getElementById("quantidade").value;
    
    var regexLetras = /[^0-9]/g;
    var soValores = /[^0-9.]/g;
    if(isNaN(numero)){
        alert("Numero do pedido deve ser numerico!");
        return false;
    }
    if(numero.value == ""){
        alert("Numero do pedido deve ser preenchido!");
        return false;       
    }

    var pattern = /^\d{4}-\d{2}-\d{2}$/;
    if (dataEmissao == '') {
        alert("Data de emissao deve ser inserida!");
        return false;
    }
    if (!pattern.test(dataEmissao)) {
        alert("Data de emissao deve ser no formato dd/mm/aaaa!");
        return false;
    }
        if (data_entrega == '') {
        alert("Data de entrega deve ser inserida!");
        return false;
    }
    if (!pattern.test(data_entrega)) {
        alert("Data de entrega deve ser no formato dd/mm/aaaa!");
        return false;
    }
    
    if (precounit <= 0) {
        alert("preencha o campo valor do frete!");
        return false;
    } else {
        precounit = precounit.replace(",", ".");
        if (soValores.test(precounit)) {
            alert("Preço inválido!!");
            return false;
        }
    }
    if (precounit.match(/[.]/g) != null) {
        if (precounit.match(/[.]/g).length >= 2) {
            alert("tire o ponto a mais do preço!");
            return false;
        }
    }
    if(precounit.substring(1,0) == "."){
        alert("O preço deve começar com números!");
        return false;
    }
    
    if(id == ''){
        alert("O id do cliente deve ser preenchido!");
        return false;
    }
    if(isNaN(id)){
        alert("O id do cliente deve ser numerico!");
        return false;
    }
    if(id2 == ''){
        alert("O id do produto deve ser preenchido!");
        return false;
    }
    if(isNaN(id2)){
        alert("O id do produto deve ser numerico!");
        return false;
    }
    if(isNaN(quantidade)){
        alert("A quantidade deve ser numerico!");
        return false;
    }    
    
    alert("Inserindo... :D");
    return true
}




