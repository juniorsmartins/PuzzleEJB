package br.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * @author JuniorMartins
 */
public class JogadorDatabase 
{
    // -------------------- ATRIBUTOS DE CLASSE -------------------- //
    public static NavigableMap<String, JogadorEntity> rank = new TreeMap<>();
    
    // -------------------- MÉTODOS ESTÁTICOS COMPLEMENTARES -------------------- //
    public static List<JogadorEntity> pegarRanking()
    {
        preencherLista();
        Stream<Map.Entry<String, JogadorEntity>> transformarRank = rank.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(JogadorEntity::getPontos).reversed()))
                .filter(j -> j.getValue().getPontos() > 0);
        List<JogadorEntity> listaJog = new ArrayList<>();
        transformarRank.forEach(j -> listaJog.add(j.getValue()));
        return listaJog;
    }
    
    public static void preencherLista()
    {
        JogadorEntity j1 = new JogadorEntity("998877897", "Franz Kafka");
        j1.setPontos(21);
        JogadorEntity j2 = new JogadorEntity("333444885", "Von Misses");
        j2.setPontos(7);
        JogadorEntity j3 = new JogadorEntity("326877795", "Mariana Souza");
        j3.setPontos(14);
        JogadorEntity j4 = new JogadorEntity("111122233", "Fernando Moraes");
        j3.setPontos(28);
        rank.put(j1.getCpf(), j1);
        rank.put(j2.getCpf(), j2);
        rank.put(j3.getCpf(), j3);
        rank.put(j4.getCpf(), j4);
    }

    public static void salvarNoRanking(JogadorEntity jogador)
    {
        if(rank.containsKey(jogador.getCpf()))
        {
            JogadorEntity jog = new JogadorEntity();
            jog = rank.remove(jogador.getCpf());
            jog.setPontos((jog.getPontos() + jogador.getPontos()));
            rank.put(jog.getCpf(), jog);
            return;
        }
        rank.put(jogador.getCpf(), jogador);
    }
    
    public static void salvarPontos(String cpf)
    {
        if(rank.containsKey(cpf))
        {
            JogadorEntity j = rank.remove(cpf);
            j.setPontos(j.getPontos() + 7);
            rank.put(cpf, j);
        }
    }
    
}







