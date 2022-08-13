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
public class ComandosPedidosHasProdutos {
    public static String lastResultPedHasProd = "";
    public static List<Produto_has_pedidos> prodHasPedLista = new ArrayList<>();
    
    public static boolean liberaExclusaoPedido(int pedidoId, int produtoId) throws SQLException, ClassNotFoundException{
        if(produtoId > -1 || pedidoId > -1){
        String sql = "DELETE FROM `produtos_has_pedidos` WHERE `produtos_has_pedidos`.`Produtos_ID` = ?  or `produtos_has_pedidos`.`Pedidos_Numero` = ?;";
        PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
        pr.setInt(1, produtoId);
        pr.setInt(2, pedidoId);
        
            lastResultPedHasProd = "excluir efetuado!!";
            pr.executeUpdate();
            pr.close();
            conexao.sairBanco();
            return true;
            
        
        
    }
        else{
            lastResultPedHasProd = "excluir falha!!";
            return false;
        } 
    }
    
    public static void bucarPedidosHasProducts() throws ClassNotFoundException{
            try {
            prodHasPedLista.clear();
            String sql = "SELECT * FROM `produtos_has_pedidos`";
            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);

            ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                Produto_has_pedidos pro = new Produto_has_pedidos(rs.getInt("Produtos_ID"),
                        rs.getInt("Pedidos_Numero"),
                        rs.getInt("Quantidade"),
                        rs.getFloat("Preco_Unitario"),
                        rs.getString("Unidade")
                );
                lastResultPedHasProd = "Procura efetuada";
                prodHasPedLista.add(pro);

            }

            pr.close();
            rs.close();
            conexao.sairBanco();
        } catch (SQLException ex) {
            lastResultPedHasProd = "Falha " + ex;
        }
    }
    
}
