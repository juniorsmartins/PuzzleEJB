package br.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author JuniorMartins
 */
@Entity
public class JogadorEntity 
{
    // -------------------- ATRIBUTOS DE CLASSE -------------------- //
    private static List<JogadorEntity> lista = new ArrayList<>();
    public static int cont = 1;
    
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String nome;
    private int pontos;
    
    // -------------------- CONSTRUTORES -------------------- //
    public JogadorEntity(){}
    public JogadorEntity(String cpf, String nome)
    {
        this.cpf = cpf;
        this.nome = nome;
    }
    
        // -------------------- MÉTODOS ESTÁTICOS COMPLEMENTARES -------------------- //
    public static List<JogadorEntity> pegaLista()
    {
        preencherLista();
        return lista;
    }
   
    public static void preencherLista()
    {
        if(cont <= 1)
        {
            JogadorEntity j1 = new JogadorEntity("998877897", "Franz Kafka");
            j1.setPontos(21);
            JogadorEntity j2 = new JogadorEntity("333444885", "Von Misses");
            j2.setPontos(7);
            JogadorEntity j3 = new JogadorEntity("326877795", "Mariana Souza");
            j3.setPontos(14);
            JogadorEntity j4 = new JogadorEntity("111122233", "Fernando Moraes");
            j3.setPontos(28);
            lista.add(j1);
            lista.add(j2);
            lista.add(j3);
            lista.add(j4);
        }
        cont++;
    }

    public static void salvarNaLista(JogadorEntity jogador)
    {lista.add(jogador);}
    
    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public String getCpf() 
    {return cpf;}
    public void setCpf(String cpf) 
    {this.cpf = cpf;}
    public String getNome() 
    {return nome;}
    public void setNome(String nome) 
    {this.nome = nome;}
    public int getPontos() 
    {return pontos;}
    public void setPontos(int pontos) 
    {this.pontos = pontos;}

    // -------------------- MÉTODOS SOBRESCRITOS -------------------- //

    @Override
    public String toString() {
        return "JogadorEntity{" + "cpf=" + cpf + ", nome=" + nome + ", pontos=" + pontos + '}';
    }
    
    
    
}









