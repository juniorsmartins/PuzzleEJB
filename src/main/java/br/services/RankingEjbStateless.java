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
    // -------------------- MÉTODOS DE SERVIÇO -------------------- //
    public List<JogadorEntity> buscarRanking()
    {
        List<JogadorEntity> ranking = JogadorEntity.pegaLista();
        Collections.sort(ranking, Comparator.comparing(JogadorEntity::getPontos));
        return ranking;
    }
    
    
    
    
}











