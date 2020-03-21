package com.br.wcc;

import com.br.wcc.models.Componente;
import com.br.wcc.models.Contador;
import com.br.wcc.models.Montador;
import com.br.wcc.models.Placa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Montador montador = new Montador();

        Map<Integer, Integer> mapaPlacaComponente = new HashMap<>();
        mapaPlacaComponente.put(0, 30);
        mapaPlacaComponente.put(1, 15);
        mapaPlacaComponente.put(2, 40);

        final List<Placa> placas = montador.montarPlacas(mapaPlacaComponente);

        /*Imprime os componentes de cada uma das placas montadas*/
        System.out.println("\n"+placas.size()+" placas foram montadas com sucesso!\n");
        System.out.println(placas.stream()
            .map(Placa::toString)
            .collect(Collectors.toList()));

        /*Imprime número total de componentes utilizados para montar n placas*/
        Contador contador = new Contador();
        Map<Componente, Integer> tabelaContador = contador.contaComponentes(placas);
        System.out.println("\nForam utilizados, no total:");
        for (Map.Entry<Componente, Integer> linha : tabelaContador.entrySet()) {
            System.out.println(linha.getKey() + ":" + linha.getValue());
        }
    }
}