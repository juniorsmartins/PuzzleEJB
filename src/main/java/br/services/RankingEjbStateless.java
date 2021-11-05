package br.services;

import br.model.JogadorEntity;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.Stateless;

/**
 * @author JuniorMartins
 */
@Stateless
public class RankingEjbStateless 
{
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    private List<JogadorEntity> ranking;

    // -------------------- MÉTODOS DE SERVIÇO -------------------- //
    public List<JogadorEntity> buscarRanking()
    {
        Collections.sort(ranking, Comparator.comparing(JogadorEntity::getPontos));
        return ranking;
    }
    
    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public List<JogadorEntity> getRanking() 
    {return ranking;}
    public void setRanking(List<JogadorEntity> ranking) 
    {this.ranking = ranking;}
    
    
    
    
}











