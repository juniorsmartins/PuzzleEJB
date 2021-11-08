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
        Stream<Map.Entry<String, JogadorEntity>> transformarRank = rank.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(JogadorEntity::getPontos).reversed()))
                .filter(j -> j.getValue().getPontos() > 0);
        List<JogadorEntity> listaJog = new ArrayList<>();
        transformarRank.forEach(j -> listaJog.add(j.getValue()));
        return listaJog;
    }
    
    public static void gerarBaseDadosPraTeste(List<JogadorEntity> jogador)
    {
        for(JogadorEntity joga : jogador)
            rank.putIfAbsent(joga.getCpf(), joga);
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
            j.setPontos(j.getPontos() + 1);
            rank.put(cpf, j);
        }
    }
    
}







