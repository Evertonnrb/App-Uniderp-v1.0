package br.com.nrbsistemas.uniderpapp.model;

/**
 * Created by Everton on 26/03/2017.
 */

public class Disciplina extends GenericDomain {
    private String nome;
    private String descrisao;
    private Professor professor;

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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
