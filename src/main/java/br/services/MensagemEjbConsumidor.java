package br.services;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "utfpr/tarefaejb"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MensagemEjbConsumidor implements MessageListener
{
    @Override
    public void onMessage(Message msg) 
    {
        try
        {
            TextMessage tm = (TextMessage) msg;
            System.out.println(tm.getText());
        }
        catch(Exception e)
        {
            System.err.println("Erro");
            System.err.println(e.getMessage());
        }
    }

    
}







