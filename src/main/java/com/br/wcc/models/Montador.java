package com.br.wcc.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Montador{
    private List<Placa> placas = new ArrayList<Placa>();

    public List<Placa> montarPlacas(Map<Integer, Integer> componentePlaca) throws NullPointerException {
        if (componentePlaca.isEmpty()){
            throw new NullPointerException("O mapa Componente - Placa não deve ser nulo");
        }

        for (int i = 0; i < componentePlaca.keySet().size(); i++) {
            Placa placa = montarPlaca(componentePlaca.get(i));
            placas.add(placa);
        }
        return placas;
    }

    private Placa montarPlaca(int numComponentes) {
        Placa placa = new Placa();
        for (int i = 0; i < numComponentes; i++) {
            try{
                placa.addComponente(Componente.escolherComponente());
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage()+ " Placa descartada, num componentes = "+numComponentes);
            }
        }
        return placa;
    }

    @Override
    public String toString() {
        return placas.toString() + "\n";
    }
}