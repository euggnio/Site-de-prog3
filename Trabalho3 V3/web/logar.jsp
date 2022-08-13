<%-- 
    Document   : resultado
    Created on : 23 de jul. de 2022, 13:00:07
    Author     : eugen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <title>Coala's Pizzas</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <%@include file="header.jsp" %>

    <h1 class="conteudo_title">Logar</h1>
    

    <div class="processamento">
        <%  
                    String info = "";
                    if(request.getAttribute("info") != null){info = (String) (request.getAttribute("info"));} %>
        <h5><%= info %></h5>
        <form action="acaoLogar" method="post">
            <div class="formulario__campos">
                        <label class="formulario__label" for="nome">Nome:
                            <input class="login" type="text" name="username" id="username" value="" >
                        </label>
            </div>
                  <div class="formulario__campos">
                        <label  class="formulario__label" for="descricao">Senha:
                            <input class="login" type="password" name="password" id="password" value="" >
                        </label>

                    </div>
                            <input class="inserir" type="submit" value="Logar" name="Logar" />
                            <button style="color:red;" class="inserir" id="botao_processamento"><a href="cadastroUsuario.jsp">Registrar</a></button>
                            <br>
                            <input class="inserir" type="submit" value="Logar sem credenciais para propósito completamente acadêmico" name="forcar" />
        </form>
        
        
      <button id="botao_processamento"><a href="index.html">Voltar ao Início</a></button>
           <h5 class="conteudo_title"> Só usuários válidos podem modificar clientes,pedidos e produtos.</h5>

    </div>

  </body>
</html>
