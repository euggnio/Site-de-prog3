<%-- 
    Document   : index
    Created on : 28 de jul. de 2022, 00:09:25
    Author     : eugen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Cliente" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="javascript.js" type="text/javascript"></script>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="limparForm()">
        <%@include file="header.jsp" %>
        
        <div class="conteudo">


           <h1 class="conteudo_title"> Formulario Cliente</h1>
            <form class="formulario" id="formulario" method="post" action="acoesCliente" >
                
                
                    <%
            Cliente cli = (Cliente) request.getAttribute("cliente");
            String opc = "atualizar";
            if (cli == null) {
                cli = new Cliente();
                opc = "inserir";
            }
                    %>
                    <input type="hidden" name="id" value="<%=cli.getId()%>">
                    <input type="hidden" name="opc" value="<%= opc %>">
                <fieldset>
                    <legend>Dados do cliente</legend>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="cpf">CPF
                         <input class="input-campos" type="text" name="cpf" id="cpf" maxlength="11" value="<%= cli.getCpf() %>" value="<%= cli.getCpf() %>" required/></label>
                         
                        <label class="formulario__label" for="rg" >RG
                         <input class="input-campos" type="text" id="rg" name="rg"  value="<%= cli.getRg() %>" required/></label>
                    </div>
                   
                    <div class="formulario__campos">
                    <label class="formulario__label" for="nome">Nome:
                    <input class="input-campos" type="text" id="nome" name="nome" value="<%= cli.getNome() %>" required/></label>
                    <label class="formulario__label" for="orgao_emissor">Orgão emissor RG
                    <input class="input-campos" type="text" id="orgao_emissor" name="orgao_emissor" value="<%= cli.getOrgao_emissor() %>" required/></label>
                    </div>
                        
                    <div class="formulario__campos">
                    <label class="formulario__label" for="data_nascimento">Data de nascimento
                    <input class="input-campos" type="date" id="data_nascimento" name="data_nascimento" value="<%= cli.getDatanascimento() %>" required/></label>
                    <label class="formulario__label" for="email">E-mail
                    <input class="input-campos" type="text" id="email" name="email" value="<%= cli.getEmail() %>" required/></label>
                    </div><!-- comment -->
                    
                    <div class="formulario__campos">
                    <label class="formulario__label" for="whats">whats
                    <input class="input-campos" type="text" id="whats" name="whats" maxlength="4" value="<%= cli.getWhats() %>" required/></label>
                    <label class="formulario__label" for="telefone">Telefone
                    <input class="input-campos" type="text" id="telefone" name="telefone" value="<%= cli.getTelefone() %>" required/></label>
                    </div>
        
                        <legend>Endereço</legend>
                        <div class="formulario__campos">
                    <label class="formulario__label" for="logradouro">Logradouro
                    <input class="input-campos" type="text" id="logradouro" name="logradouro" value="<%= cli.getLogradouro() %>" required/></label>   
                    <label class="formulario__label" for="numero">Número
                    <input class="input-campos" type="text" id="numero" name="numero" value="<%= cli.getNumero() %>" required/></label> 
                        </div>
                        <div class="formulario__campos">
                    <label class="formulario__label" for="bairro">bairro
                    <input class="input-campos" type="text" id="bairro" name="bairro" value="<%= cli.getBairro() %>" required/></label> 
                        
                    <label class="formulario__label" for="cidade">Cidade
                    <input class="input-campos" type="text" id="cidade" name="cidade" value="<%= cli.getCidade() %>" required/></label> 
                    <label class="formulario__label" for="estado">Estado (SIGLA)
                    <input class="input-campos" type="text" id="estado" name="estado" maxlength="2"  value="<%= cli.getEstado() %>" required/></label> 
                        </div>
                    
                
                <input class="inserir" type="submit" value="Cadastrar" name="cadastrar" />
                <input class="inserir" type="reset" value="Limpar" name="limpar"/>

                </fieldset>
            </form>
                     <button class="voltar" onclick="window.history.go(-1)"> VOLTAR</button>
        </div>
    </body>

</html>
