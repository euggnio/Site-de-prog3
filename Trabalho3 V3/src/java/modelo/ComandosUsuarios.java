/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;



import util.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author eugen
 */
public class ComandosUsuarios {

    public static List<Usuario> listaDeUsuarios = new ArrayList();
    public static String LastResultUsuario;
    
        public static void adicionarUsuario(String cpf, String nome, String Data_nascimento, String Email, String Telefone, String Whats, String Username, String Senha) throws SQLException, ClassNotFoundException{
        
        String sql = "INSERT INTO `usuarios` "
                + " (`CPF`, `Nome`, `Data_Nascimento`, `Email`, `Telefone`, `Whats`, `Username`, `Senha`) "
                + " VALUES "
                + " (?, ?, ?, ?, ?, ?,?,MD5(?));";
        
        PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
        pr.setString(1, cpf);
        pr.setString(2, nome);
        pr.setString(3, Data_nascimento);
        pr.setString(4, Email);
        pr.setString(5, Telefone);
        pr.setString(6, Whats);
        pr.setString(7, Username);
        pr.setString(8, Senha);

        
  
            pr.executeUpdate();
            LastResultUsuario = "Inserido efetuado!";
            pr.close();
            conexao.sairBanco();

        
        
    }
    
     public static void atualizarUsuario(String cpf, String nome, String Data_nascimento, String Email, String Telefone, String Whats, String Username, String Senha) throws SQLException, ClassNotFoundException{
        
        String sql = "UPDATE `usuarios` SET `CPF` = ?, `Nome` = ?, `Data_Nascimento` = ?, `Email` = ?, `Telefone` =?, `Whats` = ?, `Username` = ?, `Senha` = ? WHERE `usuarios`.`CPF` = ? ;";
        PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
        pr.setString(1, cpf);
        pr.setString(2, nome);
        pr.setString(3, Data_nascimento);
        pr.setString(4, Email);
        pr.setString(5, Telefone);
        pr.setString(6, Whats);
        pr.setString(7, Username);
        pr.setString(8, Senha);
        pr.setString(9, cpf);
        
            pr.executeUpdate();
            LastResultUsuario = "Atualização efetuada!!!";
            pr.close();
            conexao.sairBanco();

    }
    
    
    //procura usuarios e adiciona na lista
    public static void ProcurarUsuario(String busca) throws SQLException, ClassNotFoundException {
        try {
            String sql = "select * from usuarios"
                    + " where CPF like '" + busca + "%';";

            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);

            ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("CPF"),
                        rs.getString("Nome"),
                        rs.getString("Data_nascimento"),
                        rs.getString("Email"),
                        rs.getString("Telefone"),
                        rs.getString("Whats"),
                        rs.getString("Username"),
                        rs.getString("Senha")
                );
                LastResultUsuario = usuario.toString();
                listaDeUsuarios.add(usuario);

            }

            pr.close();
            rs.close();
            conexao.sairBanco();
        } catch (SQLException ex) {
            LastResultUsuario = "Falha " + ex;
        }
    }
    
    public static void excluirCliente(String cpf) throws ClassNotFoundException, SQLException{
                    String sql = "delete from usuarios where cpf=" + cpf + ";";
            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
            
            LastResultUsuario = "excluir efetuado!!";
            pr.executeUpdate();
            pr.close();
            conexao.sairBanco();
    }

}
