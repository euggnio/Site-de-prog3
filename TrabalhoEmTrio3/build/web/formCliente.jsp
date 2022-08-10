<%-- 
    Document   : form_cliente
    Created on : 15 de jul. de 2022, 11:31:56
    Author     : SAMSUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="topo.jsp" %>

            <!--MAIN-->
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Cadastro de Cliente</h1>
				</div>
				<br>
                                <%
                                    if(resquest.getAttribute("inserir_" != 1)){
                                    Cliente cli = (Cliente) request.getAttribute("cliente");
                                    String acao = "ATUALIZAR";
                                    
                                    if (cli == null) {
                                        cli = new Cliente();
                                        acao = "INSERIR";
                                    }
                                    }
                                %>
				<form action="ClienteSalvarServlet" id="formulario" method="post">
                                    <input  type="hidden" name="acao" value="<%= acao %>">
					<div class="form-group" id="dados-identificacao">
						<fieldset class="field-block form-control form-group">
							<legend class="form-control">Dados do Cliente</legend>
							<div class="form-row">
								<div class="form-group col-3">
									<label for="cpf">CPF:</label>
									<input name="cpf" id="cpf" value="<%= cli.getCpf()%>" type="text" maxlength="11" class="form-control"/>
								</div>
								<div class="form-group col">
									<label for="nome">Nome:</label>
									<input name="nome" id="nome" value="<%= cli.getNome()%>" type="text" maxlength="100" class="form-control"/>
								</div>
                                                                <div class="form-group col-3">
									<label for="telefone">Telefone:</label>
									<input name="telefone" id="telefone" value="<%= cli.getTelefone()%>" type="text" maxlength="20" class="form-control"/>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col">
                                                                    <label for="endereco">Endereço:</label><br>
                                                                    <textarea name="endereco" id="endereco" rows="3" cols="150" class="form-control"><%= cli.getEndereco()%></textarea>
								</div>
							</div>
						</fieldset>
					</div>
					<br>
					<div class="text-center mb-5">
						<input type="submit" id="acao" name="botao" class="btn-primary btn" value="Salvar">
						<input type="submit" id="acao" name="botao" class="btn-primary btn" value="Cancelar">
					</div>
				</form>
            </main>
            <!--END MAIN-->

<%@include file="rodape.jsp" %>