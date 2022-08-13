
function validarProduto() {
    var unidade = document.getElementById("unidade").value;
    var nome = document.getElementById("nome").value;
    var id = document.getElementById("ID").value;
    var descricao = document.getElementById("descricao").value;
    var precounit = document.getElementById("preco_unitario").value;

    var regexLetras = /[^0-9]/g;
    var soValores = /[^0-9.]/g;
    if (unidade.length > 3) {
        alert("Limite de 999 para campo unidade!");
        return false;
    }
    if (regexLetras.test(unidade)) {
        alert("Letras não são aceitas no campo Unidades:");
        return false;
    }
    if (nome == "") {
        alert("preencha o campo nome!");
        return false;
    }
        if (nome.length > 100) {
        alert("Nome é muito grande!");
        return false;
    }
    if (regexLetras.test(id)) {
        alert("Só são aceitos IDS númericos!!");
        return false;
    }
    if (id == "") {
        alert("preencha o campo id!");
        return false;
    }
    if (descricao == "") {
        alert("preencha o campo descricao!");
        return false;
    }

    if (precounit <= 0) {
        alert("preencha o campo preço unitario!");
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

        }
    }
    if(precounit.substring(1,0) == "."){
        alert("O preço deve começar com números!");
        return false;
    }
   
    
    return true;
}