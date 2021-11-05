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
    private List<JogadorEntity> ranking;

    public List<JogadorEntity> buscarRanking()
    {
        Collections.sort(ranking, Comparator.comparing(JogadorEntity::getPontos));
        return ranking;
    }
}











