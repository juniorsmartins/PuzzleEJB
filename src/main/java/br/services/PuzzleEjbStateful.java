package br.services;

import br.model.JogadorDatabase;
import br.model.JogadorEntity;
import java.util.Random;
import javax.ejb.Stateful;

/**
 * @author JuniorMartins
 */
@Stateful
public class PuzzleEjbStateful 
{    
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    private JogadorEntity jogador;
    private Random ran;
    private int valor1;
    private int valor2;
    private int soma;
    private int palpite;
    private String resposta;
    
    // -------------------- CONSTRUTORES -------------------- //
    public PuzzleEjbStateful(){}

    // -------------------- MÉTODOS DE SERVIÇO -------------------- //
    public void salvarJogador(String cpf, String nome)
    {
        jogador = new JogadorEntity(cpf, nome);
        JogadorDatabase.salvarNoRanking(jogador);
    }
       
    public void gerarNumsAleatorios()
    {
        resposta = " ";
        ran = new Random();
        valor1 = ran.nextInt(100);
        valor2 = ran.nextInt(100);
        soma = valor1 + valor2;
    }
    
    public void verificarPalpite(String cpf)
    {
        if(palpite != soma)
        {
            resposta = "Errou!";
            return;
        }
        JogadorDatabase.salvarPontos(cpf);
        resposta = "Acertou!";
    }
    
    public void limpar()
    {
        valor1 = 0;
        valor2 = 0;
        soma = 0;
        palpite = 0;
    }
    

    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public JogadorEntity getJogador() 
    {return jogador;}
    public void setJogador(JogadorEntity jogador) 
    {this.jogador = jogador;}

    public int getValor1() 
    {return valor1;}
    public void setValor1(int valor1) 
    {this.valor1 = valor1;}
    public int getValor2() 
    {return valor2;}
    public void setValor2(int valor2) 
    {this.valor2 = valor2;}
    public int getSoma() 
    { return soma;}
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








