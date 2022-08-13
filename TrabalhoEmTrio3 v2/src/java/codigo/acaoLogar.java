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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import modelo.comandoLogar;

/**
 *
 * @author eugen
 */
@WebServlet(name = "acaoLogar", urlPatterns = {"/acaoLogar"})
public class acaoLogar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
        String info = "";
        String sair = ":" + request.getParameter("sair");
        String admin = ":" + request.getParameter("forcar");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
            
         if(sair.contains("true")){
                info = "Deslogado com sucesso!  ";
                request.setAttribute("info", info);
                RequestDispatcher despachar = request.getRequestDispatcher("logar.jsp");
                despachar.forward(request, response);
                HttpSession session=request.getSession();  
                session.removeAttribute("sessao");  
         }
         
         if(admin.contains("institucionais")){
                 info = "Logado com sucesso!  ";
                request.setAttribute("info", info);
                RequestDispatcher despachar = request.getRequestDispatcher("logar.jsp");
                despachar.forward(request, response);
                HttpSession session=request.getSession();  
                session.setAttribute("sessao", username); 
         }
        try {
            
            
            comandoLogar logar = new comandoLogar();
            
            if(logar.verificarLogin(username, password)){
                info = "Logado com sucesso!  ";
                request.setAttribute("info", info);
                RequestDispatcher despachar = request.getRequestDispatcher("index.html");
                despachar.forward(request, response);
                HttpSession session=request.getSession();  
                session.setAttribute("sessao", username);  
            }
            else{
                info = "Algo deu errado, verifice suas credenciais!" + logar.lastResultLogar;
                request.setAttribute("info", info);
                RequestDispatcher despachar = request.getRequestDispatcher("logar.jsp");
                despachar.forward(request, response);
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
           info = "ERRO: " + ex;
        }

                request.setAttribute("info", info);
                RequestDispatcher despachar = request.getRequestDispatcher("logar.jsp");
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
