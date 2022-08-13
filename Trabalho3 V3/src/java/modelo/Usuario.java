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
public class Usuario {
    
    private String cpf;
    private String nome;
    private String data_nascimento;
    private String email;
    
    private String telefone;
    private String whats;
    
    private String username;
    private String senha;

    public Usuario(String cpf, String nome, String data_nascimento, String email, String telefone, String whats, String username, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.telefone = telefone;
        this.whats = whats;
        this.username = username;
        this.senha = senha;
    }
    
    public Usuario(){
                this.cpf = "";
        this.nome = "";
        this.data_nascimento = "";
        this.email = "";
        this.telefone = "";
        this.whats = "";
        this.username = "";
        this.senha = "";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getWhats() {
        return whats;
    }

    public void setWhats(String whats) {
        this.whats = whats;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cpf=" + cpf + ", nome=" + nome + ", data_nascimento=" + data_nascimento + ", email=" + email + ", telefone=" + telefone + ", whats=" + whats + ", username=" + username + ", senha=" + senha + '}';
    }
    
    
    
}
