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
/**
 *
 * @author eugen
 */
@WebServlet(name = "acoesProduto", urlPatterns = {"/acoesProduto"})
public class acoesProduto extends HttpServlet {

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
            String busca = request.getParameter("buscar");
            String acao = request.getParameter("opc");
            String[] idSelecionado = request.getParameterValues("selecionado");
            String info = "";

            if (acao != null) {
                if (acao.equals("atualizar")) {
                    try {
                        ComandosProdutos.atualizarProduto(Integer.parseInt(request.getParameter("ID")),
                                request.getParameter("nome"),
                                request.getParameter("descricao"),
                                Integer.parseInt(request.getParameter("unidade")),
                                Float.parseFloat(request.getParameter("preco_unitario")),
                                Integer.parseInt(request.getParameter("IDVelho")));
                        info = "<h1 style='color: blue;'>Atualizado com sucesso.</h1> ";
                    } catch (ClassNotFoundException ex) {
                        info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                    } catch (SQLException ex) {
                        info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                    }
                    request.setAttribute("voltar", "buscarProdutos.jsp");
                    request.setAttribute("info", info);
                    RequestDispatcher despachar = request.getRequestDispatcher("resultado.jsp");
                    despachar.forward(request, response);
                }
                if (acao.equals("inserir")) {
                    try {
                        ComandosProdutos.adicionarProduto(
                                Integer.parseInt(request.getParameter("ID")),
                                request.getParameter("nome"),
                                request.getParameter("descricao"),
                                Integer.parseInt(request.getParameter("unidade")),
                                Float.parseFloat(request.getParameter("preco_unitario")));
                        info = "<h1 style='color: green;'>Produto inserido!!</h1>";
                    } catch (ClassNotFoundException ex) {
                        info = "<h1 style='color: red;'>Falha ao inserir!! " + ex + " </h1> ";
                    } catch (SQLException ex) {
                        info = "<h1 style='color: red;'>Falha ao inserir!! " + ex + " </h1> ";
                    }
                    request.setAttribute("voltar", "buscarProdutos.jsp");
                    request.setAttribute("info", info);
                    RequestDispatcher despachar = request.getRequestDispatcher("resultado.jsp");
                    despachar.forward(request, response);
                }

            } else {

                if (busca == null) {
                    switch (opc) {
                        case "inserir":
                            RequestDispatcher despachar = request.getRequestDispatcher("cadastroProduto.jsp");
                            despachar.forward(request, response);
                            break;
                        case "atualizar":
                            if (idSelecionado == null) {
                                info = "<h1 style='color: red;'>Selecione um produto para atualizar</h1>";
                            } else {
                                if (idSelecionado.length > 1) {
                                    info = "<h1 style='color: yellow;'> Selecione apenas um produto para atualizar!!</h1>";
                                } else {
                                    try {
                                        ComandosProdutos.listaDeProdutos.clear();
                                        ComandosProdutos.ProcurarProduto(idSelecionado[0]);
                                        info = ":: " + ComandosProdutos.listaDeProdutos.get(0);
                                        request.setAttribute("produto", ComandosProdutos.listaDeProdutos.get(0));

                                        request.setAttribute("info", info);
                                        despachar = request.getRequestDispatcher("cadastroProduto.jsp");
                                        despachar.forward(request, response);

                                    } catch (ClassNotFoundException ex) {
                                        info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                                    } catch (SQLException ex) {
                                        info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                                    }
                                }
                            }
                            request.setAttribute("info", info);
                            despachar = request.getRequestDispatcher("buscarProdutos.jsp");
                            despachar.forward(request, response);
                            break;
                        case "excluir":

                            if (idSelecionado == null) {
                                info = "<h1 style='color: red;'>Selecione um ou mais produtos para excluir. </h1>";
                            } else {
                                for (int i = 0; i < idSelecionado.length; i++) {
                                    try {
                                        ComandosProdutos.excluirProduto(idSelecionado[i]);
                                        info = "<h1 style='color: green;'> Exclusão bem sucedida! </h1> ";
                                    } catch (ClassNotFoundException ex) {
                                        info = "<h1 style='color: red;'>Falha ao excluir!! " + ex + " </h1> ";
                                    } catch (SQLException ex) {
                                        info = "<h1 style='color: red;'>Falha ao excluir!! " + ex + " </h1> ";
                                    }

                                }
                            }
                            request.setAttribute("info", info);
                            despachar = request.getRequestDispatcher("buscarProdutos.jsp");
                            despachar.forward(request, response);
                            break;
                        default:
                            throw new AssertionError();
                    }
                } else {
                    ComandosProdutos.listaDeProdutos.clear();
                    try {
                        ComandosProdutos.ProcurarProduto(request.getParameter("Nome"));

                        info = "<h1 style='color: green;'> Busca concluída! </h1> ";
                    } catch (SQLException ex) {
                        info = "<h1 style='color: red;'> Erro na busca! </h1> " + ex;
                    } catch (ClassNotFoundException ex) {
                        info = "<h1 style='color: red;'> Erro na busca! </h1> " + ex;
                    }
                    request.setAttribute("lastResult", ComandosProdutos.LastResultProduto);
                    request.setAttribute("info", info);
                    request.setAttribute("listaDeProduto", ComandosProdutos.listaDeProdutos);
                    RequestDispatcher despachar = request.getRequestDispatcher("buscarProdutos.jsp");
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
