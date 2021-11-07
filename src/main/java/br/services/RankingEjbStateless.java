package br.services;

import br.model.JogadorDatabase;
import br.model.JogadorEntity;
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
    {return JogadorDatabase.pegarRanking();}
    
    
    
    
}











