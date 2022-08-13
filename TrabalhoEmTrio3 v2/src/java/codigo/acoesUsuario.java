/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package codigo;

import modelo.ComandosUsuarios;
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
import modelo.Usuario;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eugen
 */
@WebServlet(name = "acoesUsuario", urlPatterns = {"/acoesUsuario"})
public class acoesUsuario extends HttpServlet {

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
        String opc = request.getParameter("botaoClicado");
        String busca = request.getParameter("buscar");
        String acao = request.getParameter("opc");
        String[] idSelecionado = request.getParameterValues("selecionado");
        String info = "";

        if (acao != null) {
            if (acao.equals("atualizar")) {
                try {
                    ComandosUsuarios.atualizarUsuario(request.getParameter("cpf"),
                            request.getParameter("nome"),
                            request.getParameter("data_nascimento"),
                            request.getParameter("email"),
                            request.getParameter("telefone"),
                            request.getParameter("whats"),
                            request.getParameter("username"),
                            request.getParameter("senha"));
                    info = "<h1 style='color: blue;'>Atualizado com sucesso.</h1> ";
                } catch (ClassNotFoundException ex) {
                    info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                } catch (SQLException ex) {
                    info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                }
                request.setAttribute("voltar", "buscarUsuarios.jsp");
                request.setAttribute("info", info);
                RequestDispatcher despachar = request.getRequestDispatcher("resultado.jsp");
                despachar.forward(request, response);
            }
            if (acao.equals("inserir")) {
                try {
                    ComandosUsuarios.adicionarUsuario(request.getParameter("cpf"),
                            request.getParameter("nome"),
                            request.getParameter("data_nascimento"),
                            request.getParameter("email"),
                            request.getParameter("telefone"),
                            request.getParameter("whats"),
                            request.getParameter("username"),
                            request.getParameter("senha"));
                    info = "<h1 style='color: green;'>Usuario inserido!!</h1>";
                } catch (ClassNotFoundException ex) {
                    info = "<h1 style='color: red;'>Falha ao inserir!! " + ex + " </h1> ";
                } catch (SQLException ex) {
                    info = "<h1 style='color: red;'>Falha ao inserir!! " + ex + " </h1> ";
                }
                request.setAttribute("voltar", "buscarUsuarios.jsp");
                request.setAttribute("info", info);
                RequestDispatcher despachar = request.getRequestDispatcher("resultado.jsp");
                despachar.forward(request, response);
            }

        } else {

            if (busca == null) {
                switch (opc) {
                    case "inserir":
                        RequestDispatcher despachar = request.getRequestDispatcher("cadastroUsuario.jsp");
                        despachar.forward(request, response);
                        break;
                    case "atualizar":
                        if (idSelecionado == null) {
                            info = "<h1 style='color: red;'>Selecione um CPF para atualizar</h1>";
                        } else {
                            if (idSelecionado.length > 1) {
                                info = "<h1 style='color: yellow;'> Selecione apenas um CPF para atualizar!!</h1>";
                            } else {
                                try {
                                    ComandosUsuarios.listaDeUsuarios.clear();
                                    ComandosUsuarios.ProcurarUsuario(idSelecionado[0]);
                                    info = ":: " + ComandosUsuarios.listaDeUsuarios.get(0);
                                    request.setAttribute("usuario", ComandosUsuarios.listaDeUsuarios.get(0));

                                    request.setAttribute("info", info);
                                    despachar = request.getRequestDispatcher("cadastroUsuario.jsp");
                                    despachar.forward(request, response);

                                } catch (ClassNotFoundException ex) {
                                    info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                                } catch (SQLException ex) {
                                    info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                                }
                            }
                        }
                        request.setAttribute("info", info);
                        despachar = request.getRequestDispatcher("buscarUsuarios.jsp");
                        despachar.forward(request, response);
                        break;
                    case "excluir":

                        if (idSelecionado == null) {
                            info = "<h1 style='color: red;'>Selecione um ou mais CPF's para excluir o usuario </h1>";
                        } else {
                            for (int i = 0; i < idSelecionado.length; i++) {
                                try {
                                    ComandosUsuarios.excluirCliente(idSelecionado[i]);
                                    info = "<h1 style='color: green;'> Exclusão bem sucedida! </h1> ";
                                } catch (ClassNotFoundException ex) {
                                    info = "<h1 style='color: red;'>Falha ao excluir!! " + ex + " </h1> ";
                                } catch (SQLException ex) {
                                    info = "<h1 style='color: red;'>Falha ao excluir!! " + ex + " </h1> ";
                                }

                            }
                        }
                        request.setAttribute("info", info);
                        despachar = request.getRequestDispatcher("buscarUsuarios.jsp");
                        despachar.forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
            } else {
                ComandosUsuarios.listaDeUsuarios.clear();
                try {
                    ComandosUsuarios.ProcurarUsuario(request.getParameter("nome"));

                    info = "<h1 style='color: green;'> Busca concluída! </h1> ";
                } catch (SQLException ex) {
                    info = "<h1 style='color: red;'> Busca concluída! </h1> " + ex;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(acoesUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lastResult", ComandosUsuarios.LastResultUsuario);
                request.setAttribute("info", info);
                request.setAttribute("listaDeUsuario", ComandosUsuarios.listaDeUsuarios);
                RequestDispatcher despachar = request.getRequestDispatcher("buscarUsuarios.jsp");
                despachar.forward(request, response);
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
