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
    <body>
        <%@include file="header.jsp" %>
        <form action="listarClientes" method="post">
            <label for="nome">Nome:</label>
            <br>
            <input type="text" id="nome" name="nome"/>
            <input type="submit" name="buscar" id="buscar" value="Buscar">
        </form>
            <form action="acoesCliente" method="post">
                <input type="submit" name="botaoClicado" value="inserir">
                <input type= submit name="botaoClicado" value="atualizar">
                <input type= submit name="botaoClicado" value="excluir">
           
        <h1><%= request.getAttribute("lastResult") %></h1>
        <h1><%= request.getAttribute("Info") %></h1>
        <h1>Lista de clientes:</h1>
         <table class="tabelaBuscaCliente" >
          <tr>
              <th>Seleção</th>
              <th>ID</th>
              <th>Nome</th>
              <th>RG</th>
              <th>CPF</th>
              <th>Orgao Emissor</th>
              <th>Data de Nascimento</th>
              <th>E-mail</th>
              <th>Whats</th>
              <th>Telefone</th>
              <th>Endereco</th>
          </tr>
                <% ArrayList<Cliente> cli = (ArrayList<Cliente>) request.getAttribute("listaDeClientes");
                      
                      if(cli == null){
                      cli = new ArrayList<Cliente>();
                    }
                      
                      for(int i=0; i < cli.size(); i++) {
                      %>
                      <tr>
                          <td><input type="checkbox" value="<%= cli.get(i).getId() %>" id="selecionado" name="selecionado"></td>
                          <td><%= cli.get(i).getId() %></td>
                          <td><%= cli.get(i).getNome() %></td>
                          <td><%= cli.get(i).getRg() %></td>
                          <td><%= cli.get(i).getCpf() %></td>
                          <td><%= cli.get(i).getOrgao_emissor() %></td>
                          <td><%= cli.get(i).getDatanascimento() %></td>
                          <td><%= cli.get(i).getEmail() %></td>
                          <td><%= cli.get(i).getWhats() %></td>
                          <td><%= cli.get(i).getTelefone() %></td>
                          <td><%= cli.get(i).listarEndereco() %></td>
                      </tr>
                      <%
                     }

                %>
                
                
          
        </table>
         </form>
    </body>
</html>
