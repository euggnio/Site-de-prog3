function validarUsuarioo (){
  var cpf = document.getElementById("cpf").value;
  var nome = document.getElementById("nome").value;
  var dataNascimento = document.getElementById("data_nascimento").value;
  var email = document.getElementById("email").value;
  var telefone = document.getElementById("telefone").value;
  var whatsapp = document.getElementById("whats").value;
  var username = document.getElementById("username").value;
  var senha = document.getElementById("senha").value;


  var regexCpf = /^\d{11}?$/;
  if (cpf == ''){
    alert ("CPF não pode ser nulo!");
    return false;
  }
  if(!regexCpf.test(cpf)){
    alert ("CPF deve conter apenas números!");
    return false;
  }

  if (nome == ''){
    alert ("Nome é um campo obrigatório!")
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
  if(!regexWhats.test(whatsapp)){
    alert ("Whats deve ser numérico e com 3 caracteres!");
    return false;
  }
  
    if (email == ''){
    alert ("E-mail é um campo obrigatório");
    return false;
  }
    if(email.length > 45){
       alert ("email é muito grande!");
    return false;
  }
  
  var regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
   if (!regexEmail.test(email))
  {
    alert ("Coloque um e-mail válido.");
    return false;
  }
  

  if (username.value == ''){
    alert ("Username é um campo obrigatório!")
    return false;
  }
  if(username.length > 15){
        alert("Usuário deve conter apenas 15 caracteres.");
      return false;
  }

  if (senha.value == ''){
    alert ("Senha é um campo obrigatório!")
    return false;
  }
    if(senha.length > 255){
       alert ("senha é muito grande!");
    return false;
  }


  return true;
}