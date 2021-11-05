package br.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JuniorMartins
 */
public class JogadorEntity 
{
    // -------------------- ATRIBUTOS DE CLASSE -------------------- //
    public static List<JogadorEntity> lista = new ArrayList<>();;
    
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    private String cpf;
    private String nome;
    private int pontos;
    
    // -------------------- CONSTRUTORES -------------------- //
    public JogadorEntity(){}
    public JogadorEntity(String cpf, String nome)
    {
        this.cpf = cpf;
        this.nome = nome;
    }

    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public String getCpf() 
    {return cpf;}
    public void setCpf(String cpf) 
    {this.cpf = cpf;}
    public String getNome() 
    {return nome;}
    public void setNome(String nome) 
    {this.nome = nome;}
    public int getPontos() 
    {return pontos;}
    public void setPontos(int pontos) 
    {this.pontos = pontos;}

    // -------------------- MÉTODOS SOBRESCRITOS -------------------- //

    @Override
    public String toString() {
        return "JogadorEntity{" + "cpf=" + cpf + ", nome=" + nome + ", pontos=" + pontos + '}';
    }
    
    
    
}









