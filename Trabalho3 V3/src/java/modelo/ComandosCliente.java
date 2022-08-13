/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import util.conexao;
import modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eugen
 */
public class ComandosCliente {

    public static String lastResult;
    public static ArrayList<Cliente> listaDeCliente = new ArrayList<>();

    public static String lastResesult() {
        return lastResult;
    }

    public static void adicionarCliente(String nome, String data_nascimento, String cpf, String rg, String orgao_emissor, String email, String telefone, String whats, String logradouro, String numero, String bairro, String cidade, String estado) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO `clientes` "
                + "( `ID`, `Nome`, `Data_Nascimento`, `CPF`, `RG`, `Orgao_Emissor`, `Email`, `Telefone`, `Whats`, `Logradouro`, `Numero`, `Bairro`, `Cidade`, `Estado`) "
                + " VALUES "
                + "( NULL,?, ?, ?, ?, ?,?, ?, ?, ?,? ,?, ?,?)";

        PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
        pr.setString(1, nome);
        pr.setString(2, data_nascimento);
        pr.setString(3, cpf);
        pr.setString(4, rg);
        pr.setString(5, orgao_emissor);
        pr.setString(6, email);
        pr.setString(7, telefone);
        pr.setString(8, whats);
        pr.setString(9, logradouro);
        pr.setString(10, numero);
        pr.setString(11, bairro);
        pr.setString(12, cidade);
        pr.setString(13, estado);

        pr.executeUpdate();
        lastResult = "Inserir cliente";
        pr.close();
        conexao.sairBanco();

    }

    public static void atualizarCliente(String nome, String data_nascimento, String cpf, String rg, String orgao_emissor, String email, String telefone, String whats, String logradouro, String numero, String bairro, String cidade, String estado, String id) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE `clientes` SET `Nome` = ?, `Data_Nascimento` = ?, `CPF` = ?, `RG` = ?, `Orgao_Emissor` = ?, `Email` = ?, `Telefone` = ?, `Whats` = ?, `Logradouro` = ?, `Numero` = ?, `Bairro` = ?, `Cidade` = ?, `Estado` = ? WHERE `clientes`.`ID` = ?";
        PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
        pr.setString(1, nome);
        pr.setString(2, data_nascimento);
        pr.setString(3, cpf);
        pr.setString(4, rg);
        pr.setString(5, orgao_emissor);
        pr.setString(6, email);
        pr.setString(7, telefone);
        pr.setString(8, whats);
        pr.setString(9, logradouro);
        pr.setString(10, numero);
        pr.setString(11, bairro);
        pr.setString(12, cidade);
        pr.setString(13, estado);
        pr.setString(14, id);

        pr.executeUpdate();
        lastResult = "Atualizar Cliente";
        pr.close();
        conexao.sairBanco();

    }
    
    

    public static boolean verificarCliente(int id) throws ClassNotFoundException, SQLException {
                String sql = "select count(ID) as ff from clientes where ID = " + id + " ;";
            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
            
            ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                lastResult = rs.getString("ff");
                if (rs.getInt("ff") == 1) {
                    pr.close();
                    rs.close();

                    conexao.sairBanco();
                    lastResult = ":D";
                    return true;
                }

            }
            lastResult += ":(" + id;
            pr.close();
            rs.close();
            conexao.sairBanco();
            return false;

        }
    
    
    
   

    public static void procurarCliente(String busca) throws SQLException, ClassNotFoundException {
        try {
            String sql = "select * from clientes"
                    + " where nome like '" + busca + "%';";

            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);

            ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        Integer.parseInt(rs.getString("ID")),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("Nome"),
                        rs.getString("Orgao_emissor"),
                        rs.getString("Data_nascimento"),
                        rs.getString("Email"),
                        rs.getString("Whats"),
                        rs.getString("Telefone"),
                        rs.getString("Logradouro"),
                        rs.getString("Numero"),
                        rs.getString("Bairro"),
                        rs.getString("Cidade"),
                        rs.getString("Estado")
                );
                lastResult = cliente.toString();
                listaDeCliente.add(cliente);

            }

            pr.close();
            rs.close();
            conexao.sairBanco();
        } catch (SQLException ex) {
            lastResult = "False" + ex;
        }
    }

    public static void procurarClienteId(String busca) throws SQLException, ClassNotFoundException {
        try {
            String sql = "select * from clientes"
                    + " where ID = " + busca + ";";

            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);

            ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        Integer.parseInt(rs.getString("ID")),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("Nome"),
                        rs.getString("Orgao_emissor"),
                        rs.getString("Data_nascimento"),
                        rs.getString("Email"),
                        rs.getString("Whats"),
                        rs.getString("Telefone"),
                        rs.getString("Logradouro"),
                        rs.getString("Numero"),
                        rs.getString("Bairro"),
                        rs.getString("Cidade"),
                        rs.getString("Estado")
                );
                lastResult = cliente.toString();
                listaDeCliente.add(cliente);

            }

            pr.close();
            rs.close();
            conexao.sairBanco();
        } catch (SQLException ex) {
            lastResult = "False" + ex;
        }
    }

    public static void excluirCliente(int id) throws ClassNotFoundException, SQLException {
        if (ComandosPedidos.LiberarExclusão(id)) {
            String sql = "delete from clientes where id=" + id + ";";
            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
            try {
                pr.executeUpdate();

            } catch (SQLException ex) {
                ComandosCliente.lastResult = "false excluir" + ex;
            }

            pr.close();
            conexao.sairBanco();
        }
    }

  
}
