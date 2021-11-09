package br.controllers;

import br.model.JogadorEntity;
import br.services.RankingEjbStateless;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * @author JuniorMartins
 */
@Named(value = "rankingJsfRequest")
@RequestScoped
public class RankingJsfRequest implements Serializable
{
    // -------------------- ATRIBUTOS DE CLASSE -------------------- //
    public static final long serialVersionUID = 1L;
    
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @EJB
    private RankingEjbStateless rankingEjbStateless;
 
    // -------------------- CONSTRUTORES -------------------- //
    public RankingJsfRequest(){}

    // -------------------- MÉTODOS DE CONTROLE -------------------- //
    @PostConstruct
    public void gerarBaseDadosPraTeste()
    {
        JogadorEntity j1 = new JogadorEntity("998.877.897-88", "Franz Kafka");
        j1.setPontos(8);
        JogadorEntity j2 = new JogadorEntity("333.444.885-50", "Von Misses");
        j2.setPontos(2);
        JogadorEntity j3 = new JogadorEntity("326.877.795-34", "Mariana Souza");
        j3.setPontos(5);
        JogadorEntity j4 = new JogadorEntity("111.122.233-46", "Fernando Moraes");
        j4.setPontos(15);
        JogadorEntity j5 = new JogadorEntity("111.122.233-77", "Pietra Vinola");
        j5.setPontos(4);
        List<JogadorEntity> listaJogador = new ArrayList<>();
        listaJogador.add(j1);
        listaJogador.add(j2);
        listaJogador.add(j3);
        listaJogador.add(j4);
        listaJogador.add(j5);
        rankingEjbStateless.gerarBaseDadosPraTeste(listaJogador);
    }

    public List<JogadorEntity> buscarRanking()
    {return rankingEjbStateless.buscarRanking();}
    
    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //

    public RankingEjbStateless getRankingEjbStateless() 
    {return rankingEjbStateless;}
    public void setRankingEjbStateless(RankingEjbStateless rankingEjbStateless) 
    {this.rankingEjbStateless = rankingEjbStateless;}

    
    
}







