package com.br.wcc.models;

public class Fabrica {
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fabrica)) return false;

        Fabrica fabrica = (Fabrica) o;

        return nome != null ? nome.equals(fabrica.nome) : fabrica.nome == null;
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }
}