package br.controllers;

import br.model.JogadorEntity;
import br.services.PuzzleEjbStateful;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * @author JuniorMartins
 */
@Named(value = "puzzleJsfSession")
@SessionScoped
public class PuzzleJsfSession implements Serializable 
{
    // -------------------- ATRIBUTOS DE CLASSE -------------------- //
    public static final long serialVersionUID = 1L;
    
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @EJB
    private PuzzleEjbStateful puzzleEjbStateful;

    @Inject
    private JogadorEntity jogadore;

    // -------------------- CONSTRUTORES -------------------- //
    public PuzzleJsfSession(){}

    // -------------------- MÉTODOS DE CONTROLE -------------------- //    
    public void gerarNumsAleatorios()
    {puzzleEjbStateful.gerarNumsAleatorios();}
    
    public void salvarJogadorAndVerificarPalpite()
    {
        puzzleEjbStateful.salvarJogador(jogadore.getCpf(), jogadore.getNome());
        puzzleEjbStateful.verificarPalpite(jogadore.getCpf());
        puzzleEjbStateful.limpar();
    }
    
    public String sairSessao()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }

    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public JogadorEntity getJogadore() 
    {return jogadore;}
    public void setJogadore(JogadorEntity jogadore) 
    {this.jogadore = jogadore;}
    public PuzzleEjbStateful getPuzzleEjbStateful() 
    {return puzzleEjbStateful;}
    public void setPuzzleEjbStateful(PuzzleEjbStateful puzzleEjbStateful) 
    {this.puzzleEjbStateful = puzzleEjbStateful;}
    
    
    
}








