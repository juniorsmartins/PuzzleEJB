package br.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author JuniorMartins
 */
@Entity
public class JogadorEntity implements Serializable
{
    // -------------------- ATRIBUTOS DE CLASSE -------------------- //
    public static final long serialVersionUID = 1L;
    
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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









