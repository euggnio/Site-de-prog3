/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.conexao;

/**
 *
 * @author eugen
 */
public class ComandosProdutos {
public static List<Produto> listaDeProdutos = new ArrayList();
    public static String LastResultProduto;
    
        public static void adicionarProduto(int id,String nome, String descricao, int unidade, float preco_unitario) throws SQLException, ClassNotFoundException{
        
        String sql = "INSERT INTO `produtos` (`ID`, `Nome`, `Descricao`, `Unidade`, `Preco_Unitario`) VALUES (?, ?, ? , ?, ?);";
        
        PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
            pr.setInt(1, id);
            pr.setString(2, nome);
            pr.setString(3, descricao);
            pr.setInt(4, unidade);
            pr.setFloat(5, preco_unitario);

        
  
            pr.executeUpdate();
            LastResultProduto = "Inserido efetuado!";
            pr.close();
            conexao.sairBanco();

        
        
    }
    
     public static void atualizarProduto(int id, String nome, String descricao, int unidade, float preco_unitario, int idVelho) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE `produtos` SET `ID` = ?, `Nome` = ?, `Descricao` = ?, `Unidade` = ?, `Preco_Unitario` = ? WHERE ID = ?;";
        PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
        pr.setInt(1, id);
        pr.setString(2, nome);
        pr.setString(3, descricao);
        pr.setInt(4, unidade);
        pr.setFloat(5, preco_unitario);
        pr.setInt(6, idVelho);        

        
            pr.executeUpdate();
            LastResultProduto = "Atualização efetuada!!!";
            pr.close();
            conexao.sairBanco();

    }
    
    
    //procura usuarios e adiciona na lista
    public static void ProcurarProduto(String busca) throws SQLException, ClassNotFoundException {
        try {
            String sql = "SELECT * FROM `produtos` WHERE nome like '%"+busca+"%';";

            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);

            ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("ID"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        Integer.parseInt(rs.getString("Unidade")),
                        Float.parseFloat(rs.getString("Preco_unitario"))

                );
                LastResultProduto = "Procura efetuada";
                listaDeProdutos.add(produto);

            }

            pr.close();
            rs.close();
            conexao.sairBanco();
        } catch (SQLException ex) {
            LastResultProduto = "Falha " + ex;
        }
    }
    
    
    public static void ProcurarProdutoId(int busca) throws SQLException, ClassNotFoundException {
        try {
            String sql = "SELECT * FROM `produtos` WHERE ID ="+busca+";";

            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);

            ResultSet rs = pr.executeQuery(sql);
            listaDeProdutos.clear();
            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("ID"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        Integer.parseInt(rs.getString("Unidade")),
                        Float.parseFloat(rs.getString("Preco_unitario"))

                );
                LastResultProduto = "Procura efetuada";
                listaDeProdutos.add(produto);

            }

            pr.close();
            rs.close();
            conexao.sairBanco();
        } catch (SQLException ex) {
            LastResultProduto = "Falha " + ex;
        }
    }
    
    public static boolean verificaProduto(int id) throws ClassNotFoundException, SQLException {
                String sql = "select count(ID) as ff from produtos where ID = " + id + " ;";
            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
            
            ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                LastResultProduto = rs.getString("ff");
                if (rs.getInt("ff") == 1) {
                    pr.close();
                    rs.close();

                    conexao.sairBanco();
                    LastResultProduto = ":D";
                    return true;
                }

            }
            LastResultProduto += ":(" + id;
            pr.close();
            rs.close();
            conexao.sairBanco();
            return false;

        }
    public static void excluirProduto(String id) throws ClassNotFoundException, SQLException{
        if(ComandosPedidosHasProdutos.liberaExclusaoPedido(-1, Integer.parseInt(id))){
                    String sql = "delete from produtos where ID=" + id + ";";
            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
            
            LastResultProduto = "excluir efetuado!!";
            pr.executeUpdate();
            pr.close();
            conexao.sairBanco();
        }else{
            LastResultProduto = "excluir com falha ao efetuar!!";
        }
    }

}
