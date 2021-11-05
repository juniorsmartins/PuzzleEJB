package br.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author JuniorMartins
 */
public class JogadorDao 
{

    @PersistenceContext
    private EntityManager manager;
    
    public void salvar(JogadorEntity jogador)
    {
        manager.persist(jogador);
    }
    
    
}
