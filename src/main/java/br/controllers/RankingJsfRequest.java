package br.controllers;

import br.model.JogadorEntity;
import br.services.RankingEjbStateless;
import java.io.Serializable;
import java.util.List;
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
    private List<JogadorEntity> ranking;
 
    // -------------------- CONSTRUTORES -------------------- //
    public RankingJsfRequest(){}

    // -------------------- MÉTODOS DE CONTROLE -------------------- //
    public List<JogadorEntity> buscarRanking()
    {return rankingEjbStateless.buscarRanking();}
     
    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public RankingEjbStateless getRankingEjbStateless() 
    {return rankingEjbStateless;}
    public void setRankingEjbStateless(RankingEjbStateless rankingEjbStateless) 
    {this.rankingEjbStateless = rankingEjbStateless;}
    public List<JogadorEntity> getRanking() 
    {return ranking;}
    public void setRanking(List<JogadorEntity> ranking) 
    {this.ranking = ranking;}

    
    
}







