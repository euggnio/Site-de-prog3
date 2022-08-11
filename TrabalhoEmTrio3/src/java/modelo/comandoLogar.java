/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.conexao;

/**
 *
 * @author eugen
 */
public class comandoLogar {
    public String lastResultLogar;
    
    public boolean verificarLogin(String username, String password) throws SQLException, ClassNotFoundException{
        String sql = "SELECT count(cpf) as verifi FROM `usuarios` WHERE Username = '"+username+"' and Senha = MD5('"+ password +"');";
       
        PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
        
        ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                lastResultLogar = rs.getString("verifi");
                if(rs.getInt("verifi") == 1){
                        pr.close();      
                        rs.close();
                        
                        conexao.sairBanco();
                        lastResultLogar = ":D";
                    return true;
                }
                
    }
            lastResultLogar += ":(";
    pr.close();      
    rs.close();
    conexao.sairBanco();
    return false;
    
    
   
}
    
}
