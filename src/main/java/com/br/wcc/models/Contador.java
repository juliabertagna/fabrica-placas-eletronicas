package com.br.wcc.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contador {
    public Map<Componente, Integer> contaComponentes(List<Placa> placas) {
        Map<Componente, Integer> contador = new HashMap<>();
        for(Placa placa : placas) {
            List<Componente> componentes = placa.getComponentes();
            for(Componente componente : componentes) {
                contador.compute(componente, (chave, valor) ->
                        valor == null ? 1 : valor + 1);
            }
        }
        return contador;
    }
}