<%-- 
    Document   : listar
    Created on : 23 de jul. de 2022, 22:24:07
    Author     : eugen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Cliente" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="style.css" rel="stylesheet" type="text/css"/>
</head>


<%@include file="header.jsp" %>
                    <%
                if(sessao == null){
            response.sendRedirect("logar.jsp");
           
        }
        %>
<div class="conteudo">      
    <h1 class="conteudo_title">Clientes</h1>
    <form class="formulario" action="listarClientes" method="post">
        <label class="pesquisa" for="pesquisa">Nome: <br />
            <input type="text" id="pesquisa" name="nome"/>
        </label>
        <input class="filtrar" type="submit" name="buscar" id="buscar" value="Buscar">
    </form>
    <form class="formulario" action="acoesCliente" method="post">
        <input class="inserir" type="submit" name="botaoClicado" value="inserir">
        <input class="inserir" type= submit name="botaoClicado" value="atualizar">
        <input class="inserir" type= submit name="botaoClicado" value="excluir">
             <%  
                    String info = "";
                    if(request.getAttribute("info") != null){info = (String) (request.getAttribute("info"));} %>
                 <h1><%= info %></h1>


        <table class="tabela_pesquisa" >
            <tr class="linhas_tabela_pesquisa" id="linha_primaria_pesquisa">
                <th  class="titulo_tabela_pesquisa">Seleção</th>
                <th  class="titulo_tabela_pesquisa">ID</th>
                <th  class="titulo_tabela_pesquisa">Nome</th>
                <th  class="titulo_tabela_pesquisa">RG</th>
                <th  class="titulo_tabela_pesquisa">CPF</th>
                <th  class="titulo_tabela_pesquisa">Orgao Emissor</th>
                <th  class="titulo_tabela_pesquisa">Data de Nascimento</th>
                <th class="titulo_tabela_pesquisa">E-mail</th>
                <th class="titulo_tabela_pesquisa">Whats</th>
                <th class="titulo_tabela_pesquisa">Telefone</th>
                <th class="titulo_tabela_pesquisa">Endereco</th>
            </tr>
            <% ArrayList<Cliente> cli = (ArrayList<Cliente>) request.getAttribute("listaDeClientes");

                  if(cli == null){
                  cli = new ArrayList<Cliente>();
                }

                  for(int i=0; i < cli.size(); i++) {
            %>
            <tr class="linhas_tabela_pesquisa" id="linha2">
                <td><input type="checkbox" value="<%= cli.get(i).getId() %>" id="selecionado" name="selecionado"></td>
                <td class="tabela_coluna_pesquisa"><%= cli.get(i).getId() %></td>
                <td class="tabela_coluna_pesquisa"><%= cli.get(i).getNome() %></td>
                <td class="tabela_coluna_pesquisa"><%= cli.get(i).getRg() %></td>
                <td class="tabela_coluna_pesquisa"><%= cli.get(i).getCpf() %></td>
                <td class="tabela_coluna_pesquisa"><%= cli.get(i).getOrgao_emissor() %></td>
                <td class="tabela_coluna_pesquisa"><%= cli.get(i).getDatanascimento() %></td>
                <td class="tabela_coluna_pesquisa"><%= cli.get(i).getEmail() %></td>
                <td class="tabela_coluna_pesquisa"><%= cli.get(i).getWhats() %></td>
                <td class="tabela_coluna_pesquisa"><%= cli.get(i).getTelefone() %></td>
                <td class="tabela_coluna_pesquisa"><%= cli.get(i).listarEndereco() %></td>
            </tr>
            <%
           }

            %>



         </table>
         </form>
        </div>
    </body>
</html>

