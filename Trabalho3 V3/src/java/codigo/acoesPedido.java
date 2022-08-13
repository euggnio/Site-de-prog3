/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package codigo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ComandosProdutos;
import modelo.ComandosPedidos;

import modelo.ComandosCliente;
import modelo.ComandosPedidosHasProdutos;

/**
 *
 * @author eugen
 */
@WebServlet(name = "acoesPedidos", urlPatterns = {"/acoesPedidos"})
public class acoesPedido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String opc = request.getParameter("botaoClicado");
            String numero = request.getParameter("numero");
            String acao = request.getParameter("opc");
            String[] idSelecionado = request.getParameterValues("selecionado");
            String info = "";
            String retorno = "index.html";
            if(numero == ""){
               numero = "0" ;
            }

            if (acao != null) {
                if (acao.equals("atualizar")) {
                    try {
                        ComandosPedidos.atualizarPedido(Integer.parseInt(request.getParameter("numero")),
                                request.getParameter("data"),
                                Float.parseFloat(request.getParameter("valor_frete")),
                                request.getParameter("data_entrega"),
                                Integer.parseInt(request.getParameter("cliente_id")));
                        info = "<h1 style='color: blue;'>Atualizado com sucesso.</h1> ";
                        retorno = "buscarPedidos.jsp";
                    } catch (ClassNotFoundException | SQLException ex) {
                        info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                        retorno = "cadastroPedidos.jsp";
                    }
                    request.setAttribute("voltar", retorno);
                    request.setAttribute("info", info);
                    RequestDispatcher despachar = request.getRequestDispatcher("resultado.jsp");
                    despachar.forward(request, response);
                }
                if (acao.equals("inserir")) {
                    try {
                        if (ComandosPedidos.verificarPedido(Integer.parseInt(request.getParameter("numero")))) {
                            if (ComandosCliente.verificarCliente(Integer.parseInt(request.getParameter("cliente_id")))) {
                                if (ComandosProdutos.verificaProduto(Integer.parseInt(request.getParameter("idProduto")))) {

                                    ComandosPedidos.adicionarPedido(Integer.parseInt(request.getParameter("numero")),
                                            request.getParameter("data"),
                                            Float.parseFloat(request.getParameter("valor_frete")),
                                            request.getParameter("data_entrega"),
                                            Integer.parseInt(request.getParameter("cliente_id")),
                                            Integer.parseInt(request.getParameter("idProduto")),
                                            Integer.parseInt(request.getParameter("quantidade"))
                                    );
                                    info = "<h1 style='color: green;'>Pedidos inserido!!</h1>" + ComandosPedidos.lastResultPedido;
                                    retorno = "buscarPedidos.jsp";
                                }else {
                                    info = "<h1 style='color: red;'>Inserido > falha produto ID não encontrado! procure o id do produto na tabela de produtos<br /> "
                                            + " <button id=\"botao_processamento\"><a href=\"buscarProdutos.jsp\">BUSCAR PEDIDOS</a></button></h1>";
                                    retorno = "cadastroPedidos.jsp";
                                }
                            }else {
                                info = "<h1 style='color: red;'>Inserido > falha cliente ID não encontrado! procure o id do cliente na tabela clientes<br /> "
                                        + " <button id=\"botao_processamento\"><a href=\"buscarClientes.jsp\">BUSCAR CLIENTES</a></button></h1>";
                                retorno = "cadastroPedidos.jsp";
                            }
                        }else{
                            info = "<h1 style='color: red;'>Inserido > falha pedido ID já encontrado no banco de dados, use outro ID.<br /> ";
                            retorno = "cadastroPedidos.jsp";
                                      
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        info = "<h1 style='color: red;'>Falha ao inserir!! " + ex + " </h1> ";
                        retorno = "cadastroPedidos.jsp";
                    }
                    request.setAttribute("voltar", retorno);
                    request.setAttribute("info", info);
                    RequestDispatcher despachar = request.getRequestDispatcher("resultado.jsp");
                    despachar.forward(request, response);
                }

            } else {

                if (numero == null) {
                    switch (opc) {
                        case "inserir":
                            RequestDispatcher despachar = request.getRequestDispatcher("cadastroPedidos.jsp");
                            despachar.forward(request, response);
                            break;
                        case "atualizar":
                            if (idSelecionado == null) {
                                info = "<h1 style='color: red;'>Selecione um Pedido para atualizar</h1>";
                            } else {
                                if (idSelecionado.length > 1) {
                                    info = "<h1 style='color: yellow;'> Selecione apenas um Pedido para atualizar!!</h1>";
                                } else {
                                    try {
                                        ComandosPedidos.listaDePedidos.clear();
                                        ComandosPedidos.ProcurarPedido(Integer.parseInt(idSelecionado[0]));
                                        info = ":: " + ComandosPedidos.listaDePedidos.get(0);
                                        request.setAttribute("Pedidos", ComandosPedidos.listaDePedidos.get(0));

                                        request.setAttribute("info", info);
                                        despachar = request.getRequestDispatcher("cadastroPedidos.jsp");
                                        despachar.forward(request, response);
 
                                    } catch (ClassNotFoundException ex) {
                                        info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                                    } catch (SQLException ex) {
                                        info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                                    }
                                }
                            }
                            request.setAttribute("info", info);
                            despachar = request.getRequestDispatcher("buscarPedidos.jsp");
                            despachar.forward(request, response);
                            break;
                        case "excluir":

                            if (idSelecionado == null) {
                                info = "<h1 style='color: red;'>Selecione um ou mais Pedidos para excluir. </h1>";
                            } else {
                                for (int i = 0; i < idSelecionado.length; i++) {
                                    try {
                                        ComandosPedidos.excluirPedido(Integer.parseInt(idSelecionado[i]));
                                        info = "<h1 style='color: green;'> Exclusão bem sucedida! </h1> ";
                                    } catch (ClassNotFoundException ex) {
                                        info = "<h1 style='color: red;'>Falha ao excluir!! " + ex + " </h1> ";
                                    } catch (SQLException ex) {
                                        info = "<h1 style='color: red;'>Falha ao excluir!! " + ex + " </h1> ";
                                    }

                                }
                            }
                            request.setAttribute("info", info);
                            despachar = request.getRequestDispatcher("buscarPedidos.jsp");
                            despachar.forward(request, response);
                            break;
                        default:
                            throw new AssertionError();
                    }
                } else {

                    try {
                        ComandosPedidos.listaDePedidos.clear();
                        ComandosPedidos.ProcurarPedido(Integer.parseInt(numero));
                        ComandosPedidosHasProdutos.bucarPedidosHasProducts();
     
                        
                        
                        info = "<h1 style='color: green;'> Busca concluída! </h1> ";
                    } catch (SQLException ex) {
                        info = "<h1 style='color: red;'> Erro na busca! </h1> " + ex;
                    } catch (ClassNotFoundException ex) {
                        info = "<h1 style='color: red;'> Erro na busca! </h1> " + ex;
                    }
                    request.setAttribute("lastResult", ComandosPedidos.lastResultPedido);
                    request.setAttribute("info", info);
                    request.setAttribute("listaDePedidos", ComandosPedidos.listaDePedidos);
                    request.setAttribute("listaPHP", ComandosPedidosHasProdutos.prodHasPedLista);
                    RequestDispatcher despachar = request.getRequestDispatcher("buscarPedidos.jsp");
                    despachar.forward(request, response);
                }
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
