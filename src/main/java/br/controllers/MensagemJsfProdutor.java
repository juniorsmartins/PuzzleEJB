package br.controllers;

import br.model.JogadorDatabase;
import br.model.JogadorEntity;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.ConnectionFactory;

/**
 * @author JuniorMartins
 */
@Named(value = "mensagemJsfProdutor")
@RequestScoped
public class MensagemJsfProdutor 
{
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "utfpr/tarefaejb")
    private Queue tarefaejb;
    
    private String mensagem;

    // -------------------- CONSTRUTORES -------------------- //
    public MensagemJsfProdutor(){}

    // -------------------- MÉTODOS CONTROLADORES -------------------- //
    public void send()
    {
        try{
            JMSContext context = connectionFactory.createContext();
            context.createProducer().send(tarefaejb, mensagem);
        }catch(Exception e)
        {
            System.err.println("Erro!");
            System.err.println(e.getMessage());
        }
        mensagem = " ";
    }
    
    public void sendRanking()
    {
        List<JogadorEntity> rankeados = JogadorDatabase.pegarRanking();
        rankeados.sort(Comparator.comparing(JogadorEntity::getPontos).reversed());

        for(JogadorEntity jogador : rankeados)
        {
            String jogadores = "" + jogador.getNome() + " - " + jogador.getPontos();
            try{
                JMSContext context = connectionFactory.createContext();
                context.createProducer().send(tarefaejb, jogadores);
            }catch(Exception e)
            {
                System.err.println("Erro!");
                System.err.println(e.getMessage());
            }
        }
    }

    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public String getMensagem() 
    {return mensagem;}
    public void setMensagem(String mensagem) 
    {this.mensagem = mensagem;}


   
    
    
}






