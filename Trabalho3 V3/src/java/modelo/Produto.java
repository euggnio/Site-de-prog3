/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author eugen
 */
public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private int unidade;
    private float preco_unitario;

    public Produto(int id,String nome, String descricao, int unidade, float preco_unitario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.unidade = unidade;
        this.preco_unitario = preco_unitario;
    }
    
    public Produto(){
        this.nome = "";
        this.descricao = "";
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public float getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }
    
    
    
}
