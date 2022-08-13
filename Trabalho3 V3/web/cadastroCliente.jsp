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
        <script src="scripts/validarCliente.js" type="text/javascript"></script>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="limparForm()">
        <%@include file="header.jsp" %>

        <div class="conteudo">


            <h1 class="conteudo_title"> Formulario Cliente</h1>
            <form class="formulario" action="acoesCliente" method="post" id="formulario" onsubmit="return validarCliente();">


                <%
        Cliente cli = (Cliente) request.getAttribute("cliente");
        String opc = "atualizar";
        String readornot = "readonly";
        if (cli == null) {
            readornot = "required";
            cli = new Cliente();
            opc = "inserir";
        }
                %>
                <input type="hidden" name="id" value="<%=cli.getId()%>">
                <input type="hidden" name="opc" value="<%= opc %>">
                <fieldset>
                    <legend><h4>Dados do cliente</h4></legend>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="cpf">CPF
                            <input class="input-campos" type="text"  name="cpf" id="cpf" maxlength="11" <%= readornot %> value="<%= cli.getCpf() %>" /></label>

                        <label class="formulario__label" for="rg" >RG
                            <input class="input-campos" type="text" id="rg" name="rg"  maxlength="10" value="<%= cli.getRg() %>" /></label>
                    </div>

                    <div class="formulario__campos">
                        <label class="formulario__label" for="nome">Nome:
                            <input class="input-campos" type="text" id="nome" name="nome" value="<%= cli.getNome() %>" /></label>
                        <label class="formulario__label" for="orgao_emissor">Orgão emissor RG
                            <input class="input-campos" type="text" id="orgao_emissor" name="orgao_emissor" value="<%= cli.getOrgao_emissor() %>" /></label>
                    </div>

                    <div class="formulario__campos">
                        <label class="formulario__label" for="data_nascimento">Data de nascimento
                            <input class="input-campos" type="date" id="data_nascimento"  name="data_nascimento" value="<%= cli.getDatanascimento() %>" /></label>
                        <label class="formulario__label" for="email">E-mail
                            <input class="input-campos" type="text" id="email" name="email" value="<%= cli.getEmail() %>" /></label>
                    </div><!-- comment -->

                    <div class="formulario__campos">
                        <label class="formulario__label" for="whats">whats
                            <input class="input-campos" type="text" id="whats" name="whats" maxlength="4" value="<%= cli.getWhats() %>" /></label>
                        <label class="formulario__label" for="telefone">Telefone
                            <input class="input-campos" type="text" id="telefone" name="telefone" maxlength="" value="<%= cli.getTelefone() %>" /></label>
                    </div>

                    <legend><h4>Endereço</h4></legend>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="logradouro">Logradouro
                            <input class="input-campos" type="text" id="logradouro" name="logradouro" value="<%= cli.getLogradouro() %>" /></label>   
                        <label class="formulario__label" for="numero">Número
                            <input class="input-campos" type="text" id="numero" name="numero" value="<%= cli.getNumero() %>" /></label> 
                    </div>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="bairro">bairro
                            <input class="input-campos" type="text" id="bairro" name="bairro" value="<%= cli.getBairro() %>" /></label> 

                        <label class="formulario__label" for="cidade">Cidade
                            <input class="input-campos" type="text" id="cidade" name="cidade" value="<%= cli.getCidade() %>" /></label> 
                        <label class="formulario__label" for="estado">Estado (SIGLA)
                            <select class="input-campos" id="estado" name="estado">
                                <option class="input-campos" value="AC">Acre</option>
                                <option value="AL">Alagoas</option>
                                <option value="AP">Amapá</option>
                                <option value="AM">Amazonas</option>
                                <option value="BA">Bahia</option>
                                <option value="CE">Ceará</option>
                                <option value="DF">Distrito Federal</option>
                                <option value="ES">Espírito Santo</option>
                                <option value="GO">Goiás</option>
                                <option value="MA">Maranhão</option>
                                <option value="MT">Mato Grosso</option>
                                <option value="MS">Mato Grosso do Sul</option>
                                <option value="MG">Minas Gerais</option>
                                <option value="PA">Pará</option>
                                <option value="PB">Paraíba</option>
                                <option value="PR">Paraná</option>
                                <option value="PE">Pernambuco</option>
                                <option value="PI">Piauí</option>
                                <option value="RJ">Rio de Janeiro</option>
                                <option value="RN">Rio Grande do Norte</option>
                                <option value="RS">Rio Grande do Sul</option>
                                <option value="RO">Rondônia</option>
                                <option value="RR">Roraima</option>
                                <option value="SC">Santa Catarina</option>
                                <option value="SP">São Paulo</option>
                                <option value="SE">Sergipe</option>
                                <option value="TO">Tocantins</option>
                                <option value="EX">Estrangeiro</option>
                            </select></label> 
                    </div>


                    <input class="inserir" type="submit" value="Cadastrar" name="cadastrar" />
                    <input class="inserir" type="reset" value="Limpar" name="limpar"/>

                </fieldset>
            </form>
            <button class="voltar" onclick="window.history.go(-1)"> VOLTAR</button>
        </div>
    </body>

</html>
