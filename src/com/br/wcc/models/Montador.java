package com.br.wcc.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Montador{
    private List<Placa> placas = new ArrayList<Placa>();

    public List<Placa> montarPlacas(int numPlacas) {
        for (int i = 0; i < numPlacas; i++) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(100) + 1;

            try{
                Placa placa = montarPlaca(randomNumber);
                placas.add(placa);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage()+ " Placa descartada, num componentes = "+randomNumber);
            }
        }
        return placas;
    }

    private Placa montarPlaca(int numComponentes) {
        Placa placa = new Placa();
        for (int i = 0; i < numComponentes; i++) {
            placa.addComponente(Componente.escolherComponente());
        }
        return placa;
    }

    @Override
    public String toString() {
        return placas.toString() + "\n";
    }
}