package br.com.nrbsistemas.uniderpapp.model;

import android.text.format.DateFormat;

/**
 * Created by Everton on 26/03/2017.
 */

public class Professor extends Pessoa{
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    DateFormat dataEntrada() {
        return null;
    }

    @Override
    DateFormat dataSaida() {
        return null;
    }

    @Override
    Boolean ativo() {
        return null;
    }
}
