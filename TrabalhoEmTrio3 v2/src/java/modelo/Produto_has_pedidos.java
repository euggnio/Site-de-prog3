/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author eugen
 */
public class Produto_has_pedidos {
    
    private int produtos_id;
    private int pedidos_numero;
    private int quantidade;
    private float preco_unitario;
    private String unidade;

    public Produto_has_pedidos(int produtos_id, int pedidos_numero, int quantidade, float preco_unitario, String unidade) {
        this.produtos_id = produtos_id;
        this.pedidos_numero = pedidos_numero;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
        this.unidade = unidade;
        
    }

    public int getProdutos_id() {
        return produtos_id;
    }

    public void setProdutos_id(int produtos_id) {
        this.produtos_id = produtos_id;
    }

    public int getPedidos_numero() {
        return pedidos_numero;
    }

    public void setPedidos_numero(int pedidos_numero) {
        this.pedidos_numero = pedidos_numero;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    
    
}
