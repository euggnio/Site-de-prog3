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
@WebServlet(name = "listarClientes", urlPatterns = {"/listarClientes"})
public class listarClientes extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
              ComandosCliente.listaDeCliente.clear();
            ComandosCliente.procurarCliente(request.getParameter("nome"));
                       
        } catch (SQLException ex) {
            Logger.getLogger(listarClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            request.setAttribute("listaDeClientes", ComandosCliente.listaDeCliente);
            request.setAttribute("lastResult", ComandosCliente.lastResult);
            RequestDispatcher despachar = request.getRequestDispatcher("buscarClientes.jsp");
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

}
