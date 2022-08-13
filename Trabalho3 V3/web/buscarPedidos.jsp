<%-- 
    Document   : buscarProdutos
    Created on : 10 de ago. de 2022, 23:32:30
    Author     : eugen
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Pedidos" %>
<%@page import="modelo.Produto_has_pedidos" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    

    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca de pedidos</title>
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
            <h1 class="conteudo_title">Pedidos</h1>
        <form  class="formulario" action="acoesPedidos" method="post">
            <label class="pesquisa" for="numero">Número do Pedido<br />
                <input type="text" id="pesquisa" name="numero"/>
            </label>
            <input class="filtrar" type="submit" name="buscar" id="buscar" value="Buscar">
        </form>
        <form class="formulario" action="acoesPedidos" method="post">
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
                     <th class="titulo_tabela_pesquisa">Número</th>
                     <th class="titulo_tabela_pesquisa">Data de emissão</th>
                     <th class="titulo_tabela_pesquisa">Frete</th>
                     <th class="titulo_tabela_pesquisa">Data de entrega</th>
                     <th class="titulo_tabela_pesquisa">ID do Cliente</th>
                     <th class="titulo_tabela_pesquisa">Preço da Unidade</th>
                     <th class="titulo_tabela_pesquisa">Total</th>                     
                 </tr>
                <% ArrayList<Pedidos> ped = (ArrayList<Pedidos>) request.getAttribute("listaDePedidos");
                      ArrayList<Produto_has_pedidos> php = (ArrayList<Produto_has_pedidos>) request.getAttribute("listaPHP");
                      if(ped == null){
                      ped = new ArrayList<Pedidos>();
                        }
                        if(php == null){
                        php = new ArrayList<Produto_has_pedidos>();
                    }
                      
                      for(int i=0; i < ped.size(); i++) {
                        int local = 0;
                        for (int j = 0; j < php.size() ; j++) {
                            if(php.get(j).getPedidos_numero() == ped.get(i).getNumero()){
                                local = j;
                                break;
                            }
                                
                        }
                      %>
                      <tr class="linhas_tabela_pesquisa" id="linha2">
                          <td class="tabela_coluna_pesquisa"><input type="checkbox" value="<%= ped.get(i).getNumero()%>" id="selecionado" name="selecionado"></td>
                          <td class="tabela_coluna_pesquisa"><%= ped.get(i).getNumero() %></td>
                          <td class="tabela_coluna_pesquisa"><%= ped.get(i).getData() %></td>
                          <td class="tabela_coluna_pesquisa"><%= ped.get(i).getValor_frete()%></td>
                          <td class="tabela_coluna_pesquisa"><%= ped.get(i).getData_entrega() %></td>
                          <td class="tabela_coluna_pesquisa"><%= ped.get(i).getClientes_id() %></td>
                          <td class="tabela_coluna_pesquisa"><%= php.get(local).getPreco_unitario() %></td>
                          <td class="tabela_coluna_pesquisa"><%= php.get(local).getPreco_unitario() * php.get(local).getQuantidade()%></td>
                      </tr>
                      <%
                     }

                %>
                
                
          
        </table>
         </form>
        </div>
    </body>
</html>
