package br.controllers;

import br.model.JogadorEntity;
import br.services.PuzzleEjbStateful;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 * @author JuniorMartins
 */
@Named(value = "puzzleJsfSession")
@SessionScoped
public class PuzzleJsfSession implements Serializable 
{
    // -------------------- ATRIBUTOS DE CLASSE -------------------- //
    public static final long serialVersionUID = 1L;
    
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @EJB
    private PuzzleEjbStateful puzzleEjbStateful;
    
    private String cpf;
    private String nome;
    private int pontos;
    private int valor1;
    private int valor2;
    private int soma;
    private int palpite;
    private String resposta;

    // -------------------- CONSTRUTORES -------------------- //
    public PuzzleJsfSession(){}

    // -------------------- MÉTODOS DE CONTROLE -------------------- //    
    public void gerarNumsAleatorios()
    {
        resposta = " ";
        valor1 = puzzleEjbStateful.gerarNumsAleatorios();
        valor2 = puzzleEjbStateful.gerarNumsAleatorios();
        soma = valor1 + valor2;
    }
    
    public void salvarJogadorAndVerificarPalpite()
    {
        puzzleEjbStateful.salvarJogador(this.getCpf(), this.getNome());
        resposta = puzzleEjbStateful.verificarPalpite(soma, palpite, cpf);
        this.valor1 = 0;
        this.valor2 = 0;
        this.soma = 0;
        this.palpite = 0;
    }
    
    public String sairSessao()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
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
    public int getValor1() 
    {return valor1;}
    public void setValor1(int valor1) 
    {this.valor1 = valor1;}
    public int getValor2() 
    {return valor2;}
    public void setValor2(int valor2) 
    {this.valor2 = valor2;}
    public int getSoma() 
    {return soma;}
    public void setSoma(int soma) 
    {this.soma = soma;}
    public int getPalpite() 
    {return palpite;}
    public void setPalpite(int palpite) 
    {this.palpite = palpite;}
    public String getResposta() 
    {return resposta;}
    public void setResposta(String resposta) 
    {this.resposta = resposta;}


    

    
    
    
    
}








