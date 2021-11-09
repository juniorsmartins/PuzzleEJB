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
    
    // -------------------- CONSTRUTORES -------------------- //
    public PuzzleEjbStateful(){}

    // -------------------- MÉTODOS DE SERVIÇO -------------------- //
    public void salvarJogador(String cpf, String nome)
    {
        jogador = new JogadorEntity(cpf, nome);
        JogadorDatabase.salvarNoRanking(jogador);
    }
       
    public int gerarNumsAleatorios()
    {
        ran = new Random();
        return ran.nextInt(100);
    }
    
    public String verificarPalpite(int soma, int palpite, String cpf)
    {
        if(palpite == soma)
        {
            JogadorDatabase.salvarPontos(cpf);
            return "Acertou!";
        }
        return "Errou!";
    }
    

    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public JogadorEntity getJogador() 
    {return jogador;}
    public void setJogador(JogadorEntity jogador) 
    {this.jogador = jogador;}
    
    
}








