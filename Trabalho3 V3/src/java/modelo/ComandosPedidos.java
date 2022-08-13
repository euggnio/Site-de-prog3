package modelo;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static modelo.ComandosProdutos.LastResultProduto;
import util.conexao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author eugen
 */
public class ComandosPedidos {


        public static List<Pedidos> listaDePedidos = new ArrayList();
        public static String lastResultPedido;
        
       
    public static boolean LiberarExclusão(int clienteID) throws SQLException, ClassNotFoundException {
        if (clienteID > -1) {
            String sql = "DELETE FROM `pedidos` WHERE `pedidos`.`Clientes_ID` = ?;";
            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
            pr.setInt(1, clienteID);

            lastResultPedido = "excluir efetuado!!";
            pr.executeUpdate();
            pr.close();
            conexao.sairBanco();
            return true;

        }
        return true;
    }
        
        public static void addPedidoHasProdutos(int idProduto, int idPedido, int quantidade, int unidade) throws SQLException, ClassNotFoundException{
            ComandosProdutos.ProcurarProdutoId(idProduto);
            float preco = ComandosProdutos.listaDeProdutos.get(0).getPreco_unitario();
            String sql = "INSERT INTO `produtos_has_pedidos` (`Produtos_ID`, `Pedidos_Numero`, `Quantidade`, `Preco_Unitario`, `Unidade`) VALUES (? , ?, ?,?, ?)";
            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
                pr.setInt(1, idProduto);
                pr.setInt(2, idPedido);
                pr.setInt(3, quantidade);
                pr.setFloat(4, preco);
                pr.setInt(5, unidade);
                
      
                pr.execute();
                lastResultPedido = "Inserido efetuado!";
                pr.close();
                conexao.sairBanco();

        }
            
        public static void adicionarPedido(int numero,String data, float valor_frete, String data_entrega, int clientes_id,int idProduto, int quantidade) throws SQLException, ClassNotFoundException {
            if(ComandosCliente.verificarCliente(clientes_id) && ComandosProdutos.verificaProduto(idProduto)){
                String sql = "INSERT INTO `pedidos` (`Numero`, `Data_Emissao`, `Valor_Frete`, `Data_Entrega`, `Clientes_ID`) VALUES (? , ?, ?, ?, ?)";
                PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
                pr.setInt(1, numero);
                pr.setString(2, data);
                pr.setFloat(3, valor_frete);
                pr.setString(4, data_entrega);
                pr.setInt(5, clientes_id);
                
                
                

            pr.executeUpdate();
            lastResultPedido = "Inserido efetuado!";
            pr.close();
            conexao.sairBanco();
            
            addPedidoHasProdutos(idProduto, numero, quantidade, quantidade);
            }else{
                
                lastResultPedido = "Inserido > falha cliente ou produto não encontrado!";
            }
        }

        public static void atualizarPedido(int numero,String data, float valor_frete, String data_entrega, int clientes_id) throws SQLException, ClassNotFoundException {
           String sql = "UPDATE `pedidos` SET `Numero` = ?, `Data_emissao` = ?, `Valor_frete` = ?, `Data_entrega` = ?, `Clientes_ID` = ? WHERE Numero = ?;";
            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
            pr.setInt(1, numero);
            pr.setString(2, data);
            pr.setFloat(3, valor_frete);
            pr.setString(4, data_entrega);
            pr.setInt(5, clientes_id);
            pr.setInt(6, numero);

            pr.executeUpdate();
            lastResultPedido = "Atualização efetuada!!!";
            pr.close();
            conexao.sairBanco();

        }

        //procura usuarios e adiciona na lista
        public static void ProcurarPedido(int busca) throws SQLException, ClassNotFoundException {
            try {
                String sql;
                if(busca > 0){
                 sql = "SELECT * FROM `pedidos` WHERE numero = "+ busca +";";
                }else{
                     sql = "SELECT * FROM `pedidos`;";
                }

                PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);

                ResultSet rs = pr.executeQuery(sql);
                while (rs.next()) {
                    Pedidos pedidos = new Pedidos(rs.getInt("Numero"),
                            rs.getString("Data_Emissao"),
                            rs.getFloat("Valor_Frete"),
                            rs.getString("Data_entrega"),
                            rs.getInt("Clientes_ID")
                    );
                    lastResultPedido = "Procura efetuada";
                    listaDePedidos.add(pedidos);

                }

                pr.close();
                rs.close();
                conexao.sairBanco();
            } catch (SQLException ex) {
                lastResultPedido = "Falha na procura " + ex;
            }
        }
        
         public static boolean verificarPedido(int numero) throws ClassNotFoundException, SQLException {
            String sql = "select count(Numero) as ff from pedidos where Numero = " + numero + " ;";
            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);
            
            ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                LastResultProduto = rs.getString("ff");
                if (rs.getInt("ff") == 1) {
                    pr.close();
                    rs.close();

                    conexao.sairBanco();
                    LastResultProduto = ":D";
                    return false;
                }

            }
            LastResultProduto += ":(" + numero;
            pr.close();
            rs.close();
            conexao.sairBanco();
            return true;

        }
        
        

        public static void excluirPedido(int numero) throws ClassNotFoundException, SQLException {
            
            if(ComandosPedidosHasProdutos.liberaExclusaoPedido(numero, -1)){
            String sql = "delete from pedidos where numero=" + numero + ";";
            PreparedStatement pr = conexao.conectarBanco().prepareStatement(sql);

            lastResultPedido = "excluir efetuado!!";
            
            pr.executeUpdate();
            pr.close();
            conexao.sairBanco();
        }else{
                lastResultPedido = "excluir falha ao efetuar!!";
            }
        }
        

    }


