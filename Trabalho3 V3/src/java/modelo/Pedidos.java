/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author eugen
 */
public class Pedidos {
    
    //variaveis
    private int numero;
    private String data;
    private float valor_frete;
    private String data_entrega;
    private int clientes_id;
    
    
    //construtor sem o numero do pedido
    public Pedidos(int numero,String data, float valor_frete, String data_entrega, int clientes_id) {
        this.numero = numero;
        this.data = data;
        this.valor_frete = valor_frete;
        this.data_entrega = data_entrega;
        this.clientes_id = clientes_id;
    }
    
    public Pedidos(){
        this.data = "";
        this.data_entrega = "";
    }

 
    
    //gets e sets
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(float valor_frete) {
        this.valor_frete = valor_frete;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public int getClientes_id() {
        return clientes_id;
    }

    public void setClientes_id(int clientes_id) {
        this.clientes_id = clientes_id;
    }
    
    
    
    
    
    
    
}
