<%-- 
    Document   : cadastrarProduto
    Created on : 11 de ago. de 2022, 00:04:29
    Author     : eugen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Produto" %>
<!DOCTYPE html>
<html>
    
                    <% String sessao = (String) session.getAttribute("sessao");
                if(sessao == null){
            response.sendRedirect("logar.jsp");
           
        }
        %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coala's Pizzas</title>
        <script src="javascript.js" type="text/javascript"></script>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%@include file="header.jsp" %> 
        <div class="conteudo">
            <h1 class="conteudo_title">Cadastro Produtos</h1>
            <form class="formulario" action="acoesProduto" method="post">

                <%
                            Produto pro = (Produto) request.getAttribute("produto");
                            String opc = "atualizar";
                            if (pro == null) {
                            pro = new Produto();
                            opc = "inserir";
                        }
                %>
                <input type="hidden" name="opc" value="<%= opc %>">
                <input type="hidden" name="IDVelho" value="<%=pro.getId()%>">
                <fieldset>
                    <legend>Dados de Identificação</legend>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="ID">Id:
                            <input type="text" name="ID" id="ID" value="<%= pro.getId() %>" style="width: 10%;">
                        </label>


                    </div>

                    <div class="formulario__campos">
                        <label class="formulario__label" for="nome">Nome:
                            <input type="text" name="nome" id="nome" value="<%= pro.getNome() %>" style="width: 80%;">
                        </label>
                        <label class="formulario__label" for="descricao">Descrição:
                            <input type="text" name="descricao" id="descricao" value="<%= pro.getNome() %>"style="width: 80%;">
                        </label>

                    </div>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="unidade">Unidades:
                            <input type="text" name="unidade" id="unidade" value="<%= pro.getNome() %>" style="width: 80%;">
                        </label>
                        <label class="formulario__label" for="preco_unitario">Preço Unitário:
                            <input type="text" name="preco_unitario" id="preco_unitario" value="<%= pro.getNome() %>" style="width: 80%;">
                        </label>
                    </div>

                <input class="inserir" type="submit" value="Cadastrar" name="cadastrar" />
                <input class="inserir" type="reset" value="Limpar" name="limpar"/>

                </fieldset>
            </form>
            <button class="voltar" onclick="window.history.go(-1)"> VOLTAR</button>
        </div>
    </body>
</html>
