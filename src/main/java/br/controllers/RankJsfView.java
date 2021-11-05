package br.controllers;

import br.model.JogadorEntity;
import br.services.RankingEjbStateless;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 * @author JuniorMartins
 */
@Named(value = "rankJsfView")
@ViewScoped
public class RankJsfView implements Serializable 
{
    // -------------------- ATRIBUTOS DE CLASSE -------------------- //
    public static final long serialVersionUID = 1L;

    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @EJB
    private RankingEjbStateless rankingEjbStateless;
    private List<JogadorEntity> ranking;
    
    // -------------------- CONSTRUTORES -------------------- //
    public RankJsfView(){}
    
    // -------------------- MÉTODOS DE CONTROLE -------------------- //
     
    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public RankingEjbStateless getRankingEjbStateless() 
    {return rankingEjbStateless;}
    public void setRankingEjbStateless(RankingEjbStateless rankingEjbStateless) 
    {this.rankingEjbStateless = rankingEjbStateless;}
    public List<JogadorEntity> getRanking() 
    {
        ranking = rankingEjbStateless.buscarRanking();
        return ranking;
    }
    public void setRanking(List<JogadorEntity> ranking) 
    {this.ranking = ranking;}
    
}
