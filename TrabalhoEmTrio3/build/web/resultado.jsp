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
    <div class="header">
      <div class="banner"></div>
      <div class="menu">
        <ul class="menu">
          <li><a class="menu_item" href="index.html">HOME</a></li>
          <li><a class="menu_item" href="usuarios.html">USUÁRIOS</a></li>
          <li><a class="menu_item" href="clientes.html">CLIENTES</a></li>
          <li><a class="menu_item" href="produtos.html">PRODUTOS</a></li>
          <li><a class="menu_item" href="pedidos.html">PEDIDOS</a></li>
        </ul>
      </div>
      <div class="banner"></div>
    </div>

    <h1 class="conteudo_title">CONFIRMAÇÃO</h1>

    <div class="processamento">

        <p id="mensagem_processamento">
            <%= request.getAttribute("info") %>

        </p>

      <button id="botao_processamento"><a href="<%= request.getAttribute("voltar") %>">Voltar</a></button>

    </div>

  </body>
</html>
