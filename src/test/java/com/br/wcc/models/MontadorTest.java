package com.br.wcc.models;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MontadorTest {
    private Montador montador;

    @Test
    public void montarPlacasOk(){
        final Map<Integer, Integer> mapaPlacaComponente = new HashMap<>();
        mapaPlacaComponente.put(0, 30);
        mapaPlacaComponente.put(1, 15);
        mapaPlacaComponente.put(2, 40);

        montador = new Montador();
        final List<Placa> resultado = montador.montarPlacas(mapaPlacaComponente);

        assertNotNull(resultado);
        assertEquals(mapaPlacaComponente.keySet().size(), resultado.size());
        for (int i = 0; i < resultado.size(); i++) {
            Integer esperadoComponentes = mapaPlacaComponente.get(i);
            assertEquals(esperadoComponentes.intValue(), resultado.get(i).getComponentes().size());
        }
    }

    @Test
    public void montarPlacasMaisComponentes(){
        final Map<Integer, Integer> mapaPlacaComponente = new HashMap<>();
        mapaPlacaComponente.put(0, 30);
        mapaPlacaComponente.put(1, 15);
        mapaPlacaComponente.put(2, 60);
        mapaPlacaComponente.put(3, 70);

        montador = new Montador();
        final List<Placa> resultado = montador.montarPlacas(mapaPlacaComponente);

        assertNotNull(resultado);
        assertEquals(mapaPlacaComponente.keySet().size(), resultado.size());
        for (int i = 0; i < resultado.size(); i++) {
            Integer esperadoComponentes = mapaPlacaComponente.get(i);
            esperadoComponentes = (esperadoComponentes > 50) ? 50 : esperadoComponentes;

            assertEquals(esperadoComponentes.intValue(), resultado.get(i).getComponentes().size());
        }
    }

    @Test(expected = NullPointerException.class)
    public void montarPlacasMapNull(){
        montador = new Montador();
        montador.montarPlacas(Collections.emptyMap());
    }
}