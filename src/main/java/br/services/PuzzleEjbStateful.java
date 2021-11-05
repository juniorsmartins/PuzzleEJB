package br.services;

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
        JogadorEntity.lista.add(jogador);
        System.out.println(jogador);
    }
    
    public int gerarNumsAleatorios()
    {
        ran = new Random();
        return ran.nextInt(100);
    }
    
    public String verificarPalpite(int valor1, int valor2, int palpite, String cpf)
    {
        if(palpite == (valor1 + valor2))
        {
            for(JogadorEntity jog : JogadorEntity.lista)
            {
                if(jog.getCpf().equals(cpf))
                    jog.setPontos(jog.getPontos() + 7);
            }
            System.out.println(jogador);
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








