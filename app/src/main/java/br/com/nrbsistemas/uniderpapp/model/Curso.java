package br.com.nrbsistemas.uniderpapp.model;

/**
 * Created by Everton on 26/03/2017.
 */

public class Curso extends GenericDomain{
    private String nome;
    private String descrisao;
    private Disciplina disciplina;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrisao() {
        return descrisao;
    }

    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
