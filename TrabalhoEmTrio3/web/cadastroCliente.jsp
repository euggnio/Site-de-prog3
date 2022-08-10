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


            <h1>Cadastro de clientes:</h1>
            <form class="formulario" id="formulario" method="post" action="clienteOp" >
                
                
                    <%
            Cliente cli = (Cliente) request.getAttribute("cliente");
            String opc = "atualizar";
            if (cli == null) {
                cli = new Cliente();
                opc = "inserir";
            }
                    %>
                    <input type="hidden" name="opc" value="<%= opc %>">
                    <input type="number" name="id" value="<%=cli.getId()%>">
                    <h1><%= opc%></h1>
                <fieldset>
                    <legend>Dados do cliente</legend>
                    <label for="cpf">CPF:</label>
                    <br>
                    <input type="text" name="cpf" id="cpf" maxlength="11" value="<%= cli.getCpf() %>" value="<%= cli.getCpf() %>" required/>
                    <br>
                    <label for="rg" >RG:</label>
                    <br>
                    <input type="text" id="rg" name="rg"  value="<%= cli.getRg() %>" required/>
                    <br>
                    <label for="nome">Nome:</label>
                    <br>
                    <input type="text" id="nome" name="nome" value="<%= cli.getNome() %>" required/>
                    <br>
                    <label for="orgao_emissor">Orgão emissor RG:</label>
                    <br>
                    <input type="text" id="orgao_emissor" name="orgao_emissor" value="<%= cli.getOrgao_emissor() %>" required/>
                    <br>
                    <label for="data_nascimento">Data de nascimento: </label>
                    <br>
                    <input type="date" id="data_nascimento" name="data_nascimento" value="<%= cli.getDatanascimento() %>" required/>
                    <br>
                    <label for="email">E-mail:</label>
                    <br>
                    <input type="text" id="email" name="email" value="<%= cli.getEmail() %>" required/>
                    <br>
                    <label for="whats">whats</label>
                    <br>
                    <input type="text" id="whats" name="whats" maxlength="4" value="<%= cli.getWhats() %>" required/>
                    <br>
                    <label for="telefone">Telefone</label>
                    <br>
                    <input type="text" id="telefone" name="telefone" value="<%= cli.getTelefone() %>" required/>
                    <br>
                    <label for="logradouro">logradouro</label>
                    <br>
                    <input type="text" id="logradouro" name="logradouro" value="<%= cli.getLogradouro() %>" required/>
                    <br>   
                    <label for="numero">numero</label>
                    <br>
                    <input type="text" id="numero" name="numero" value="<%= cli.getNumero() %>" required/>
                    <br> 
                    <label for="bairro">bairro</label>
                    <br>
                    <input type="text" id="bairro" name="bairro" value="<%= cli.getBairro() %>" required/>
                    <br> 
                    <label for="cidade">cidade</label>
                    <br>
                    <input type="text" id="cidade" name="cidade" value="<%= cli.getCidade() %>" required/>
                    <br> 
                    <label for="estado">Estado:</label>
                    <br>
                    <input type="text" id="estado" name="estado" maxlength="2"  value="<%= cli.getEstado() %>" required/>
                    <br> 
                
                <input type="submit" value="Cadastrar" name="cadastrar" />
                <input type="reset" value="Limpar" name="limpar"/>
                
                </fieldset>
            </form>
                     <a href="buscarClientes.jsp"><button> VOLTAR</button> </a>
        </div>
    </body>

</html>
