package br.controllers;

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

    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "utfpr/tarefaejb")
    private Queue fila;
    
    private String mensagem;

    public MensagemJsfProdutor(){}

    public void send()
    {
        try{
            JMSContext context = connectionFactory.createContext();
            context.createProducer().send(fila, mensagem);
        }catch(Exception e)
        {
            System.err.println("Erro!");
            System.err.println(e.getMessage());
        }
        mensagem = " ";
    }

    public String getMensagem() 
    {return mensagem;}
    public void setMensagem(String mensagem) 
    {this.mensagem = mensagem;}

   
    
    
}






