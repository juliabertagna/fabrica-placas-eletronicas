package com.br.wcc.models;

import java.util.ArrayList;
import java.util.List;

public class Placa{
    private List<Componente> componentes = new ArrayList<Componente>();

    public void addComponente(Componente componente) throws IllegalArgumentException, NullPointerException {
        int limiteComponentes = 50;
        if(componente == null){
            throw new NullPointerException("O componente adicionado na placa não pode ser nulo.");
        }

        if (componentes.size() >= limiteComponentes){
            throw new IllegalArgumentException("Ultrapassado limite de componentes (n = "+limiteComponentes+").");
        }
        componentes.add(componente);
    }

    @Override
    public String toString() {
        return componentes.toString() + "\n";
    }

    public List<Componente> getComponentes() {
        return componentes;
    }
}