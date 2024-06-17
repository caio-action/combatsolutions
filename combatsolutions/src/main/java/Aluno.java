/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 202304289212
 */
public class Aluno {
    private int id;
    private String nome;
    private String email;
    private boolean ativo;
    
public Aluno(int id, String nome, String email){
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.ativo = true ; // Aluno começa ativo
    }
public int getId(){
    return id;
}
public String getNome(){
    return nome;
}
public String getEmail(){
    return email;
}
public boolean isAtivo(){
    return ativo;
}
public void desativar(){
    this.ativo = false;
}

@Override
    public String toString() {
        return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", ativo=" + ativo + "]";
    }
}

