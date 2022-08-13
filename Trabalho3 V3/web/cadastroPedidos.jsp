<%-- 
    Document   : cadastrarProduto
    Created on : 11 de ago. de 2022, 00:04:29
    Author     : eugen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Pedidos" %>
<!DOCTYPE html>
<html>
    
 
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coala's Pizzas</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <script src="scripts/validarPedido.js" type="text/javascript"></script>
    </head>
    <body>

        <%@include file="header.jsp" %> 
        <div class="conteudo">
            <h1 class="conteudo_title">Cadastro de Pedido</h1>
            <form class="formulario" action="acoesPedidos" method="post"  onsubmit="return validarPedido();">

                <%         
                            Pedidos pro = (Pedidos) request.getAttribute("Pedidos");
                            String opc = "atualizar";
                            String readornot = "readonly";
                            if (pro == null) {
                            readornot = "required";
                            pro = new Pedidos();
                            opc = "inserir";
                        }
                %>
                <input type="hidden" name="opc" value="<%= opc %>">
                <input type="hidden" name="IDVelho" value="<%=pro.getNumero()%>">
                <fieldset>
                    <legend><h4>Dados do pedido</h4></legend>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="numero">Número do pedido:
                            <input type="text" name="numero" id="numero" value="<%= pro.getNumero() %>" <%= readornot %> style="width: 10%;">
                        </label>


                    </div>

                    <div class="formulario__campos">
                        <label class="formulario__label" for="data_emissao">Data de emissão
                            
                            <input type="date" name="data" id="data" value="<%= pro.getData() %>" style="width: 80%;">
                            
                            <script>
                            document.getElementById('data').valueAsDate = new Date();
                            </script>
                            
                        </label>
                        <label class="formulario__label" for="valor_frete">Valor do Frete
                            <input type="text" name="valor_frete" id="valor_frete" value="<%= pro.getValor_frete() %>"style="width: 80%;">
                        </label>

                    </div>
                    <div class="formulario__campos">
                        <label class="formulario__label" for="data_entrega">Data para entrega
                            <input type="date" name="data_entrega" id="data_entrega" value="<%= pro.getData_entrega() %>" style="width: 80%;">
                        </label>
                        <label class="formulario__label" for="cliente_id">ID do cliente
                            <input type="text" name="cliente_id" id="cliente_id" value="<%= pro.getClientes_id() %>" style="width: 80%;">
                        </label>
                    </div>
                        <h4>Produto </h4>
                        <input type="hidden" value="1" id="quant" name="quant">
                        
                    <div class="formulario__campos">
                        <label class="formulario__label" for="idProduto"> ID do produto
                            <input type="text" name="idProduto" id="idProduto" value="" required style="width: 80%;">
                        </label>
                        <label class="formulario__label" for="quantidade">Quantidade:
                            <input type="text" name="quantidade" id="quantidade" value="" style="width: 80%;">
                        </label>
                    </div>
                    
               

                <input class="inserir" type="submit" value="Cadastrar" name="cadastrar" />
                <input class="inserir" type="reset" value="Limpar" name="limpar"/>

                </fieldset>
            </form>
        </div>
    </body>
</html>
