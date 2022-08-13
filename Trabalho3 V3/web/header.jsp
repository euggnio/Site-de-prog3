<%-- 
    Document   : header
    Created on : 9 de ago. de 2022, 22:23:00
    Author     : eugen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        
        <div class="header">
            <% String sessao = (String) session.getAttribute("sessao"); %>
            <div class="banner"></div>
            <div class="menu">
                <ul class="menu">
                    <li><a class="menu_item" href="index.html">HOME</a></li>
                    <li><a class="menu_item" href="buscarUsuarios.jsp">USUÁRIOS</a></li>
                    <li><a class="menu_item" href="buscarClientes.jsp">CLIENTES</a></li>
                    <li><a class="menu_item" href="buscarProdutos.jsp">PRODUTOS</a></li>
                    <li><a class="menu_item" href="buscarPedidos.jsp">PEDIDOS</a></li>
                    <% if(sessao != null){
                     %>
                    <form action="acaoLogar" method="post">
                        <input type="hidden" name="sair" value="true">
                        <li><input style="color:red;" class="menu_item" type="submit" name="sairButton" value="SAIR"></li>
                    </form>
                   <%} %>
                </ul>
            </div>
            <div class="banner"></div>
        </div>