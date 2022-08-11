/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author eugen
 */
public class conexao {
    
    private static Connection conexaoBD = null;
           
    public static Connection conectarBanco() throws SQLException, ClassNotFoundException{
    Scanner scanner = new Scanner(System.in);
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String bancoUrl = "jdbc:mysql://127.0.0.1/mydb?useTimezone=true&serverTimezone=UTC";
        String bancoLogin = "root";
        String bancoSenha = "";
        
       
            
         Class.forName(myDriver);
         conexaoBD = DriverManager.getConnection(bancoUrl, bancoLogin, bancoSenha);
         
        
        return conexaoBD;
    }
    
    public static void sairBanco() throws SQLException{
        if(conexaoBD != null){
            try {
                
                conexaoBD.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
