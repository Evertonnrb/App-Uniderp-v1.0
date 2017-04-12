package br.com.nrbsistemas.uniderpapp.model;

/**
 * Created by Everton on 12/04/2017.
 */

public class Estado extends GenericDomain{
    private String nome;
    private String uf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return uf;
    }

    public void setSigla(String uf) {
        this.uf = uf;
    }
}
