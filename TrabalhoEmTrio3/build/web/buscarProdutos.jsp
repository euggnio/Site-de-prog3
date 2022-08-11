<%-- 
    Document   : buscarProdutos
    Created on : 10 de ago. de 2022, 23:32:30
    Author     : eugen
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Produto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    

    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca de produtos</title>
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
            <h1 class="conteudo_title">Produtos</h1>
        <form  class="formulario" action="acoesProduto" method="post">
            <label class="pesquisa" for="pesquisa">Nome: <br />
                <input type="text" id="pesquisa" name="Nome"/>
            </label>
            <input class="filtrar" type="submit" name="buscar" id="buscar" value="Buscar">
        </form>
        <form class="formulario" action="acoesProduto" method="post">
                <input class="inserir" type="submit" name="botaoClicado" value="inserir">
                <input class="inserir" type= submit name="botaoClicado" value="atualizar">
                <input class="inserir" type= submit name="botaoClicado" value="excluir">
           
                <%  
                    String info = "";
                    if(request.getAttribute("info") != null){info = (String) (request.getAttribute("info"));} %>
                 <h1><%= info %></h1>

             <table class="tabela_pesquisa">
                 <tr class="linhas_tabela_pesquisa" id="linha_primaria_pesquisa">
                     <th class="titulo_tabela_pesquisa">ID</th>
                     <th class="titulo_tabela_pesquisa">Seleção</th>
                     <th class="titulo_tabela_pesquisa">Nome</th>
                     <th class="titulo_tabela_pesquisa">Unidades</th>
                     <th class="titulo_tabela_pesquisa">Descricao</th>
                     <th class="titulo_tabela_pesquisa">Preço</th>
                 </tr>
                <% ArrayList<Produto> pro = (ArrayList<Produto>) request.getAttribute("listaDeProduto");
                      if(pro == null){
                      pro = new ArrayList<Produto>();
                    }
                      
                      for(int i=0; i < pro.size(); i++) {
                      %>
                      <tr class="linhas_tabela_pesquisa" id="linha2">
                          <td class="tabela_coluna_pesquisa"><input type="checkbox" value="<%= pro.get(i).getId()%>" id="selecionado" name="selecionado"></td>
                          <td class="tabela_coluna_pesquisa"><%= pro.get(i).getId() %></td>
                          <td class="tabela_coluna_pesquisa"><%= pro.get(i).getNome() %></td>
                          <td class="tabela_coluna_pesquisa"><%= pro.get(i).getUnidade()%></td>
                          <td class="tabela_coluna_pesquisa"><%= pro.get(i).getDescricao() %></td>
                          <td class="tabela_coluna_pesquisa"><%= pro.get(i).getPreco_unitario() %></td>

                      </tr>
                      <%
                     }

                %>
                
                
          
        </table>
         </form>
        </div>
    </body>
</html>
