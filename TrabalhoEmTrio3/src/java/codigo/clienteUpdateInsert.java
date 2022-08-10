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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author eugen
 */
@WebServlet(name = "clienteOp", urlPatterns = {"/clienteOp"})
public class clienteUpdateInsert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs


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
            String opc = request.getParameter("opc");
            
            if(opc.contains("inserir")){
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
            }
            if(opc.contains("atualizar")){
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
            }
        } catch (SQLException ex) {
            request.setAttribute("ff", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clienteUpdateInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
            request.setAttribute("mm", request.getParameter("opc"));
            request.setAttribute("ee", request.getParameter("nome"));
            request.setAttribute("tt", ComandosCliente.lastResult);
            RequestDispatcher despachar = request.getRequestDispatcher("resultado.jsp");
            despachar.forward(request, response);
        
        


   
    
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
    
    
    public String formatarData(String data) throws ParseException{
        if(data == null){
            data = "24-04-2001";
        }
        SimpleDateFormat dataf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = dataf.parse(data);
        return dataf.format(dataFormatada);
    }

}
