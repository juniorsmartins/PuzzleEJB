package br.controllers;

import static br.model.JogadorDatabase.rank;
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
    private List<JogadorEntity> listaRanqueados;
 
    // -------------------- CONSTRUTORES -------------------- //
    public RankingJsfRequest(){}

    // -------------------- MÉTODOS DE CONTROLE -------------------- //
    @PostConstruct
    public void gerarBaseDadosPraTeste()
    {
        JogadorEntity j1 = new JogadorEntity("998877897", "Franz Kafka");
        j1.setPontos(21);
        JogadorEntity j2 = new JogadorEntity("333444885", "Von Misses");
        j2.setPontos(7);
        JogadorEntity j3 = new JogadorEntity("326877795", "Mariana Souza");
        j3.setPontos(14);
        JogadorEntity j4 = new JogadorEntity("111122233", "Fernando Moraes");
        j3.setPontos(28);
        List<JogadorEntity> listaJogador = new ArrayList<>();
        listaJogador.add(j1);
        listaJogador.add(j2);
        listaJogador.add(j3);
        listaJogador.add(j4);
        rankingEjbStateless.gerarBaseDadosPraTeste(listaJogador);
    }

    public List<JogadorEntity> buscarRanking()
    {
        listaRanqueados = rankingEjbStateless.buscarRanking();
        return listaRanqueados;
    }
    
    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //

    public RankingEjbStateless getRankingEjbStateless() 
    {return rankingEjbStateless;}
    public void setRankingEjbStateless(RankingEjbStateless rankingEjbStateless) 
    {this.rankingEjbStateless = rankingEjbStateless;}
    public List<JogadorEntity> getListaRanqueados() 
    {
        listaRanqueados = rankingEjbStateless.buscarRanking();
        return listaRanqueados;
    }
    public void setListaRanqueados(List<JogadorEntity> listaRanqueados) 
    {this.listaRanqueados = listaRanqueados;}

    
    
}







