function validarCliente (){
  var nome = document.getElementById("nome").value;
  var dataNascimento = document.getElementById("data_nascimento").value;
  var cpf = document.getElementById("cpf").value;
  var rg = document.getElementById("rg").value;
  var orgao = document.getElementById("orgao_emissor").value;
  var email = document.getElementById("email").value;
  var telefone = document.getElementById("telefone").value;
  var whatsapp = document.getElementById("whats").value;
  var logradouro = document.getElementById("logradouro").value;
  var numero = document.getElementById("numero").value;
  var bairro = document.getElementById("bairro").value;
  var cidade = document.getElementById("cidade").value;
  var estado = document.getElementById("estado").value;
  
  
  if (nome == ''){
    alert ("Nome é um campo obrigatório!");
    return false;
  }
  if(nome.length > 100){
       alert ("Nome é muito grande!");
    return false;
  }

  var pattern = /^\d{4}-\d{2}-\d{2}$/;
  if (dataNascimento == ''){
    alert ("Data de nascimento deve ser inserida!");
    return false;
  }
  if(!pattern.test(dataNascimento)){
      alert ("Data de nascimento deve ser no formato dd/mm/aaaa!");
    return false;
  }

  var regexCpf = /^\d{11}?$/;
  if (cpf == ''){
    alert ("CPF não pode ser nulo!");
    return false;
  }
  if(!regexCpf.test(cpf)){
    alert ("CPF deve conter apenas números!");
    return false;
  }

  var regexRg = /^\d{10}?$/;
  if (rg == ''){
    alert ("RG não pode ser nulo!");
    return false;
  }
  if(!regexRg.test(rg)){
    alert ("RG deve conter apenas números e 10 caracteres");
    return false;
  }
  
  if (orgao.length > 6  || orgao == ""){
    alert ("Orgao Emissor deve conter apenas iniciais!");
    return false;
  }
   var regexNumeros = /[^aA-zZ]/g;
  if(regexNumeros.test(orgao)){
    alert ("Orgao Emissor deve conter apenas letras!");
    return false;
  }

  if (email == ''){
    alert ("E-mail é um campo obrigatório");
    return false;
  }
   if (email.length > 100){
    alert ("E-mail é muito grande!");
    return false;
  }
  
  var regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
   if (!regexEmail.test(email))
  {
    alert ("Coloque um e-mail válido.");
    return false;
  }
  

  var pattern = /^\d{11}?$/;
  if (telefone == ''){
    alert ("Telefone deve conter 11 números! (DDD + número)");
    return false;
  }
  if(!pattern.test(telefone)){
    alert ("Telefone deve conter 11 números! (DDD + número)");
    return false;
  }

  var regexWhats = /^\d{3}?$/;
  if (whatsapp == ''){
    alert ("WhatsApp não pode ser nulo!");
    return false;
  }
  if (whatsapp > 127){
    alert ("WhatsApp deve ser menor que 127!");
    return false;
  }
  if(!regexWhats.test(whatsapp)){
    alert ("Whats deve ser numérico e com 3 caracteres!");
    return false;
  }

  if (logradouro == ''){
    alert ("Logradouro é um campo obrigatório!");
    return false;
  }
    if (logradouro.length > 100){
    alert ("Logradouro é muito grande!");
    return false;
  }  

  if (numero == ''){
    alert ("Número é um campo obrigatório!");
    return false;
  }
  if (numero.length > 20){
    alert ("Número é muito grande!");
    return false;
  }  

  if (bairro == ''){
    alert ("Bairro é um campo obrigatório!");
    return false;
  }
    if (bairro.length > 45){
    alert ("Bairro é muito grande!");
    return false;
  }  

  if (cidade == ''){
    alert ("Cidade é um campo obrigatório!");
    return false;
  }
    if (cidade.length > 45){
    alert ("cidade é muito grande!");
    return false;
  }  

  if (estado == ''){
    alert ("Estado é um campo obrigatório!");
    return false;
  }


  return true;
}