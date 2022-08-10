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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String botaoClicado = request.getParameter("botaoClicado");      
        String[] idSelecionado = request.getParameterValues("selecionado");
        String info = "";
        
        if(botaoClicado.contains("inserir")){

            RequestDispatcher despachar = request.getRequestDispatcher("index.jsp");
            despachar.forward(request, response);
        }
            
        //se for exclusão call excluirCliente por ID;
        else if(botaoClicado.contains("excluir")){
            if(idSelecionado == null){
                info = "Selecione um cliente ou mais para excluir!!!";
            }
            else{
                if(idSelecionado.length == 1){
                    ComandosCliente.excluirCliente(Integer.parseInt(idSelecionado[0]));
                     info ="Clientes excluidos com sucesso!!!";
                }
                if(idSelecionado.length >= 2){
                    for (int i = 0; i < idSelecionado.length; i++) {
                         info ="Clientes excluidos com sucesso!!!";
                        ComandosCliente.excluirCliente(Integer.parseInt(idSelecionado[i]));

                    }
            }
            }
            
            request.setAttribute("Info", info);
            request.setAttribute("lastResult", ComandosCliente.lastResult);
            RequestDispatcher despachar = request.getRequestDispatcher("buscarClientes.jsp");
            despachar.forward(request, response);
        }
        //se clica em atualizar manda pro index com o select
        else if(botaoClicado.contains("atualizar")){
                            if(idSelecionado == null){
                    info = "Selecione algum cliente para atualizar";
                }else{
            for (int i = 0 ; i < ComandosCliente.listaDeCliente.size(); i ++) {
                if(idSelecionado.length > 1){
                    info = "Selecione apenas 1 cliente para atualizar!!!";
                }else{
                if(Integer.parseInt(idSelecionado[0]) == ComandosCliente.listaDeCliente.get(0).getId()){
                    
                    request.setAttribute("cliente", ComandosCliente.listaDeCliente.get(0));
                    request.setAttribute("Info", info);
                    request.setAttribute("lastResult", ComandosCliente.lastResult);
                    RequestDispatcher despachar = request.getRequestDispatcher("index.jsp");
                    despachar.forward(request, response);
                  }
                }
            }
        }
            //busca normal
            request.setAttribute("Info", info);
            request.setAttribute("lastResult", ComandosCliente.lastResult);
            RequestDispatcher despachar = request.getRequestDispatcher("buscarClientes.jsp");
            despachar.forward(request, response);
        }
                    request.setAttribute("Info", info);
            request.setAttribute("lastResult", ComandosCliente.lastResult);
            RequestDispatcher despachar = request.getRequestDispatcher("buscarClientes.jsp");
            despachar.forward(request, response);
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
                        
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(acoesCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(acoesCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
