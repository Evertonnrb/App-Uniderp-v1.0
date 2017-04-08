package br.com.nrbsistemas.uniderpapp.model;

import java.io.Serializable;

/**
 * Created by Everton on 26/03/2017.
 * Classe que vai distribuir os id das entidades
 */

public class GenericDomain implements Serializable{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
