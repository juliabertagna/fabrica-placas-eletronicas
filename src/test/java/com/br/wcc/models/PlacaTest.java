package com.br.wcc.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlacaTest {
    Placa placa;
    int numComponentes;

    @Test
    public void montarPlacaOk(){
        placa = new Placa();
        numComponentes = 20;

        for (int i = 0; i < numComponentes; i++) {
            placa.addComponente(Componente.escolherComponente());
        }

        assertNotNull(placa.getComponentes());
        assertEquals(placa.getComponentes().size(), numComponentes);
    }

    @Test(expected = IllegalArgumentException.class)
    public void montarPlacaNok(){
        placa = new Placa();
        numComponentes = 60;

        for (int i = 0; i < numComponentes; i++) {
            placa.addComponente(Componente.escolherComponente());
        }
    }

    @Test(expected = NullPointerException.class)
    public void montarPlacaComponenteNull(){
        placa = new Placa();
        numComponentes = 40;

        for (int i = 0; i < numComponentes; i++) {
            placa.addComponente(null);
        }
    }
}