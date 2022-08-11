
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package codigo;

import modelo.ComandosCliente;
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

/**
 *
 * @author eugen
 */
@WebServlet(name = "acoesCliente", urlPatterns = {"/acoesCliente"})
public class acoesCliente extends HttpServlet {

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
        String botaoClicado = request.getParameter("botaoClicado");      
        String[] idSelecionado = request.getParameterValues("selecionado");
        String opc = request.getParameter("opc");
        String info = "";
        
        if(opc != null){
                    if(opc.contains("atualizar")){
            
            try{
                    ComandosCliente.atualizarCliente(
                        request.getParameter("nome"),
                        request.getParameter("data_nascimento"),
                        request.getParameter("cpf"),
                        request.getParameter("rg"),
                        request.getParameter("orgao_emissor"),
                        request.getParameter("email"),
                        request.getParameter("telefone"),
                        request.getParameter("whats"),
                        request.getParameter("logradouro"),
                        request.getParameter("numero"),
                        request.getParameter("bairro"),
                        request.getParameter("cidade"),
                        request.getParameter("estado"),
                        request.getParameter("id")
                        );
                    info = "<h1 style='color: green;'>Atualizado com sucesso.</h1> " + ComandosCliente.lastResult;
                }       catch (SQLException ex) { 
                           info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                        } catch (ClassNotFoundException ex) {
                            info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                        }
                request.setAttribute("voltar", "buscarClientes.jsp");
                request.setAttribute("info", info);
                RequestDispatcher despachar = request.getRequestDispatcher("resultado.jsp");
                despachar.forward(request, response);
            }
            if(opc.contains("inserir")){
          
              try {
                  ComandosCliente.adicionarCliente(
                          request.getParameter("nome"),
                          request.getParameter("data_nascimento"),
                          request.getParameter("cpf"),
                          request.getParameter("rg"),
                          request.getParameter("orgao_emissor"),
                          request.getParameter("email"),
                          request.getParameter("telefone"),
                          request.getParameter("whats"),
                          request.getParameter("logradouro"),
                          request.getParameter("numero"),
                          request.getParameter("bairro"),
                          request.getParameter("cidade"),
                          request.getParameter("estado"));
                  info = "<h1 style='color: green;'>Cliente inserido! </h1>";
              } catch (ClassNotFoundException ex) {
                  info = "<h1 style='color: red;'>Erro ao inserir! " +ex + "</h1>";
              } catch (SQLException ex) {
               info = "<h1 style='color: red;'>Erro ao inserir! " +ex + "</h1>";
            }


                    
                request.setAttribute("voltar", "buscarClientes.jsp");
                request.setAttribute("info", info);
                RequestDispatcher despachar = request.getRequestDispatcher("resultado.jsp");
                despachar.forward(request, response);
            }
        }
        else{
        
        
        if(botaoClicado.contains("inserir")){

            RequestDispatcher despachar = request.getRequestDispatcher("cadastroCliente.jsp");
            despachar.forward(request, response);
        }
            
        //se for exclusão call excluirCliente por ID;
        else if(botaoClicado.contains("excluir")){
            if(idSelecionado == null){
                 info = "<h1 style='color: red;'>Selecione um ou mais Clientes para excluir. </h1>";
            }
            else{
                if(idSelecionado.length == 1){
                    try {
                        ComandosCliente.excluirCliente(Integer.parseInt(idSelecionado[0]));
                        info = "<h1 style='color: green;'> Exclusão bem sucedida! </h1> ";
                    } catch (ClassNotFoundException ex) {
                       info = "<h1 style='color: red;'> Exclusão com erro: " +ex+" </h1> ";
                    } catch (SQLException ex) {
                        info = "<h1 style='color: red;'> Exclusão com erro: " +ex+" </h1> ";
                    }
                }
                if(idSelecionado.length >= 2){
                    for (int i = 0; i < idSelecionado.length; i++) {
                         
                        try {
                            ComandosCliente.excluirCliente(Integer.parseInt(idSelecionado[i]));
                       info = "<h1 style='color: green;'> Exclusão bem sucedida! </h1> ";
                    } catch (ClassNotFoundException ex) {
                       info = "<h1 style='color: red;'> Exclusão com erro: " +ex+" </h1> ";
                    } catch (SQLException ex) {
                        info = "<h1 style='color: red;'> Exclusão com erro: " +ex+" </h1> ";
                    }

                    }
                    info = "<h1 style='color: green;'> Exclusão bem sucedida! </h1> ";
            }
            }
            
            request.setAttribute("info", info);
            request.setAttribute("lastResult", ComandosCliente.lastResult);
            RequestDispatcher despachar = request.getRequestDispatcher("buscarClientes.jsp");
            despachar.forward(request, response);
        }
        //se clica em atualizar manda pro index com o select
        else if(botaoClicado.equals("atualizar")){
                            if(idSelecionado == null){
                    info = "<h1 style='color: red;'>Selecione um Cliente para atualizar. </h1>";
                }else{
            for (int i = 0 ; i < ComandosCliente.listaDeCliente.size(); i ++) {
                if(idSelecionado.length > 1){
                    info = "<h1 style='color: red;'>Selecione apenas um Cliente para atualizar. </h1>";
                }else{
                    try {
                        ComandosCliente.listaDeCliente.clear();
                        ComandosCliente.procurarClienteId(idSelecionado[0]);
                        
                        request.setAttribute("cliente", ComandosCliente.listaDeCliente.get(0));
                        request.setAttribute("info", info);
                        request.setAttribute("lastResult", ComandosCliente.lastResult);
                        RequestDispatcher despachar = request.getRequestDispatcher("cadastroCliente.jsp");
                        despachar.forward(request, response);
                        
                                } catch (ClassNotFoundException ex) {
                                    info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                                } catch (SQLException ex) {
                                    info = "<h1 style='color: red;'>Falha ao atualizar!! " + ex + " </h1> ";
                                }
                    
                        request.setAttribute("info", info);
                        request.setAttribute("lastResult", ComandosCliente.lastResult);
                        RequestDispatcher despachar = request.getRequestDispatcher("buscarClientes.jsp");
                        despachar.forward(request, response);
                  
                }
            }
        }
            //busca normal
            request.setAttribute("info", info);
            request.setAttribute("lastResult", ComandosCliente.lastResult);
            RequestDispatcher despachar = request.getRequestDispatcher("buscarClientes.jsp");
            despachar.forward(request, response);
        }
                    request.setAttribute("info", info);
            request.setAttribute("lastResult", ComandosCliente.lastResult);
            RequestDispatcher despachar = request.getRequestDispatcher("buscarClientes.jsp");
            despachar.forward(request, response);
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

    