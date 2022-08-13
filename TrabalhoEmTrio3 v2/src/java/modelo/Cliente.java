/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author eugen
 */
public class Cliente {
    //variaveis de dados sensiveis
    private int id ;
    private String cpf;
    private String rg;
    private String nome;
    private String orgao_emissor;
    private String datanascimento;
    
    //variaveis de dados de contato
    private String email;
    private String whats;
    private String telefone;
    
    //variaveis de endereço
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    
    
    //construtor

    public Cliente(int id, String cpf, String rg, String nome, String orgao_emissor, String datanascimento, String email, String whats, String telefone, String logradouro, String numero, String bairro, String cidade, String estado) {
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.orgao_emissor = orgao_emissor;
        this.datanascimento = datanascimento;
        this.email = email;
        this.whats = whats;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Cliente() {
        this.id = -1;
        this.cpf = "";
        this.rg = "";
        this.nome = "";
        this.orgao_emissor = "";
        this.datanascimento = "";
        this.email = "";
        this.whats = "";
        this.telefone = "";
        this.logradouro = "";
        this.numero = "";
        this.bairro = "";
        this.cidade = "";
        this.estado = "";
    }

    
    
    //gets e sets

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrgao_emissor() {
        return orgao_emissor;
    }

    public void setOrgao_emissor(String orgao_emissor) {
        this.orgao_emissor = orgao_emissor;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhats() {
        return whats;
    }

    public void setWhats(String whats) {
        this.whats = whats;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return " " + this.id + " " + this.cpf + " " + this.rg + " " + this.nome + " " + this.orgao_emissor + " " + this.datanascimento + " " + this.email + " " + this.whats + " " + this.telefone;
    }
    
    public String listarEndereco(){
        return "Endereço: " + this.logradouro + ", N.: " + this.numero + " , Bairro: " + this.bairro + " em " + this.cidade + " - " + this.estado;
    }
    

    
    
    
}
