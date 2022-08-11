<%-- 
    Document   : listar
    Created on : 23 de jul. de 2022, 22:24:07
    Author     : eugen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
 
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca de Usuario</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         
         <%@include file="header.jsp" %>
                    <%
                if(sessao == null){
            response.sendRedirect("logar.jsp");
           
        }
        %>
        <div class="conteudo">
            <h1 class="conteudo_title">Usuários</h1>
        <form  class="formulario" action="acoesUsuario" method="post">
            <label class="pesquisa" for="pesquisa">Nome: <br />
                <input type="text" id="pesquisa" name="nome"/>
            </label>
            <input class="filtrar" type="submit" name="buscar" id="buscar" value="Buscar">
        </form>
        <form class="formulario" action="acoesUsuario" method="post">
                <input class="inserir" type="submit" name="botaoClicado" value="inserir">
                <input class="inserir" type= submit name="botaoClicado" value="atualizar">
                <input class="inserir" type= submit name="botaoClicado" value="excluir">
           
                
                
                <%  
                    String info = "";
                    if(request.getAttribute("info") != null){info = (String) (request.getAttribute("info"));} %>
        <h1><%= info %></h1>

             <table class="tabela_pesquisa">
                 <tr class="linhas_tabela_pesquisa" id="linha_primaria_pesquisa">
                     <th class="titulo_tabela_pesquisa">Seleção</th>
                     <th class="titulo_tabela_pesquisa">CPF</th>
                     <th class="titulo_tabela_pesquisa">Nome</th>
                     <th class="titulo_tabela_pesquisa">DATA NASCIMENTO</th>
                     <th class="titulo_tabela_pesquisa">E-MAIL</th>
                     <th class="titulo_tabela_pesquisa">TELEFONE</th>
                     <th class="titulo_tabela_pesquisa">WHATS</th>
                     <th class="titulo_tabela_pesquisa">USERNAME</th>
                 </tr>
                <% ArrayList<Usuario> usu = (ArrayList<Usuario>) request.getAttribute("listaDeUsuario");
                      
                      if(usu == null){
                      usu = new ArrayList<Usuario>();
                    }
                      
                      for(int i=0; i < usu.size(); i++) {
                      %>
                      <tr class="linhas_tabela_pesquisa" id="linha2">
                          <td class="tabela_coluna_pesquisa"><input type="checkbox" value="<%= usu.get(i).getCpf() %>" id="selecionado" name="selecionado"></td>
                          <td class="tabela_coluna_pesquisa"><%= usu.get(i).getCpf() %></td>
                          <td class="tabela_coluna_pesquisa"><%= usu.get(i).getNome() %></td>
                          <td class="tabela_coluna_pesquisa"><%= usu.get(i).getData_nascimento() %></td>
                          <td class="tabela_coluna_pesquisa"><%= usu.get(i).getEmail() %></td>
                          <td class="tabela_coluna_pesquisa"><%= usu.get(i).getTelefone() %></td>
                          <td class="tabela_coluna_pesquisa"><%= usu.get(i).getWhats() %></td>
                          <td class="tabela_coluna_pesquisa"><%= usu.get(i).getUsername() %></td>
                      </tr>
                      <%
                     }

                %>
                
                
          
        </table>
         </form>
        </div>
    </body>
</html>
