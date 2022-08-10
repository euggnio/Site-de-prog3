<%-- 
    Document   : index
    Created on : 28 de jul. de 2022, 00:09:25
    Author     : eugen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Usuario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coala's Pizzas</title>
        <script src="javascript.js" type="text/javascript"></script>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="limparForm()">
        
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
        
        <div class="conteudo">
            <h1 class="conteudo_title">Cadastro Usuário</h1>
            <form class="formulario" id="formulario" method="post" action="acoesUsuario" >
                <%
                    Usuario user = (Usuario) request.getAttribute("usuario");
                    String opc = "atualizar";
                    if (user == null) {
                    user = new Usuario();
                    opc = "inserir";
                }
                %>
                <input type="hidden" name="opc" value="<%= opc %>">
                <h1><%= opc%></h1>
                <fieldset>
                    <legend>Dados do usuario</legend>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="cpf">CPF:           
                        <input class="input-campos" type="text" name="cpf" id="cpf" maxlength="11" value="<%= user.getCpf() %>" required/>             
                        </label> 
                        <label class="formulario__label" for="nome">Nome:
                        <input class="input-campos" type="text" id="nome" name="nome" value="<%= user.getNome() %>" required/>
                        </label> 
                    </div>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="data_nascimento">Data de nascimento
                        <input class="input-campos" type="date" id="data_nascimento" name="data_nascimento" value="<%= user.getData_nascimento() %>" required/>
                        </label> 
                        <label class="formulario__label" for="email">E-mail
                        <input class="input-campos" type="text" id="email" name="email" value="<%= user.getEmail() %>" required/>
                        </label> 
                    </div>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="whats">whats
                        <input class="input-campos" type="text" id="whats" name="whats" maxlength="4" value="<%= user.getWhats() %>" required/>
                        </label>                        
                        <label class="formulario__label" for="telefone">Telefone
                        <input class="input-campos" type="text" id="telefone" name="telefone" value="<%= user.getTelefone() %>" required/>
                        </label> 
                    </div>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="username">Nome de usuário
                        <input class="input-campos" type="text" id="username" name="username" value="<%= user.getUsername() %>" required/>
                        </label> 
                        <label class="formulario__label" for="senha">Senha
                        <input class="input-campos" type="password" id="senha" name="senha" value="<%= user.getSenha() %>" required/>
                        </label> 
                    </div>

                    <input type="submit" value="Cadastrar" name="cadastrar" />
                    <input type="reset" value="Limpar" name="limpar"/>

                </fieldset>
            </form>
                        <button class="voltar" onclick="window.history.go(-1)"> VOLTAR</button>
        </div>
    </body>

</html>